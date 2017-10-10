package objectsClasses.salesReport_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ChaosFire on 10.10.2017 г.
 */
public class SalesReport {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Map<String, List<Sale>> sales = new HashMap<>();
        for (int i = 0; i < count; i++) {
            Sale sale = Sale.readSale(reader.readLine());
            List<Sale> salesPerTown = sales.get(sale.getTown());
            if (salesPerTown == null) {
                salesPerTown = new ArrayList<>();
                salesPerTown.add(sale);
                sales.put(sale.getTown(), salesPerTown);
            } else {
                salesPerTown.add(sale);
            }
        }
        reader.close();

        StringBuilder output = new StringBuilder();
        sales.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    double total = entry.getValue().stream().mapToDouble(sale -> sale.getPrice() * sale.getQuantity()).sum();
                    output.append(entry.getKey()).append(" -> ").append(String.format("%.2f", total)).append(System.lineSeparator());
                });
        System.out.print(output);
    }
}

class Sale {

    private String town;
    private double price;
    private double quantity;

    private Sale(String town, double price, double quantity) {
        this.setTown(town);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    static Sale readSale(String input) {
        String[] data = input.split("\\s+");
        return new Sale(data[0], Double.parseDouble(data[2]), Double.parseDouble(data[3]));
    }

    String getTown() {
        return this.town;
    }

    private void setTown(String town) {
        this.town = town;
    }

    double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    double getQuantity() {
        return this.quantity;
    }

    private void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}