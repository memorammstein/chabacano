package com.compis;

public class Symbol {
	
	private String symbol = "";
	
	public Symbol(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
	        return false;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    final Symbol other = (Symbol) obj;
	    if (this.symbol != other.symbol) {
	        return false;
	    }
	    return true;
	};

}
