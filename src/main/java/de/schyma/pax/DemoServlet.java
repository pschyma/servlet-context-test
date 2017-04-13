package de.schyma.pax;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Peter Schyma
 * @since 10.04.17
 */
@Component(
  service = Servlet.class,
  scope = ServiceScope.PROTOTYPE,
  property = {
    HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/servlet",
    DemoServletContext.CONTEXT_SERVICE_SELECTOR
  }
)
public class DemoServlet
  extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    resp.getOutputStream().println("registered servlet");
  }
}
