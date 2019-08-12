package gildedRose;
public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if(items[i].name.equals("Aged Brie")){
                handleAgedBrie(items[i]);
                continue;
            }
            if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                handleBackstagePasses(items[i]);
                continue;
            }

            if(items[i].name.equals("Sulfuras, Hand of Ragnaros")){
                continue;
            }


            handleOther(items[i]);
        }
    }

    private void handleOther(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void handleBackstagePasses(Item item) {

        item.sellIn--;
        if(item.sellIn < 0) {
            item.quality = 0;
            return;
        }
        if(item.sellIn < 5){
            item.quality = Math.min(item.quality + 3, 50);
            return;
        }
        if(item.sellIn < 10){
            item.quality = Math.min(item.quality + 2, 50);
            return;
        }
        if(item.sellIn >= 10){
            item.quality = Math.min(item.quality + 1, 50);
        }

    }

    private void handleAgedBrie(Item item) {
       if(item.getSellIn()<1){
           item.quality=Math.min(item.quality+2,50);
       }
       item.quality=Math.min(item.quality+1,50);
       item.sellIn--;
    }
}