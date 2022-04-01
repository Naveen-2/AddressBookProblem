package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    /*
    addressBook list to add Person objects
     */
    List<Person> addressBook = new ArrayList<>();

    /**
     * addContactToAddressBook - method to get user input and create a contact
     * and also store it in address book list of contacts
     */
    public void addContactToAddressBook(){

        Scanner input = new Scanner(System.in);
        /*
        Person object created
         */
        Person person = new Person();

        /*
        Getting contact details input from user
         */
        System.out.print("Enter First Name: ");
        person.setFirstName(input.next());
        System.out.print("Enter Last Name: ");
        person.setLastName(input.next());
        System.out.print("Enter Address: ");
        person.setAddress(input.next());
        System.out.print("Enter City: ");
        person.setCity(input.next());
        System.out.print("Enter State: ");
        person.setState(input.next());
        System.out.print("Enter Zip: ");
        person.setZip(input.nextInt());
        System.out.print("Enter Phone number: ");
        person.setPhoneNumber(input.next());
        System.out.print("Enter Email address: ");
        person.setEmail(input.next());

        /*
        adding person to address book
         */
        addressBook.add(person);
    }

}
