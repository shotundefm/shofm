/**
 * This Business Object class is used to for Homeowner Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cts.insurance.homequote.dao.PolicyDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Policy;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public class PolicyBO {
	/**
	 * @param quoteId
	 * @param policyEffectiveDate
	 * @return
	 */
	public Policy savePolicy(final int quoteId, final String policyEffDate, final int term)
			throws HomequoteBusinessException, ParseException {
		final PolicyDAO poilcyDAO = new PolicyDAO();
		try {
			final Policy policy = new Policy();
			policy.setPolicyKey(quoteId + "_" + policy.getPolicyTerm());
			policy.setQuoteId(quoteId);
			policy.setPolicyEffDate(policyEffDate);
			policy.setPolicyEndDate(getDateAfterOneYear(policyEffDate));
			policy.setPolicyTerm(term);
			policy.setPolicyStatus(HomeInsuranceConstants.STATUS_ACTIVE);
			poilcyDAO.savePolicy(policy);
			return policy;
		} catch (HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
		}
	}

	/**
	 * @param userName
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public List<Policy> getPolicies(final String userName) throws HomequoteBusinessException {

		List<Policy> userPolicies = null;

		final PolicyDAO policyDAO = new PolicyDAO();
		try {
			userPolicies = policyDAO.getPolicies(userName);
		} catch (HomequoteSystemException e) {
			System.out.println("Can't get user policy exception " + e);
			e.printStackTrace();

		}

		return userPolicies; // return list of Object
	}

	/**
	 * @param policyKey
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Policy cancelPolicy(final String policyKey) throws HomequoteBusinessException {

		Policy canceledPolicy = null;

		final PolicyDAO policyDAO = new PolicyDAO();
		try {
			canceledPolicy = policyDAO.cancelPolicy(policyKey);
		} catch (HomequoteSystemException e) {
			System.out.println("Policy not calceled " + e);
			e.printStackTrace();

		}

		return canceledPolicy; // return Object
	}

	/**
	 * @param policyKey
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Policy renewPolicy(final String policyKey) throws HomequoteBusinessException {

		Policy renewedPolicy = null;

		final PolicyDAO policyDAO = new PolicyDAO();

		try {
			renewedPolicy = policyDAO.renewPolicy(policyKey);
		} catch (HomequoteSystemException e) {
			System.out.println("Policy not renewed " + e);
			e.printStackTrace();

		}
		return renewedPolicy; // return Object
	}

	/**
	 * @param policyEffectiveDate
	 * @throws ParseException
	 */
	private String getDateAfterOneYear(final String policyEffDate) throws HomequoteBusinessException {

		Date newDate = null;

		Date format;
		try {
			format = new SimpleDateFormat("yyyy-MM-dd").parse(policyEffDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(format);
			calendar.add(Calendar.YEAR, 1);
			newDate = calendar.getTime();
		} catch (ParseException e) {
			System.out.println("Could not parse date " + e);
			// }catch (HomequoteSystemException e) {
			// System.out.println("Date Exception " + e);
			//
		}
		return newDate.toString(); // return String
	}
}
