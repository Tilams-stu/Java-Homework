package cn.edu.nankai.Tilams.Homework3;

import java.lang.StringTemplate.Processor;


class StringSwapAdapter implements Processor{
	public String name() {
		return "StringSwapAdapter ";
	}
	StringSwap stringSwap;
	public StringSwapAdapter(StringSwap stringSwap) {
		this.stringSwap = stringSwap;
	}
	public String process(Object input) {
		return stringSwap.process((String)input);
	}
}

public class StringSwapProcessor {
	public static String s = "Disagreement with beliefs is by definition incorrect";
	public static void main(String[] args) {
		String s = new String(args[0]);
		Apply.process(new StringSwapAdapter(new StringSwap()), s);
	}
}
