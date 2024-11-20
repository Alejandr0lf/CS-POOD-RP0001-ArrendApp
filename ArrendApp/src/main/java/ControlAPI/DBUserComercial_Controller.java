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
import DataBase.DBServices.UserClientService;
import DataBase.DBServices.UserService;
import Model.User.User;
import Model.User.User_Client;

@Path("/comercial")
public class DBUserComercial_Controller {

    // CORREGIR TODA ESTA MRD

    // UserComercialService userService = new UserComercialService();

    // @GET
    // public Response ping() {
    // return Response
    // .ok("ping Jakarta EE")
    // .build();
    // }

    // @GET
    // @Path("/seeAll")
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response consulta() {
    // List<User> user = new ArrayList<>();
    // user = userService.consultar();
    // return Response
    // .status(200)
    // .header("Access-Control-Allow-Origen", "*")
    // .entity(user)
    // .build();
    // }

    // @POST
    // @Path("/upload")
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response crear(User_Client user) {
    // try {
    // userClientService.crear(user);
    // return Response
    // .status(Response.Status.CREATED)
    // .entity(user)
    // .build();
    // } catch (Exception e) {
    // return Response
    // .status(Response.Status.INTERNAL_SERVER_ERROR)
    // .entity(e.getMessage())
    // .build();
    // }
    // }

    // @DELETE
    // @Path("/delete/{id}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response borrar(@PathParam("id") String id) {
    // User x = new User_Client(id);
    // int i = userService.delete(x);
    // if (i > 0) {
    // return Response
    // .ok("Correcto")
    // .build();
    // } else {
    // return Response
    // .status(Response.Status.BAD_REQUEST)
    // .entity("Incorrecto")
    // .build();
    // }
    // }

    // @PUT
    // @Path("/update")
    // @Produces(MediaType.APPLICATION_JSON)
    // @Consumes(MediaType.APPLICATION_JSON)
    // public Response actualizar(User user) {
    // try {
    // userService.update(user);
    // return Response
    // .status(Response.Status.CREATED)
    // .entity(user)
    // .build();
    // } catch (Exception e) {
    // return Response
    // .status(Response.Status.INTERNAL_SERVER_ERROR)
    // .entity(e.getMessage())
    // .build();
    // }
    // }
    // }

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

}
