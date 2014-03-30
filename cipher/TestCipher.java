package hofbauer.cipher;

import java.util.ArrayList;
import java.util.List;

public class TestCipher {

	public static String join(CharSequence[] array, String delimiter) {
        if (array.length == 0) return null;
        StringBuilder sb = new StringBuilder();
        int i;
        for(i = 0; i < array.length - 1; i++) {
        	sb.append(array[i].toString());
        	sb.append(delimiter);
        }
        return sb.toString() + array[i];
	}
	
	public static String repeat(CharSequence seq, int count) {
		StringBuilder sb = new StringBuilder(count);
		for(int i = 0; i < count; i++) sb.append(seq);
		return sb.toString();
	}
	
	public static List<Character> arrayToList(char[] a) {
		List<Character> list = new ArrayList<Character>();
	    for (char c : a) {
	        list.add(c);
	    }
	    return list;
	}
}
