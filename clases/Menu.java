package clases;

import static teclado.Teclado.*;

import java.util.Random;

import teclado.Teclado.Rangos;

/**Esta clase es para crear el menu del programa de creacion, visualizacion y clonacion de mosaicos.
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 * 
 */
public class Menu {

	/**
	 * Mosaico actual.
	 */
	private Mosaico mosaico = new Mosaico();

	/**
	 * Accion elegida por el usuario.
	 */
	private static int opcion;

	/**
	 * Menu principal
	 */
	public void menu_principal() {

		System.out.println("Esto es un programa para crear mosaicos");

		while (opcion != 4) {

			System.out.println(
					"Selecciona una opción\n1. Crear mosaico nuevo\n2. Ver mosaico actual\n3. Clonar mosaico actual\n4. Salir del programa");

			opcion = readRange(1, 4, Rangos.AMBOSIN);

			switch (opcion) {

			case 1:

				this.crear_mosaico();

				break;

			case 2:
				this.mosaico.mostrar_mosaico();

				break;

			case 3:
				this.mosaico.clonar_mosaico();

				break;

			case 4:
				System.out.println("¡Gracias! ¡Hasta luego!");

				break;

			}

		}

	}

	/**Submenu que da elegir al usuario entre crear un mosaico manualmente o aleatoriamente.
	 * @return res
	 */
	private Figura[][] crear_mosaico() {

		Figura[][] res = null;

		System.out.println("¿Como deseas crear el mosaico?\n1. Por mi cuenta\n2. De forma aleatoria");

		int opcion = readRange(1, 2, Rangos.AMBOSIN);

		switch (opcion) {

		case 1:
			res = this.mosaico.crear_conf();

			break;

		case 2:
			res = this.mosaico.crear_random();

			break;

		}

		if (res != null) {

			System.out.println("Mosaico creado exitosamente");

		}

		else if (res == null) {

			throw new IllegalArgumentException("El mosaico no se ha creado correctamente");

		}

		return res;

	}
	
	Figura[][] crear_conf() {

		System.out.println("Introduce el número de filas del mosaico\n(Mínimo 1, Máximo 3)");

		int filas = readRange(1, 3, Rangos.AMBOSIN);

		System.out.println("Introduce el número de columnas del mosaico\n(Mínimo 1, Máximo 5)");

		int columnas = readRange(1, 5, Rangos.AMBOSIN);

		System.out.println("Introduce el tamaño de las figuras\n(Mínimo 5, Máximo 15)");

		Figura.setAltura(readRange(5, 15, Rangos.AMBOSIN));

		System.out.println("¿Cuántas figuras vas a introducir?\n(Mínimo 1, Máximo: " + (filas*columnas +")"));
		
		int numfiguras = readRange(1, filas*columnas, Rangos.AMBOSIN);
		
		for (int i = 0; i < numfiguras; i++) {
			
			System.out.println("Elige la figura nº " + (i+1));
			
			System.out.println("1. Triangulo Superior\n2. Triangulo Inferior\n3. Rombo\n4. Circulo\n5. Cruz");

			int figura_opcion = readRange(1, 5, Rangos.AMBOSIN);
			
			switch (figura_opcion) {

			case 1:
				mosaico.figuras[i] = new TrianguloSuperior();

				break;

			case 2:
				mosaico.figuras[i] = new TrianguloInferior();

				break;

			case 3:
				mosaico.figuras[i] = new Rombo();

				break;

			case 4:
				mosaico.figuras[i] = new Circulo();

				break;

			case 5:
				mosaico.figuras[i] = new Cruz();

				break;

			}
			
			System.out.println("Elige el color de la figura\n1. Rojo\n2. Azul\n3. Verde\n4. Amarillo");

			mosaico.figuras[i].setColorfigura(readRange(1, 4, Rangos.AMBOSIN));

			System.out.println("Elige el color del fondo\n1. Negro\n2. Morado\n3. Celeste\n4. Blanco");

			mosaico.figuras[i].setFondo(readRange(1, 4, Rangos.AMBOSIN));

		}
		
		int contador = 0;
		
		for (int i = 0; i < mosaico.mosaico.length; i++) {
			
			for (int j = 0; j < mosaico.mosaico[i].length; j++) {
				
				mosaico.mosaico[i][j] = figuras[contador];
				
				if (contador == figuras.length-1) {
					
					contador = 0;
					
				}
				
				else {
					
					contador++;
					
				}
				
			}
			
		}
		

		


		return mosaico;

	}

	/**Crea un mosaico de con parametros aleatorios.
	 * @return mosaico
	 */
	Figura[][] crear_random() {

		Random random = new Random();

		setFilas(random.nextInt(3) + 1);

		setColumnas(random.nextInt(5) + 1);

		mosaico = new Figura[getFilas()][getColumnas()];

		int[] posiblesalturas = { 5, 7, 9, 11, 13, 15 };

		Figura.setAltura(posiblesalturas[random.nextInt(posiblesalturas.length)]);
		
		int numfiguras = random.nextInt(getFilas()*getColumnas())+1;
		
		figuras = new Figura[numfiguras];
		
		for (int i = 0; i < figuras.length; i++) {
			
			int figura_opcion = random.nextInt(5)+1;
			
			switch (figura_opcion) {

			case 1:
				figuras[i] = new TrianguloSuperior();

				break;

			case 2:
				figuras[i] = new TrianguloInferior();

				break;

			case 3:
				figuras[i] = new Rombo();

				break;

			case 4:
				figuras[i] = new Circulo();

				break;

			case 5:
				figuras[i] = new Cruz();

				break;

			}

			figuras[i].setColorfigura(random.nextInt(4)+1);

			figuras[i].setFondo(random.nextInt(4)+1);

		}
		
		int contador = 0;
		
		for (int i = 0; i < getFilas(); i++) {
			
			for (int j = 0; j < getColumnas(); j++) {
				
				mosaico[i][j] = figuras[contador];
				
				if (contador == figuras.length-1) {
					
					contador = 0;
					
				}
				
				else {
					
					contador++;
					
				}
				
			}
			
		}

		return mosaico;

	}

	/**
	 * Muestra el mosaico (en caso de que ya se haya creado uno antes)
	 */
	void mostrar_mosaico() {

		if (mosaico == null) {

			System.out.println("Debes crear un mosaico antes de poder verlo");

		}

		else {

			for (int k = 0; k < getFilas(); k++) {

				int j = 1;

				while (j <= Figura.altura) {

					for (int l = 0; l < getColumnas(); l++) {

						mosaico[k][l].dibujarFigura(j);

					}

					System.out.println();

					j++;

				}

			}

		}

	}
	
	/**
	 * Clona el mosaico, en caso de ya se haya creado uno antes, y lo compara con el original.
	 */
	void clonar_mosaico() {

		if (mosaico == null) {

			System.out.println("No se puede clonar un mosaico que no existe");

		}

		else {

			System.out.println("Mosaico original:");

			mostrar_mosaico();

			Mosaico clon = new Mosaico(this);

			System.out.println("Mosaico clonado:");

			clon.mostrar_mosaico();

			System.out.println(
					(this.equals(clon) ? "El mosaico y su clon son iguales" : "El mosaico y su clon NO son iguales"));

			System.out.println("Selecciona una figura:");

			for (int i = 0; i < figuras.length; i++) {
				
				System.out.printf("%d. %s\n", (i+1), figuras[i].info_figura(figuras[i].getColorfigura(), figuras[i].getFondo()));
				
			}
		
			int opcion = readRange(1, figuras.length, Rangos.AMBOSIN);

			System.out.println("Has seleccionado esta figura:");

			System.out.println(figuras[opcion-1].info_figura(figuras[opcion-1].getColorfigura(), figuras[opcion-1].getFondo()));

			System.out.println("Selecciona un nuevo color para la figura\n1. Rojo\n2. Azul\n3. Verde\n4. Amarillo");

			clon.figuras[opcion-1].setColorfigura(readRange(1, 4, Rangos.AMBOSIN));

			System.out.println("Selecciona un nuevo color para el fondo\n1. Negro\n2. Morado\n3. Celeste\n4. Blanco");

			clon.figuras[opcion-1].setFondo(readRange(1, 4, Rangos.AMBOSIN));

			System.out.println("Mosaico original:");

			mostrar_mosaico();

			System.out.println("Mosaico clonado (modificado):");

			clon.mostrar_mosaico();

			System.out.println(
					(this.equals(clon) ? "El mosaico y su clon son iguales" : "El mosaico y su clon NO son iguales"));

		}

	}

}
