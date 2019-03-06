package clases;

import static teclado.Teclado.*;

import java.util.Random;

import teclado.Teclado.Rangos;

/**
 * @author SantosCJ
 * @version 1.0
 * @since 1.0
 */
public class Menu {

	/**
	 * Mosaico con el que trabaja el menu
	 */
	Mosaico m;

	/**
	 * Menu desde donde se utiliza el programa para crear, mostrar y clonar mosaicos.
	 */
	public void menu_principal() {

		int opcion = 0;

		System.out.println("Bienvenido.");

		while (opcion != 4) {

			System.out.println(
					"Selecciona una accion\n1. Crear mosaico\n2. Mostrar mosaico\n3. Clonar mosaico\n4. Salir");

			opcion = readRange(1, 4, Rangos.AMBOSIN);

			switch (opcion) {

			case 1:
				crear();

				break;

			case 2:
				if (m == null) {

					System.out.println("Primero debes crear un mosaico");

				}

				else {

					m.mostrar_mosaico();

				}

				break;

			case 3:
				clonar_mosaico();

				break;

			case 4:
				System.out.println("¡Hasta luego!");

				break;

			}

		}

	}

	/**
	 * Submenu para crear mosaicos
	 */
	private void crear() {

		System.out.println("¿Cómo deseas crear el mosaico?\n1. Manualmente\n2. Aleatoriamente");

		int opcion = readRange(1, 2, Rangos.AMBOSIN);

		if (opcion == 1) {

			crear_conf();

		}

		else {

			crear_random();

		}

	}

	/**
	 * Creador de mosaicos a nivel de usuario.
	 */
	private void crear_conf() {

		int filas = 0;

		int columnas = 0;

		int numfiguras = 0;

		System.out.println("Introduce el número de filas del mosaico\n(Mínimo 1, Máximo 3)");

		filas = readRange(1, 3, Rangos.AMBOSIN);

		System.out.println("Introduce el número de columnas del mosaico\n(Mínimo 1, Máximo 5)");

		columnas = readRange(1, 5, Rangos.AMBOSIN);

		System.out.println("Introduce el tamaño de las figuras\n(Mínimo 5, Máximo 15)");

		Figura.setAltura(readRange(5, 15, Rangos.AMBOSIN));

		System.out.println("¿Cuántas figuras vas a introducir?\n(Mínimo 1, Máximo: " + filas * columnas + ")");

		numfiguras = readRange(1, filas * columnas, Rangos.AMBOSIN);

		Figura[] figuras = new Figura[numfiguras];

		for (int i = 0; i < figuras.length; i++) {

			System.out.println("Elige la figura nº " + (i + 1));

			System.out.println("1. Triangulo Superior\n2. Triangulo Inferior\n3. Rombo\n4. Circulo\n5. Cruz");

			int figura_opcion = readRange(1, 5, Rangos.AMBOSIN);

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

			System.out.println("Elige el color de la figura\n1. Rojo\n2. Azul\n3. Verde\n4. Amarillo");

			figuras[i].setColorfigura(readRange(1, 4, Rangos.AMBOSIN));

			System.out.println("Elige el color del fondo\n1. Negro\n2. Morado\n3. Celeste\n4. Blanco");

			figuras[i].setFondo(readRange(1, 4, Rangos.AMBOSIN));

		}

		m = new Mosaico(figuras, filas, columnas);

	}

	/**
	 * Creador de mosaicos automatico.
	 */
	private void crear_random() {

		Random random = new Random();

		int filas = 0;

		int columnas = 0;

		int numfiguras = 0;

		Figura[] figuras;

		filas = random.nextInt(3) + 1;

		columnas = random.nextInt(5) + 1;

		int[] posiblesalturas = { 5, 7, 9, 11, 13, 15 };

		Figura.setAltura(posiblesalturas[random.nextInt(posiblesalturas.length)]);

		numfiguras = random.nextInt(filas * columnas) + 1;

		figuras = new Figura[numfiguras];

		for (int i = 0; i < figuras.length; i++) {

			int figura_opcion = random.nextInt(5) + 1;

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

			figuras[i].setColorfigura(random.nextInt(4) + 1);

			figuras[i].setFondo(random.nextInt(4) + 1);

		}

		m = new Mosaico(figuras, filas, columnas);

	}

	/**
	 * Submenu que clona un mosaico, lo muestra, y modifica una de sus figuras para
	 * despues volver a mostrarla y comprobar si son iguales.
	 */
	private void clonar_mosaico() {

		if (m != null) {

			System.out.println("Mosaico original:");

			m.mostrar_mosaico();

			Mosaico clon = new Mosaico(m);

			System.out.println("Mosaico clonado:");

			clon.mostrar_mosaico();

			System.out.println(
					(m.equals(clon) ? "El mosaico y su clon son iguales" : "El mosaico y su clon NO son iguales"));

			System.out.println("Selecciona una figura:");

			for (int i = 0; i < m.figuras.length; i++) {

				System.out.printf("%d. %s\n", (i + 1),
						m.figuras[i].info_figura());

			}

			int opcion = readRange(1, m.figuras.length, Rangos.AMBOSIN);

			System.out.println("Has seleccionado esta figura: " + m.figuras[opcion - 1].info_figura());

			System.out.println("Selecciona un nuevo color para la figura\n1. Rojo\n2. Azul\n3. Verde\n4. Amarillo");

			clon.figuras[opcion - 1].setColorfigura(readRange(1, 4, Rangos.AMBOSIN));

			System.out.println("Selecciona un nuevo color para el fondo\n1. Negro\n2. Morado\n3. Celeste\n4. Blanco");

			clon.figuras[opcion - 1].setFondo(readRange(1, 4, Rangos.AMBOSIN));

			System.out.println("Mosaico original:");

			m.mostrar_mosaico();

			System.out.println("Mosaico clonado (modificado):");

			clon.mostrar_mosaico();

			System.out.println(
					(m.equals(clon) ? "El mosaico y su clon son iguales" : "El mosaico y su clon NO son iguales"));

		}

		else {

			System.out.println("No se puede clonar un mosaico que no existe.");

		}

	}

}
