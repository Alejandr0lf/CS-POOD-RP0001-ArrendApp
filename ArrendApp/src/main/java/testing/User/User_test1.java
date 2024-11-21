package testing.User;

import java.util.Scanner;
import DataBase.DBServices.UserService;
import Model.User.*;

/**
 * TEST 1: CREATE AN NORMAL USER AND INSERT INTO THE DATABASE
 */
public class User_test1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Nombre: ");
        String name = scan.nextLine();

        System.out.println("Apellido: ");
        String lastname = scan.nextLine();

        System.out.println("Cédula: ");
        long id = scan.nextLong();

        System.out.println("Número: ");
        scan.nextLine();
        String number = scan.nextLine();

        System.out.println("Email: ");
        String email = scan.nextLine();

        /*
         * --------------------------------------------------------------------------
         *
         * We use and User_Client because could have the same parameters of an normal
         * User, and User is abstract and can't be instanced
         *
         * --------------------------------------------------------------------------
         */
        User user = new User_Client(id, name, lastname, number, email);

        UserService add = new UserService();
        add.create(user);

        scan.close();
    }
}
