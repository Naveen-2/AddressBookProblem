package com;

import java.util.Scanner;


public class UserMenu {
    Scanner input = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("""
                Main Menu:
                 1.Add Contact\s
                 2.Edit Contact\s
                 3.Delete Contact\s
                 4.Add Multiple Contacts\s
                 5.Add New Address Book""");
        System.out.print("Enter your choice: ");
        return input.nextInt();
    }

}

