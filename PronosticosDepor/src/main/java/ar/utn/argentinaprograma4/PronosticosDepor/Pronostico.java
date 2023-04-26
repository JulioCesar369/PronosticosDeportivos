package ar.utn.argentinaprograma4.PronosticosDepor;

public class Pronostico {
	private String apostador;
	private Partido partido;
	private Equipo equipo;
	private String resultado;
	
	

	public Pronostico(String apostador, String resultado) {
		super();
		this.apostador = apostador;
		this.resultado = resultado;
	}

	public Pronostico(String apostador, Partido partido, Equipo equipo, String resultado) {
		super();
		this.apostador = apostador;
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}

	public int puntos() {
		String resulReal = partido.resultado(equipo);
		if(resultado.equals(resulReal)) {
			return 1;
		}else {
			return 0;
		}	
	}

	public String resultado() {
		return "equipo";
	}
	
	
	
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getParticipante() {
		return apostador;
	}

	public void setParticipante(String participante) {
		this.apostador = participante;
	}

	
}
