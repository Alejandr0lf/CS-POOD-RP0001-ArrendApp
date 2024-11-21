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
import DataBase.DBServices.*;
import Model.appObjects.Services;

@Path("/services")
public class DBBuildingServices_Controller {

    ServicesService servicesService = new ServicesService();

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
        List<Services> services = new ArrayList<>();
        services = servicesService.check();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origen", "*")
                .entity(services)
                .build();
    }

    @GET
    @Path("/check/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkID(@PathParam("id") String id) {
        Services serviceId = new Services(Long.parseLong(id));
        Services servicesReturn = servicesService.checkId(serviceId);
        return Response
                .status(200)
                .entity(servicesReturn)
                .build();
    }

    @POST
    @Path("/upload")
    @Produces(MediaType.APPLICATION_JSON)
    public Response upload(Services services) {
        try {
            servicesService.create(services);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(services)
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
        Services x = new Services(Long.parseLong(id));
        int i = servicesService.delete(x);
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
    public Response update(Services services) {
        try {
            servicesService.update(services);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(services)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
