package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private BordersDAO dao;
	private Map<String, Country> countries;
	private List<Border> borders;
	private SimpleGraph<Country, DefaultEdge> grafo;

	public Model() {
		
		dao = new BordersDAO();
		countries = new HashMap<String, Country>(dao.loadAllCountries());
		borders = new ArrayList<Border>();
	}

	public Map<String, Country> getCountries() {
		return countries;
	}

	public List<Border> getBorders(int anno){
		borders = dao.getCountryPairs(anno);
		return borders;
	}
	
	public void createGraph(int anno) {
		
		this.grafo = new SimpleGraph<>(DefaultEdge.class);
		dao = new BordersDAO();
		
		//aggiungo vertici
		Graphs.addAllVertices(this.grafo, this.getCountries().values());
		
		
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
