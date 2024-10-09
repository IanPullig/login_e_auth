package org.acme;

import io.vertx.ext.auth.authentication.Credentials;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthRecurso {

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    public Response login(Credentials credentials){
        User user = authService.findByUsername(credentials.username);
        if (user != null && authService.verifiyPassword(credentials.password, user.password)) {
            String token = authService.generateToken(user.username, user.role);
            return Response.ok(token).build();
        }
    }


    public class Credentials {
        public String username;
        public String password;
    }
}
