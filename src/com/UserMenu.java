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
                 5.Add New Address Book\s
                 6.Search Person by City name\s
                 7.Search Person by State name\s
                 8.View Person by City\s
                 9.View Person by State\s
                 10.Count Person by City\s
                 11.Count Person by State\s
                 12.Sort contacts Alphabetically\s""");
        System.out.print("Enter your choice: ");
        return input.nextInt();
    }

}

