package at.htl;

import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class UserResource {

    @Inject
    SecurityIdentity identity;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @NoCache
    public SecurityIdentity getUserInfo(){
        return identity;
    }

    @GET
    @Path("/admin")
    public String getAdmin() {
        return "I am admin";
    }
}

