package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.println("=== DRZEWO BINARNE ===");

        // Get numbers from user via console
        System.out.println("Podaj liczby oddzielone spacjami: ");
        String userinput = scanner.nextLine();
        scanner.close();

        // Validate user input
        if(userinput == null || userinput.trim().isEmpty()){
            System.out.println("\033[31mNie wpisano żadnych danych.\033[0m");

        } else {
            String[] elements = userinput.trim().split("\\s+");

            // Convering userInput elements to int type
            for(String element : elements){
                try{
                    int number = Integer.parseInt(element);
                    tree.insert(number);
                } catch (NumberFormatException e){
                    // If element can't be converted to number type, ex. letters
                    System.out.println("\033[33m# Pominieto '" + element + "', poniewaz nie jest liczba.\033[0m");
                }
            }
        }

        tree.printTree();
        System.out.println("--------------------");
        tree.printInOrder();
    }
}