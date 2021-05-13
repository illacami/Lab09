package it.polito.tdp.borders.model;

import java.util.List;
import java.util.Map;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		Border b = new Border("USA", "CAN", 1920);  //quando creo un nuovo border mi aggiunge i Coutry
		System.out.println(b.toString());

		System.out.println("TestModel -- TODO");
		
		Map<String, Country> countries = model.getCountries();
		System.out.format("Trovate %d nazioni\n", countries.size());
	
		
		System.out.println("Creo il grafo relativo al 2000");
		model.createGraph(2000);
		
	

//		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
	}

}
