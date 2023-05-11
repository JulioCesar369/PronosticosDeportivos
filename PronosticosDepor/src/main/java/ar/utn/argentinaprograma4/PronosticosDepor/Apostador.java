package ar.utn.argentinaprograma4.PronosticosDepor;

public class Apostador {

	private String nombre;
	private int puntos;
	
	
	public Apostador(String nombre, int puntos) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void sumarPunto() {
		this.puntos += 1;
	}
	
}
