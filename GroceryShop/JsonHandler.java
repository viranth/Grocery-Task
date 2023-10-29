package GroceryShop;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonHandler {
    public void readJsonFile(StockManager stockManager) {
        try (FileReader reader = new FileReader("stock_data.json")) {
            Gson gson = new Gson();
            Type stockListType = new TypeToken<List<StockItem>>() {
            }.getType();

            List<StockItem> stockItems = gson.fromJson(reader, stockListType);

            for (StockItem item : stockItems) {
                stockManager.addStockItem(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJsonFile(StockManager stockManager) {
        try (FileWriter writer = new FileWriter("stock_data.json")) {
            Gson gson = new Gson();
            gson.toJson(stockManager.getAllStockItems(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
