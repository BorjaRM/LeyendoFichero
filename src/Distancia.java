import java.io.File;
import java.util.Scanner;


public class Distancia {
	private int kilometros;
	
	public Distancia(int km){
		kilometros=km;
	}

	public int getKilometros() {
		return kilometros;
	}
	
	public static void creaSegundoArrayDistancias(Distancia[][] kms){
		for(int fila=0;fila<kms.length;fila++){
			kms[fila]=new Distancia[fila];
		}
	}
		
	public static void distanciasDesdeFicheroTexto(Distancia[][] kms){
		File fichero = new File("distancias.txt");
		Scanner dist = null;

		try{
			dist = new Scanner(fichero);
			
			for(int i=0;i<kms.length;i++){
				for(int j=0;j<kms[i].length;j++){
					int distancia =  dist.nextInt(); //Guardamos la distancia en un integer
					kms[i][j] = new Distancia(distancia); // lo añadimos al array
				}
			}
		}catch (Exception ex) {
			System.out.println("Error");
		}finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try{
				if(dist != null)
					dist.close();
			}catch(Exception ex2){
				System.out.println("Otro error");
			}
		}
	}
	
	public static int calculaDistancia(int d1, int d2, Distancia[][] kms){
		int y;
		int x;
		
		if(d1>d2){ //En el eje vertical(Y) debemos buscar la ciudad que ocupa la posicion mas alta en orden alfabetico
			y=d1;
			x=d2;
		}else{
			y=d2;
			x=d1;
		}		
		return kms[y][x].kilometros;
	}
}

