package clases;

import static teclado.Teclado.*;

import java.util.Arrays;
import java.util.Random;

/**Esta clase se utiliza para crear mosaicos.
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 *
 */
public class Mosaico {

	/**
	 * Mosaico de figuras
	 */
	private Figura[][] mosaico;

	/**
	 * Numero de filas
	 */
	private int filas;

	/**
	 * Numero de columnas.
	 */
	private int columnas;
	
	/**
	 * Conjunto de figuras
	 */
	private Figura[] figuras;

	// Constructores

	/**
	 * Constructor por defecto
	 */
	Mosaico() {

	}

	/**
	 * Constructor a partir de las filas, columnas y el mosaico.
	 * @param filas Numero de filas
	 * @param columnas Numero de columnas
	 * @param mosaico Mosaico de figuras
	 * @param figuras Conjunto de figuras seleccionadas
	 */
	private Mosaico(int filas, int columnas, Figura[][] mosaico, Figura[] figuras) {

		this.filas = filas;

		this.columnas = columnas;

		this.mosaico = mosaico;
		
		this.figuras = figuras;
		
		

	}

	/** Constructor a partir de otro mosaico
	 * @param original Mosaico (clonado)
	 */
	private Mosaico(Mosaico original) {

		this(original.filas, original.columnas, copiar(original.mosaico, original.filas, original.columnas), Arrays.copyOf(original.figuras,  original.figuras.length));

	}

	

	/** Comprueba si un mosaico es igual a su clon.
	 * @param mosaico (Mosaico original)
	 * @param clon (Mosaico clonado)
	 * @param filas (Numero de filas)
	 * @param columnas (Numero de columnas)
	 * @return true (Si todas las celdas son iguales)
	 */
	private static boolean comparar_celdas(Figura[][] mosaico, Figura[][] clon, int filas, int columnas) {

		boolean celda_igual = true;

		for (int i = 0; i < filas && celda_igual == true; i++) {

			for (int j = 0; j < columnas && celda_igual == true; j++) {

				if (!(clon[i][j].getClass().getSimpleName().equals(mosaico[i][j].getClass().getSimpleName())
						&& clon[i][j].colorfigura.equals(mosaico[i][j].colorfigura)
						&& clon[i][j].fondo.equals(mosaico[i][j].fondo))) {

					celda_igual = false;

				}

			}

		}

		return celda_igual;

	}


	/**Copia un mosaico a otro array bidimensional.
	 * @param original (Mosaico original)
	 * @param filas (Numero de filas)
	 * @param columnas (Numero de columnas)
	 * @return (Copia del mosaico)
	 */
	private static Figura[][] copiar(Figura[][] original, int filas, int columnas) {

		Figura[][] copia = new Figura[filas][columnas];

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {

				if (original[i][j].getClass().getSimpleName().equals("TrianguloSuperior")) {

					copia[i][j] = new TrianguloSuperior(original[i][j]);

				}

				else if (original[i][j].getClass().getSimpleName().equals("TrianguloInferior")) {

					copia[i][j] = new TrianguloInferior(original[i][j]);

				}

				else if (original[i][j].getClass().getSimpleName().equals("Rombo")) {

					copia[i][j] = new Rombo(original[i][j]);

				}

				else if (original[i][j].getClass().getSimpleName().equals("Circulo")) {

					copia[i][j] = new Circulo(original[i][j]);

				}

				else if (original[i][j].getClass().getSimpleName().equals("Cruz")) {

					copia[i][j] = new Cruz(original[i][j]);

				}

			}

		}

		return copia;

	}

	/**Devuelve el numero de filas.
	 * @return filas
	 */
	private int getFilas() {
		return filas;
	}

	/**Establece el numero de filas, comprendido entre 1 y 3.
	 * @param filas Numero de filas.
	 */
	private void setFilas(int filas) {

		if (filas < 1 && filas > 3) {

			throw new IllegalArgumentException("Debe haber, como mínimo, una fila y, como maximo, 3");

		}

		this.filas = filas;
	}

	/** Devuelve el numero de columnas.
	 * @return columnas
	 */
	private int getColumnas() {
		return columnas;
	}

	/** Establece el numero de columnaas, comprendido entre 1 y 5.
	 * @param columnas Numero de columnas
	 */
	private void setColumnas(int columnas) {

		if (columnas < 1 && columnas > 5) {

			throw new IllegalArgumentException("Debe haber, como mínimo, una columna, y como maximo, 5");

		}

		this.columnas = columnas;
	}

	// Método equals de la clase Mosaico.

	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof Mosaico && comparar_celdas(mosaico, ((Mosaico) obj).mosaico, filas, columnas)
				&& filas == ((Mosaico) obj).filas && columnas == ((Mosaico) obj).columnas) {
			resultado = true;
		}
		return resultado;
	}

	/**Permite al usuario crear un mosaico
	 * @return mosaico,
	 */
	Figura[][] crear_conf() {

		System.out.println("Introduce el número de filas del mosaico\n(Mínimo 1, Máximo 3)");

		setFilas(readRange(1, 3, Rangos.AMBOSIN));

		System.out.println("Introduce el número de columnas del mosaico\n(Mínimo 1, Máximo 5)");

		setColumnas(readRange(1, 5, Rangos.AMBOSIN));

		mosaico = new Figura[getFilas()][getColumnas()];

		System.out.println("Introduce el tamaño de las figuras\n(Mínimo 5, Máximo 15)");

		Figura.setAltura(readRange(5, 15, Rangos.AMBOSIN));

		System.out.println("¿Cuántas figuras vas a introducir?");
		
		int numfiguras = readRange(1, getFilas()*getColumnas(), Rangos.AMBOSIN);
		
		figuras = new Figura[numfiguras];
		
		for (int i = 0; i < figuras.length; i++) {
			
			System.out.println("Elige la figura nº " + (i+1));
			
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

			this.mostrar_mosaico();

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

			clon.mostrar_mosaico();

			System.out.println("Mosaico clonado (modificado):");

			this.mostrar_mosaico();

			System.out.println(
					(this.equals(clon) ? "El mosaico y su clon son iguales" : "El mosaico y su clon NO son iguales"));

		}

	}
}
