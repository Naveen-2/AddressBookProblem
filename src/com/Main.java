package com;

public class Main {

    public static void main(String[] args) {
        Main menu = new Main();
        menu.handleUserSelection();
    }

    public void handleUserSelection() {
        AddressBookMain addressBookMain = new AddressBookMain();
        UserMenu userMenu = new UserMenu();

        int x;

        do {
            int choice = userMenu.showMainMenu();
            switch (choice) {
                case 1 -> addressBookMain.addContactToAddressBook();
                case 2 -> addressBookMain.editByName(ScannerUtil.getString("Enter contact name to edit: "));
                case 3 -> addressBookMain.deleteByName(ScannerUtil.getString("Enter contact name to delete: "));
                default -> {
                }
            }
            x = ScannerUtil.getInt("Do you want to continue...press 1\n");
        } while (x == 1);
    }

}
