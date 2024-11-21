package DataBase.DBServices;

import java.util.List;
import DataBase.DBObjects.UserComercialDAO;
import Model.User.User;

public class UserComercialService {
    UserComercialDAO userDAO = new UserComercialDAO();
    
    public List<User> check(){
        return userDAO.check();
    }

    // public User_Comercial checkId(User_Comercial user){
    //     return userDAO.checkId(user);
    // }

    // public int crear(User_Comercial user){
    //     return userDAO.create(user);
    // }

    // public int delete(User_Comercial user){
    //     return userDAO.delete(user);
    // }

    // public int update(User_Comercial user){
    //     return userDAO.update(user);
    // }
}
