package com.main;

import com.compis.M_Table;
import com.compis.Symbol;
import com.compis.Transition;
import com.compis.analyzer.PredictiveSyntacticAnalyzer;

public class Main {
	public static void main(String[] args) {
		PredictiveSyntacticAnalyzer psa = null;
		M_Table m = null;
		Symbol[] m_top = {
	              new Symbol("id"),
	              new Symbol("+"),
	              new Symbol("*"),
	              new Symbol("("),
	              new Symbol(")"),
	              new Symbol("$")
	              };
		Symbol[] m_left = {
                new Symbol("E"),
                new Symbol("E'"),
                new Symbol("T"),
                new Symbol("T'"),
                new Symbol("F")
                };
		Transition[][] table = {
				{
					new Transition(new Symbol("E"), new Symbol[]{new Symbol("T"), new Symbol("E'")}), 
					null, 
					null, 
					new Transition(new Symbol("E"), new Symbol[]{new Symbol("T"), new Symbol("E'")}), 
					null, 
					null
				},
				{
					null, 
					new Transition(new Symbol("E'"), new Symbol[]{new Symbol("+"), new Symbol("T"), new Symbol("E'")}), 
					null, 
					null, 
					new Transition(new Symbol("E'"), new Symbol[]{null}), 
					new Transition(new Symbol("E'"), new Symbol[]{null})
				},
				{
					new Transition(new Symbol("T"), new Symbol[]{new Symbol("F"), new Symbol("T'")}), 
					null, 
					null, 
					new Transition(new Symbol("T"), new Symbol[]{new Symbol("F"), new Symbol("T'")}), 
					null, 
					null
				},
				{
					null, 
					new Transition(new Symbol("T'"), new Symbol[]{null}), 
					new Transition(new Symbol("T'"), new Symbol[]{new Symbol("*"), new Symbol("F"), new Symbol("T'")}), 
					null, 
					new Transition(new Symbol("T'"), new Symbol[]{null}), 
					new Transition(new Symbol("T'"), new Symbol[]{null})
				},
				{
					new Transition(new Symbol("F"), new Symbol[]{new Symbol("id")}), 
					null, 
					null, 
					new Transition(new Symbol("F"), new Symbol[]{new Symbol("("), new Symbol("E"),new Symbol(")")}), 
					null, 
					null
				}
				};
		m = new M_Table(m_top, m_left, table);
		Symbol[] input = {
				new Symbol("id"),
				new Symbol("+"),
				new Symbol("id"),
				new Symbol("*"),
				new Symbol("id"),
				new Symbol("$")
		};
		psa = new PredictiveSyntacticAnalyzer(input, m);
		psa.addToStack(new Symbol("E"));
		System.out.println(psa.analyze() ? "valid input" : "invalid input");
		return;
	}
}
