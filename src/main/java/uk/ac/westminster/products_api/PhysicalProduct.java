package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it is still something the shop sells, with an id, a name and a price, and it can be used anywhere a Product is expected.
// A ShoppingCart would NOT pass this test: a cart is not a product, it contains products (HAS-A).
public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

    // empty no-arg constructor, Jackson needs this to build an object from JSON
    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
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
}
