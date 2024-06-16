package ru.gb.hwSem12.services;

import ru.gb.hwSem12.model.Note;
import ru.gb.hwSem12.model.Observer;

public class WebhookObserver implements Observer {
    private String webhookUrl;

    public WebhookObserver(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    @Override
    public void update(Note note) {
        // Здесь можно реализовать логику для отправки webhook-уведомления
        System.out.println("Отправляем webhook-уведомление на URL " + webhookUrl + " о изменении заметки: " + note);
    }
}

