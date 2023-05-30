package com.AddressBook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Address Book Application");
        System.out.println("------------------------");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a person to the address book");
            System.out.println("2. Display all contacts");
            System.out.println("3. Write address book to JSON file");
            System.out.println("4. Read address book from JSON file");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    Contacts person = new Contacts();

                    System.out.println("Enter first name: ");
                    person.setFirstName(scanner.nextLine());

                    System.out.println("Enter last name: ");
                    person.setLastName(scanner.nextLine());

                    // Enter other contact details as per your requirement

                    addressBook.addDetails(person);
                    System.out.println("Person added to the address book.");
                    break;

                case 2:
                    System.out.println("Contacts in the address book:");
                    addressBook.displayContacts();
                    break;

                case 3:
                    System.out.println("Enter the name of the JSON file to write: ");
                    String writeFileName = scanner.nextLine();
                    addressBook.writeToJsonFile(writeFileName);
                    break;

                case 4:
                    System.out.println("Enter the name of the JSON file to read: ");
                    String readFileName = scanner.nextLine();
                    addressBook.readFromJsonFile(readFileName);
                    break;

                case 5:
                    System.out.println("Exiting the address book application.");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}