package gildedRose;

public class BackstageStrategy implements Strategy {
    @Override
    public void doChange(Item item) {
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
}
