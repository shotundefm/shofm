package com.cts.insurance.homequote.bo;

import com.cts.insurance.homequote.exception.HomequoteBusinessException;

public class Validate {

	public static void main(String[] args) {
		LoginBO login = new LoginBO();
		try {
			login.getUser("shawn");
		} catch (HomequoteBusinessException e) {
			
			e.printStackTrace();
		}
	

}
}
