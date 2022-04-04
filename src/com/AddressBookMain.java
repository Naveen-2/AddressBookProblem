package com;

import java.util.*;

public class AddressBookMain {


    AddressBookDictionary addressBookDictionary = new AddressBookDictionary();
    /*
    addressBook list to add Person objects
     */
    List<Person> addressBook = new ArrayList<>();


    public static Hashtable<String, ArrayList<Person>> personByCity  = new Hashtable<>();
    public static Hashtable<String, ArrayList<Person>> personByState = new Hashtable<>();

    /**
     * addContactToAddressBook - method to get user input and create a contact
     * and also store it in address book list of contacts
     */
    public void addContactToAddressBook(){
        /*
        Person object created
         */
        Person person = new Person();
        person.setFirstName(ScannerUtil.getString("Enter First name: "));
        person.setLastName(ScannerUtil.getString("Enter Last name: "));
        person.setPhoneNumber(ScannerUtil.getLong("Enter Phone number: "));
        person.setEmail(ScannerUtil.getString("Enter Email: "));
        person.setAddress(ScannerUtil.getString("Enter Address: "));
        person.setCity(ScannerUtil.getString("Enter City: "));
        person.setState(ScannerUtil.getString("Enter State: "));
        person.setZip(ScannerUtil.getInt("Enter Zip code: "));

        if(checkDuplicateByFirstName(person.getFirstName())){
            System.out.println("So not added to this address book.");
        } else {
            /*
            adding person to address book
            */
            addressBook.add(person);
        }
    }

    public void editByName(String firstName){
        for(int i = 0; i < addressBook.size(); i++){
            if (firstName.equalsIgnoreCase(addressBook.get(i).firstName)) {
                addressBook.set(i, editContact(addressBook.get(i)));
            } else {
                System.out.println("Contact nor found");
            }
        }
    }

    private Person editContact(Person person) {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                Select the detail to edit:\s
                 1.First Name
                 2.Last Name
                 3.Address
                 4.City
                 5.State
                 6.Zip
                 7.Phone
                 8.Email
                
                """);
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter First Name: ");
                person.setFirstName(input.next());
            }
            case 2 -> {
                System.out.print("Enter Last Name: ");
                person.setLastName(input.next());
            }
            case 3 -> {
                System.out.print("Enter Address: ");
                person.setAddress(input.next());
            }
            case 4 -> {
                System.out.print("Enter City: ");
                person.setCity(input.next());
            }
            case 5 -> {
                System.out.print("Enter State: ");
                person.setState(input.next());
            }
            case 6 -> {
                System.out.print("Enter Zip: ");
                person.setZip(input.nextInt());
            }
            case 7 -> {
                System.out.print("Enter Phone number: ");
                person.setPhoneNumber(input.nextLong());
            }
            case 8 -> {
                System.out.print("Enter Email address: ");
                person.setEmail(input.next());
            }
        }
        return person;
    }

    /**
     * displayContacts - method to display the contacts in addressBook
     */
    public void displayContacts(){
        if(!addressBook.isEmpty()) {
            for (int i = 1; i <= addressBook.size(); i++) {
                System.out.println("Contact " + i);
                System.out.println("First Name: " + addressBook.get(i - 1).getFirstName());
                System.out.println("Last Name: " + addressBook.get(i - 1).getLastName());
                System.out.println("Address: " + addressBook.get(i - 1).getAddress());
                System.out.println("City: " + addressBook.get(i - 1).getCity());
                System.out.println("State: " + addressBook.get(i - 1).getState());
                System.out.println("Zip: " + addressBook.get(i - 1).getZip());
                System.out.println("Phone: " + addressBook.get(i - 1).getPhoneNumber());
                System.out.println("Email: " + addressBook.get(i - 1).getEmail());

            }
        } else {
            System.out.println("Address book empty.");
        }
    }

    /**
     * method to check if the contact is already available in address book or not
     * @param name
     * @return
     */
    public boolean checkDuplicateByFirstName(String name) {
        for (Person person : addressBook) {
            if (name.equalsIgnoreCase(person.firstName)) {
                System.out.println("Contact already available");
                return true;
            }
        }
        return false;
    }

    /**
     * method to delete a contact by first name
     * @param name
     */
    public void deleteByName(String name) {
        if(!addressBook.isEmpty()) {
            for (Person person : addressBook) {
                if (name.equals(person.firstName)) {
                    addressBook.remove(person);
                    System.out.println("Contact removed successfully.");
                    break;
                } else {
                    System.out.println("Contact nor found");
                }
            }
        }
    }

    /**
     * addMultipleContacts - method to add multiple contacts in same list
     */
    public void addMultipleContacts() {
        String option;
        do {
            addContactToAddressBook();
            option = ScannerUtil.getString("Press 'Y' to add more contacts");
        } while (option.equalsIgnoreCase("Y"));
    }

    /**
     *  addPersonToCity - method t check the person by city
     * @param contact- We are parsing the contact there
     */
    public void addPersonToCity(Person contact) {
        if (personByCity.containsKey(contact.getCity())) {
            personByCity.get(contact.getCity()).add(contact);
        }
        else {
            ArrayList<Person> cityList = new ArrayList<>();
            cityList.add(contact);
            personByCity.put(contact.getCity(), cityList);
        }
    }


    /**
     *  addPersonToState method to check the person by state
     * @param contact- We are parsing the contact there
     */
    public void addPersonToState(Person contact) {
        if (personByState.containsKey(contact.getState())) {
            personByState.get(contact.getState()).add(contact);
        }
        else {
            ArrayList<Person> stateList = new ArrayList<>();
            stateList.add(contact);
            personByState.put(contact.getState(), stateList);
        }
    }


}
