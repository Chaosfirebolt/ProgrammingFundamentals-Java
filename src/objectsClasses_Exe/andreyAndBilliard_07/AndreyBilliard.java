package objectsClasses_Exe.andreyAndBilliard_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ChaosFire on 11.10.2017 г.
 */
public class AndreyBilliard {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Map<String, Product> products = new HashMap<>();
        for (int i = 0; i < count; i++) {
            Product product = parseProduct(reader.readLine().split("-"));
            if (products.containsKey(product.getName())) {
                products.replace(product.getName(), product);
            } else {
                products.put(product.getName(), product);
            }
        }
        String input = reader.readLine();
        Map<String, Client> clients = new HashMap<>();
        while (!input.equals("end of clients")) {
            String[] data = input.split("[-,]");
            String productName = data[1];
            if (products.containsKey(productName)) {
                String client = data[0];
                int quantity = Integer.parseInt(data[2]);
                if (!clients.containsKey(client)) {
                    clients.put(client, new Client(client));
                }

                Product product = products.get(productName);
                Integer oldVal = clients.get(client).getBoughtProducts().get(product);
                if (oldVal == null) {
                    clients.get(client).getBoughtProducts().put(product, quantity);
                } else {
                    clients.get(client).getBoughtProducts().replace(product, oldVal + quantity);
                }
            }

            input = reader.readLine();
        }

        StringBuilder output = new StringBuilder();
        Bill totalBill = new Bill();
        clients.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    output.append(entry.getKey()).append(System.lineSeparator());
                    Set<Map.Entry<Product, Integer>> bought = entry.getValue().getBoughtProducts().entrySet();
                    for (Map.Entry<Product, Integer> pair : bought) {
                        output.append(String.format("-- %s - %d", pair.getKey().getName(), pair.getValue())).append(System.lineSeparator());
                    }
                    double bill = entry.getValue().bill();
                    totalBill.increment(bill);
                    output.append(String.format("Bill: %.2f", bill)).append(System.lineSeparator());
                });
        output.append(String.format("Total bill: %.2f", totalBill.getTotal()));
        System.out.print(output);
    }

    private static Product parseProduct(String[] data) {
        return new Product(data[0], Double.parseDouble(data[1]));
    }
}

class Bill {

    private static final double DEFAULT = 0;

    private double total;

    Bill() {
        this.setTotal(DEFAULT);
    }

    void increment(double value) {
        this.total += value;
    }

    double getTotal() {
        return this.total;
    }

    private void setTotal(double total) {
        this.total = total;
    }
}

class Client {

    private String name;
    private Map<Product, Integer> boughtProducts;

    Client(String name) {
        this.setName(name);
        this.setBoughtProducts(new LinkedHashMap<>());
    }

    double bill() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : this.boughtProducts.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrice();
        }
        return total;
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    Map<Product, Integer> getBoughtProducts() {
        return this.boughtProducts;
    }

    private void setBoughtProducts(Map<Product, Integer> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }
}

class Product {

    private String name;
    private double price;

    Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Product other = (Product) o;
        return this.getName().equals(other.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
}