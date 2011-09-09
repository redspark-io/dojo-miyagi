package br.com.dclick.dojo.conceitos;


public class Intervalo {

	double min;
	double max;
	String nota;
	
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public Intervalo(double min, double max, String nota) {
		super();
		this.min = min;
		this.max = max;
		this.nota = nota;
	}

	public boolean estaDentro(Intervalo intervalo) {
		if( this.getMin() > intervalo.getMax() || this.getMax() < intervalo.getMin() )
			return false;
		
		return true;
	}
	
	
	

}
