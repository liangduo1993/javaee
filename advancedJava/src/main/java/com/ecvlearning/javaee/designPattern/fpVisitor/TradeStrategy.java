package com.ecvlearning.javaee.designPattern.fpVisitor;


import java.util.function.Consumer;

public interface TradeStrategy {
    void changeArbitrageStrategy(Consumer<EquityTransaction> consumer);
    Consumer<EquityTransaction> makeArbitrageStrategy();
}
