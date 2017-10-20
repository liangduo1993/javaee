package com.ecvlearning.javaee.business;

import com.ecvlearning.javaee.model.Trade;

import java.io.IOException;
import java.util.List;

public interface TradeBo {
    public List<Trade> getTradeList() throws IOException;

    public List<Trade> getTradeByPrice(long low, long high) throws IOException;
}
