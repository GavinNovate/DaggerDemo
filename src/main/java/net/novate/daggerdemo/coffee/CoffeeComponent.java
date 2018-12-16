package net.novate.daggerdemo.coffee;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {CoffeeModule.class})
interface CoffeeComponent {

    void inject(CoffeeMaker maker);
}
