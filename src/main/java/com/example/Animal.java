package com.example;

import java.util.List;

public class Animal {
    //Получаем список еды в зависимости от вида животного
    public List<String> getFood(String animalKind) throws Exception {
        //Если животное травоядное
        if ("Травоядное".equals(animalKind)) {
            return List.of("Трава", "Различные растения");
        //Иначе если животное хищник
        } else if ("Хищник".equals(animalKind)) {
            return List.of("Животные", "Птицы", "Рыба");
        //В остальных случаях получаем исключение
        } else {
            throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }
    //Принадлежность животного к виду
    public String getFamily() {
        return "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }
}