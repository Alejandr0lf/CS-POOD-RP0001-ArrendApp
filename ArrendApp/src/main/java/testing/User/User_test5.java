package testing.User;

import java.util.Scanner;

import DataBase.DBServices.UserService;
import Model.User.*;

/**
 * TEST 4: CHECK AN NORMAL USER OF THE DATABASE
 */
public class User_test5 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        UserService newService = new UserService();

        System.out.println("¿Qué ID de usuario quiere consultar?: ");
        String ID = scan.nextLine();

        User_Client u = new User_Client(ID);

        System.out.println(newService.consultar(u));

        scan.close();
    }

}
