/**
 * Servlet for capturing Property information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import com.cts.insurance.homequote.dao.AbstractDAOFactory;
import com.cts.insurance.homequote.model.Homeowner;
import com.cts.insurance.homequote.model.Location;
import com.cts.insurance.homequote.model.Property;
import com.cts.insurance.homequote.model.Quote;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public class PropertyServlet extends HttpServlet{
	
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
				if(session.getAttribute("property") == null)
				{
					//Get Request Parameters and set it to the data object
					final Property property = new Property();
					property.setMarketValue(Integer.parseInt(request.getParameter(HomeInsuranceConstants.MARKET_VALUE)));
					property.setYearBuilt(Integer.parseInt(request.getParameter(HomeInsuranceConstants.YEAR_BUILT)));
					property.setSquareFootage(Integer.parseInt(request.getParameter(HomeInsuranceConstants.SQUARE_FOOTAGEG)));
					property.setDwellingStyle(Integer.parseInt(request.getParameter(HomeInsuranceConstants.DWELLING_STYLE)));
					property.setRoofMaterial(request.getParameter(HomeInsuranceConstants.ROOF_MATERIAL));
					property.setGarageType(request.getParameter(HomeInsuranceConstants.GARAGE_TYPE));
					property.setNumFullBaths(Integer.parseInt(request.getParameter(HomeInsuranceConstants.NUM_FULL_BATHS)));
					property.setNumHalfBaths(Integer.parseInt(request.getParameter(HomeInsuranceConstants.NUM_HALF_BATHS)));
					property.setHasSwimmingPool(Boolean.parseBoolean(request.getParameter(HomeInsuranceConstants.HAS_SWIMMING_POOL)));
					
					if(session.getAttribute("location") != null)
						
					{
						final PropertyBO propertyBo = new PropertyBO();
						final Location location = (Location)session.getAttribute("location");
						
						property.setQuoteId(location.getQuoteId());
					
				
					
					propertyBo.saveProperty(property);
					session.setAttribute("property", property);
					
					final Homeowner homeowner = (Homeowner)session.getAttribute("homeowner");
//					 property = (Property)session.getAttribute("property");
					
					
					
					final QuoteBO quoteBO = new QuoteBO();
					final Quote quote = quoteBO.calculateQuote(location, homeowner, property);
					System.out.println("In property servlet with quote id " + location.getQuoteId());
					quote.setQuoteId(location.getQuoteId());
					quoteBO.saveQuote(quote);
					request.setAttribute("quote", quote);
					session.setAttribute("location", location);
					session.setAttribute("homeowner", homeowner);
					session.setAttribute("property", property);
					session.setAttribute("quote", quote);
					System.out.println("going into the quote arena");
					}
				}
				final RequestDispatcher dispatcher = request.getRequestDispatcher(HomeInsuranceConstants.QUOTE);
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