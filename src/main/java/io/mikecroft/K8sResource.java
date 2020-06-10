package io.mikecroft;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;

@Path("/pods")
public class K8sResource {

    @Inject
    PodLister podLister;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPods() {
        return podLister.getPods();
    }
}