package lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class HashyPoo {

	public static void main(String[] args) {

		String[] Minnows = new String[5];
		Minnows[0] = "John";
		Minnows[1] = "Luke";

		String[] Dolphins = new String[5];
		Dolphins[0] = "Jane";
		
		HashMap<String, String[]> groupNames = new HashMap<String, String[]>();
		groupNames.put("Minnows", Minnows);
		groupNames.put("Dolphins", Dolphins);
		
		for (Entry<String, String[]> mapElement : groupNames.entrySet()) {
            String key = mapElement.getKey();
 
            // Adding some bonus marks to all the students
            String[] value = (mapElement.getValue());
 
            // Printing above marks corresponding to
            // students names
            System.out.print(key);
            
            for (int i = 0; i < 5; i++) {
            	if (value [i] != null)
            	System.out.print(value[i] + ",");
            }
        }
		

	}
}