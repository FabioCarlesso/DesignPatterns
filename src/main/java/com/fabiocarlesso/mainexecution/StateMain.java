package com.fabiocarlesso.mainexecution;

import com.fabiocarlesso.state.Package;

public class StateMain {
    public static void stateMain() {
        Package pkg = new Package();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();
    }
}
