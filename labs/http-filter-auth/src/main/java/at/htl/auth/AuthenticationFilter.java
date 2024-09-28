package at.htl.auth;

import io.quarkus.logging.Log;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext ctx) throws IOException {
        Log.info("Container Request Filter for authentication - Wer bin ich?");
        Log.info("Authorization=" + ctx.getHeaderString("Authorization"));
    }
}
