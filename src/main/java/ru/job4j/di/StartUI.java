package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * С помощью аннотации Autowired можно внедрять зависимости через:
 * - через конструктор. Правильный способ.
 * - через поле и аннотацию @Autowired. Нежелательный способ.
 * - через метод set и аннотацию @Autowired. Нежелательный способ.
 */

@Component
public class StartUI {

    @Autowired
    private Store store;
    @Autowired
    private ConsoleInput input;

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public void printInput(String str) {
       input.askStr(str);
    }
}
