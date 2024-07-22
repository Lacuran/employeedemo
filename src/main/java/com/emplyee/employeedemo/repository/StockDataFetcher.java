package com.emplyee.employeedemo.repository;

import com.emplyee.employeedemo.model.StockDetails;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StockDataFetcher implements DataFetcher<List<StockDetails>> {

  @Override
  public List<StockDetails> get(DataFetchingEnvironment dataFetchingEnvironment) {
    StockDetails stockDetails = new StockDetails();

    stockDetails.setTicker("sdf");
    stockDetails.setStockValue("34");
    stockDetails.setVolume("326.8M");
    stockDetails.setAverageVolume("23.8M");
    stockDetails.setEPS("1.4");
    stockDetails.setPE_Ratio("2.45");
    stockDetails.setDividend("234%");
    stockDetails.setMarketCap("45.54T");
    stockDetails.setPreviousOpen("123.32");
    stockDetails.setPreviousClose("345.3");

    List<StockDetails> stockDetailsList = new ArrayList<>();
    stockDetailsList.add(stockDetails);

    return stockDetailsList;
  }
}
