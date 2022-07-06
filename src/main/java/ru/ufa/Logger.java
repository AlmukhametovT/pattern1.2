package ru.ufa;

import java.time.LocalDateTime;

public class Logger {
    protected int num = 1;

    // В этом поле храним ссылку на тот единственный объект этого класса
    // который будем отдавать пользователям
    private static Logger instance = null;

    // Запрещаем пользователям пользоваться конструктором нашего класса
    private Logger() {
    }

    // Пользователи которым нужен объект нашего класса получают всегда один
    // и тот же объект, который мы храним в приватном статичном поле, которое
    // мы заполняем в этом методе если оно до того не было заполнено
    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    public void log(String msg) {
        System.out.println("[" + LocalDateTime.now() + " " + num + "] " + msg);
        num++;
    }
}