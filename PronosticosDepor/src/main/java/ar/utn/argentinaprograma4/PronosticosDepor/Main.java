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
    	int puntos = 0;
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
    	    	 
		Path leePronostico = Paths.get(args[1]);
		List<String> lineaPronosticos = null;
		Pronostico partidoPronos = null;
		String resulPronostico = null;
		int aciertos=0;
		try {
				lineaPronosticos = Files.readAllLines(leePronostico);
		} catch (IOException e) {
				System.out.println("No se encontro el archivo...");
				System.out.println(e.getMessage());
				System.exit(1);
		}
			
		for(String lineaPronostico : lineaPronosticos) {
				String [] camposPronosticos = lineaPronostico.split(",");
				
				Equipo eq1 = new Equipo(camposPronosticos[1] );
	    		Equipo eq2 = new Equipo(camposPronosticos[5] );
	    		
	    		
	    		for(Partido partidoBuscado : partidosLeidos) {
	    			
	    		
	    			 if(partidoBuscado.getEquip1().getNombre().equals(eq1.getNombre()) && partidoBuscado.getEquip2().getNombre().equals(eq2.getNombre())) {
	    		 
	    			if("X".equals(camposPronosticos[2])) {
	    					 resulPronostico = partidoBuscado.getEquip1().getNombre();
	    					 	    					 
	    				 }else if("X".equals(camposPronosticos[3])) {
	    					 resulPronostico = "empate";
	    					 
	    				 }else {
	    					 resulPronostico = partidoBuscado.getEquip2().getNombre();
	    					 
	    				 }
	    				 
	    				 if(resulPronostico.equals(partidoBuscado.getResultado())){
	    					 aciertos++;
	    				 }
	    	
	    			}
	    			 
	    		}
	    		partidoPronos = new Pronostico(camposPronosticos[0], resulPronostico);
	    		System.out.println(partidoPronos.getParticipante()+ " puntos por acierto: "+aciertos);
	    		
	 		
	    		
		}
		
    }
}
