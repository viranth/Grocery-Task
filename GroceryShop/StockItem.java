/**
 * @author Viranth Dharmalingam
 * @date Oct 28 21:50PM
 * @version JDK 1.8
 * StockItem class is used to store the details of the Stocks for the grocery shop
 */
package GroceryShop;

class StockItem {
    
    private int id;
    private String name;
    private double price;
    private double quantity;
    private double reorderLeft;

    /**
     * StockItem constructor with areguments
     * @param name String
     * @param price Double
     * @param quantity Double
     */
    public StockItem( String name, double price, double quantity) {
        // this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reorderLeft= (int)quantity-10;
    }

    // Getters and setters for StockItem attributes

    /**
     * To get the stock id
     * @return id Integer
     */
    public int getId() {
        return id;
    }

    /**
     * To set the value for Stock id
     * @param id Integer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * To get a product name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * To set a product name
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To get a product price
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * To set a Product Price 
     * @param price Integer
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * To get a product Quantity
     * @return
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * to set product quantity
     * @param quantity Double
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * To get a reorderLeft
     * @return reorederLeft Double
     */
    public double getReorderLeft() {
        return reorderLeft;
    }

    /**
     * to set product reorderLeft
     * @param newReorderLeft double
     */
    public void setReorderLeft(double newReorderLeft) {
        this.reorderLeft = newReorderLeft;
    }
}
