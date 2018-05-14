import java.io.*;
import java.util.Scanner;

public class Customer {

    private String name;
    private String phoneNumber;
    private String personalIdNumber;
    private String password;


    public Customer() {
    }

    public Customer(String name, String phoneNumber, String personalIdNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.personalIdNumber = personalIdNumber;
        this.password = password;
    }

    public static void saveCustomerInFile(Customer customer) throws IOException {
        FileWriter fw = new FileWriter("customers.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("#userbelow");
            bw.newLine();
        bw.write(customer.personalIdNumber);
            bw.newLine();
        bw.write(customer.password);
            bw.newLine();
        bw.write(customer.name);
            bw.newLine();
        bw.write(customer.phoneNumber);
            bw.newLine();

        bw.close();
        fw.close();
    }

    public static boolean checkCredentials(String personalIdNumber, String password) throws IOException {
        FileReader fr = new FileReader("customers.txt");
        BufferedReader bw = new BufferedReader(fr);
        String line = bw.readLine();
        do{
            if(line.equals("#customerbelow")) {
                if ((line = bw.readLine()).equals(personalIdNumber) && (line = bw.readLine()).equals(password)) {
                    System.out.println("Successfully logged in!");
                    return true;
                }
            } else {
                line = bw.readLine();
            }
        } while (line != null);

        return false;
    }

    public static void makeAReservation() {
        System.out.println("Reservation done!");
    }

    public static void showCustomersReservations() {
        System.out.println("These are your reservations: ");
    }

    public static void cancelCustomersReservation() {
        System.out.println("Choose a reservation to cancel.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public void setPersonalIdNumber(String personalIdNumber) {
        if (personalIdNumber.length() == 7) {
            this.personalIdNumber = personalIdNumber;
        } else {
            System.out.println("Your personal ID number is not 7 chars long. Try again!");
            Scanner input = new Scanner(System.in);
            String inputString = input.nextLine();
            while (inputString.length() != 7 || !inputString.matches("[0-9]+")) {
                System.out.println("Your personal ID number should be 7 chars long and it should contain only digits. Try again!");
                inputString = input.nextLine();
            }
            this.personalIdNumber = personalIdNumber;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean makeReservation(Room room) {
        if (room.isItAvailable()) {
            return true;
        } else {
            return false;
        }
    }

    public void payForTheRoom(Room room) {
        Payment.processPayment(room.getRoomPrice());
    }




}
