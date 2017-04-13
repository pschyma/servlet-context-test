package de.schyma.pax;


import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.http.context.ServletContextHelper;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Set;


@Component(
  service = ServletContextHelper.class,
  scope = ServiceScope.BUNDLE,
  property = {
    HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "=" + DemoServletContext.NAME,
    HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_PATH + "=/demo",
  }
)
public class DemoServletContext
  extends ServletContextHelper {

  private static final Logger LOGGER = LoggerFactory.getLogger(DemoServletContext.class);


  public static final String NAME = "demo-ctx";


  public static final String CONTEXT_SERVICE_SELECTOR = HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT +
    "=(" + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "=" + DemoServletContext.NAME + ")";


  private ServletContextHelper delegate;


  @Activate
  public void activate(BundleContext bundleContext, ComponentContext componentContext) {
    LOGGER.info("bundle context   : {}", bundleContext.getBundle());
    LOGGER.info("component context: {}", componentContext.getUsingBundle());
    delegate = new ServletContextHelper(bundleContext.getBundle()) {
    };
  }


  @Override
  public URL getResource(String name) {
    LOGGER.info("requested resource: {}", name);
    return delegate.getResource(name);
  }


  @Override
  public String getMimeType(String name) {
    return delegate.getMimeType(name);
  }


  @Override
  public Set<String> getResourcePaths(String path) {
    return delegate.getResourcePaths(path);
  }


  @Override
  public String getRealPath(String path) {
    return delegate.getRealPath(path);
  }

}
