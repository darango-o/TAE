import java.util.Scanner;

public class GlobantBank {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;
        Bank bank = new Bank();

        System.out.println("Bienvenido a Globant Bank.");
        do {
            System.out.println("\nMarque el número con la opción que desee: \n1. Iniciar Sesión.\n2. Crear cuenta.\n3. Mostrar información de nuestros usuarios.\n4. Salir.");
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("\nIngrese el número de la cuenta: ");
                    bank.clientManager(scanner.nextInt());
                }
                case 2 -> {
                    bank.createClient();
                }
                case 3 -> {
                    System.out.println(bank.toString());
                }
                case 4 -> {
                    System.out.println("Gracias por usar los servicios de Globant Bank.");
                    return;
                }
                default -> System.out.println("Opción inválida. Ingrese una opción válida.");
            }

        } while (true);
    }
}
