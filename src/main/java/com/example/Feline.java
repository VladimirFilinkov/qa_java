package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {

    //Реализуем метод поедания мяса из Predator
    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }
    //Переопределяем метод получения принадлежности из Animal
    @Override
    public String getFamily() {
        return "Кошачьи";
    }
    //Возвращаем кол-во котят (1)
    public int getKittens() {
        return getKittens(1);
    }
    //Возвращаем переданное кол-во котят
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}
