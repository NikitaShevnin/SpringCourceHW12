package ru.gb.hwSem12.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class NoteSubject {
    private List<Observer> observers = new ArrayList<>();
    @Getter
    private Note note;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(note);
        }
    }

    public void setNote(Note note) {
        this.note = note;
        notifyObservers();
    }

}

