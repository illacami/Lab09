package it.polito.tdp.borders.model;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private BordersDAO dao;
	private Map<Integer, Country> countries;
	private List<Border> borders;
	private SimpleGraph<Country, DefaultEdge> grafo;
	private Map<Integer, Country> countriesVertici;

	public Model() {
		
		dao = new BordersDAO();
		countries = new HashMap<Integer, Country>(dao.loadAllCountries());
		borders = new ArrayList<Border>();
		countriesVertici = new HashMap<Integer,Country>();
	}

	public Map<Integer, Country> getCountries() {
		return countries;
	}

	public List<Border> getBorders(int anno){
		borders = dao.getCountryPairs(anno, countriesVertici);
		return borders;
	}
	
	public Map<Integer, Country> getCountriesVertici() {
		return countriesVertici;
	}
	
	public void createGraph(int anno) {
		
		this.grafo = new SimpleGraph<Country, DefaultEdge>(DefaultEdge.class);
		
		this.getBorders(anno);
		
		System.out.println("ARCHI: "+borders.size());
		System.out.println("VERTICI PORCAAAA : "+this.getCountriesVertici().values().size());
		System.out.println("VERTICI PORCAAAA : "+this.getCountriesVertici().values());
		
		//aggiungo vertici
		Graphs.addAllVertices(this.grafo, this.getCountriesVertici().values());
		
		//aggiungo gli archi
		
		for(Border b : this.getBorders(anno)) {
			if(this.grafo.containsVertex(b.getState1()) && this.grafo.containsVertex(b.getState2())) {
				
					Graphs.addEdgeWithVertices(this.grafo, b.getState1(), b.getState2());
				
			}
			//Graphs.addEdgeWithVertices(this.grafo, b.getState1(), b.getState2());
			//this.grafo.addEdge(b.getState1(), b.getState2());
		}
		
		System.out.format("Grafo creato con %d vertici e %d archi\n",
				this.grafo.vertexSet().size(), this.grafo.edgeSet().size()) ;
	}
	
}
