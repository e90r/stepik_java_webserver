package servlets;

import resourceServer.ResourceServer;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourcesServlet extends HttpServlet {
    public static final String PAGE_URL = "/resources";
    private ResourceServer resourceServer;

    public ResourcesServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) {

        String path = request.getParameter("path");
        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(path);
        resourceServer.setResource(resource);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
