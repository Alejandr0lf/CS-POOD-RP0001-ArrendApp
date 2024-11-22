package ControlAPI;

import java.util.ArrayList;
import java.util.List;

import DataBase.DBServices.DirectionService;
import Model.appObjects.Direction;
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

@Path("/direction")
public class DBBuildingDirection_Controller {

    DirectionService directionService = new DirectionService();

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
        List<Direction> directions = new ArrayList<>();
        directions = directionService.check();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origen", "*")
                .entity(directions)
                .build();
    }

    @GET
    @Path("/check/{coordinate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkID(@PathParam("coordinate") String coordinates) {
        Direction directionId = new Direction(coordinates);
        Direction dReturn = directionService.checkId(directionId);
        return Response
                .status(200)
                .entity(dReturn)
                .build();
    }

    @POST
    @Path("/upload")
    @Produces(MediaType.APPLICATION_JSON)
    public Response upload(Direction direction) {
        try {
            directionService.create(direction);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(direction)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/delete/{coordinate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("coordinate") String coordinate) {
        Direction x = new Direction(coordinate);
        int i = directionService.delete(x);
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
    public Response update(Direction direction) {
        try {
            directionService.update(direction);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(direction)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
