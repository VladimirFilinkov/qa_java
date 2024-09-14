package com.example;

import java.util.List;

public class Cat {

    Predator predator;

    //определили кота независимым хищником
    public Cat(Predator predator) {
        this.predator = predator;
    }

    //научили кота мяукать
    public String getSound() {
        return "Мяу";
    }
    //получаем список пищи кота(хищника)
    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
