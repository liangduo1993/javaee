package com.ecvlearning.javaee.designPattern.visitor;

public class Gic extends FixedIncomeTransaction{
    @Override
    public void accept(TradeStrategy ts) {
        ts.trade(this);
    }
}
