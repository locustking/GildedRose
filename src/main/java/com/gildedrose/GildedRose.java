package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {

            if (item.name.contains("Sulfuras")) {
                item.quality = 80;
            } else if(item.name.equals("Aged Brie") && item.quality < 50 && item.sellIn<0){
                    item.quality = item.quality + 1;
            } else {
                if (!item.name.equals("Aged Brie") &&
                        !item.name.contains("Backstage passes") &&
                        item.quality > 0) {
                            item.quality = item.quality - 1;
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;

                        if (item.name.contains("Backstage passes")) {
                            if (item.sellIn < 11) {
                                item.quality = item.quality + 1;
                            }

                            if (item.sellIn < 6) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                        if (!item.name.contains("Backstage passes") && item.quality > 0) {

                                item.quality = item.quality - 1;

                        } else {
                            item.quality = item.quality - item.quality;
                        }
                }
            }
        }
    }
}
