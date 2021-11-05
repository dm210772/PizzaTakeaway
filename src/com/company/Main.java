package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);

        HashMap<String, Double> pizzaPrices = new HashMap <>();
        ArrayList<String> toppings = new ArrayList<>();

        pizzaPrices.put("small", 7.99);
        pizzaPrices.put("medium", 10.99);
        pizzaPrices.put("large", 13.99);

        double price = 0;

        System.out.println("What size pizza would you like?");
        String size = "";
        try {
            size = input.next().toLowerCase(Locale.ROOT);
        } catch (NullPointerException e) {
            System.out.println("Not a valid size");
        }

        price += pizzaPrices.get(size);

        System.out.println("Any toppings? (£1.25 each, 2 free) (type 'end' to finish)");
        String topping = "";
        while (!topping.equalsIgnoreCase("end")) {
            topping = input.next();
            toppings.add(topping);
        }

        toppings.remove("end");

        for (int i = 0; i < toppings.size() - 2; i++) {
            price += 1.25;
        }

        System.out.println("Size: " + size);
        System.out.print("Toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.print(toppings.get(i) + ", ");
        }
        System.out.println("");

        double roundOff = (double) Math.round(price * 100) / 100;
        System.out.println("Price: £" + roundOff);
    }
}
