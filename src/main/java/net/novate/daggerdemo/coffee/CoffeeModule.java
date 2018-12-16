package net.novate.daggerdemo.coffee;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class CoffeeModule {

    @Singleton
    @Provides
    static Heater provideHeater() {
        return new ElectricHeater();
    }

    @Singleton
    @Provides
    static Pump providePump(Thermosiphon thermosiphon) {
        return thermosiphon;
    }
}
