package it.polito.tdp.borders.model;

public class Border {

	private Country state1;
	private Country state2;
	private int cod1;
	private int cod2;
	private String abb1;
	private String abb2;
	private int years;
	private Model model;
	
	public Border(int cod1, String abb1, int cod2, String abb2, int years) {
		super();
		model = new Model();
		this.cod1 = cod1;
		this.cod2 = cod2;
		this.abb1 = abb1;
		this.abb2 = abb2;
		this.years = years;
		this.state1 = model.getCountries().get(cod1);
		this.state2 = model.getCountries().get(cod2);
	}

	public Country getState1() {
		return model.getCountries().get(cod1);
	}

	public void setState1(Country state1) {
		this.state1 = state1;
	}

	public Country getState2() {
		return model.getCountries().get(cod2);
	}

	public void setState2(Country state2) {
		this.state2 = state2;
	}

	public int getCod1() {
		return cod1;
	}

	public void setCod1(int cod1) {
		this.cod1 = cod1;
	}

	public int getCod2() {
		return cod2;
	}

	public void setCod2(int cod2) {
		this.cod2 = cod2;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
	

	public String getAbb1() {
		return abb1;
	}

	public void setAbb1(String abb1) {
		this.abb1 = abb1;
	}

	public String getAbb2() {
		return abb2;
	}

	public void setAbb2(String abb2) {
		this.abb2 = abb2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state1 == null) ? 0 : state1.hashCode());
		result = prime * result + ((state2 == null) ? 0 : state2.hashCode());
		result = prime * result + years;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Border other = (Border) obj;
		if (state1 == null) {
			if (other.state1 != null)
				return false;
		} else if (!state1.equals(other.state1))
			return false;
		if (state2 == null) {
			if (other.state2 != null)
				return false;
		} else if (!state2.equals(other.state2))
			return false;
		if (years != other.years)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return state1 + " " + state2 + " " + years;
	}
	
	
}
