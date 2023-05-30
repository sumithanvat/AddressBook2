package com.AddressBook;


import java.util.Scanner;

public class AdressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Enter the number of contacts to add: ");
        int numContacts = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < numContacts; i++) {
            Contacts contact = new Contacts();
            System.out.println("Enter first name: ");
            contact.setFirstName(sc.nextLine());
            System.out.println("Enter last name: ");
            contact.setLastName(sc.nextLine());
            System.out.println("Enter address: ");
            contact.setAddress(sc.nextLine());
            System.out.println("Enter city name: ");
            contact.setCity(sc.nextLine());
            System.out.println("Enter state name: ");
            contact.setState(sc.nextLine());
            System.out.println("Enter zip code: ");
            contact.setZipCode(sc.nextLine());
            System.out.println("Enter contact no.: ");
            contact.setContactNo(sc.nextLine());
            System.out.println("Enter email: ");
            contact.setEmail(sc.nextLine());
            addressBook.addDetails(contact);
        }

        System.out.println("Contacts in the Address Book:");
        addressBook.displayContacts();

        // Write the Address Book to a CSV file
        String fileName = "addressbook.csv";
        addressBook.writeToFile(fileName);

        // Clear the existing contact details
        addressBook.contactDetails.clear();

        // Read the Address Book from the CSV file
        addressBook.readFromFile(fileName);

        System.out.println("Contacts in the Address Book (after reading from file):");
        addressBook.displayContacts();
    }
}