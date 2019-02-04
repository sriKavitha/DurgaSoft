package CollectionsTesting;

import java.util.HashMap;

//This program will find number of vowels in a given string
public class SplitStringIntoCharArray {
	public static void main(String[] args) {
		String s1="aeiou aeiou aeiou bcd";
		char[] ch=new char[s1.length()];
		ch=s1.toCharArray();
		int no_char_a=0, no_char_e=0, no_char_i=0, no_char_o=0, no_char_u=0, other_chars=0;
	
		HashMap<Integer, String> hm=new HashMap<Integer, String>();
		hm.put(1, "a");
		hm.put(2, "e");
		hm.put(3, "i");
		hm.put(4, "o");
		hm.put(5, "u");

		for(int i=0;i<ch.length;i++)
		{
			switch(ch[i])
			{
			case 'a':
				no_char_a++;
				break;
			case 'e':
				no_char_e++;
				break;
			case 'i':
				no_char_i++;
				break;
			case 'o':
				no_char_o++;
				break;
			case 'u':
				no_char_u++;
				break;
			default:
				other_chars++;
				break;
			}
		}
		System.out.println("Number of A's : "+no_char_a);
		System.out.println("Number of E's : "+no_char_e);
		System.out.println("Number of I's : "+no_char_i);
		System.out.println("Number of O's : "+no_char_o);
		System.out.println("Number of U's : "+no_char_u);
		System.out.println("Number of OTHER CHAR's : "+other_chars);

	}
}
