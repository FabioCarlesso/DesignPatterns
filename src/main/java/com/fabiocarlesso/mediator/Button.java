package com.fabiocarlesso.mediator;

import lombok.Data;

@Data
public class Button {
    private Mediator mediator;

    public void press() {
        mediator.press();
    }
}
