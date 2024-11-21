package DataBase.DBServices;

import java.util.List;

import DataBase.DBObjects.UserClientDAO;
import Model.User.User;
import Model.User.User_Client;

public class UserClientService {
    UserClientDAO userDAO = new UserClientDAO();
    
    public List<User> check(){
        return userDAO.check();
    }

    public User_Client checkId(User_Client user){
        return userDAO.checkId(user);
    }

    public int crear(User_Client user){
        return userDAO.create(user);
    }

    public int delete(User_Client user){
        return userDAO.delete(user);
    }

    public int update(User_Client user){
        return userDAO.update(user);
    }
}
