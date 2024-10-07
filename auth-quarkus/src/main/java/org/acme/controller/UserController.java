package org.acme.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.UserEntity;
import org.acme.service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @POST
    public Response createUser(UserEntity userEntity) {
        return Response.ok(UserService.createUser(userEntity)).build();

    }


}



