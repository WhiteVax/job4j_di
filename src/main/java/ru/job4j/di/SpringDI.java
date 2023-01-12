package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(StartUI.class);
        context.register(ConsoleInput.class);
        context.register(Store.class);
        context.refresh();

        StartUI ui = context.getBean(StartUI.class);

        ui.add("Ivan Ivan");
        ui.print();

        ui.printInput("Ask");
    }
}
