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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Policy;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;
import com.cts.insurance.homequote.util.SqlQueries;

public class PolicyDAO {
	private final static Logger LOG =  Logger.getLogger(PolicyDAO.class);
	/**
	 * @param userName
	 * @return
	 * @throws HomequoteSystemException
	 */
	public List<Policy> getPolicies(final String userName) throws HomequoteSystemException {
		LOG.info("PolicyDAO.getPolicies - starts");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		ArrayList<Policy> policyList = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			//SELECT * from Policy p, Location l where p.QUOTE_ID= l.QUOTE_ID and l.USER_NAME = ?
			stmt = conn.prepareStatement(SqlQueries.GET_POLICIES);
			stmt.setString(1, userName);
			resultSet = stmt.executeQuery();
			policyList = new ArrayList<Policy>();
			while (resultSet.next()) {
				Policy policy = new Policy();
				policy.setPolicyKey(resultSet.getString(1));
				policy.setQuoteId(resultSet.getInt(2));
				policy.setPolicyEffDate(resultSet.getString(3));
				policy.setPolicyEndDate(resultSet.getString(4));
				policy.setPolicyTerm(resultSet.getInt(5));
				policy.setPolicyStatus(resultSet.getString(6));
				policyList.add(policy);
			}
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
				conn.close();
			}
			catch (SQLException e)
			{
				LOG.error("Exception while trying to close Connection : " + e.getMessage() );
			}
		}
		LOG.info("PolicyDAO.getPolicies - ends");
		return policyList;
	}
	
	/**
	 * @param quote
	 * @throws HomequoteSystemException
	 */
	public void savePolicy(final Policy policy) throws HomequoteSystemException {
		LOG.info("PolicyDAO.savePolicy - starts");
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			//INSERT INTO Policy (POLICY_KEY, QUOTE_ID, POLICY_EFFECTIVE_DATE,
			//POLICY_END_DATE, POLICY_TERM, POLICY_STATUS) VALUES
			//('14_1', 14, '2013-07-17', '2014-07-17', 1, 'ACTIVE');
			stmt = conn.prepareStatement(SqlQueries.SAVE_POLICY);
			stmt.setString(1, policy.getPolicyKey());
			stmt.setInt(2, policy.getQuoteId());
			stmt.setString(3, policy.getPolicyEffDate());
			stmt.setString(4, policy.getPolicyEndDate());
			stmt.setInt(5, policy.getPolicyTerm());
			stmt.setString(6, policy.getPolicyStatus());
			stmt.executeUpdate();
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
		LOG.info("PolicyDAO.savePolicy - ends");
	}

	/**
	 * @param policyKey
	 * @return
	 */
	public Policy renewPolicy(final String policyKey) throws HomequoteSystemException
	{
		return modifyPolicy("Renew", policyKey);
	}
	/**
	 * @param policyKey
	 * @return
	 */
	public Policy cancelPolicy(final String policyKey) throws HomequoteSystemException
	{	
		return modifyPolicy("Cancel", policyKey);
	}
	
	/**
	 * @param policyKey
	 * @return
	 * @throws HomequoteSystemException
	 */
	public Policy modifyPolicy(final String updateAction, final String policyKey) throws HomequoteSystemException {
		LOG.info("PolicyDAO.getPolicy - starts");
		Connection conn = null;
		ResultSet resultSet = null;
		Policy policy = null;
		try
		{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			
			if("Renew".equals(updateAction))
			{
				final PreparedStatement stmt = conn.prepareStatement(SqlQueries.RENEW_POLICY);
				stmt.setString(1, policyKey);
				stmt.executeUpdate();
				stmt.close();
			} else if("Cancel".equals(updateAction))
			{
				final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    final String todaysDate = sdf.format(Calendar.getInstance().getTime());
			    
				final PreparedStatement stmt = conn.prepareStatement(SqlQueries.CANCEL_POLICY);
				stmt.setString(1, todaysDate);
				stmt.setString(2, policyKey);
				stmt.executeUpdate();
				stmt.close();
			}
			
			//SELECT * from Policy where POLICY_KEY = ?
			final PreparedStatement stmt = conn.prepareStatement(SqlQueries.GET_POLICY);
			stmt.setString(1, policyKey);
			resultSet = stmt.executeQuery();
			policy = new Policy();
			while (resultSet.next()) {
				policy.setPolicyKey(resultSet.getString(1));
				policy.setQuoteId(resultSet.getInt(2));
				policy.setPolicyEffDate(resultSet.getString(3));
				policy.setPolicyEndDate(resultSet.getString(4));
				policy.setPolicyTerm(resultSet.getInt(5));
				policy.setPolicyStatus(resultSet.getString(6));
			}
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
				conn.close();
			}
			catch (SQLException e)
			{
				LOG.error("Exception while trying to close Connection : " + e.getMessage() );
			}
		}
		LOG.info("PolicyDAO.getPolicy - ends");
		return policy;
	}
}
