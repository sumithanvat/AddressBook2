package com.AddressBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    List<Contacts> contactDetails = new ArrayList<>();

    public void addDetails(Contacts info) {
        contactDetails.add(info); // Add the Contacts object to the contactDetails ArrayList
    }

    public void displayContacts() {
        for (Contacts contact : contactDetails) {
            System.out.println(contact); // Print each Contacts object using its toString() method
        }
    }

    public void writeToJsonFile(String fileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Write the contactDetails list to the JSON file
            objectMapper.writeValue(new File(fileName), contactDetails);

            System.out.println("Address Book has been written to the JSON file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to the JSON file: " + e.getMessage());
        }
    }

    public void readFromJsonFile(String fileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file and map it to the contactDetails list
            contactDetails = objectMapper.readValue(new File(fileName),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Contacts.class));

            System.out.println("Address Book has been read from the JSON file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading from the JSON file: " + e.getMessage());
        }
    }
}
