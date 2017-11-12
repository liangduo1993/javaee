package com.ecvlearning.javaee.designPattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class FixedIncomeTransaction implements Transaction {
    private List<Gic> gics = new ArrayList<>();

    private String symbol;
    private String action;
    private int price;
    private int transactionFee;

    @Override
    public void accept(TradeStrategy ts) {
        ts.trade(this);
        gics.forEach(item->item.accept(ts));
    }

}
