import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainScreen {

    private static List<Customer> customersList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Room room1 = new Room("#1", 100, true);
        Room room2 = new Room("#2", 100, true);
        Room room3 = new Room("#3", 100, true);
        Room room4 = new Room("#4", 100, true);
        Room room5 = new Room("#5", 150, true);
        Room room6 = new Room("#6", 150, true);
        Room room7 = new Room("#7", 200, true);
        Room room8 = new Room("#8", 200, true);

        showHomeMenu();
        boolean inside = true;
        int choice = readUsersChoice();

        do {
            switch (choice) {
                case 1:
                    System.out.println("Registering Module");
                    addNewCustomer();
                case 2:
                    System.out.println("Login Module");
                    //loginModule();
                    break;
                case 3:
                    inside = false;
                    System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again!");
            }
            showHomeMenu();
            choice = readUsersChoice();
        } while (inside);

    }

    /*private static void loginModule() throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your ID number: ");
        String personalIdNumber = input.nextLine();
        //String loginResult = Customer.checkCredentials(personalIdNumber, password);
        if(loginResult.equals("false")) {
            System.out.println("Wrong ID!");
            showHomeMenu();
        } else {
            System.out.println("Please enter your password");
            String password = input.nextLine();
            if (password.equals(loginResult)) {
                System.out.println("Welcome!");
                showLoggedInModule();
            }
        }
    }*/

    private static void showLoggedInModule() {

        System.out.println("Choose one of the options below: \n 1. Make reservation \n 2. Check reservation \n 3. Cancel reservation \n 4. Logout");
        boolean inside = true;
        int choice = readUsersChoice();

        do {
            switch (choice) {
                case 1:
                    System.out.println("Registering Module");
                    break;
                case 2:
                    System.out.println("Login Module");
                    break;
                case 3:
                    System.out.println("Cancel reservation");
                    break;

                    case 4:
                    inside = false;
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again!");
            }
            showLoggedInModule();
            choice = readUsersChoice();
        } while (inside);

    }

    private static void addNewCustomer() throws IOException {
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

        System.out.println("New user created successfully!");
        customersList.add(customer);
       // Customer.saveCustomerInFile(customer.getPersonalIdNumber(), customer.getPassword());
    }


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

    private static void showHomeMenu() {
        System.out.println("Choose one of the options below: \n 1. Register \n 2. Login \n 3. Exit");
    }

}
