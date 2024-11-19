package testing;

import java.util.Scanner;

import DataBase.DBServices.UserService;
import Model.User.User;
import Model.User.User_Client;

public class CreatingUsers {

    // Scanner scan = new Scanner(System.in);

    // System.out.println("Nombre: ");
    // String name = scan.nextLine();

    // System.out.println("Apellido: ");
    // String lastname = scan.nextLine();

    // System.out.println("Cédula: ");
    // long id = scan.nextLong();

    // System.out.println("Número: ");
    // scan.nextLine();
    // String number = scan.nextLine();

    // System.out.println("Email: ");
    // String email = scan.nextLine();

    // User user = new User_Client(id, name, lastname, number, email);

    // scan.close();
    public static void main(String[] args) {

        System.out.println("0: " + comprobar("+573113936341"));
        System.out.println("1: " + comprobar("+57 311 393 6341"));
        System.out.println("2: " + comprobar("+123113936341"));
        System.out.println("3: " + comprobar("+57-311-393-6341"));
        System.out.println("4: " + comprobar("+57 (311) 3936341"));
        System.out.println("5: " + comprobar("+57,311.393||6341"));

    }

    public static boolean comprobar(String num) {
        if (num != null) {
            num = num.replaceAll("[^0-9]", "");
            if (num.length() >= 11 && num.length() <= 14) {
                return true;
            }
        }
        return false;
    }

}
