package ar.utn.argentinaprograma4.PronosticosDepor;

public class Pronostico {
	private String apostador;
	private Partido partido;
	private String resultado;
	private int puntos; 
		
	public Pronostico(String apostador, String resultado) {
		super();
		this.apostador = apostador;
		this.resultado = resultado;
	}

	public Pronostico(String apostador, Partido partido, String resultado, int puntos) {
		super();
		this.apostador = apostador;
		this.partido = partido;
		this.resultado = resultado;
		this.setPuntos(puntos);
	}

	/*public int puntos() {
		String resulReal = partido.resultado(equipo);
		if(resultado.equals(resulReal)) {
			return 1;
		}else {
			return 0;
		}	
	}*/

	public String resultado() {
		return "equipo";
	}
	
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getApostador() {
		return apostador;
	}

	public void setApostador(String participante) {
		this.apostador = participante;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	

	
}
