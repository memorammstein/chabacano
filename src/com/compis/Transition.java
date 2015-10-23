package com.compis;

import java.util.Arrays;

public class Transition {
	
	private Symbol from = null;
	private Symbol[] to = null;
	
	public Transition(Symbol from, Symbol[] to) {
		this.from = from;
		this.to = to;
	}
	
	public Symbol[] match(Symbol s) {
		if (s.equals(from)) {
			return to;
		} else {
			return null;
		}
	}
	
	public Symbol[] getTo() {
		return to;
	}
	
	@Override
	public String toString() {
		return "from: " + from + " to: " + Arrays.toString(to);
	}

}
