package ControlAPI;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import DataBase.DBServices.UserService;
import Model.User.User;
import Model.User.User_Client;


@Path("/user")
public class DBUserUsers_Controller {

    UserService userService = new UserService();

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
        user = userService.consultar();
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
        User userID = new User_Client(id);
        User userReturn = userService.consultar(userID);
        return Response
                .status(200)
                .entity(userReturn)
                .build();
    }

}
