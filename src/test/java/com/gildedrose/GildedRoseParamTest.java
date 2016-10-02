package com.gildedrose;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

/**
 * Created by Daryl on 9/25/2016.
 */
@RunWith(Parameterized.class)
public class GildedRoseParamTest {
    private String itemName;
    private int initSellIn;
    private int initQuality;
    private int expSellIn;
    private int expQuality;
    private String testName;

    public GildedRoseParamTest(String testName, String itemName, int initSellIn, int initQuality, int expSellIn, int expQuality){
        this.testName = testName;
        this.itemName = itemName;
        this.initSellIn = initSellIn;
        this.initQuality = initQuality;
        this.expSellIn = expSellIn;
        this.expQuality = expQuality;
    }

    @Parameters(name = "{index}: {0}")
    public static Collection<Object[]> itemsToTest(){
        return Arrays.asList(new Object[][] {

                // TEST NAME -- ITEM -- Initial Sell In -- Initial Quality -- Expected Sell In -- Expected Quality
                {"Standard degrade","foo",10,5,9,4},
                {"Double degrade after SellIn passed","foo",0,10,-1,8},
                {"Quality not negative single","foo",10,0,9,0},
                {"Quality not negative double","foo",0,1,-1,0},
             //   {"Quality max of 50","foo",10,60,9,49},
             //   {"Sulfuras is always 80 quality and no sell in","Sulfuras, Hand of Ragnaros",10,50,0,80},
             //   {"Sulfuras negative init","Sulfuras, Hand of Ragnaros",-20,30,0,80},
                {"Aged Brie increases quality","Aged Brie",20,30,19,31},
                {"Aged Brie Increases quality max 50","Aged Brie",20,50,19,50},
                {"Aged Brie increases quality 11","Aged Brie",11,20,10,21},
                {"Aged Brie increases quality 10","Aged Brie",10,20,9,21},
                {"Aged Brie increases quality 6","Aged Brie",6,20,5,21},
                {"Aged Brie increases quality 5","Aged Brie",5,20,4,21},
                {"Aged Brie increases quality 1","Aged Brie",1,20,0,21},
             //   {"Aged Brie increases quality 0","Aged Brie",0,20,-1,21},
             //   {"Aged Brie increases quality -5","Aged Brie",-5,20,-6,21},
                {"Backstage more than 10 days","Backstage passes to a TAFKAL80ETC concert",11,20,10,21},
                {"Backstage 10 days","Backstage passes to a TAFKAL80ETC concert",10,20,9,22},
                {"Backstage 6 days","Backstage passes to a TAFKAL80ETC concert",6,20,5,22},
                {"Backstage 5 days or less","Backstage passes to a TAFKAL80ETC concert",5,20,4,23},
                {"Backstage 1 day","Backstage passes to a TAFKAL80ETC concert",1,20,0,23},
                {"Backstage 0 days","Backstage passes to a TAFKAL80ETC concert",0,20,-1,0},
                {"Backstage negative sell in","Backstage passes to a TAFKAL80ETC concert",-5,0,-6,0},
                {"Backstage sell in 11 max","Backstage passes to a TAFKAL80ETC concert",11,50,10,50},
                {"Backstage sell in 6 max","Backstage passes to a TAFKAL80ETC concert",6,50,5,50},
                {"Backstage sell in 1 max","Backstage passes to a TAFKAL80ETC concert",1,50,0,50},
                {"Backstage sell in 0 max to 0","Backstage passes to a TAFKAL80ETC concert",0,50,-1,0},
             //   {"Conjured 2x degrade","Conjured foo",10,5,9,3},
             //   {"Conjured double 2x degrade after SellIn passed","Conjured foo",0,10,-1,6},
             //   {"Conjured Quality not negative from 1 normal","Conjured foo",10,1,9,0},
             //   {"Conjured Quality not negative from 2 double","Conjured foo",0,2,-1,0},
             //   {"Conjured Quality not negative from 0 double","Conjured foo",0,0,-1,0},
             //   {"Conjured Quality max of 50","Conjured foo",10,60,9,49}
        });
    }

    @Test
    public void testItems(){
        Item[] items = new Item[] { new Item(itemName, initSellIn, initQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(itemName, app.items[0].name);
        assertEquals(expSellIn,app.items[0].sellIn);
        assertEquals(expQuality, app.items[0].quality);
    }

}

