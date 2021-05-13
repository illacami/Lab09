package it.polito.tdp.borders.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Border;

public class TestDAO {

	public static void main(String[] args) {

		BordersDAO dao = new BordersDAO();
		Map<Integer, Country> mappa = new HashMap<Integer, Country>();
	
		System.out.println("Lista di tutte le nazioni:");
		System.out.println(dao.loadAllCountries().get("USA"));
		
		Map<Integer, Country> countries = new HashMap<Integer, Country>(dao.loadAllCountries());
		
		System.out.println(countries.values());
		
		System.out.println("Borders");
		
		System.out.println(dao.getCountryPairs(1817, mappa));
		
		System.out.println(mappa.values());
	}
}
