package com.compis.analyzer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

import com.compis.*;

public class PredictiveSyntacticAnalyzer {
	
	private Symbol[] input = null;
	private Stack<Symbol> stack = null;
	private M_Table m_table = null;
	
	public PredictiveSyntacticAnalyzer(Symbol[] input, M_Table m_table) {
		this.input = input;
		this.stack = new Stack<Symbol>();
		this.stack.push(new Symbol("$"));
		this.m_table = m_table;
	}
	
	public void analyze() {
		Iterator<Symbol> it = Arrays.asList(input).iterator();
		Symbol ip = it.next();
		Symbol x = stack.pop();
		while (!x.equals(new Symbol("$"))) {
			if (x.equals(ip)) {
				ip = it.next();
			} else {
				Transition t = m_table.getTransition(ip, x);
				if (t != null) {
					for (int i = t.getTo().length-1; i <= 0; i--) {
						addToStack(t.getTo()[i]);
					}
				}
			}
		}
	}
	
	public void addToStack(Symbol s) {
		stack.push(s);
	}
	
}
