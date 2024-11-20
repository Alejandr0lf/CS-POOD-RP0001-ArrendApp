package testing.User;

import java.util.Scanner;

/**
 * TEST 2: DELETE AN NORMAL USER OF THE DATABASE
 */
import DataBase.DBServices.UserService;
import Model.User.User;
import Model.User.User_Client;

public class User_test2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID:\n");
        String ID = isValidID(sc.nextLine());

        /*
         * --------------------------------------------------------------------------
         *
         * We use and User_Client because could have the same parameters of an normal
         * User, and User is abstract and can't be instanced
         *
         * --------------------------------------------------------------------------
         */
        User user = new User_Client(ID);
        UserService newService = new UserService();
        newService.delete(user);

        sc.close();
    }

    public static String isValidID(String s) {
        try {
            Long.parseLong(s);
            return s;
        } catch (NumberFormatException e) {
            throw new RuntimeException("The ID inputed isn't a valid number...");
        }
    }
}
