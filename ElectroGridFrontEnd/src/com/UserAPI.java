package com;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	User userObj = new User();
	
    public UserAPI() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = userObj.insertUser(request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("pass"),
				request.getParameter("mobile"),
				request.getParameter("type"));

		response.getWriter().write(output);
	}

	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request)
	    {
			Map<String, String> map = new HashMap<String, String>();
			try
			{
				Scanner scanner = new Scanner(request.getInputStream(),"UTF-8");
				String queryString = scanner.hasNext() ?
						scanner.useDelimiter("\\A").next() : "";
				scanner.close();
		 
				String[] params = queryString.split("&");
				for (String param : params)
				{ 
					String[] p = param.split("=");
					map.put(p[0], p[1]);
			    }
			 }
					
			 catch (Exception e)
		     {
			 }
			 
			return map;
		}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = userObj.updateUser(paras.get("hidItemIDSave").toString(),
										   paras.get("name").toString(),
										   paras.get("email").toString(),
										   paras.get("pass").toString(),
										   paras.get("mobile").toString(),
										   paras.get("type").toString());
			
		response.getWriter().write(output);
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		Map paras = getParasMap(request);
		String output = userObj.deleteUser(paras.get("id").toString());
		response.getWriter().write(output);
	}

}
