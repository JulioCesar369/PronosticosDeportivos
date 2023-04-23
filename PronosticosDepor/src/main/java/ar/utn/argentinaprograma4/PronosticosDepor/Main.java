package utn.argentinaprograma.PronosticosDeportivos;

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
    	Path leeResultado = Paths.get("src/main/resources/Resultados.csv");
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
    		 
    		 partidosLeidos.add(partido);
    		 
    		 
    	 }
		Path leePronostico = Paths.get("src/main/resources/Pronosticos.csv");
		List<String> lineaPronosticos = null;
		try {
				lineaPronosticos = Files.readAllLines(leePronostico);
		} catch (IOException e) {
				System.out.println("No se encontro el archivo...");
				System.out.println(e.getMessage());
				System.exit(1);
		}
			
		for(String lineaPronostico : lineaPronosticos) {
				String [] camposPronosticos = lineaPronostico.split(",");
				Equipo equi1 = new Equipo(camposPronosticos[1].trim() );
	    		Equipo equi2 = new Equipo(camposPronosticos[3].trim() );
	    		
				Pronostico pronostico = new Pronostico(pronos, equip, resu);
			
		}
   	
    }
}
