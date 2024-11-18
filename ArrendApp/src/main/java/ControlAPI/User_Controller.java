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
import DataBase.DBServices.UserService;
import Model.User.User;
import Model.User.User_Client;
import Model.User.User_Comercial;

@Path("/user")
public class User_Controller {
    UserService userService = new UserService();

    @GET
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @GET
    @Path("/consultar")
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

//

// @GET
// @Path("/vehiculoconsulta/{id}")
// @Produces(MediaType.APPLICATION_JSON)
// public Response consultaID(@PathParam("id") String id) {
// Vehiculo vehiculo = new Vehiculo(id);
// Vehiculo rVehiculo = vehiculoServices.consultarID(vehiculo);
// return Response
// .status(200)
// .entity(rVehiculo)
// .build();
// }

// @POST
// @Path("/vehiculocrear")
// @Produces(MediaType.APPLICATION_JSON)
// public Response crear(Vehiculo vehiculo) {
// try {
// vehiculoServices.crear(vehiculo);
// return Response
// .status(Response.Status.CREATED)
// .entity(vehiculo)
// .build();
// }
// catch (Exception e){
// return
// Response
// .status(Response.Status.INTERNAL_SERVER_ERROR)
// .entity(e.getMessage())
// .build();
// }

// }

// @DELETE
// @Path("/vehiculoborrar/{id}")
// @Produces(MediaType.APPLICATION_JSON)
// public Response borrar(@PathParam("id") String id){
// Vehiculo vehiculo = new Vehiculo(id);
// int i = vehiculoServices.borrar(vehiculo);
// if (i > 0){
// return Response
// .ok("Correcto")
// .build();
// }
// else {
// return Response
// .status(Response.Status.BAD_REQUEST)
// .entity("Incorrecto")
// .build();
// }

// }

// @PUT
// @Path("/vehiculoactualizar")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public Response actualizar(Vehiculo vehiculo){
// try {
// vehiculoServices.actualizar(vehiculo);
// return Response
// .status(Response.Status.CREATED)
// .entity(vehiculo)
// .build();
// }
// catch (Exception e){
// return
// Response
// .status(Response.Status.INTERNAL_SERVER_ERROR)
// .entity(e.getMessage())
// .build();
// }

// }
