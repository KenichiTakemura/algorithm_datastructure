package interviews;

import java.util.Arrays;
import java.util.Hashtable;

import stack.Stack;
import stack.StackOnQueue;

/**
 * Reverse a string
 * @author ktakemur
 *
 */
public class StringUtils {

	public String reverse(String s) {
		char[] r = new char[s.length()];
		int start = 0;
		int end = s.length() - 1;
		System.arraycopy(s.toCharArray(), 0, r, 0, s.length());
		for(;start<end;start++,end--) {
			r[start] = s.charAt(end);
			r[end] = s.charAt(start);
		}
		return String.valueOf(r);
	}
	
	public String removeDuplicated(String s) {
		StringBuilder buf = new StringBuilder();
		int start = 0;
		int end = s.length();
		char[] sa = s.toCharArray();
		Hashtable<String,String> hash = new Hashtable<String,String>();
		for(;start<end;start++) {
			String key = String.valueOf(sa[start]);
			if(hash.get(key) == null) {
				hash.put(key, key);
				buf.append(sa[start]);
			}
		}
		return buf.toString();
	}
	
	public boolean bracketMatch(String in) {
		Stack<String> stack = new StackOnQueue<String>();
		stack.clear();
		int i = 0;
		while (i < in.length()) {
			char c = in.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(String.valueOf(c));
			}
			if (c == ')' || c == '}' || c == ']') {
				String s = stack.pop();
				if (s == null) {
					return false;
				}
				if ((c == ')' && s.equals("(")) || (c == '}' && s.equals("{"))
						|| (c == ']' && s.equals("["))) {
				} else {
					System.err.println(i + " " + c + " but " + s);
				}
			}
			i++;
		}
		return stack.isEmpty();
	}
	
	public boolean isAnagram(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		char[] s1Array = s1.toCharArray();
		char[] s2Array = s2.toCharArray();
		Arrays.sort(s1Array);
		Arrays.sort(s2Array);
		for(int i=0;i<s1Array.length;i++) {
			if(s1Array[i] != s2Array[i])
				return false;
		}
		return true;
	}
}
