package testing;

import java.util.Scanner;
import Model.User.User;
import Model.User.User_Client;

public class CreatingUsers {
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

        User user = new User_Client(id, name, lastname, number, email);
        System.out.println(user);

        scan.close();

    }
}
