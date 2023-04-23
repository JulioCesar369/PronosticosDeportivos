package utn.argentinaprograma.PronosticosDeportivos;

import com.opencsv.bean.CsvBindByPosition;

public class ArchivoPronostico {

	@CsvBindByPosition(position=0)
	private String participante;
	
	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}

	@CsvBindByPosition(position=1)
	private String equipo1;
	
	@CsvBindByPosition(position=2)
	private String resultado;
	
	@CsvBindByPosition(position=3)
	private String equipo2;

	
	
}