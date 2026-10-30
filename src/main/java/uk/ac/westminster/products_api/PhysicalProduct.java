package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it is still something the shop sells, with an id, a name and a price, and it can be used anywhere a Product is expected.
// A ShoppingCart would NOT pass this test: a cart is not a product, it contains products (HAS-A).
public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    // empty no-arg constructor, Jackson needs this to build an object from JSON
    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
        this.discountedPrice = price;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName()
                + " | Weight: " + weightKg + "kg";
    }
    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
