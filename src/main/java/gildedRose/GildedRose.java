package gildedRose;

public class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals("Aged Brie")) {
                handleAgedBrie(items[i]);
                continue;
            }
            if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                handleBackstagePasses(items[i]);
                continue;
            }
            if (items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            handleOther(items[i]);
        }
    }

    private void handleOther(Item item) {
        if (item.getSellIn() < 1) {
            item.setQuality(Math.max(item.getQuality() - 2, 0));
        }
        item.setQuality(Math.max(item.getQuality() - 1, 0));
        item.setSellIn(item.getSellIn()-1);
    }

    private void handleBackstagePasses(Item item) {

        item.setSellIn(item.getSellIn()-1);
        if (item.getSellIn() < 0) {
            item.setQuality(0);
            return;
        }
        if (item.getSellIn() < 5) {
            item.setQuality(Math.min(item.getQuality() + 3, 50));
            return;
        }
        if (item.getSellIn() < 10) {
            item.setQuality(Math.min(item.getQuality() + 2, 50));
            return;
        }
        if (item.getSellIn() >= 10) {
            item.setQuality(Math.min(item.getQuality() + 1, 50));
        }

    }

    private void handleAgedBrie(Item item) {
        if (item.getSellIn() < 1) {
            item.setQuality(Math.min(item.getQuality() + 2, 50));
        }
        item.setQuality(Math.min(item.getQuality() + 1, 50));
        item.setSellIn(item.getSellIn()-1);
    }
}