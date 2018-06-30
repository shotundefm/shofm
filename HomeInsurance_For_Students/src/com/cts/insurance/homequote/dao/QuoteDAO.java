/**
 * This DAO class is used to for Quote Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Quote;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;
import com.cts.insurance.homequote.util.SqlQueries;

public class QuoteDAO {
	private final static Logger LOG =  Logger.getLogger(QuoteDAO.class);
	/**
	 * @param quoteId
	 * @return
	 * @throws HomequoteSystemException
	 */
	public Quote getQuote(final int quoteId) throws HomequoteSystemException {
		LOG.info("PropertyDAO.saveQuote - starts");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		Quote quote = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			//select * from Quote where QUOTE_ID = ?
			stmt = conn.prepareStatement(SqlQueries.GET_QUOTE);
			stmt.setInt(1, quoteId);
			resultSet = stmt.executeQuery();
			quote = new Quote();
			while (resultSet.next()) {
				quote.setQuoteId(resultSet.getInt(1));
				quote.setPremium(resultSet.getDouble(2));
				quote.setDwellingCoverage(resultSet.getDouble(3));
				quote.setDetachedStructure(resultSet.getDouble(4));
				quote.setPersonalProperty(resultSet.getDouble(5));
				quote.setAddnlLivgExpense(resultSet.getDouble(6));
				quote.setMedicalExpense(resultSet.getDouble(7));
				quote.setDeductible(resultSet.getDouble(8));
			}
			resultSet.close();
			stmt.close();
		}
		catch (SQLException e)
		{
			throw new HomequoteSystemException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HomequoteSystemException(e.getMessage());
		} 
		finally
		{
			try
			{
				resultSet.close();
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				LOG.error("Exception while trying to close Connection : " + e.getMessage() );
			}
		}
		LOG.info("PropertyDAO.saveQuote - ends");
		return quote;
	}
	
	/**
	 * @param quote
	 * @throws HomequoteSystemException
	 */
	public void saveQuote(final Quote quote) throws HomequoteSystemException {
		LOG.info("PropertyDAO.saveQuote - starts");
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			//INSERT INTO Quote (QUOTE_ID, PREMIUM, DWELLING_COVERAGE, DETACHED_STRUCTURE,
			//PERSONAL_PROPERTY, ADDNL_LIVING_EXPENSE, MEDICAL_EXPENSE, DEDUCTIBLE) VALUES
			//(?, ?, ?, ?, ?, ?, ?, ?);
			stmt = conn.prepareStatement(SqlQueries.SAVE_QUOTE);
			stmt.setInt(1, quote.getQuoteId());
			stmt.setDouble(2, quote.getPremium());
			stmt.setDouble(3, quote.getDwellingCoverage());
			stmt.setDouble(4, quote.getDetachedStructure());
			stmt.setDouble(5, quote.getPersonalProperty());
			stmt.setDouble(6, quote.getAddnlLivgExpense());
			stmt.setDouble(7, quote.getMedicalExpense());
			stmt.setDouble(8, quote.getDeductible());
			stmt.executeUpdate();
			stmt.close();
		}
		catch (SQLException e)
		{
			throw new HomequoteSystemException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HomequoteSystemException(e.getMessage());
		} 
		finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				LOG.error("Exception while trying to close Connection : " + e.getMessage() );
			}
		}
		LOG.info("PropertyDAO.saveQuote - ends");
	}
}
