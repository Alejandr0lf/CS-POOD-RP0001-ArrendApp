package testing.User;

import java.util.Scanner;

import DataBase.DBServices.UserService;
import Model.User.User;
import Model.User.User_Client;

public class User_test2 {
    public static void main(String[] args) {

        /* -------------------------------------------------------------------------- */
        /* Test para eliminar usuarios de la base de datos */
        /* -------------------------------------------------------------------------- */
        String ID = "102298";
        User user = new User_Client(ID);
        UserService newService = new UserService();
        newService.delete(user);
    }
}
