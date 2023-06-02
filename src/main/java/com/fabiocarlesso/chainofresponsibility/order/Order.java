package com.fabiocarlesso.chainofresponsibility.order;

import com.fabiocarlesso.strategy.PayStrategy;
import lombok.Getter;

public class Order {
    @Getter
    private int totalCost = 0;
    @Getter
    private boolean isClosed = false;

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
        // Here we could collect and store payment data from the strategy.
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public void setClosed() {
        isClosed = true;
    }
}
