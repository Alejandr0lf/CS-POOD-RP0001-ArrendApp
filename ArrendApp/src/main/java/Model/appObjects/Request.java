package Model.appObjects;

import Model.User.User_Client;

public class Request {
    private User_Client tenant;
    private Building building;
    
    public Request() {
    }
    
    public Request(User_Client tenant, Building building) {
        this.tenant = tenant;
        this.building = building;
    }
}
