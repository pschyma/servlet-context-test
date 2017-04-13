package de.schyma.pax;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;


@Component(
  service = Object.class,
  scope = ServiceScope.PROTOTYPE,
  property = {
    HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PREFIX + "=/web",
    HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PATTERN + "=/resources",
    DemoServletContext.CONTEXT_SERVICE_SELECTOR
  }
)
public class DemoResourceService {
  // nothing to implement
}
