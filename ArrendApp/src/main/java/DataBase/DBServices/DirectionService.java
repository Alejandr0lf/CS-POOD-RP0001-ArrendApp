package DataBase.DBServices;

import java.util.List;

import DataBase.DBObjects.DirectionDAO;
import Model.appObjects.Direction;

public class DirectionService {
    DirectionDAO directionDAO = new DirectionDAO();
    
    public List<Direction> check(){
        return directionDAO.check();
    }

    public Direction checkId(Direction services){
        return directionDAO.checkId(services);
    }

    public int create(Direction services){
        return directionDAO.create(services);
    }

    public int delete(Direction services){
        return directionDAO.delete(services);
    }

    public int update(Direction services){
        return directionDAO.update(services);
    }

}
