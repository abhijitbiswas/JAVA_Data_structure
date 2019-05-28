package ConcurrencyAndThread;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class SynchronizingHashMap {
    public static void main(String args[]) {
        HashMap<Integer, String> hmap= new HashMap<Integer, String>();
        hmap.put(2, "Anil");
        hmap.put(44, "Ajit");
        hmap.put(1, "Brad");
        hmap.put(4, "Sachin");
        hmap.put(88, "XYZ");

        Map map= Collections.synchronizedMap(hmap);
        Set set = map.entrySet();
        synchronized(map){
            Iterator i = set.iterator();
            // Display elements
            while(i.hasNext()) {
                Map.Entry me = (Map.Entry)i.next();
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
        }
    }
}

/*
Output:
1: Brad
2: Anil
4: Sachin
88: XYZ
44: Ajit
 */