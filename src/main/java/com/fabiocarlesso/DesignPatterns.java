package com.fabiocarlesso;

import com.fabiocarlesso.command.invoker.TextFileOperationExecutor;
import com.fabiocarlesso.command.receiver.TextFile;
import com.fabiocarlesso.chainofresponsibility.middleware.Middleware;
import com.fabiocarlesso.chainofresponsibility.middleware.RoleCheckMiddleware;
import com.fabiocarlesso.chainofresponsibility.middleware.ThrottlingMiddleware;
import com.fabiocarlesso.chainofresponsibility.middleware.UserExistsMiddleware;
import com.fabiocarlesso.chainofresponsibility.order.Order;
import com.fabiocarlesso.mainexecution.ChainOfResponsabilityMain;
import com.fabiocarlesso.mainexecution.CommandMain;
import com.fabiocarlesso.mainexecution.StateMain;
import com.fabiocarlesso.mainexecution.StrategyMain;
import com.fabiocarlesso.state.Package;
import com.fabiocarlesso.strategy.PayByCreditCard;
import com.fabiocarlesso.strategy.PayByPayPal;
import com.fabiocarlesso.strategy.PayStrategy;
import com.fabiocarlesso.chainofresponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DesignPatterns {
    public static void main(String[] args) throws IOException {
        //StrategyMain.strategyMain();
        //ChainOfResponsabilityMain.chainOfResponsabilityMain();
        //CommandMain.commandMain();
        StateMain.stateMain();
    }

}