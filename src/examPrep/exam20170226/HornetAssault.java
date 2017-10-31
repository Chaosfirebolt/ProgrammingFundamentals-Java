package examPrep.exam20170226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ChaosFire on 29.10.2017 г.
 */
public class HornetAssault {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<LongNode> beehives = parseInput(reader.readLine().split("\\s+"));
        LinkedList<LongNode> hornets = parseInput(reader.readLine().split("\\s+"));
        reader.close();

        long power = power(hornets);
        Iterator<LongNode> beehiveIterator = beehives.iterator();
        while (beehiveIterator.hasNext() && hornets.size() > 0) {
            LongNode beehive = beehiveIterator.next();
            if (power > beehive.getValue()) {
                beehiveIterator.remove();
            } else if (power == beehive.getValue()) {
                beehiveIterator.remove();
                power -= hornets.removeFirst().getValue();
            } else {
                beehive.setValue(beehive.getValue() - power);
                power -= hornets.removeFirst().getValue();
            }
        }

        if (beehives.size() > 0) {
            print(beehives);
        } else {
            print(hornets);
        }
    }

    private static void print(LinkedList<LongNode> list) {
        StringBuilder output = new StringBuilder();
        for (LongNode node : list) {
            output.append(node.getValue()).append(" ");
        }
        System.out.print(output);
    }

    private static long power(LinkedList<LongNode> list) {
        long sum = 0;
        for (LongNode node : list) {
            sum += node.getValue();
        }
        return sum;
    }

    private static LinkedList<LongNode> parseInput(String[] input) {
        LinkedList<LongNode> result = new LinkedList<>();
        for (String str : input) {
            result.addLast(new LongNode(Integer.parseInt(str)));
        }
        return result;
    }
}

class LongNode {

    private long value;

    LongNode(long value) {
        this.setValue(value);
    }

    long getValue() {
        return this.value;
    }

    void setValue(long value) {
        this.value = value;
    }
}