/**
 * Servlet for capturing Login information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.bo.LoginBO;
import com.cts.insurance.homequote.bo.PolicyBO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.model.Policy;
import com.cts.insurance.homequote.model.User;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(final HttpServletRequest req, final HttpServletResponse res) throws ServletException,IOException {
		final Logger logger = Logger.getLogger(this.getClass().getName());
		HttpSession session = req.getSession();
		
		final String action = req.getParameter("action");
		if(!"searchUser".equals(action))
		{
			if(session.getAttribute("location") != null)
			{	
				session.removeAttribute("location");
				session.removeAttribute("homeowner");
				session.removeAttribute("property");
			}
			
			session.invalidate();
		}
		session = req.getSession(true);
		
		if("ExistingUser".equals(action))
		{
			loginExistingUser(req, res, logger, session);
		}
		else if("newUser".equals(action))
		{
			loginNewUser(req, res, logger, session);
		}
		else if("searchUser".equals(action))
		{
			searchUser(req, res, logger, session);
		}
		else if("logout".equals(action))
		{
			session.invalidate();
			final RequestDispatcher dispatcher = req.getRequestDispatcher(HomeInsuranceConstants.LOGOUT);
			dispatcher.forward(req, res);
		}
	}

	/**
	 * @param req
	 * @param res
	 * @param logger
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void searchUser(final HttpServletRequest req,
			final HttpServletResponse res, final Logger logger,
			final HttpSession session) throws ServletException, IOException {
		try {
			String page = null;
			final String selectedUser = req.getParameter("selectedUser");
			final LoginBO loginBO = new LoginBO();
			final User user = loginBO.getUser(selectedUser);
			if(user != null)
			{
				session.setAttribute(HomeInsuranceConstants.USER_NAME, selectedUser);
				
				//Get Policy
				final PolicyBO policyBO = new PolicyBO();
				final List<Policy> policyList = policyBO.getPolicies(selectedUser);
				if(policyList.isEmpty())
				{
					page = HomeInsuranceConstants.GET_STARTED;
				}
				else
				{
					req.setAttribute("policyList", policyList);
					page = HomeInsuranceConstants.POLICY_DETAILS;
				}
			}
			else
			{
				req.setAttribute(HomeInsuranceConstants.MESSAGE, "Invalid UserName");
				page = HomeInsuranceConstants.SEARCH_USER;
			}
			final RequestDispatcher dispatcher = req.getRequestDispatcher(page);
			dispatcher.forward(req, res);
		
		} catch (Exception e) {
			logger.error("Exception occurred while executing method LoginServlet.doGet :: " + e);
			req.setAttribute(HomeInsuranceConstants.MESSAGE, e.getMessage());
			final RequestDispatcher dispatcher = req.getRequestDispatcher(HomeInsuranceConstants.ERROR);
			dispatcher.forward(req, res);
		}
	}

	/**
	 * @param req
	 * @param res
	 * @param logger
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loginNewUser(final HttpServletRequest req,
			final HttpServletResponse res, final Logger logger,
			final HttpSession session) throws ServletException, IOException {
		final String userName = req.getParameter(HomeInsuranceConstants.USER_NAME);
		final String password = req.getParameter("password");
		final User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		try {
			final LoginBO loginBO = new LoginBO();
			loginBO.registerUser(user);
			session.setAttribute(HomeInsuranceConstants.USER_NAME, userName);
			final RequestDispatcher dispatcher = req.getRequestDispatcher(HomeInsuranceConstants.GET_STARTED);
			dispatcher.forward(req, res);
		} catch (Exception e) {
			logger.error("Exception occurred while executing method LoginServlet.doGet :: " + e);
			req.setAttribute(HomeInsuranceConstants.MESSAGE, e.getMessage());
			final RequestDispatcher dispatcher = req.getRequestDispatcher(HomeInsuranceConstants.ERROR);
			dispatcher.forward(req, res);
		}
	}

	/**
	 * @param req
	 * @param res
	 * @param logger
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loginExistingUser(final HttpServletRequest req,
			final HttpServletResponse res, final Logger logger,
			final HttpSession session) throws ServletException, IOException {
		try {
			final String userName = req.getParameter(HomeInsuranceConstants.USER_NAME);
			final String password = req.getParameter("password");
			String page = null;
			final LoginBO loginBO = new LoginBO();
			final User user = loginBO.getUser(userName);
			if(user != null)
			{
				if(user.getUserRole() != null && user.getUserRole().equals("Admin"))
				{
					session.setAttribute("Role", "Admin");
					page = HomeInsuranceConstants.SEARCH_USER;
				}
				else
				{
					session.setAttribute(HomeInsuranceConstants.USER_NAME, userName);
					if(!user.getPassword().equals(password))
					{
						throw new HomequoteBusinessException("Invalid Password");
					}
					
					//Get Policy
					final PolicyBO policyBO = new PolicyBO();
					final List<Policy> policyList = policyBO.getPolicies(userName);
					if(policyList.isEmpty())
					{
						page = HomeInsuranceConstants.GET_STARTED;
					}
					else
					{
						req.setAttribute("policyList", policyList);
						page = HomeInsuranceConstants.POLICY_DETAILS;
					}
				}
			}
			else
			{
				req.setAttribute(HomeInsuranceConstants.MESSAGE, "Invalid UserName");
				page = HomeInsuranceConstants.ERROR;
			}
			final RequestDispatcher dispatcher = req.getRequestDispatcher(page);
			dispatcher.forward(req, res);				
		} catch (Exception e) {
			logger.error("Exception occurred while executing method LoginServlet.doPost :: " + e);
			req.setAttribute(HomeInsuranceConstants.MESSAGE, e.getMessage());
			final RequestDispatcher dispatcher = req.getRequestDispatcher(HomeInsuranceConstants.ERROR);
			dispatcher.forward(req, res);
		}
	}
}