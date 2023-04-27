package ar.utn.argentinaprograma4.PronosticosDepor;


import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {

    String rutaArchivo;
    List<ArchivoPronostico> lineasArchivo;

    public LectorCSV(String ruta) {
        this.rutaArchivo = ruta;
        this.parsearArchivo();
    }

    public void parsearArchivo() {
        List<ArchivoPronostico> pronosticos = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
        	pronosticos = new CsvToBeanBuilder(new FileReader(this.rutaArchivo))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(',')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(ArchivoPronostico.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
    }
        this.lineasArchivo = pronosticos;
        System.out.println(pronosticos);
    }
    
}