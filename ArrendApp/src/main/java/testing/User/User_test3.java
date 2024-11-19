package testing.User;

import DataBase.DBServices.UserService;
import Model.User.User;
import Model.User.User_Client;

public class User_test3 {
    public static void main(String[] args) {

        /* -------------------------------------------------------------------------- */
        /* Test para actualizar un usuario en la base de datos */
        /* -------------------------------------------------------------------------- */

        long ID = 10;
        User user = new User_Client(ID, "Agente", "007", "+57 (323) 056-7890", "agente007@agente.com");
        UserService newService = new UserService();
        newService.update(user);
    }
}
