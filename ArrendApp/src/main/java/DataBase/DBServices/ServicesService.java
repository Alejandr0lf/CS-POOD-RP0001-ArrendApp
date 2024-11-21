package DataBase.DBServices;

import java.util.List;

import DataBase.DBObjects.ServicesDAO;
import Model.appObjects.Services;

public class ServicesService {
    ServicesDAO servicesDAO = new ServicesDAO();
    
    public List<Services> check(){
        return servicesDAO.check();
    }

    public Services checkId(Services services){
        return servicesDAO.checkId(services);
    }

    public int create(Services services){
        return servicesDAO.create(services);
    }

    public int delete(Services services){
        return servicesDAO.delete(services);
    }

    public int update(Services services){
        return servicesDAO.update(services);
    }

}
