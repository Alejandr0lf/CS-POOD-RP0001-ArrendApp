package ControlAPI;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import Model.User.User;
import DataBase.DBServices.*;
import Model.User.User_Client;

@Path("/client")
public class DBUserCliente_Controller {

    UserClientService userService = new UserClientService();

    @GET
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @GET
    @Path("/check/All")
    @Produces(MediaType.APPLICATION_JSON)
    public Response check() {
        List<User> user = new ArrayList<>();
        user = userService.check();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origen", "*")
                .entity(user)
                .build();
    }

    @GET
    @Path("/check/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkID(@PathParam("id") String id) {
        User_Client userID = new User_Client(id);
        User_Client userReturn = userService.checkId(userID);
        return Response
                .status(200)
                .entity(userReturn)
                .build();
    }

    @POST
    @Path("/upload")
    @Produces(MediaType.APPLICATION_JSON)
    public Response upload(User_Client user) {
        try {
            userService.crear(user);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(user)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) {
        User_Client x = new User_Client(id);
        int i = userService.delete(x);
        if (i > 0) {
            return Response
                    .ok("Correcto")
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Incorrecto")
                    .build();
        }
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(User_Client user) {
        try {
            userService.update(user);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(user)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
