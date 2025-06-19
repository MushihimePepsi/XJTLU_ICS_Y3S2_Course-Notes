import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
public class FlightBoardingSystem {
    public static void main(String[] args) {
        PriorityQueue<String> firstClassQueue = new PriorityQueue<>(Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Ethan", "Fiona"));
        PriorityQueue<String> businessClassQueue = new PriorityQueue<>(Arrays.asList("Charlie", "Diana", "Grace", "Ian"));
        PriorityQueue<String> economyClassQueue = new PriorityQueue<>(Arrays.asList("Alice", "Grace", "Ethan", "Hannah", "Ian"));

        Set<String> exclusiveFirstClass = findExclusiveFirstClassPassengers(firstClassQueue,businessClassQueue,economyClassQueue);
        System.out.println(exclusiveFirstClass);
    }

    public static Set<String> findExclusiveFirstClassPassengers( PriorityQueue<String>firstClassQueue,
                                                                 PriorityQueue<String>businessClassQueue,
                                                                 PriorityQueue<String>economyClassQueue) {
        Set<String> exclusiveFirstClass = new HashSet<>(firstClassQueue);
        Set<String> businessClassSet = new HashSet<>(businessClassQueue);
        Set<String> economyClassSet = new HashSet<>(economyClassQueue);
        exclusiveFirstClass.removeAll(businessClassSet);
        exclusiveFirstClass.removeAll(economyClassSet);
        return exclusiveFirstClass;
    }
}
