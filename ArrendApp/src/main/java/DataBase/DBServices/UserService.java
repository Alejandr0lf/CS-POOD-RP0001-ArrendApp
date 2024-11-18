package DataBase.DBServices;

import java.util.List;
import DataBase.DBObjects.UserDAO;
import Model.User.User;

public class UserService {
    UserDAO userDAO = new UserDAO();
    
    public List<User> consultar(){
        return userDAO.consultar();
    }
}
