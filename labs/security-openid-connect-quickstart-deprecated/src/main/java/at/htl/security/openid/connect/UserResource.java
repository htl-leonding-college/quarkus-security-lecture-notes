package at.htl.security.openid.connect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/users")
public class UserResource {

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @RolesAllowed("user")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public SecurityIdentity getUserInfo() {
        return securityIdentity;
    }
}
