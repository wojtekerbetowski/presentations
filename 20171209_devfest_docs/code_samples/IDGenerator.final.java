import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IDGenerator {

    public List<String> generateIDs(int count) {
        List<String> ids = new ArrayList<String>();

        while (ids.size() < count) {
            String id = randomId();

            for (String anotherId : ids) {
                if(calculateHammingDistance(id, anotherId) < 2) {
                    continue;
                }
            }

            ids.add(id);
        }

        return ids;
    }

    private String randomId() {
        String id = "";
        for (int i = 0; i < 6; i++) {
            id += String.valueOf(new Random().nextInt(9));
        }
        return id;
    }

    private int calculateHammingDistance(String left, String right) {
        int distanceCounter = 0;

        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) distanceCounter++;
        }

        return distanceCounter;
    }
}
