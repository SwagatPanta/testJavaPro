package com.mycomp;

import java.util.List;

public class Portfolio {
    private List<Stock> stock;
    private StockService stockService;



    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    /***
     * getPrice(Stock) method is from interface StockService which has not been implemented
     * by other class so we will mock (Create unreal object as real) from the test class i.e
     * TestmockExample.
     *
     * */
    public double getMarketValue() {
        double totalMarketValue=0.00;
        for (Stock stk : stock) {
            totalMarketValue += stockService.getPrice(stk) * stk.getQuantity();
        }
        return totalMarketValue;
    }
//    100*10+10*15=>1000+150=>1150
}
