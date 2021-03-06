package com.myorg.hzsession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
  protected void doPost (HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

    HttpSession session = request.getSession(false);

    // Invalidate the session and removes any attribute related to it
    System.out.println("going to invalidate session");
    session.invalidate();

    // Get an HttpSession related to this request, if no session exist don't
    // create a new one. This is just a check to see after invalidation the
    // session will be null.
    session = request.getSession(false);

    response.getWriter().println("Session : " + session);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    doPost(request, response);
  }
}
