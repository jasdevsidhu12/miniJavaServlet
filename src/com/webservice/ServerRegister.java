package com.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webservice.RegisterUser;
/**
 * Servlet implementation class Register
 */
public class ServerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected List<String> userEmails = new LinkedList<String>();
	protected ServletContext servletContext;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getPathInfo().split("/")[1];
		new RegisterUser().newUser(getServletContext(), userEmail);

	}

	protected void saveEmails(HttpServletResponse response, String email) {
		System.out.println(getServletContext().getAttribute("userEmails"));
		ArrayList<String> userEmails = (ArrayList<String>) getServletContext().getAttribute("userEmails");
		if (userEmails == null) {
			System.out.println("creating a new linked list");
			ArrayList<String> newUserEmails = new ArrayList<String>();
			newUserEmails.add(email);
			getServletContext().setAttribute("userEmails", newUserEmails);
		} else {
			System.out.println("appending new email into linked list");
			userEmails.add(email);
		}
	}

	protected void displayEmails(HttpServletResponse response, String userEmail) throws IOException {
		userEmails.add(userEmail);
		Iterator<String> itr = userEmails.iterator();
		while (itr.hasNext()) {
			response.getWriter().println("Email : " + itr.next());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
