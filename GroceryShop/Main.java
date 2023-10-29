package GroceryShop;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StockManager stockManager = new StockManager();
        JsonHandler jsonHandler = new JsonHandler();
        Scanner sc = new Scanner(System.in);
        int mainMenu = 0;
        int stockMenu = 0;
        jsonHandler.readJsonFile(stockManager);
        System.out.println("Main Menu :");
        while (true) {
            System.out.println(
                    "1.Stock\n" +
                            "2.Sell\n" +
                            "3.Sales Record");
            System.out.println("Enter your Option : ");
            mainMenu = sc.nextInt();
            if (mainMenu == 1) {
                while (true) {
                    System.out.println("1.addItemStock\n" +
                            "2.updateItemStock\n" +
                            "3.deleteItemStock\n" +
                            "4.ViewItemStock\n" +
                            "5.returnToMainmenu\n");
                    System.out.println("Enter your choice : ");
                    stockMenu = sc.nextInt();
                    if (stockMenu == 1) {
                        System.out.println("Enter the number of products to add : ");
                        int productsCount = sc.nextInt();
                        for (int i = 0; i < productsCount; i++) {
                            System.out.println("Enter the name of the product: \n");
                            String name = sc.next();
                            System.out.println("Enter the price of the product: ");
                            double price = sc.nextDouble();
                            System.out.print("Enter the quantity of the product: ");
                            double quantity = sc.nextDouble();

                            // Create a new product and add it to the stock
                            StockItem newProduct = new StockItem(name, price, quantity);
                            stockManager.addStockItem(newProduct);
                            jsonHandler.writeJsonFile(stockManager);
                        }
                    } else if (stockMenu == 2) {

                        System.out.print("Enter the poduct id you want to update :");
                        int idToUpdate = sc.nextInt();
                        String nameToUpdate = "";
                        for (StockItem item : stockManager.getAllStockItems()) {
                            if (item.getId() == idToUpdate) {
                                nameToUpdate = item.getName();
                            }
                        }

                        System.out.println("Do you want to update " + nameToUpdate + "? Y/N");
                        char updateChoice = sc.next().charAt(0);
                        if (updateChoice == 'Y' || updateChoice == 'y') {
                            System.out.println("Update Product Name press P\n" +
                                    "Update Price press C\n" +
                                    "Update Quantity press Q\n");
                            char updateItemChoice = sc.next().charAt(0);
                            String newName = "";
                            double newPrice = 0;
                            double updateQuantity = 0;
                            double newReorderLeft = 0;

                            if ((updateItemChoice == 'P') || (updateItemChoice == 'p')) {
                                System.out.print("Enter the new name for the product: ");
                                newName = sc.next();
                                System.out.println();
                            } else if ((updateItemChoice == 'c') || (updateItemChoice == 'C')) {
                                System.out.print("Enter the new price for the product: ");
                                newPrice = sc.nextDouble();
                                System.out.println();
                            } else if ((updateItemChoice == 'q') || (updateItemChoice == 'Q')) {
                                System.out.print("Enter the new quantity for the product: ");
                                updateQuantity = sc.nextDouble();
                                System.out.println();
                            }

                            for (StockItem item : stockManager.getAllStockItems()) {
                                if (item.getId() == idToUpdate) {
                                    if ((updateItemChoice == 'P') || (updateItemChoice == 'p')) {
                                        item.setName(newName);
                                    } else if ((updateItemChoice) == 'c' || (updateItemChoice == 'C')) {
                                        item.setPrice(newPrice);
                                    } else if ((updateItemChoice == 'q') || (updateItemChoice == 'Q')) {
                                        double newQuantity = item.getQuantity() + updateQuantity;
                                        // Calculate the new 1
                                        newReorderLeft = newQuantity - 10;
                                        item.setQuantity(newQuantity);
                                        item.setReorderLeft(newReorderLeft);// Update reorderLeft
                                    }

                                }
                            }

                            jsonHandler.writeJsonFile(stockManager);
                        }

                    } else if (stockMenu == 3) {
                        int idToDelete = sc.nextInt(); // ID of the product you want to delete
                        String nameToDelete = "";
                        for (StockItem item : stockManager.getAllStockItems()) {
                            if (item.getId() == idToDelete) {
                                nameToDelete = item.getName();
                            }
                        }
                        System.out.println("you want to delete " + nameToDelete + "? Y/N");
                        char deleteProduct = sc.next().charAt(0);
                        if ((deleteProduct == 'Y') || (deleteProduct == 'y')) {
                            stockManager.deleteStockItem(idToDelete);
                            // Write the updated data back to the JSON file
                            jsonHandler.writeJsonFile(stockManager);
                            break; // Exit the loop after deletion
                        }

                    } else if (stockMenu == 4) {
                        // Generate and display the stock report
                        String stockReport = stockManager.generateStockReport();
                        System.out.println(stockReport);

                    } else if (stockMenu == 5) {
                        System.out.println("Return to Main Menu");
                        break;
                    } else {
                        System.out.println("You choice is wrong choose correct choice!...");
                        continue;
                    }
                }

            } else if (mainMenu == 2) {
                System.out.println("1.orderItem\n" +
                        "2.Billing");

            } else if (mainMenu == 3) {
                break;

            } else {
                System.out.println("Your choice is wrong give good choice");
                continue;
            }
        }

        jsonHandler.writeJsonFile(stockManager);
    }
}
