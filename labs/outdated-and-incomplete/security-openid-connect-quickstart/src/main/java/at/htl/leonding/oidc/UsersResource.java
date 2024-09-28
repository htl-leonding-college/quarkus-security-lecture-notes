package at.htl.leonding.oidc;

import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.reactive.NoCache;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/users")
public class UsersResource {

    @Inject
    SecurityIdentity identity;

    @GET
    @RolesAllowed("user")
    //@PermitAll
    @Path("/me")
    @NoCache
    @Produces({MediaType.APPLICATION_JSON})
    public User me() {
        return new User(identity);
    }

    public static class User {

        private final String userName;

        User(SecurityIdentity identity) {
            this.userName = identity.getPrincipal().getName();
        }

        public String getUserName() {
            return userName;
        }
    }
}

