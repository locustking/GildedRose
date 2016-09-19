package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {




    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(19, app.items[0].quality);
        assertEquals(9,app.items[0].sellIn);
    }

    @Test
    public void itemAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(21, app.items[0].quality);
        assertEquals(9,app.items[0].sellIn);
    }

    @Test
    public void itemAgedBrie50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(9,app.items[0].sellIn);
    }



    @Test
    public void itemFooSellby() {
        Item[] items = new Item[] { new Item("Foo", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Foo", app.items[0].name);
        assertEquals(48, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        app.updateQuality();
        assertEquals("Foo", app.items[0].name);
        assertEquals(46, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void itemFooBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(22, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }
    @Test
    public void itemFooBackstageLess6and50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(23, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    public void itemSellInBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);

        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);

        app.updateQuality(); //8, 25
        app.updateQuality(); //7, 27
        app.updateQuality(); //6, 29
        app.updateQuality(); //5, 31


        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);

        app.updateQuality(); //4,
        app.updateQuality(); //3,
        app.updateQuality(); //2
        app.updateQuality(); //1,

        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(46, app.items[0].quality);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void itemSulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 11, 80),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", 10, 80)

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(11, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);

//        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);
//        assertEquals(-1, app.items[1].sellIn);
//        assertEquals(80, app.items[1].quality);

//        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
//        assertEquals(9, app.items[2].sellIn);
//        assertEquals(80, app.items[2].quality);
    }




}
