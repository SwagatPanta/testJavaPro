package com.mycomp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestmockExample {

    StockService stockService;
    Portfolio portfolio;


    public void setUp(){
        //create Portfolio object which is to be tested
        portfolio=new Portfolio();
        //create mock object of StockService
        stockService=mock(StockService.class);
        //set the stockService for the Portfolio
        portfolio.setStockService(stockService);
    }

    @Test
    public void testMarketValue(){
        setUp();
        List<Stock> stocks = new ArrayList<Stock>();
        Stock facebook=new Stock(1,"facebook",100);
        Stock instagram=new Stock(2,"Instagram",10);
        stocks.add(facebook);
        stocks.add(instagram);

        //add stock to the portfolio
        portfolio.setStock(stocks);

        when(stockService.getPrice(facebook)).thenReturn(10.00);
        when(stockService.getPrice(instagram)).thenReturn(15.00);


        double totalVal=portfolio.getMarketValue();
        Assert.assertEquals(totalVal,1150.00,0.00);
    }
}
