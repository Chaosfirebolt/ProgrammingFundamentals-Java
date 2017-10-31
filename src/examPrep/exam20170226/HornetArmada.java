package examPrep.exam20170226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 29.10.2017 г.
 */
public class HornetArmada {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Pattern pattern = Pattern.compile("(\\d+)\\s+=\\s+([^=>: -]+)\\s+->\\s+([^=>: -]+):(\\d+)");
        Armada armada = new Armada();
        for (int i = 0; i < n; i++) {
            Matcher matcher = pattern.matcher(reader.readLine());
            if (!matcher.find()) {
                continue;
            }
            long lastActivity = Long.parseLong(matcher.group(1));
            String legionName = matcher.group(2);
            String soldierType = matcher.group(3);
            long soldierCount = Long.parseLong(matcher.group(4));

            if (!armada.getLegionActivity().containsKey(legionName)) {
                Legion legion = new Legion(legionName);
                legion.getSoldiers().put(soldierType, new Soldier(soldierType, soldierCount));

                armada.getLegionActivity().put(legionName, lastActivity);
                armada.getLegions().put(legionName, legion);
            } else {
                if (armada.getLegionActivity().get(legionName) < lastActivity) {
                    armada.getLegionActivity().replace(legionName, lastActivity);
                }
                if (!armada.getLegions().get(legionName).getSoldiers().containsKey(soldierType)) {
                    armada.getLegions().get(legionName).getSoldiers().put(soldierType, new Soldier(soldierType, soldierCount));
                } else {
                    Soldier soldier = armada.getLegions().get(legionName).getSoldiers().get(soldierType);
                    soldier.setCount(soldier.getCount() + soldierCount);
                }
            }
        }
        String[] input = reader.readLine().split("\\\\");
        reader.close();
        StringBuilder output = new StringBuilder();
        if (input.length == 1) {
            String soldierType = input[0];
            armada.getLegions().values()
                    .stream()
                    .filter(legion -> hasSoldierType(legion, soldierType))
                    .sorted((l1, l2) -> {
                        Long firstLegionActivity = armada.getLegionActivity().get(l1.getLegionName());
                        Long secondLegionActivity = armada.getLegionActivity().get(l2.getLegionName());
                        return secondLegionActivity.compareTo(firstLegionActivity);
                    })
                    .forEach(l -> {
                        output.append(String.format("%d : %s", armada.getLegionActivity().get(l.getLegionName()), l.getLegionName()));
                        output.append(System.lineSeparator());
                    });
        } else {
            long activity = Long.parseLong(input[0]);
            String soldierType = input[1];
            Map<String, Long> legionSoldierMap = new LinkedHashMap<>();
            armada.getLegionActivity().entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() < activity)
                    .forEach(entry -> {
                        String legionName = entry.getKey();
                        Soldier soldier = armada.getLegions().get(legionName).getSoldiers().get(soldierType);
                        if (soldier != null) {
                            legionSoldierMap.put(legionName, soldier.getCount());
                        }
                    });
            legionSoldierMap.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> output.append(String.format("%s -> %d", entry.getKey(), entry.getValue())).append(System.lineSeparator()));
        }
        System.out.print(output);
    }

    private static boolean hasSoldierType(Legion legion, String soldierType) {
        Collection<Soldier> soldiers = legion.getSoldiers().values();
        for (Soldier soldier : soldiers) {
            if (soldier.getType().equals(soldierType)) {
                return true;
            }
        }
        return false;
    }
}

class Armada {

    private Map<String, Long> legionActivity;
    private Map<String, Legion> legions;

    Armada() {
        this.setLegionActivity(new LinkedHashMap<>());
        this.setLegions(new LinkedHashMap<>());
    }

    Map<String, Long> getLegionActivity() {
        return this.legionActivity;
    }

    private void setLegionActivity(Map<String, Long> legionActivity) {
        this.legionActivity = legionActivity;
    }

    Map<String, Legion> getLegions() {
        return this.legions;
    }

    private void setLegions(Map<String, Legion> legions) {
        this.legions = legions;
    }
}

class Legion {

    private String legionName;
    private Map<String, Soldier> soldiers;

    Legion(String legionName) {
        this.setLegionName(legionName);
        this.setSoldiers(new LinkedHashMap<>());
    }

    String getLegionName() {
        return this.legionName;
    }

    private void setLegionName(String legionName) {
        this.legionName = legionName;
    }

    Map<String, Soldier> getSoldiers() {
        return this.soldiers;
    }

    private void setSoldiers(Map<String, Soldier> soldiers) {
        this.soldiers = soldiers;
    }
}

class Soldier {

    private String type;
    private Long count;

    Soldier(String type, Long count) {
        this.setType(type);
        this.setCount(count);
    }

    String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
    }

    Long getCount() {
        return this.count;
    }

    void setCount(Long count) {
        this.count = count;
    }
}