package Actividad1T1;

import java.util.ArrayList;
import java.util.Random;
import Actividad1T1.*;
public class Main {

	public static void main(String[] args) {
		//Creo un objeto Random para los precios de los productos
		Random r = new Random();
				
		// Creo la lista que de Paginable que voy a usar
		
		Paginable<Producto> lista1 = new Paginable<Producto>();
		
		// Creando los productos base. Los precios se calculan 
		// de forma aleatoria entre 0.95 y 100.95 

		Producto p1 = new Producto(1, 20.00/*r.nextInt(100- 0) +0.95*/, "Computadora G4MING");
		Producto p2 = new Producto(1, r.nextInt(100- 0) +0.95, "Computadora G4MING");
		Producto p3 = new Producto(1, r.nextInt(100- 0) +0.95, "Computadora G4MING");
		Producto p4 = new Producto(1, r.nextInt(100- 0) +0.95, "Computadora G4MING");
		Producto p5 = new Producto(1, r.nextInt(100- 0) +0.95, "Computadora G4MING");
		Producto p6 = new Producto(1, r.nextInt(100- 0) +0.95, "Computadora G4MING");
		Producto p7 = new Producto(1, r.nextInt(100- 0) +0.95, "Computadora G4MING");
		Producto p8 = new Producto(1, r.nextInt(100- 0) +0.95, "Computadora G4MING");
		Producto p9 = new Producto(1, r.nextInt(100- 0) +0.95, "Computadora G4MING");
		Producto p10 = new Producto(1, 50.00 /* r.nextInt(100- 0) +0.95*/, "Computadora G4MING");
		
		//Productos añadidos
		
		lista1.add(p1);
		lista1.add(p2);
		lista1.add(p3);
		lista1.add(p4);
		lista1.add(p5);
		lista1.add(p6);
		lista1.add(p7);
		lista1.add(p8);
		lista1.add(p9);
		lista1.add(p10);

//		System.out.println(lista1.getTotal());
//		
//		System.out.println(lista1.size());
//		ArrayList<Producto> objetos = new ArrayList<Producto>();
//		
//		objetos.add(p10);
//		objetos.add(p9);
//		
//		Producto.mostrarArray(lista1.getPage(1));
		
		//Hacer for para mostrar productos y hacer el metodo de mostar en producto
		
		
		
	}

}
