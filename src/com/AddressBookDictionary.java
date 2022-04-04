package com;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AddressBookDictionary {

    /*
   Hashtable containing address books mapped to a name
    */
    public Hashtable<String, List<Person>> addressBookDict = new Hashtable<>();

    /**
     * addAddressBook - method to add new addressBooks to the addressBookDict Hashtable
     * @param name - name that needs to be mapped to the address book
     */
    public void addAddressBook(String name) {
        if(!addressBookDict.containsKey(name)) {
            List<Person> addressBook = new ArrayList<>();
            addressBookDict.put(name, addressBook);
            if (ScannerUtil.getString("Press 'a' to add more Address books\n").equalsIgnoreCase("A")) {
                addAddressBook(ScannerUtil.getString("Enter name of Address Book: "));
            }
        } else {
            System.out.println("Address Book with same name already available. Please use a different name.");
        }
    }


    /**
     * searchByCity - method to find the contacts in specified city
     */
    public void searchByCity() {

        String cityName = ScannerUtil.getString("Enter the name of the City to get the persons : ");
        for (String i : addressBookDict.keySet()) {
            List<Person> arr = addressBookDict.get(i);
            arr.stream().filter(contact -> contact.getCity().equals(cityName)).forEach(contact -> System.out.println(contact.getFirstName()));
        }
    }

    /**
     * searchByState - method to find the contacts in specified state
     */
    public void searchByState() {

        String stateName = ScannerUtil.getString("Enter the name of the State to the get persons : ");
        for (String i : addressBookDict.keySet()) {
            List<Person>	arr = addressBookDict.get(i);
            arr.stream().filter(person -> person.getState().equals(stateName)).forEach(person -> System.out.println(person.getFirstName()));
        }
    }

    /**
     * displayPeopleByRegion - method to display the contacts only in specified region
     * @param addressBookDict - List of contacts in the selected region
     */
    public void displayPeopleByRegion(Hashtable<String, ArrayList<Person>> addressBookDict) {
        String regionName = ScannerUtil.getString("Enter the name of the region :");

        addressBookDict.values().stream()
                .map(region -> region.stream()
                        .filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
                .forEach(person -> person.forEach(System.out::println));
    }

    /**
     * In this method we are displaying the number of person in the city or state.
     * @param listToDisplay - we are passing the list of city or state
     */
    public void countPeopleByRegion(Hashtable<String, ArrayList<Person>> listToDisplay) {

        String regionName = ScannerUtil.getString("Enter the name of the region :");
        long countPeople = listToDisplay.values().stream()
                .map(region -> region.stream().filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
                .count();

        System.out.println("Number of People residing in " + regionName+" are: "+countPeople+"\n");

    }
}

