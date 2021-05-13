package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {

	public Map<Integer, Country> loadAllCountries() {

		String sql = "SELECT ccode, StateAbb, StateNme FROM country ORDER BY StateAbb";
		Map<Integer, Country> result = new HashMap<Integer, Country>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				 Country c = new Country(rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme"));
				 result.put(rs.getInt("ccode"), c);
				// System.out.format("%d %s %s\n", rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme"));
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}

	public List<Border> getCountryPairs(int anno, Map<Integer,Country> mappa) {
		String sql = "SELECT state1no, state1ab, state2no, state2ab, year "
				+ "FROM contiguity "
				+ "WHERE year <= ? AND conttype = 1 AND state1no>state2no";
		
		List<Border> result = new ArrayList<Border>();
		Map<Integer, Country> country = new HashMap<Integer,Country>(this.loadAllCountries());
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				//System.out.format("%d %s %s\n", rs.getInt("year"), rs.getString("state1ab"), rs.getString("state2ab"));
				Border b = new Border(rs.getInt("state1no"), rs.getString("state1ab"),rs.getInt("state2no"), rs.getString("state2ab"),rs.getInt("year"));
				result.add(b);
				
				if(country.containsKey(rs.getInt("state1no"))) 
					mappa.put(b.getCod1(), country.get(b.getCod1()));
				
				if(country.containsKey(rs.getInt("state2no")))
					mappa.put(b.getCod2(), country.get(b.getCod2()));
				
				if(!country.containsKey(rs.getInt("state1no")) || !country.containsKey(rs.getString("state2ab"))) {
					//System.out.println(b.toString().toUpperCase());
				}
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
		
	}
}
