import java.util.Scanner;

public class Inicio {
	private static Ciudad[] ciudades;
	private static Distancia[][] kms;
	
	public static void main(String[] args) {
		//Creamos un objeto de tipo Inicio que contiene un Array de tipo ciudad y una matriz de tipo Distancia
		Inicio calculo = new Inicio();
		
		//Rellenamos el array Ciudad
		Ciudad.ciudadesDesdeFicheroTexto(ciudades);
		
		//Indicamos el numero de columnas que tendra cada fila de la matriz kms
		Distancia.creaSegundoArrayDistancias(kms);
	
		//Rellenamos la matriz Distancia
		Distancia.distanciasDesdeFicheroTexto(kms);
				
		//En caso de querer imprimir todo el diagrama:
		//calculo.imprimeDiagrama();
		
		boolean continuar=true;
		
		do{
			System.out.println("Introduce el nombre de 2 ciudades para conocer la distancia que hay entre ellas:");	
			System.out.println("");		
	
			int posicionCiudad1 = calculo.pideDatos("Introduce ciudad de origen");
			int posicionCiudad2 = calculo.pideDatos("Introduce ciudad de destino");
			
			if(posicionCiudad1 == posicionCiudad2){
				System.out.println("...si...es 0");
			}else{
				int distancia = Distancia.calculaDistancia(posicionCiudad1,posicionCiudad2,kms);
				System.out.println("La distancia entre " +ciudades[posicionCiudad1].getNombre() +" y " +ciudades[posicionCiudad2].getNombre() +" es de " +distancia +"km.");
			}
			continuar=calculo.finalizar();
		}while(continuar);
		
	}
	
	public Inicio(){
		ciudades=new Ciudad[47];
		kms=new Distancia[47][];
	}
	
	public void imprimeDiagrama(){
		for(int i=0;i<kms.length;i++){
			System.out.print(ciudades[i].getNombre() +"\t");
			for(int j=0;j<kms[i].length;j++){
				System.out.print("[" +kms[i][j].getKilometros() +"]" +"\t");
			}
			System.out.print(ciudades[i].getNombre());
			System.out.println("");
		}
	}
	
	public int pideDatos(String msj){
		Scanner sc=new Scanner(System.in);	
		boolean ciudadExiste=false;
		int posicionEnArray;
		Ciudad ciudad = null;
		
		while(!ciudadExiste){
			System.out.println(msj);
			ciudad = new Ciudad(sc.nextLine().toLowerCase());
			ciudadExiste=ciudad.compruebaSiExisteCiudad(ciudad, ciudades);
			if(!ciudadExiste){
				System.out.println(ciudad.getNombre() +" no es una ciudad valida");
			}
		}
		
		posicionEnArray=ciudad.calculaPosicionCiudad(ciudad, ciudades);
		return posicionEnArray;
	}
	
	public boolean finalizar(){
		Scanner sc=new Scanner(System.in);	
		String eleccion;
		
		System.out.println("¿Quieres continuar? SI/NO");
		eleccion=sc.next();
		if(eleccion.equalsIgnoreCase("si")){
			return true;
		}else{
			return false;
		}
	}
}
