package testing.User;

import java.util.Scanner;

import DataBase.DBServices.UserService;
import Model.User.User_Client;

/**
 * TEST 3: UPDATE AN NORMAL USER OF THE DATABASE
 */
public class User_test3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        UserService newService = new UserService();

        System.out.println("¿Qué ID de usuario quiere actualizar?: ");
        long ID = Long.parseLong(scan.nextLine());

        System.out.println("Nombre: ");
        String name = scan.nextLine();

        System.out.println("Apellido: ");
        String lastname = scan.nextLine();

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
        User_Client user = new User_Client(ID, name, lastname, number, email);

        newService.update(user);

        scan.close();
    }
}
