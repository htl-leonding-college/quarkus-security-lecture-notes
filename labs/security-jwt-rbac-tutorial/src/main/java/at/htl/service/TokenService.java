package at.htl.service;

import org.acme.jwt.utils.TokenUtils;
import org.eclipse.microprofile.jwt.Claims;
import org.jboss.logging.Logger;
import org.jose4j.jwt.JwtClaims;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class TokenService {

    @Inject
    Logger logger;

    public String generateToken(String email, String username, String birthdate) {
        try {
            JwtClaims jwtClaims = new JwtClaims();
            jwtClaims.setIssuer("htl-leonding");
            jwtClaims.setJwtId("a-123");
            jwtClaims.setSubject(email);
            jwtClaims.setClaim(Claims.upn.name(), email);
            jwtClaims.setClaim(Claims.preferred_username.name(), username);
            jwtClaims.setClaim(Claims.birthdate.name(), birthdate);
            jwtClaims.setClaim(Claims.groups.name(), List.of(TokenUtils.ROLE_USER));
            jwtClaims.setAudience("using-jwt");
            jwtClaims.setExpirationTimeMinutesInTheFuture(1);

            String token = TokenUtils.generateTokenString(jwtClaims);
            logger.infof("Token generated: %s", token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
