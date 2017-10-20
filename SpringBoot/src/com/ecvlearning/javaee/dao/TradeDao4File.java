package com.ecvlearning.javaee.dao;

import com.ecvlearning.javaee.Constants.DaoConstants;
import com.ecvlearning.javaee.model.Trade;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TradeDao4File implements BaseDao {

    public List<Trade> getTradeList() throws IOException {
        List<Trade> trades = new ArrayList<>();
        String line = "";


        try (BufferedReader br = this.readFile(DaoConstants.FILE_PATH)) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] columns = line.split(DaoConstants.SEPARATOR);
                Trade t = new Trade();
                t.setId(Integer.valueOf(columns[0]));
                t.setPrice(Long.valueOf(columns[2]));
                t.setTicker(columns[1]);
                t.setClientName(columns[4]);
                t.setAction(columns[3]);
                trades.add(t);

            }
        }


        return trades;

    }

    public List<Trade> getTradeByPrice(long low, long high) throws IOException {
        List<Trade> trades = new ArrayList<>();
        String line = "";

        try (BufferedReader br = this.readFile(DaoConstants.FILE_PATH)) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] columns = line.split(DaoConstants.SEPARATOR);
                long price = Long.valueOf(columns[2]);
                if(price > low && price < high){
                    Trade t = new Trade();
                    t.setId(Integer.valueOf(columns[0]));
                    t.setPrice(Long.valueOf(columns[2]));
                    t.setTicker(columns[1]);
                    t.setClientName(columns[4]);
                    t.setAction(columns[3]);
                    trades.add(t);
                }
            }
        }
        return trades;
    }

    private BufferedReader readFile(String path) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        return br;
    }
}

