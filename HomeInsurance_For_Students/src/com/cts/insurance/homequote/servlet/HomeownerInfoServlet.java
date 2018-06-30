/**
 * Servlet for capturing Homeowner information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.bo.HomeownerBO;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;
import com.cts.insurance.homequote.model.Location;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public class HomeownerInfoServlet extends HttpServlet{
	
	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Executes the action and returns the chosen renderer
	 *
	 * @param req Http Request
	 * @param req Http Response
	 * @return renderer chosen based on the result of saving a product
	 * @throws Throwable if exception occurs while saving the product
	 */
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,IOException {

		final Logger logger = Logger.getLogger(this.getClass().getName());
		try {
			final HttpSession session = request.getSession();
			if(session.getAttribute("homeowner") == null)
			{
				//Get Request Parameters and set it to the data object
				final Homeowner homeowner = new Homeowner();
				homeowner.setFirstName(request.getParameter(HomeInsuranceConstants.FIRST_NAME));
				homeowner.setLastName(request.getParameter(HomeInsuranceConstants.LAST_NAME));
				homeowner.setDob(request.getParameter(HomeInsuranceConstants.DATE_OF_BIRTH));
				homeowner.setIsRetired(request.getParameter(HomeInsuranceConstants.IS_RETIRED));
				homeowner.setSsn(request.getParameter(HomeInsuranceConstants.SSN));
				homeowner.setEmailAddress(request.getParameter(HomeInsuranceConstants.EMAIL_ADDRESS));
				
				if(session.getAttribute("location") != null)
				{
					
				}
				else
				{
					String message = "QuoteId not retrieved after location page in method HomeownerInfoServlet.doPost";
					logger.error(message);
					throw new HomequoteSystemException(message);
				}
				final Location location = (Location)session.getAttribute("location");
				System.out.println("In homeowner Servlet with quote id " + location.getQuoteId());
				homeowner.setQuoteId(location.getQuoteId());
				
				final HomeownerBO homeownerBo = new HomeownerBO();
				homeownerBo.saveHomeownerInfo(homeowner);
				session.setAttribute("homeowner", homeowner);
				
				
				session.setAttribute("location", location);
				
				System.out.println("passing on to property servlet with quote id " + location.getQuoteId());
				
				
			}
			final RequestDispatcher dispatcher = request.getRequestDispatcher(HomeInsuranceConstants.PROPERTY);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error("Exception occurred in method HomeownerInfoServlet.doPost :: "
					+ e);
			request.setAttribute("message", e.getMessage());
			final RequestDispatcher dispatcher = request.getRequestDispatcher(HomeInsuranceConstants.ERROR);
			dispatcher.forward(request, response);
		}
	}
}