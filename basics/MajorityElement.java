package basics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author rbgangad
 *
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (hashMap.containsKey(array[i])) {
				Integer value = hashMap.get(array[i]);
				hashMap.put(array[i], ++value);
			} else {
				hashMap.put(array[i], 1);
			}
		}
		
		Set<Entry<Integer, Integer>> entrySet = hashMap.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Integer> currentEntry = iterator.next();
			System.out.println("KEY= "+currentEntry.getKey()+" COUNT="+currentEntry.getValue());
		}
	}
}
