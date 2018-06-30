/**
 * Servlet for capturing Location Information
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

import com.cts.insurance.homequote.bo.LocationBO;
import com.cts.insurance.homequote.dao.AbstractDAOFactory;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Location;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

//@WebServlet(/homeownerinfo"")
public class LocationServlet extends HttpServlet {

	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Executes the action and returns the chosen renderer
	 *
	 * @param req
	 *            Http Request
	 * @param req
	 *            Http Response
	 * @return renderer chosen based on the result of saving a product
	 * @throws Throwable
	 *             if exception occurs while saving the product
	 */
	public void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		final Logger logger = Logger.getLogger(this.getClass().getName());
		try {
			final HttpSession session = request.getSession();
			// Fill code here
			if (session.getAttribute("location") == null) {
				final Location location = new Location();
				final LocationBO locationBO = new LocationBO();

				location.setResidenceType(request.getParameter(HomeInsuranceConstants.RESIDENCE_TYPE));
				location.setAddressLine1(request.getParameter(HomeInsuranceConstants.ADDRESS_LINE_1));
				location.setAddressLine2(request.getParameter(HomeInsuranceConstants.ADDRESS_LINE_2));
				location.setCity(request.getParameter(HomeInsuranceConstants.CITY));
				location.setState(request.getParameter(HomeInsuranceConstants.STATE));
				location.setZip(request.getParameter(HomeInsuranceConstants.ZIP));
				location.setResidenceUse(request.getParameter(HomeInsuranceConstants.RESIDENCE_USE));
				location.setUserName(request.getParameter(HomeInsuranceConstants.USER_NAME));
				
				
				
				
				
		
//			session.setAttribute("location", locationBO.saveHomeLocation(location) );
				
//				session.setAttribute("location", locationBO.saveHomeLocation(location));
//				session.getAttribute("location");
//				location.setQuoteId(location.getQuoteId());
//				System.out.println(location.getQuoteId());
		
				location.setQuoteId(locationBO.saveHomeLocation(location));
				
				
//				final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
//				Connection conn = daoFactory.getConnection();
//				String query = "select max(quote_id) from locations";
//				PreparedStatement stmt =null;
//				ResultSet resultSet = null;
//				int quoteId = 0;
//				stmt = conn.prepareStatement(query);
//				if (resultSet.next()) {
//				quoteId = resultSet.getInt(1);}
//				
//				System.out.println("servlet statement " + quoteId);
				
				session.setAttribute("location", location);
				
				session.getAttribute("location");
				System.out.println("Servlet is getting the returned quote id " + location.getQuoteId() );
				
				session.setAttribute("location", location);
				
			
	
			}else {
				
				String message = "Re-enter location information Can't attribute it to session in LocationServlet.doPost";
				logger.error(message);
				throw new HomequoteSystemException(message);
			
			}
			System.out.println("passing on to home owner");

//			 response.sendRedirect("homeownerInfo.jsp");
			RequestDispatcher rd = request.getRequestDispatcher(HomeInsuranceConstants.HOMEOWNER_INFO);
			rd.forward(request, response);

		}

		catch (Exception e) {
			logger.error("Exception occurred in method LocationServlet.doPost :: " + e);
			request.setAttribute("message", e.getMessage());
			final RequestDispatcher dispatcher = request.getRequestDispatcher(HomeInsuranceConstants.ERROR);
			dispatcher.forward(request, response);
		}

	}
}