package net.novate.daggerdemo.coffee;

import javax.inject.Inject;

class CoffeeMaker {

    @Inject
    Heater heater;
    @Inject
    Pump pump;

    public CoffeeMaker() {
        DaggerCoffeeComponent.create().inject(this);
    }
}
