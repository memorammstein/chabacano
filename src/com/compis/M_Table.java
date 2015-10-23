package com.compis;

import java.util.Arrays;

public class M_Table {
	
	Symbol[] top_header = null;
	Symbol[] left_header = null;
	Transition[][] table = null;
	
	public M_Table(Symbol[] t, Symbol[] l, Transition[][] table) {
		this.top_header = t;
		this.left_header = l;
		this.table = table;
	}
	
	public Transition getTransition(Symbol input_symbol, Symbol stack_symbol) {
		if (Arrays.asList(top_header).indexOf(input_symbol) != -1) {
			if (Arrays.asList(left_header).indexOf(stack_symbol) != -1) {
				return table[Arrays.asList(left_header).indexOf(stack_symbol)][Arrays.asList(top_header).indexOf(input_symbol)];
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
