package ControlAPI;

import jakarta.jws.soap.SOAPBinding.Use;
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
import DataBase.DBServices.UserService;
import Model.User.User;


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
    @Path("/check")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consulta() {
        List<User> user = new ArrayList<>();
        user = userService.consultar();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origen", "*")
                .entity(user)
                .build();
    }

}
