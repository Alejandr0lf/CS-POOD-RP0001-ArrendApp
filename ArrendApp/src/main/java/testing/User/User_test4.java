package testing.User;

import DataBase.DBServices.UserService;

public class User_test4 {
    public static void main(String[] args) {
        UserService newService = new UserService();
        System.out.println(newService.consultar());
    }
    
}
