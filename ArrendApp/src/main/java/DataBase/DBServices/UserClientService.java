package DataBase.DBServices;

import java.util.List;

import DataBase.DBObjects.UserClientDAO;
import Model.User.User;
import Model.User.User_Client;

public class UserClientService {
    UserClientDAO userDAO = new UserClientDAO();
    
    public List<User> consultar(){
        return userDAO.consultar();
    }

    public User_Client consultar(User_Client user){
        return userDAO.consultarId(user);
    }

    public int crear(User_Client user){
        return userDAO.create(user);
    }

    // public int delete(User user){
    //     return userDAO.delete(user);
    // }

    // public int update(User user){
    //     return userDAO.update(user);
    // }
}
