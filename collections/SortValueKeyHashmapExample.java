package Collections;

import java.text.ParseException;
import java.util.*;
import java.util.Map.Entry;

/*
* How to sort HashMap in Java by keys and values. * HashMap doesn't guarantee any order, so you cannot rely on it, even if * it appear that it storing entries in a particular order, because * it may not be available in future version e.g. earlier HashMap stores * integer keys on the order they are inserted but from Java 8 it has changed. *

Read more: http://www.java67.com/2015/01/how-to-sort-hashmap-in-java-based-on.html#ixzz5oN3c1hox
 */

public class SortValueKeyHashmapExample {
    //can't define sys out, out side main,static block or method.
    //System.out.println("");
    public static void main(String args[]) throws ParseException {
        // let's create a map with Java releases and their code names.
        HashMap<String, String> codenames = new HashMap<String, String>();
        codenames.put("JDK 1.1.4", "Sparkler");
        codenames.put("J2SE 1.2", "Playground");
        codenames.put("J2SE 1.3", "Kestrel");
        codenames.put("J2SE 1.4", "Merlin");
        codenames.put("J2SE 5.0", "Tiger");
        codenames.put("Java SE 6", "Mustang");
        codenames.put("Java SE 7", "Dolphin");


        //sort by key first
        //// TreeMap keeps all entries in sorted order

        TreeMap<String, String> sorted = new TreeMap<>(codenames);
        Set<Entry<String, String>> mappings = sorted.entrySet();
        for (Entry<String, String> mapping : mappings) {
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }

        //sort by values
    }

    //sort by values IMP:
    //if value is int , that also we can
    /*
    HashMap<Integer,String> map = new HashMap<Integer,String>();
map.put(1,"froyo");
map.put(2,"abby");
map.put(3,"denver");
map.put(4,"frost");
map.put(5,"daisy");
Required output:

2,abby;
5,daisy;
3,denver;
4,frost;
1,froyo;
     */

    public LinkedHashMap<Integer, String> sortHashMapByValues(HashMap<Integer, String> passedMap) {
        List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
        List<String> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<Integer, String> sortedMap =
                new LinkedHashMap<>();

        Iterator<String> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            String val = valueIt.next();
            Iterator<Integer> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Integer key = keyIt.next();
                String comp1 = passedMap.get(key);
                String comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }


}
