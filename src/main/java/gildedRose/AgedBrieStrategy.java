package gildedRose;

public class AgedBrieStrategy implements  Strategy {
    @Override
    public void doChange(Item item) {
        if (item.getSellIn() < 1) {
            item.setQuality(Math.min(item.getQuality() + 2, 50));
        }
        item.setQuality(Math.min(item.getQuality() + 1, 50));
        item.setSellIn(item.getSellIn()-1);
    }
}
