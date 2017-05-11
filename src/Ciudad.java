import java.io.File;
import java.util.Scanner;

public class Ciudad {
	private String nombre;
	
	public Ciudad(String nombre){
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public static void ciudadesDesdeFicheroTexto(Ciudad[] ciudades){
		File fichero = new File("ciudades.txt");
		Scanner nombresCiudades = null;
		int posicion=0;

		try{
			// Leemos el contenido del fichero
			nombresCiudades = new Scanner(fichero);
			
			// Leemos linea a linea el fichero
			for(int i=0;i<ciudades.length;i++){
				String ciudad = nombresCiudades.nextLine(); // Guardamos el nombre de la ciudad en un String
				ciudades[i] = new Ciudad(ciudad);	
			}
		}catch (Exception ex) {
			System.out.println("Error");
		}finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try{
				if(nombresCiudades != null)
					nombresCiudades.close();
			}catch(Exception ex2){
				System.out.println("Otro error");
			}
		}
	}
	
	public boolean compruebaSiExisteCiudad(Ciudad ciudad, Ciudad[] ciudades){
		
		for(int i=0;i<ciudades.length;i++){
			if(ciudades[i].nombre.equalsIgnoreCase(ciudad.nombre)){
				return true;
			}
		}
		return false;		
	}
	
	public int calculaPosicionCiudad(Ciudad ciudad, Ciudad[] ciudades){
		int posicion=0;
		
		for(int i=0;i<ciudades.length;i++){
			if(ciudades[i].nombre.equalsIgnoreCase(ciudad.nombre))
				posicion=i;				
		}
		return posicion;
	}
	
}

	
