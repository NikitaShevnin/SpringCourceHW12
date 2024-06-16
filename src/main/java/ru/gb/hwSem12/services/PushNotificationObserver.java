package ru.gb.hwSem12.services;

import ru.gb.hwSem12.model.Note;
import ru.gb.hwSem12.model.Observer;

public class PushNotificationObserver implements Observer {
    private String deviceToken;

    public PushNotificationObserver(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public void update(Note note) {
        System.out.println("Отправляем push-уведомление на устройство с токеном " + deviceToken + " о изменении заметки: " + note);
    }
}

