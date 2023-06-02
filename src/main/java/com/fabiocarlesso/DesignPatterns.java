package com.fabiocarlesso;

import com.fabiocarlesso.mainexecution.ChainOfResponsabilityMain;
import com.fabiocarlesso.mainexecution.CommandMain;
import com.fabiocarlesso.mainexecution.StateMain;
import com.fabiocarlesso.mainexecution.StrategyMain;

import java.io.IOException;

public class DesignPatterns {
    public static void main(String[] args) throws IOException {
        //StrategyMain.strategyMain();
        //ChainOfResponsabilityMain.chainOfResponsabilityMain();
        //CommandMain.commandMain();
        StateMain.stateMain();
    }

}