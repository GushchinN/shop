public class Product {
    private String name;
    private double price;
    private Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {return name;}
    public double getPrice() {return price;}
    public Category getCategory() {return category;}

    @Override
    public String toString() {
        return String.format("%-20s %10.2f руб.", name, price);
    }
}
