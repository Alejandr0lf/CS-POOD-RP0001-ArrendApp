package DataBase.DBServices;

import java.util.List;
import DataBase.DBObjects.UserDAO;
import Model.User.User;

public class UserService {
    UserDAO userDAO = new UserDAO();
    
    public List<User> consultar(){
        return userDAO.consultar();
    }

    public int crear(User user){
        return userDAO.create(user);
    }

    public int delete(User user){
        return userDAO.delete(user);
    }

    public int update(User user){
        return userDAO.update(user);
    }

}
