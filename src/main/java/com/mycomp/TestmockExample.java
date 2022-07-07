package com.mycomp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestmockExample {
    /**
     * <h1>Test Driven Development (TDD)</h1>
     * Here we develop clean architectural development.
     * <p>
     * It test the total market value of the stocks.
     *
     * @author Swagat Panta
     * @version 1.0
     * @since 2022-07-07
     */
    StockService stockService;
    Portfolio portfolio;


    public void setUp(){
        //create Portfolio object which is to be tested
        portfolio=new Portfolio();
        //create mock object of StockService
        /**
         * Since StockService has not been implemented we are creating mock object
         * so that we can set it's service in the portfolio and StockService's service is used
         * later on by Portfolio. Finally, our TDD will be accomplished.
         *
         * @see Portfolio
         * @see StockService
         * */
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
