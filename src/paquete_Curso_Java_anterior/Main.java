package paquete_Curso_Java_anterior;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] guests = new String[10];
        Scanner scanner = new Scanner(System.in);

        // Insert test names into the guest array
        insertTestNames(guests);

        // Call the displayMenu method to show the menu
        displayMenu(guests, scanner);

        scanner.close();
    }

    // Method to display the menu and handle user options
    public static void displayMenu(String[] guests, Scanner scanner) {
        do {
            displayGuests(guests);
            System.out.println("------------------------------------------");
            System.out.println("Menu: ");
            System.out.println();
            System.out.println("1 - Add Guest");
            System.out.println("2 - Remove Guest");
            System.out.println("3 - Rename Guest");
            System.out.println("4 - Insert Guest");
            System.out.println("5 - Exit");

            int option = getOption(scanner);
            System.out.println();

            if (option == 1) {
                addGuest(guests, scanner);
            } else if (option == 2) {
                removeGuest(guests, scanner);
            } else if (option == 3) {
                renameGuest(guests, scanner);
            } else if (option == 4) {
                insertGuest(guests, scanner);
            } else if (option == 5) {
                System.out.println("Exiting...");
                break;
            }
        } while (true);
    }

    // Method to get the user's menu option
    public static int getOption(Scanner scanner) {
        System.out.print("Option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println();
        return option;
    }

    // Method to display guests with numbers
    public static void displayGuests(String[] guests) {
        System.out.println("------------------------------------------\n -Guests: \n");
        int guestNumber = 1; // Initialize the guest number
        boolean isEmpty = true; // Initialize a flag to check if the guest list is empty

        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                System.out.println((i + 1) + ". " + guests[i]);
                isEmpty = false; // Set the flag to false if a guest is found
                guestNumber++; // Increment guest number for non-null entries
            }
        }
        if (isEmpty) {
            System.out.println("Guest list is empty.");
        }
    }

    // Method to add a guest to the array
    public static void addGuest(String[] guests, Scanner scanner) {
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                System.out.print("Name: ");
                guests[i] = scanner.nextLine(); // Use nextLine to allow spaces in names
                break;
            }
        }
    }

    // Method to remove a guest from the array by number
    public static void removeGuest(String[] guests, Scanner scanner) {
        displayGuests(guests); // Display guests with numbers
        System.out.print("Enter the number of the guest to remove: ");
        int guestNumber = scanner.nextInt();

        if (guestNumber >= 1 && guestNumber <= guests.length && guests[guestNumber - 1] != null) {
            guests[guestNumber - 1] = null;

            String[] temp = new String[guests.length];
            int ti = 0;
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] != null) {
                    temp[ti] = guests[i];
                    ti++;
                }
            }
            //guests = temp; Está sentencia no vale se envía por referencia

            for (int i = 0; i < guests.length; i++) {
                guests[i]=temp[i];//Hay que crear un bucle auqí, no se inicializa correctamente
            }
        } else {
            System.out.println("\nError: There is no guest with that number.");
        }
    }

    // Method to rename a guest in the array by number
    public static void renameGuest(String[] guests, Scanner scanner) {
        displayGuests(guests); // Display guests with numbers
        System.out.print("Enter the number of the guest to rename: ");
        int guestNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (guestNumber >= 1 && guestNumber <= guests.length && guests[guestNumber - 1] != null) {
            System.out.print("Enter the new name for the guest: ");
            guests[guestNumber - 1] = scanner.nextLine(); // Update the guest's name
        } else {
            System.out.println("\nError: There is no guest with that number.");
        }
    }

    // Method to insert a guest at a particular position in the array
    public static void insertGuest(String[] guests, Scanner scanner) {
        System.out.print("Enter the position to insert the guest: ");
        int position = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (position >= 1 && position <= guests.length) {
            System.out.print("Enter the name of the guest: ");
            String name = scanner.nextLine();

            // Shift elements to the right to make room for the new guest
            for (int i = guests.length - 1; i > position - 1; i--) {
                guests[i] = guests[i - 1];
            }

            guests[position - 1] = name; // Insert the new guest at the specified position
        } else {
            System.out.println("\nError: Invalid position.");
        }
    }

    // Method to insert test names into the guest array
    public static void insertTestNames(String[] guests) {
        guests[0] = "Jacob Hughes";
        guests[1] = "Edward Jones";
        guests[2] = "Rose Morrison";
        guests[3] = "Molly Jones";
        guests[4] = "Christopher Morgan";
    }
}
