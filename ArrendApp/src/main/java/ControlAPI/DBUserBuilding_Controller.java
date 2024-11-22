package ControlAPI;

import java.util.ArrayList;
import java.util.List;

import DataBase.DBServices.BuildingService;
import Model.appObjects.Building;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/building")
public class DBUserBuilding_Controller {

    BuildingService buildingService = new BuildingService();

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
        List<Building> directions = new ArrayList<>();
        directions = buildingService.check();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origen", "*")
                .entity(directions)
                .build();
    }
}
