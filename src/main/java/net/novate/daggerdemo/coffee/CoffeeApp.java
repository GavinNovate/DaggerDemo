package net.novate.daggerdemo.coffee;

public class CoffeeApp {

    public static void main(String[] args) {

        System.out.println(new CoffeeMaker().pump);
        System.out.println(new CoffeeMaker().heater);
    }
}