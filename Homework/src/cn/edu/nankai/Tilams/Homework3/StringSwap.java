package cn.edu.nankai.Tilams.Homework3;

public class StringSwap {
	static String process(String s) {
		char[] ch = new char[s.length()];
		if((s.length()%2 == 0)) {
			for(int i=0 ; i< s.length();i+=2) {
				ch[i] = s.charAt(i+1);
				ch[i+1] = s.charAt(i);
			}
			return new String(ch);
		}
		else {
			for(int i=0;i< s.length()-1;i+=2) {
				ch[i] = s.charAt(i+1);
				ch[i+1] = s.charAt(i);
			}
			ch[s.length()-1] = s.charAt(s.length() - 1);
			return new String(ch);
		}
	}
}

