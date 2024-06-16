package ru.gb.hwSem12.services;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final Counter myCounter;

    public MyService(MeterRegistry meterRegistry) {
        this.myCounter = meterRegistry.counter("my.custom.counter");
    }

    public void doSomething() {
        myCounter.increment();
    }
}