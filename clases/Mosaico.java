package clases;

import static teclado.Teclado.*;

import java.util.Random;

public class Mosaico {

	private Figura[][] mosaico;

	private int filas;

	private int columnas;

	// Constructores

	Mosaico() {

	}

	private Mosaico(int filas, int columnas, Figura[][] mosaico) {

		this.filas = filas;

		this.columnas = columnas;

		this.mosaico = mosaico;

	}

	private Mosaico(Mosaico original) {

		this(original.filas, original.columnas, copiar(original.mosaico, original.filas, original.columnas));

	}

	// Método que comprueba si un mosaico es igual a su clon

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

	// Método que copia un mosaico a otro array bidimensional.

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

	private int getFilas() {
		return filas;
	}

	private void setFilas(int filas) {

		if (filas < 1 && filas > 3) {

			throw new IllegalArgumentException("Debe haber, como mínimo, una fila y, como maximo, 3");

		}

		this.filas = filas;
	}

	private int getColumnas() {
		return columnas;
	}

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

	// Método que crea un mosaico de forma manual.

	Figura[][] crear_conf() {

		System.out.println("Introduce el número de filas del mosaico\n(Mínimo 1, Máximo 3)");

		setFilas(readRange(1, 3, Rangos.AMBOSIN));

		System.out.println("Introduce el número de columnas del mosaico\n(Mínimo 1, Máximo 5)");

		setColumnas(readRange(1, 5, Rangos.AMBOSIN));

		mosaico = new Figura[getFilas()][getColumnas()];

		System.out.println("Introduce el tamaño de las figuras\n(Mínimo 5, Máximo 15)");

		Figura.setTamaño(readRange(5, 15, Rangos.AMBOSIN));

		for (int i = 0; i < getFilas(); i++) {

			for (int j = 0; j < getColumnas(); j++) {

				System.out.println("Elige la figura (Fila: " + (i + 1) + ", Columna: " + (j + 1) + ")");

				System.out.println("1. Triangulo Superior\n2. Triangulo Inferior\n3. Rombo\n4. Circulo\n5. Cruz");

				int figura_opcion = readRange(1, 5, Rangos.AMBOSIN);

				Figura figura = null;

				switch (figura_opcion) {

				case 1:
					figura = new TrianguloSuperior();

					break;

				case 2:
					figura = new TrianguloInferior();

					break;

				case 3:
					figura = new Rombo();

					break;

				case 4:
					figura = new Circulo();

					break;

				case 5:
					figura = new Cruz();

					break;

				}

				System.out.println("Elige el color de la figura\n1. Rojo\n2. Azul\n3. Verde\n4. Amarillo");

				figura.setColorfigura(readRange(1, 4, Rangos.AMBOSIN));

				System.out.println("Elige el color del fondo\n1. Negro\n2. Morado\n3. Celeste\n4. Blanco");

				figura.setFondo(readRange(1, 4, Rangos.AMBOSIN));

				mosaico[i][j] = figura;

			}

		}

		return mosaico;

	}

	// Método que crea un mosaico de forma aleatoria.

	Figura[][] crear_random() {

		Random random = new Random();

		setFilas(random.nextInt(3) + 1);

		setColumnas(random.nextInt(5) + 1);

		mosaico = new Figura[getFilas()][getColumnas()];

		int[] posiblestamaños = { 5, 7, 9, 11, 13, 15 };

		Figura.setTamaño(posiblestamaños[random.nextInt(posiblestamaños.length)]);

		for (int i = 0; i < getFilas(); i++) {

			for (int j = 0; j < getColumnas(); j++) {

				int figura_opcion = random.nextInt(5) + 1;

				Figura figura = null;

				switch (figura_opcion) {

				case 1:
					figura = new TrianguloSuperior();

					break;

				case 2:
					figura = new TrianguloInferior();

					break;

				case 3:
					figura = new Rombo();

					break;

				case 4:
					figura = new Circulo();

					break;

				case 5:
					figura = new Cruz();

					break;

				}

				figura.setColorfigura(random.nextInt(4) + 1);

				figura.setFondo(random.nextInt(4) + 1);

				mosaico[i][j] = figura;

			}

		}

		return mosaico;

	}

	// Método que muestra un mosaico. (En caso de que se haya creado uno).

	void mostrar_mosaico() {

		if (mosaico == null) {

			System.out.println("Debes crear un mosaico antes de poder verlo");

		}

		else {

			for (int k = 0; k < getFilas(); k++) {

				int j = 1;

				while (j <= Figura.tamaño) {

					for (int l = 0; l < getColumnas(); l++) {

						mosaico[k][l].dibujarFigura(j);

					}

					System.out.println();

					j++;

				}

			}

		}

	}

	// Método que clona un mosaico, lo compara con el original, lo modifica, y lo
	// vuelve a comparar. (En caso de que
	// se haya creado uno).

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

			System.out.println("Selecciona una fila\n" + "(Mínimo 1, Máximo " + clon.getFilas() + ")");

			int i = readRange(1, clon.getFilas(), Rangos.AMBOSIN);

			System.out.println("Selecciona una columna\n(Mínimo 1, Máximo " + clon.getColumnas() + ")");

			int j = readRange(1, clon.getColumnas(), Rangos.AMBOSIN);

			System.out.println("Has seleccionado esta figura (Fila " + i + ", Columna: " + j + ")");

			for (int linea = 0; linea < Figura.getTamaño(); linea++) {

				clon.mosaico[i - 1][j - 1].dibujarFigura(linea);

				System.out.println();

			}

			System.out.println("Selecciona un nuevo color para la figura\n1. Rojo\n2. Azul\n3. Verde\n4. Amarillo");

			clon.mosaico[i - 1][j - 1].setColorfigura(readRange(1, 4, Rangos.AMBOSIN));

			System.out.println("Selecciona un nuevo color para el fondo\n1. Negro\n2. Morado\n3. Celeste\n4. Blanco");

			clon.mosaico[i - 1][j - 1].setFondo(readRange(1, 4, Rangos.AMBOSIN));

			System.out.println("Mosaico original:");

			this.mostrar_mosaico();

			System.out.println("Mosaico clonado (modificado):");

			clon.mostrar_mosaico();

			System.out.println(
					(this.equals(clon) ? "El mosaico y su clon son iguales" : "El mosaico y su clon NO son iguales"));

		}

	}
}
