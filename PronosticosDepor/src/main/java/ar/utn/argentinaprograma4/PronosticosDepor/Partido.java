package ar.utn.argentinaprograma4.PronosticosDepor;

public class Partido {
	private Equipo equip1;
	private Equipo equip2;
	private int golEquip1;
	private int golEquip2;
	private String resultado;
	
	
	public Partido(Equipo equip1, Equipo equip2, int golEquip1, int golEquip2, String resultado) {
		super();
		this.equip1 = equip1;
		this.equip2 = equip2;
		this.golEquip1 = golEquip1;
		this.golEquip2 = golEquip2;
		this.resultado = resultado;
	}

	public Partido(Equipo equip1, Equipo equip2) {
		super();
		this.equip1 = equip1;
		this.equip2 = equip2;
	}

	public Equipo getEquip1() {
		return equip1;
	}

	public void setEquip1(Equipo equip1) {
		this.equip1 = equip1;
	}

	public Equipo getEquip2() {
		return equip2;
	}

	public void setEquip2(Equipo equip2) {
		this.equip2 = equip2;
	}

	public int getGolEquip1() {
		return golEquip1;
	}

	public void setGolEquip1(int golEquip1) {
		this.golEquip1 = golEquip1;
	}

	public int getGolEquip2() {
		return golEquip2;
	}

	public void setGolEquip2(int golEquip2) {
		this.golEquip2 = golEquip2;
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public String resultado(Equipo equip) {
		if(equip.equals(equip1)) {
			if(golEquip1 > golEquip2) {
				return "ganador";
			}
		}
		
		return "completar...";		
	}

	
	

}
