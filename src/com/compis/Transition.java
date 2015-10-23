package com.compis;

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

}
