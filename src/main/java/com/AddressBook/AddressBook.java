package com.AddressBook;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileReader;
import java.io.FileWriter;
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

    public void writeToFile(String fileName) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            // Create a StatefulBeanToCsv object to write the Contacts objects to the CSV file
            StatefulBeanToCsv<Contacts> beanToCsv = new StatefulBeanToCsvBuilder<Contacts>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER) // Set the quote character to none
                    .build();

            beanToCsv.write(contactDetails); // Write the contactDetails ArrayList to the CSV file
            System.out.println("Address Book has been written to the CSV file: " + fileName);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("Error writing to the CSV file: " + e.getMessage());
        }
    }

    public void readFromFile(String fileName) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withSkipLines(1).build()) {
            // Create a CsvToBean object to read the CSV file and map it to Contacts objects
            CsvToBean<Contacts> csvToBean = new CsvToBeanBuilder<Contacts>(reader)
                    .withType(Contacts.class) // Specify the target class for mapping
                    .build();

            contactDetails = csvToBean.parse(); // Parse the CSV file and store the Contacts objects in the contactDetails ArrayList
            System.out.println("Address Book has been read from the CSV file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading from the CSV file: " + e.getMessage());
        }
    }
}