package examPrep.exam_20170709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ChaosFire on 28.10.2017 г.
 */
public class PokemonEvolution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<String, Pokemon> pokemons = new LinkedHashMap<>();
        StringBuilder output = new StringBuilder();
        while (!input.equals("wubbalubbadubdub")) {
            String[] data = input.split("\\s+->\\s+");
            String name = data[0];
            if (data.length == 1) {
                Pokemon pokemon = pokemons.get(name);
                if (pokemon != null) {
                    output.append(pokemon.toString()).append(System.lineSeparator());
                }
            } else {
                Pokemon pokemon = pokemons.get(name);
                Evolution evolution = new Evolution(data[1], Integer.parseInt(data[2]));
                if (pokemon == null) {
                    pokemon = new Pokemon(name);
                    pokemon.addEvolution(evolution);
                    pokemons.put(name, pokemon);
                } else {
                    pokemon.addEvolution(evolution);
                }
            }
            input = reader.readLine();
        }
        reader.close();

        for (Pokemon pokemon : pokemons.values()) {
            output.append(pokemon.toStringOrdered()).append(System.lineSeparator());
        }
        System.out.print(output.toString().trim());
    }
}

class Pokemon {

    private String name;
    private LinkedList<Evolution> evolutions;

    Pokemon(String name) {
        this.name = name;
        this.evolutions = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(String.format("# %s", this.name));
        for (Evolution evolution : this.evolutions) {
            output.append(System.lineSeparator()).append(evolution.toString());
        }
        return output.toString();
    }

    String toStringOrdered() {
        StringBuilder output = new StringBuilder(String.format("# %s", this.name));
        this.evolutions
                .stream()
                .sorted()
                .forEach(ev -> output.append(System.lineSeparator()).append(ev.toString()));
        return output.toString();
    }

    void addEvolution(Evolution evolution) {
        this.evolutions.addLast(evolution);
    }
}

class Evolution implements Comparable<Evolution> {

    private String type;
    private int index;

    Evolution(String type, int index) {
        this.type = type;
        this.index = index;
    }

    @Override
    public String toString() {
        return String.format("%s <-> %d", this.type, this.index);
    }

    @Override
    public int compareTo(Evolution o) {
        return Integer.compare(o.index, this.index);
    }
}