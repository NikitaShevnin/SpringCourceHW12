package ru.gb.hwSem12.services;

import ru.gb.hwSem12.model.Note;
import ru.gb.hwSem12.model.Observer;

public class EmailNotificationObserver implements Observer {
    private String email;

    public EmailNotificationObserver(String email) {
        this.email = email;
    }

    @Override
    public void update(Note note) {
        System.out.println("Отправляем email-уведомление на адрес " + email + " о изменении заметки: " + note);
    }
}

