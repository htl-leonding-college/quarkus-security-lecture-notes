package at.htl.security.openid.connect;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/admin")
public class AdminResource {

    @Inject
    JsonWebToken jwt;

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    @NoCache
    public String admin() {
        return "Access for subject " + jwt.getSubject() + " is granted";
    }
}