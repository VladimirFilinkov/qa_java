package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane; //Есть ли грива?
    public Feline feline; // Для зависимости

    //Принимаем пол льва и его пренадлежность
    public Lion(String sex) throws Exception {
        this.feline = feline; //инициализация feline
        //Если самец - грива есть
        if ("Самец".equals(sex)) {
            hasMane = true;
        //Иначе если самка - гривы нет
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        //Иначе получаем исключение
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    //Получаем кол-во котят
    public int getKittens() {
        return feline.getKittens();
    }

    //Узнаём - есть ли грива
    public boolean doesHaveMane() {
        return hasMane;
    }

    //Получаем список пищи льва(хищника)
    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
