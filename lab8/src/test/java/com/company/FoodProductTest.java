package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class FoodProductTest {
    @Test
    void fromCsvNameTest(){
        FoodProduct product = FoodProduct.fromCsv(Path.of("src/test/resources/testowyplik.csv"));

        String nameProduct = product.getName();
        Assertions.assertEquals("maslo",nameProduct);
    }
    @Test
    void fromCsvPriceTest(){
        FoodProduct product = FoodProduct.fromCsv(Path.of("src/test/resources/testowyplik.csv"));

        Double productPrice = product.getPrice(2010, 2, "XXX");
        Assertions.assertEquals(6.78,productPrice);
    }
}
