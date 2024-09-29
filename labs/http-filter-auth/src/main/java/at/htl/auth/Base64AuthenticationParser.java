package at.htl.auth;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Base64;
import java.util.regex.Pattern;

@ApplicationScoped
public class Base64AuthenticationParser {
    private static final Pattern BASIC_AUTH_PATTERN = Pattern.compile("Basic (.*)");

    public static record Credentials(String username, String password) {}

    public Credentials parseAuthenticationHeader(String header) {
        if (header == null) {
            return null;
        }

        var matcher = BASIC_AUTH_PATTERN.matcher(header);
        if (!matcher.find()) {
            return null;
        }

        var encodedCredentials = matcher.group(1);
        var decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
        Log.info(decodedCredentials);

        var usernameAndPassword = decodedCredentials.split(":");
        return new Credentials(usernameAndPassword[0], usernameAndPassword[1]);
    }
}