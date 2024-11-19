package testing.User;

import java.util.Scanner;
import DataBase.DBServices.UserService;
import Model.User.*;

public class User_test1 {
    public static void main(String[] args) {

        /* -------------------------------------------------------------------------- */
        /* Test para crear usuarios */
        /* -------------------------------------------------------------------------- */

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

        User user = new User_Client(id, name, lastname, number, email);

        UserService add = new UserService();
        add.crear(user);

        scan.close();
    }
}
