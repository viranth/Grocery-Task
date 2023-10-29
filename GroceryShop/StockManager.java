/**
 * @author Viranth Dharmalingam
 * @date Oct 28 21:50PM
 * @version JDK 1.8
 * StockManager is to Manage the stocks like add update delete view the stock details
 */
package GroceryShop;
import java.util.ArrayList;
import java.util.List;

public class StockManager {
    private List<StockItem> stockItems;
    private int nextItemId;

    /**
     * StockManager Constructor without argument
     */
    public StockManager() {
        this.stockItems = new ArrayList<>();
        // Determine the starting ID based on the existing data
        this.nextItemId = calculateNextItemId();
    }

    // Calculate the next available ID based on existing data
    /***
     * The Product Id Auto generated method
     * @return
     */
    private int calculateNextItemId() {
        int maxId = 0;
        for (StockItem item : stockItems) {
            if (item.getId() > maxId) {
                maxId = item.getId();
            }
        }
        return maxId + 1;
    }

    /**
     * Add new product in the list
     * @param item StockItem class
     */
    public void addStockItem(StockItem item) {
        item.setId(nextItemId); // Assign the next available ID
        stockItems.add(item);
        nextItemId++; // Increment the next available ID for the next item
    }


    /***
     * To update the Stock details
     * @param updatedItem StockItem class object
     */
    public void updateStockItem(StockItem updatedItem) {
        for (StockItem item : stockItems) {
            if (item.getId() == updatedItem.getId()) {
                item.setName(updatedItem.getName());
                item.setPrice(updatedItem.getPrice());
                item.setQuantity(updatedItem.getQuantity());
                return;
            }
        }
    }

    /**
     * To delete the stock
     * @param itemId Integer
     */
    public void deleteStockItem(int itemId) {
        stockItems.removeIf(item -> item.getId() == itemId);
    }

    /**
     * to return the stockItems details
     * @return stockItems List
     */
    public List<StockItem> getAllStockItems() {
        return stockItems;
    }


    /**
     * Generate the Stock details
     * @return report StringBuilder
     */
    public String generateStockReport() {
        StringBuilder report = new StringBuilder();
        report.append("Stock Report\n");
        report.append("-----------------------------------------------------------------\n");
        report.append(String.format("%-5s %-20s %-10s %-10s %-12s\n", "ID", "Product", "Price (₹)", "Quantity", "Reorder Left"));
    
        for (StockItem item : stockItems) {
            report.append(String.format("%-5d %-20s %-10.2f %-10.2f %-12.2f\n", item.getId(), item.getName(), item.getPrice(), item.getQuantity(), item.getReorderLeft()));
        }
    
        return report.toString();
    }
    

    
}
