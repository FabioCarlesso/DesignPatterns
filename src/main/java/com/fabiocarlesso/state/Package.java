package com.fabiocarlesso.state;

import com.fabiocarlesso.state.packagestate.OrderedState;
import com.fabiocarlesso.state.packagestate.PackageState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Package {
    @Getter
    @Setter
    private PackageState state = new OrderedState();

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}
