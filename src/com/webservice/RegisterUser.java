package com.webservice;

import java.util.LinkedList;

import javax.servlet.ServletContext;

public class RegisterUser {
	public RegisterUser() {

	}

	public void newUser(ServletContext servletContext, String email) {
		LinkedList<String> userEmails = (LinkedList<String>) servletContext.getAttribute("userEmails");
		System.out.println("--------in this method---------");
		if (userEmails == null) {
			LinkedList<String> newUserEmails = new LinkedList<String>();
			newUserEmails.add(email);
			servletContext.setAttribute("userEmails", newUserEmails);
		} else {
			userEmails.add(email);
		}
		System.out.println(userEmails);
	}

}
