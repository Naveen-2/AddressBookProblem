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

}

