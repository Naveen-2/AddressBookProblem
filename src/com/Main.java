package com;

public class Main {

    public static void main(String[] args) {
        Main menu = new Main();
        menu.handleUserSelection();
    }

    public void handleUserSelection() {
        AddressBookMain addressBookMain = new AddressBookMain();
        UserMenu userMenu = new UserMenu();

        AddressBookDictionary addressBookDictionary = new AddressBookDictionary();
        addressBookDictionary.addAddressBook(ScannerUtil.getString("Enter name of Address Book: "));

        int x;

        do {
            int choice = userMenu.showMainMenu();
            switch (choice) {
                /*
                Option to add a new contact to the selected address book
                 */
                case 1 -> addressBookMain.addContactToAddressBook();
                /*
                Option to edit an existing contact with first name selected address book
                 */
                case 2 -> addressBookMain.editByName(ScannerUtil.getString("Enter contact name to edit: "));
                /*
                 Option to delete an existing contact from the selected address book
                 */
                case 3 -> addressBookMain.deleteByName(ScannerUtil.getString("Enter contact name to delete: "));
                /*
                Option to add multiple contacts to the selected address book
                 */
                case 4 ->  addressBookMain.addMultipleContacts();
                /*
                Option to add new address book
                 */
                case 5 -> addressBookDictionary.addAddressBook(ScannerUtil.getString("Enter name of Address Book: "));  /*
                Search and print first names of all contacts by city
                 */
                case 6 -> addressBookDictionary.searchByCity();
                /*
                Search and print first name of all contacts by state
                 */
                case 7 -> addressBookDictionary.searchByState(); /*
                Display only the contacts in certain city
                 */
                case 8 -> addressBookDictionary.displayPeopleByRegion(AddressBookMain.personByCity);
                /*
                Display only the contacts in certain state
                 */
                case 9 -> addressBookDictionary.displayPeopleByRegion(AddressBookMain.personByState);
                default -> {
                }
            }
            x = ScannerUtil.getInt("Do you want to continue...press 1\n");
        } while (x == 1);
    }

}
