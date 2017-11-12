package com.ecvlearning.javaee.designPattern.fpVisitor;

import java.util.function.Consumer;

public class ArbitrageStrategy implements TradeStrategy{

    private Consumer<EquityTransaction> etc = et -> {
        System.out.println("This is equity etc");
        System.out.println(et.getAction()+" "+et.getTicker()+" @ "+et.getPrice());
    };


    @Override
    public void changeArbitrageStrategy(Consumer<EquityTransaction> consumer) {
        etc = consumer;
    }

    @Override
    public Consumer<EquityTransaction> makeArbitrageStrategy() {
        return etc;
    }
}
