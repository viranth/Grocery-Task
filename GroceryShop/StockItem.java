package GroceryShop;

class StockItem {
    private int id;
    private String name;
    private double price;
    private double quantity;
    private double reorderLeft;

    public StockItem( String name, double price, double quantity) {
        // this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reorderLeft= (int)quantity-10;
    }

    // Getters and setters for StockItem attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getReorderLeft() {
        return reorderLeft;
    }

    public void setReorderLeft(double newReorderLeft) {
        this.reorderLeft = newReorderLeft;
    }
}
