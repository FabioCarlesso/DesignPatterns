package com.fabiocarlesso.mainexecution;

import com.fabiocarlesso.mediator.Button;
import com.fabiocarlesso.mediator.Fan;
import com.fabiocarlesso.mediator.Mediator;
import com.fabiocarlesso.mediator.PowerSupplier;

public class MediatorMain {
    public static void mediatorMain() {
        Fan fan = new Fan();
        Button button = new Button();
        Mediator mediator = Mediator.builder()
                .fan(fan)
                .button(button)
                .powerSupplier(new PowerSupplier())
                .build();

        fan.setMediator(mediator);
        button.setMediator(mediator);

        button.press();
        button.press();
    }
}
