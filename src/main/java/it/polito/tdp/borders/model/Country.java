package it.polito.tdp.borders.model;

public class Country {
	
	private int code;
	private String abb;
	private String name;
	
	public Country(int code, String abb, String name) {
		super();
		this.code = code;
		this.abb = abb;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getAbb() {
		return abb;
	}

	public void setAbb(String abb) {
		this.abb = abb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abb == null) ? 0 : abb.hashCode());
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
		Country other = (Country) obj;
		if (abb == null) {
			if (other.abb != null)
				return false;
		} else if (!abb.equals(other.abb))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return code + " " + abb + " " + name;
	}
	
	

}
