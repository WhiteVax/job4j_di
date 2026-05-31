package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Простой пример реализации Sрring context, dependency injection.
 * - есть хранилище, в котором регистрируются классы, объекты которых нужны в проекте;
 * - context хранилище для объектов проекта;
 * - после регистрации классов Context начинает инициализацию. Он строит дерево зависимостей.
 * Сначала строит объекты без зависимостей. Потом с зависимостями.
 * - после инициализации можно получить нужный объект из Context.
 * Для реализациия DI используется мета программирование или рефлексия.
 * По средствам рефлексии узнаёт какие елементы имеет класс.
 */
public class Context {
    /**
     * Карта для хранения проинициализированных объектов.
     */
    private Map<String, Object> els = new HashMap<String, Object>();

    public void reg(Class cl) {
        /**
         * Получает все конструкторы класса, если их больше  1 кидает исключение.
         */
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors : " + cl.getCanonicalName());
        }
        /**
         * Когда нашел конструктор, собирает все зарегистрированные объекты для внедрения их в конструктор.
         */
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<Object>();
        for (Class arg : con.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        /**
         * Собирает объект и добавляет его в карту.
         */
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Coun't create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    public <T> T get(Class<T> inst) {
        return (T) els.get(inst.getCanonicalName());
    }
}
