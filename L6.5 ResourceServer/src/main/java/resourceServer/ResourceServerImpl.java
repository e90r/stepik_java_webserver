package resourceServer;

import resources.TestResource;

public class ResourceServerImpl implements ResourceServer {
    private TestResource resource = null;

    @Override
    public TestResource getResource() {
        return resource;
    }

    @Override
    public void setResource(TestResource resource) {
        this.resource = resource;
    }
}
