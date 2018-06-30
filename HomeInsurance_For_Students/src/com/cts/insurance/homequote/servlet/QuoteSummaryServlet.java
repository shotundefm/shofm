/**
 * Servlet for capturing Quote summary information
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

import com.cts.insurance.homequote.bo.HomeownerBO;
import com.cts.insurance.homequote.bo.LocationBO;
import com.cts.insurance.homequote.bo.PropertyBO;
import com.cts.insurance.homequote.bo.QuoteBO;
import com.cts.insurance.homequote.model.Location;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public class QuoteSummaryServlet extends HttpServlet{
	
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
			//Get Request Parameters
			final String action = request.getParameter("action");
			String forward = null;
			final HttpSession session = request.getSession();

			if("getQuotes".equals(action))
			{
				final String userName = (String)session.getAttribute("userName");
				
				final LocationBO locationBO = new LocationBO();
				final List<Location> locationList = locationBO.getQuoteIds(userName);
				request.setAttribute("locationList", locationList);
				forward = HomeInsuranceConstants.RETRIEVE_QUOTE;
			}
			else
			{
				final int quoteId = Integer.parseInt(request.getParameter("quoteIdSelected"));
				session.setAttribute("quoteId", Integer.valueOf(quoteId));
				
				final LocationBO locationBO = new LocationBO();
				request.setAttribute("location", locationBO.getHomeLocation(quoteId));
				
				final HomeownerBO homeownerBO = new HomeownerBO();
				request.setAttribute("homeowner", homeownerBO.getHomeownerInfo(quoteId));
				
				final PropertyBO propertyBO = new PropertyBO();
				request.setAttribute("property", propertyBO.getProperty(quoteId));
				
				final QuoteBO quoteBO = new QuoteBO();
				session.setAttribute("quote", quoteBO.getQuote(quoteId));
				forward = HomeInsuranceConstants.QUOTE_SUMMARY;
			}
						
			final RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error("Exception occurred in method PropertyServlet.doPost :: "
					+ e);
			request.setAttribute("message", e.getMessage());
			final RequestDispatcher dispatcher = request.getRequestDispatcher(HomeInsuranceConstants.ERROR);
			dispatcher.forward(request, response);
		}
	}
}