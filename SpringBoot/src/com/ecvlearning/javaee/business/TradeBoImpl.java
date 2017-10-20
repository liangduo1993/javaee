package com.ecvlearning.javaee.business;

import com.ecvlearning.javaee.dao.BaseDao;
import com.ecvlearning.javaee.dao.TradeDao4File;
import com.ecvlearning.javaee.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TradeBoImpl implements TradeBo{

    @Autowired
    BaseDao tradeDao;

    public List<Trade> getTradeList() throws IOException {
        return tradeDao.getTradeList();
    }

    @Override
    public List<Trade> getTradeByPrice(long low, long high) throws IOException {
        return tradeDao.getTradeByPrice(low, high);
    }


}
