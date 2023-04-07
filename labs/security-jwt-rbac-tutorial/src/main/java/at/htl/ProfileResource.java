package at.htl;

import at.htl.service.TokenService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Path("/profile")
@RequestScoped
public class ProfileResource {

    @Inject
    TokenService service;

    @GET
    @RolesAllowed({"User"})
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public HashMap<String, String> register(@QueryParam("username") String username,
                                            @QueryParam("email") String email,
                                            @QueryParam("birthdate") String birthdate
    ) {
        final String token = service.generateToken(email, username, birthdate);
        return new HashMap<String, String>() {{
            put("token",token);
        }};

    }
}