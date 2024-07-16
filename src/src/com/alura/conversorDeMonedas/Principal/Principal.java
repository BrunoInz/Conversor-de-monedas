package com.alura.conversorDeMonedas.Principal;

import java.io.IOException;
import java.util.Scanner;

import static com.alura.conversorDeMonedas.Principal.ConversionAPI.*;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner =new Scanner(System.in);
        System.out.println("********************");
        System.out.println("¡Welcome to Alura`s Currency Convertor!");
        System.out.println("********************");
        //Request and validate fromCurrency
        System.out.println("From which currency would you like to convert?");
        String fromCurrency = scanner.nextLine().toUpperCase().trim();
        while (fromCurrency.isBlank()){
            System.out.println("Origin currency can`t be empty. Try again: ");
            fromCurrency = scanner.nextLine().toUpperCase().trim();
        }
        //Request and validate toCurrency
        System.out.println("Now enter the currency you want to convert to: ");
        String toCurrency= scanner.nextLine().toUpperCase().trim();
        while(toCurrency.isBlank()){
            System.out.println("Target currency can`t be empty. Please enter a valid option: ");
            toCurrency = scanner.nextLine().toUpperCase().trim();
        }
        //Request amount and turn it from String to double
        double amount = 0;
        boolean validAmount = false;
        while (!validAmount) {
            System.out.println("Enter the amount you want to convert: ");
            String amountToConvert = scanner.nextLine().trim();
            amount = Double.parseDouble(amountToConvert);
            try {
                if (amount <= 0) {
                    System.out.println("The amount can`t be a negative value. Please try again: ");
                } else {
                    validAmount =true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry, please try again: ");
            }
        }

        //Output
        try {
            double convertedAmount = ConversionAPI.convertCurrency(fromCurrency, toCurrency, amount);
            System.out.println(amount +" " + fromCurrency + " Equates to: " + convertedAmount +" " + toCurrency);
        } catch (IOException| InterruptedException e) {
            e.printStackTrace();
        }

    scanner.close();
    }
}
