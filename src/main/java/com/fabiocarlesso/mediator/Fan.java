package com.fabiocarlesso.mediator;

import lombok.Data;

@Data
public class Fan {
    private Mediator mediator;
    private boolean isOn = false;

    public void turnOn() {
        mediator.start();
        isOn = true;
        System.out.println("Fan turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Fan turned OFF");
        mediator.stop();
    }
}
