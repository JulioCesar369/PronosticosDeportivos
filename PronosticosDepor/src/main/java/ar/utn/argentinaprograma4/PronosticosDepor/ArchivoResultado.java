package utn.argentinaprograma.PronosticosDeportivos;

import com.opencsv.bean.CsvBindByPosition;

public class ArchivoResultado {

	@CsvBindByPosition(position=0)
	private String ronda;

	@CsvBindByPosition(position=1)
	private String equipo1;
	
	@CsvBindByPosition(position=2)
	private String golesE1;
	
	@CsvBindByPosition(position=3)
	private String golesE2;
	
	@CsvBindByPosition(position=4)
	
	private String equipo2;

	public String getRonda() {
		return ronda;
	}

	public void setRonda(String ronda) {
		this.ronda = ronda;
	}

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getGolesE1() {
		return golesE1;
	}

	public void setGolesE1(String golesE1) {
		this.golesE1 = golesE1;
	}

	public String getGolesE2() {
		return golesE2;
	}

	public void setGolesE2(String golesE2) {
		this.golesE2 = golesE2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	
	
	
}