package com;

import java.util.Scanner;


public class UserMenu {
    Scanner input = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("""
                Main Menu:
                 1.Add Contact\s
                 2.Edit Contact\s""");
        System.out.print("Enter your choice: ");
        return input.nextInt();
    }

}

