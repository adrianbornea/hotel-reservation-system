import java.io.IOException;
import java.util.Scanner;

public class MenuTest {

    public static void main(String[] args) throws IOException {

        showMainMenu();

    }

    // Login Module
    private static void loginModule() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your ID number: ");
        String personalIdNumber = input.nextLine();

        System.out.println("Please enter your password");
        String password = input.nextLine();

        if (Customer.checkCredentials(personalIdNumber, password)) {
            showLoggedInMenu();
        } else {
            System.out.println("Wrong credentials!");
        }


    }

    // Logged In Menu
    private static void showLoggedInMenu() throws IOException {

        System.out.println("Choose one of the options below: " +
                "\n 1. Make reservation " +
                "\n 2. Your reservations " +
                "\n 3. Cancel reservation " +
                "\n 4. Logout");
        boolean inside = true;
        int choice = readUsersChoice();

        do {
            switch (choice) {
                case 1:
                    System.out.println("\nMaking a reservation");
                    Customer.makeAReservation();
                    break;
                case 2:
                    System.out.println("\nYour reservations");
                    Customer.showCustomersReservations();
                    break;
                case 3:
                    System.out.println("\nCancel reservation");
                    Customer.cancelCustomersReservation();
                    break;

                case 4:
                    inside = false;
                    showMainMenu();
                default:
                    System.out.println("Invalid choice. Try again!");
            }
            showLoggedInMenu();
            choice = readUsersChoice();
        } while (inside);

    }

    // Registering Module
    private static void registerModule() throws IOException {
        Customer customer = new Customer();
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        customer.setName(input.nextLine());

        System.out.println("Please enter your phone number: ");
        customer.setPhoneNumber(input.nextLine());

        System.out.println("Please enter your personal ID card number: ");
        customer.setPersonalIdNumber(input.nextLine());

        System.out.println("Please enter a password: ");
        customer.setPassword(input.nextLine());

        System.out.println("New customer created successfully!");
        customer.saveCustomerInFile(customer);
    }

    // Reading user's choice (Making sure is a number)
    private static int readUsersChoice() {
        Scanner input = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(input.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
        }
        return -1;
    }

    // Main Menu
    private static void showMainMenu() throws IOException {
        System.out.println("Choose one of the options below: \n 1. Register \n 2. Login \n 3. Exit \n Make a choice ... ");
        boolean inside = true;
        int choice = readUsersChoice();
        do {
            switch (choice) {
                case 1:
                    System.out.println("\nRegistering Module");
                    registerModule();
                case 2:
                    System.out.println("\nLogin Module");
                    loginModule();
                    break;
                case 3:
                    inside = false;
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again!");
            }
            showMainMenu();
            choice = readUsersChoice();
        } while (inside);
    }


}
