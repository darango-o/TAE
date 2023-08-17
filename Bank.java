import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bank {
    private ArrayList<Client> clients = new ArrayList<Client>();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    private void addClient(Client client){
        clients.add(client);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Client client : clients){
            s.append("Usuario: ").append(client.getUser_name()).append("\tNúmero de cuenta: ").append(client.getAccount().getAccount_number()).append("\tFecha de creación: ").append(client.getAccount().getOpening_date()).append("\nBalance: ").append(client.getAccount().getBalance()).append("\n");
        }

        return s.toString();
    }

    public Client getClient(int account_number){
        for(Client client : clients){
            if (account_number == client.getAccount().getAccount_number()){
                System.out.println("\nCuenta encontrada.");
                return client;
            }
        }
        System.out.println("\nLa cuenta no se encuentra en el sistema.");
        return null;
    }

    public void clientManager(int account_number){
        Client client = getClient(account_number);
        if(client==null){
            return;
        }
        System.out.println("\nBienvenido " + client.getUser_name() + ".");
        int choice;
        do{
            System.out.println("\nSeleccione una de las siguientes opciones: \t(Saldo: $" + client.getAccount().getBalance() + ".)\n1. Depositar dinero.\n2. Retirar dinero.\n3. Transferir dinero.\n4. Cancelar.");
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("\nIngrese la cantidad de dinero que desea depositar: ");
                    client.getAccount().addBalance(scanner.nextDouble());
                    System.out.println("\nTransacción hecha exitosamente.");
                }
                case 2 -> {
                    System.out.println("\nIngrese la cantidad de dinero que desea retirar: ");
                    client.getAccount().withdrawBalance(scanner.nextDouble());
                    System.out.println("\nTransacción hecha exitosamente.");
                }
                case 3 -> {
                    System.out.println("\nIngrese el número de la cuenta a la que desea transferir: ");
                    Client temp = getClient(scanner.nextInt());
                    System.out.println("\nIngrese la cantidad de dinero que desea transferir: ");
                    double temp_q = scanner.nextDouble();
                    temp.getAccount().addBalance(temp_q);
                    client.getAccount().withdrawBalance(temp_q);
                    System.out.println("\nTransacción hecha exitosamente.");
                }
                case 4 -> {
                    System.out.println("Volviendo al menú principal.");
                    return;
                }
                default -> System.out.println("Opción inválida. Ingrese una opción válida.");
            }
        }while (true);
    }

    public void createClient(){
        System.out.println("\nIngresa tu nombre completo:");
        String username = scanner.nextLine();
        System.out.println("\nIngresa una contraseña: ");
        String password = scanner.nextLine();
        String password_confirmation = null;
        do{
            System.out.println("\nEscribe de nuevo tu contraseña: ");
            password_confirmation = scanner.nextLine();
        }while (!password.equals(password_confirmation));
        int account_number = random.nextInt(9000) + 1000;
        System.out.println("\nSu número de cuenta será: " + account_number);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String open_date = currentDate.format(dateFormatter);

        Account account = new Account(account_number, open_date, 0);
        Client client = new Client(account, username, password);
        addClient(client);
        System.out.println("\nUsuario creado correctamente.\nCuenta creada el: " + open_date);

    }
    public void transferMoney(Client client, double quantity){
        client.getAccount().addBalance(quantity);
    }
}
