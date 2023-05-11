package ar.utn.argentinaprograma4.PronosticosDepor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main 
{
    public static void main( String[] args )
    {
       //LectorCSV leerArchivo = new LectorCSV("src/main/resources/Resultados.csv");
    	List<Partido> partidosLeidos = new ArrayList<>(); 
    	Path leeResultado = Paths.get(args[0]);
    	List<String> lineaResultados = null;
    	try {
			lineaResultados = Files.readAllLines(leeResultado);
		} catch (IOException e) {
			System.out.println("No se encontro el archivo...");
			System.out.println(e.getMessage());
			System.exit(1);
		}
    	 for(String lineaResultado : lineaResultados) {
    		 
    		 String [] camposResultados = lineaResultado.split(",");
    		 Equipo equi1 = new Equipo(camposResultados[1].trim() );
    		 Equipo equi2 = new Equipo(camposResultados[4].trim() );
    		     		 
    		 Partido partido = new Partido(equi1, equi2);
    		 
    		 partido.setGolEquip1( Integer.parseInt(camposResultados[2].trim()) );
    		 partido.setGolEquip2( Integer.parseInt(camposResultados[3].trim()) );
    		 
    		 if(partido.getGolEquip1() > partido.getGolEquip2()){
    			 partido.setResultado(equi1.getNombre()); 
    		 }else if(partido.getGolEquip1() == partido.getGolEquip2()) {
    			 partido.setResultado("empate");
    		 }else {
    			 partido.setResultado(equi2.getNombre() );
    		 }
    		 
    		 partidosLeidos.add(partido);
  		 
    	 }
    	 
    	 
// Lee archivo pronosticos--------------------------------------------------------------------------------------------------	    	 
    	 List<Pronostico> pronosticoLeido = new ArrayList<>(); 
    	Path leePronostico = Paths.get(args[1]);
		List<String> lineaPronosticos = null;
		Pronostico partidoPronos = null;
		String resulPronostico = null;
		int totalPuntos = 0;
		String nomApos = null;
		try {
				lineaPronosticos = Files.readAllLines(leePronostico);
		} catch (IOException e) {
				System.out.println("No se encontro el archivo...");
				System.out.println(e.getMessage());
				System.exit(1);
		}

		Apostador apostador = null;
		int cuentaPuntos = 0;
		
		for(String lineaPronostico : lineaPronosticos) {
				String [] camposPronosticos = lineaPronostico.split(",");				
				Equipo eq1 = new Equipo(camposPronosticos[1].trim() );
	    		Equipo eq2 = new Equipo(camposPronosticos[5].trim() );
	    		
	    		Partido partidoApuesta = new Partido (eq1, eq2);
	    		   		
	    		Pronostico pronosticoApuesta = new Pronostico(camposPronosticos[0].trim(), partidoApuesta, null, 0);
  		
	    		//apostador = new Apostador(camposPronosticos[0], 0);
	    		//nomApos = apostador.getNombre();
	    		
	    		
	    		for(Partido partidoBuscado : partidosLeidos) {
	    			
	    		
	    			 if(partidoBuscado.getEquip1().getNombre().equals(eq1.getNombre()) && partidoBuscado.getEquip2().getNombre().equals(eq2.getNombre())) {
	    		 	    				 
	    				 if("X".equals(camposPronosticos[2])) {
	    					 resulPronostico = partidoBuscado.getEquip1().getNombre();
	    					 pronosticoApuesta.setResultado(partidoBuscado.getEquip1().getNombre());		 
	    				 }else if("X".equals(camposPronosticos[3])) {
	    					 resulPronostico = "empate";
	    					 pronosticoApuesta.setResultado("empate");
	    					 
	    				 }else {
	    					 resulPronostico = partidoBuscado.getEquip2().getNombre();
	    					 pronosticoApuesta.setResultado(partidoBuscado.getEquip2().getNombre());
	    				 }
	    				 
	    				 if(resulPronostico.equals(partidoBuscado.getResultado())){
	    					 //apostador.sumarPunto();
	    					 //cuentaPuntos+=1;
	    					 pronosticoApuesta.setPuntos(1);	    					 	    					 	    					
	    				 }	 
	    			 }	    			    		
	    		 }	
	    		pronosticoLeido.add(pronosticoApuesta);
	    		
			}
				int c =0;
				String aux = null;
				String nombJugador = null;
				for(Pronostico leeJugador : pronosticoLeido) {
					nombJugador = leeJugador.getApostador();
										
					for(Pronostico cuentPunto :  pronosticoLeido) {
						if(!nombJugador.equals(aux)) {
							if(nombJugador.equals(cuentPunto.getApostador())) {
								c = c + cuentPunto.getPuntos();
								
							}
						}
					}
					if(!nombJugador.equals(aux)) {
						System.out.println(nombJugador + " tiene: " + c);
						aux = nombJugador;
						c = 0;
					}
					
				}
					
  }
}