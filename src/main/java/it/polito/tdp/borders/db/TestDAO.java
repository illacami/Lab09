package it.polito.tdp.borders.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Border;

public class TestDAO {

	public static void main(String[] args) {

		BordersDAO dao = new BordersDAO();

	
		System.out.println("Lista di tutte le nazioni:");
		System.out.println(dao.loadAllCountries().get("USA"));
		
		Map<String, Country> countries = new HashMap<String, Country>(dao.loadAllCountries());
		
		System.out.println(countries.values());
		
		dao.getCountryPairs(1817);
		
		//System.out.println();
	}
}
