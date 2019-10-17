package Actividad3T1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


import Actividad3T1.*;

public class Main {

	public static void main(String[] args) {
		// Creo un objeto Random para los precios de los productos
		Random r = new Random();

		// Creo la lista que de Paginable que voy a usar

		Paginable<Producto> lista1 = new Paginable<Producto>();

		// Creando los productos base. Los precios se calculan
		// de forma aleatoria entre 0.95 y 100.95

		Producto p1 = new Producto(1, 20.00/* r.nextInt(100- 0) +0.95 */, "Computadora G4MING");
		Producto p2 = new Producto(2, r.nextInt(100 - 0) + 0.95, "Computadora G4MING");
		Producto p3 = new Producto(3, r.nextInt(100 - 0) + 0.95, "Computadora G4MING");
		Producto p4 = new Producto(4, r.nextInt(100 - 0) + 0.95, "Computadora G4MING");
		Producto p5 = new Producto(5, r.nextInt(100 - 0) + 0.95, "Computadora G4MING");
		Producto p6 = new Producto(6, r.nextInt(100 - 0) + 0.95, "Computadora G4MING");
		Producto p7 = new Producto(7, r.nextInt(100 - 0) + 0.95, "Computadora G4MING");
		Producto p8 = new Producto(8, r.nextInt(100 - 0) + 0.95, "Computadora G4MING");
		Producto p9 = new Producto(9, r.nextInt(100 - 0) + 0.95, "Computadora G4MING");
		Producto p10 = new Producto(10, 50.00 /* r.nextInt(100- 0) +0.95 */, "Computadora G4MING");

		// Productos añadidos

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

		System.out.println(lista1.getPage(p7));
		System.out.println();
		System.out.println(lista1.contains(p3));
		System.out.println();
		Producto.mostrar(lista1.get(3));

		lista1.remove(p5);
		System.out.println();
		System.out.println(lista1.getTotal());

		for (int i = 0; i < lista1.size(); i++) {

			Producto.mostrar(lista1.get(i));
		}

		lista1.ordenar();
		System.out.println();
		System.out.println("LISTA ORDENADA");
		for (int i = 0; i < lista1.size(); i++) {

			Producto.mostrar(lista1.get(i));
		}
		System.out.println();
		System.out.println("PAGINA 2");

		for (Producto e : lista1.getPage(2)) {
			Producto.mostrar(e);
		}
		
		System.out.println();
		
		System.out.println(lista1.getPage(p4));


	}

}
