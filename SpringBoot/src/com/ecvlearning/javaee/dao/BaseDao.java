package com.ecvlearning.javaee.dao;

import com.ecvlearning.javaee.model.Trade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BaseDao {

    public List<Trade> getTradeList() throws IOException;

    public List<Trade> getTradeByPrice(long low, long high) throws IOException;
}
