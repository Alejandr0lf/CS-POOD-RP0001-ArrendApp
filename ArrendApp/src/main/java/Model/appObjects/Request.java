package Model.appObjects;

import Model.User.User_Client;

public class Request {

    private User_Client tenant;
    private Building building;
    private boolean accepted;
    
    public Request() {
    }
    
    public Request(User_Client tenant, Building building) {
        this.tenant = tenant;
        this.building = building;
    }

    public boolean accepted() {
        return accepted;
    }

    public void setStatus(boolean status) {
        this.accepted = status;
    }

    public User_Client getTenant() {
        return tenant;
    }

    public Building getBuilding() {
        return building;
    }
}
