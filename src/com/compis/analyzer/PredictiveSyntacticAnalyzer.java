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
		addToStack(new Symbol("$"));
		this.m_table = m_table;
	}
	
	public boolean analyze() {
		Iterator<Symbol> it = Arrays.asList(input).iterator();
		Symbol ip = it.next();
		Symbol x = stack.pop();
		while (!x.equals(new Symbol("$"))) {
			if (x.equals(ip)) {
				System.out.println(x + " equals " + ip);
				ip = it.next();
				x = stack.pop();
			} else {
				Transition t = m_table.getTransition(ip, x);
				if (t != null) {
					System.out.println("found transition: " + t);
					System.out.println("add " + Arrays.toString(t.getTo()) + " to stack");
					for (int i = t.getTo().length-1; i >= 0; i--) {
						System.out.println("adding " + t.getTo()[i] + " to stack");
						addToStack(t.getTo()[i]);
					}
					System.out.println(stack);
					x = stack.pop();
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	public void addToStack(Symbol s) {
		if (s != null) {
			stack.push(s);
			System.out.println("added " + s + " to stack");
		}
	}
	
}
