package GroceryShop;
import java.util.ArrayList;
import java.util.List;

public class StockManager {
    private List<StockItem> stockItems;
    private int nextItemId;

    public StockManager() {
        this.stockItems = new ArrayList<>();
        // Determine the starting ID based on the existing data
        this.nextItemId = calculateNextItemId();
    }

    // Calculate the next available ID based on existing data
    private int calculateNextItemId() {
        int maxId = 0;
        for (StockItem item : stockItems) {
            if (item.getId() > maxId) {
                maxId = item.getId();
            }
        }
        return maxId + 1;
    }

    public void addStockItem(StockItem item) {
        item.setId(nextItemId); // Assign the next available ID
        stockItems.add(item);
        nextItemId++; // Increment the next available ID for the next item
    }


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

    public void deleteStockItem(int itemId) {
        stockItems.removeIf(item -> item.getId() == itemId);
    }

    public List<StockItem> getAllStockItems() {
        return stockItems;
    }

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
