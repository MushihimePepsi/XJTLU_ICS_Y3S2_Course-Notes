import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("New York"); // add
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");

        System.out.println("A list of cities in collection1:");
        System.out.println(collection1);

        // the Collection interface's contains method
        System.out.println("\nIs Dallas in collection1? " + collection1.contains("Dallas")); // contains

        // the Collection interface's remove method
        collection1.remove("Dallas"); // remove

        // the Collection interface's size method
        System.out.println("\n" + collection1.size() + // size
                " cities are in collection1 now");

        Collection<String> collection2 = new ArrayList<>();
        collection2.add("Seattle");
        collection2.add("Portland");

        System.out.println("\nA list of cities in collection2:");
        System.out.println(collection2);

        ArrayList<String> c1 = (ArrayList<String>) (collection1.clone()); // clone
        c1.addAll(collection2); // addAll
        System.out.println("\nCities in collection1 or collection2:");
        System.out.println(c1);

        c1 = (ArrayList<String>) (collection1.clone());
        c1.retainAll(collection2); // retainAll
        System.out.println("\nCities in collection2:");
        System.out.println(c1);

        c1 = (ArrayList<String>) (collection1.clone());
        c1.removeAll(collection2); // removeAll
        System.out.println("\nCities in collection1, but not in 2: ");
        System.out.println(c1);
    }
}