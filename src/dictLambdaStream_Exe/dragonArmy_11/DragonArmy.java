package dictLambdaStream_Exe.dragonArmy_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ChaosFire on 8.10.2017 г.
 */
public class DragonArmy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Map<String, Set<Dragon>> dragons = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] data = reader.readLine().split("\\s+");
            Dragon dragon = new Dragon(data[1], data[0], data[2], data[3], data[4]);

            Set<Dragon> dragonsByType = dragons.get(dragon.getType());
            if (dragonsByType == null) {
                dragonsByType = new HashSet<>();
                dragonsByType.add(dragon);
                dragons.put(dragon.getType(), dragonsByType);
            } else {
                dragonsByType.remove(dragon);
                dragonsByType.add(dragon);
            }
        }
        reader.close();

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Set<Dragon>> entry : dragons.entrySet()) {
            StringBuilder sb = new StringBuilder();
            Total total = new Total();
            entry.getValue()
                    .stream()
                    .sorted(Comparator.comparing(Dragon::getName))
                    .forEach(dragon -> {
                        sb.append("-").append(dragon.toString()).append(System.lineSeparator());
                        total.setTotalDamage(total.getTotalDamage() + dragon.getDamage());
                        total.setTotalHealth(total.getTotalHealth() + dragon.getHealth());
                        total.setTotalArmor(total.getTotalArmor() + dragon.getArmor());
                    });
            int drCount = entry.getValue().size();
            output.append(String.format("%s::(%.2f/%.2f/%.2f)",
                    entry.getKey(), total.getTotalDamage() / drCount, total.getTotalHealth() / drCount, total.getTotalArmor() / drCount))
                    .append(System.lineSeparator())
                    .append(sb);
        }
        System.out.print(output);
    }
}

class Total {

    private static final double DEFAULT = 0;

    private double totalDamage;
    private double totalHealth;
    private double totalArmor;

    Total() {
        this.setTotalDamage(DEFAULT);
        this.setTotalHealth(DEFAULT);
        this.setTotalArmor(DEFAULT);
    }

    double getTotalDamage() {
        return this.totalDamage;
    }

    void setTotalDamage(double totalDamage) {
        this.totalDamage = totalDamage;
    }

    double getTotalHealth() {
        return this.totalHealth;
    }

    void setTotalHealth(double totalHealth) {
        this.totalHealth = totalHealth;
    }

    double getTotalArmor() {
        return this.totalArmor;
    }

    void setTotalArmor(double totalArmor) {
        this.totalArmor = totalArmor;
    }
}

class Dragon {

    private static final int DEFAULT_DAMAGE = 45;
    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_ARMOR = 10;

    private String name;
    private String type;
    private int damage;
    private int health;
    private int armor;

    Dragon(String name, String type, String damage, String health, String armor) {
        this.setName(name);
        this.setType(type);
        this.setDamage(this.tryParse(damage, DEFAULT_DAMAGE));
        this.setHealth(this.tryParse(health, DEFAULT_HEALTH));
        this.setArmor(this.tryParse(armor, DEFAULT_ARMOR));
    }

    private int tryParse(String string, int defValue) {
        int value;
        try {
            value = Integer.parseInt(string);
        } catch (NumberFormatException exc) {
            value = defValue;
        }
        return value;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * 17 + this.type.hashCode() * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Dragon)) {
            return false;
        }
        Dragon other = (Dragon) obj;
        return this.name.equals(other.name) && this.type.equals(other.type);
    }

    @Override
    public String toString() {
        return String.format("%s -> damage: %d, health: %d, armor: %d", this.name, this.damage, this.health, this.armor);
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
    }

    int getDamage() {
        return this.damage;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    int getArmor() {
        return this.armor;
    }

    private void setArmor(int armor) {
        this.armor = armor;
    }
}