package clases;

/**
 * Esta clase se utiliza para crear mosaicos.
 * 
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 *
 */

public class Mosaico {

	/**
	 * Figuras del mosaico.
	 */
	Figura[][] mosaico;

	/**
	 * Conjunto de figuras elegidas por el usuario
	 */
	Figura[] figuras;

	/**
	 * Constructor del mosaico
	 * 
	 * @param figuras  Conjunto de figuras
	 * @param filas    Filas del mosaico
	 * @param columnas Columnas del mosaico
	 */
	Mosaico(Figura[] figuras, int filas, int columnas) {

		this.figuras = figuras;

		crear_mosaico(filas, columnas);

	}

	/**
	 * Clonador del mosaico
	 * 
	 * @param original Mosaico original
	 */
	Mosaico(Mosaico original) {

		figuras = copiar_figuras(original.figuras);

		crear_mosaico(original.mosaico.length, original.mosaico[0].length);

	}

	/**
	 * Metodo que realiza una copia del array de figuras en otra direccion de
	 * memoria.
	 * 
	 * @param original Array de figuras original
	 * @return copia Copia del array de figuras
	 */
	private static Figura[] copiar_figuras(Figura[] original) {

		Figura[] copia = new Figura[original.length];

		for (int i = 0; i < copia.length; i++) {

			if (original[i] instanceof TrianguloSuperior) {

				copia[i] = new TrianguloSuperior(original[i]);

			}

			else if (original[i] instanceof TrianguloInferior) {

				copia[i] = new TrianguloInferior(original[i]);

			}

			else if (original[i] instanceof Rombo) {

				copia[i] = new Rombo(original[i]);

			}

			else if (original[i] instanceof Circulo) {

				copia[i] = new Circulo(original[i]);

			}

			else if (original[i] instanceof Cruz) {

				copia[i] = new Cruz(original[i]);

			}

		}

		return copia;

	}

	/**
	 * Metodo que crea el mosaico
	 * 
	 * @param filas    Filas del mosaico
	 * @param columnas Columnas del mosaico
	 */
	private void crear_mosaico(int filas, int columnas) {

		int contador = 0;

		mosaico = new Figura[filas][columnas];

		for (int i = 0; i < mosaico.length; i++) {

			for (int j = 0; j < mosaico[i].length; j++) {

				mosaico[i][j] = figuras[contador];

				if (contador == figuras.length - 1) {

					contador = 0;

				}

				else {

					contador++;

				}

			}

		}

	}

	/**
	 * Metodo que comprueba si un mosaico es igual a su clon
	 * 
	 * @param clon Clon del mosaico
	 * @return true (si son iguales), o false (si son distintos)
	 */
	private boolean comparar_celdas(Mosaico clon) {

		boolean celda_igual = true;

		for (int i = 0; i < mosaico.length && celda_igual; i++) {

			for (int j = 0; j < mosaico[i].length && celda_igual; j++) {

				if (!(((Figura) mosaico[i][j]).equals(((Figura) clon.mosaico[i][j])))) {
					celda_igual = false;

				}

			}

		}

		return celda_igual;

	}

	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof Mosaico && comparar_celdas((Mosaico) obj)) {
			resultado = true;
		}

		return resultado;
	}

	/**
	 * Metodo que dibuja el mosaico.
	 */
	void mostrar_mosaico() {

		for (int k = 0; k < mosaico.length; k++) {

			int j = 1;

			while (j <= Figura.altura) {

				for (int l = 0; l < mosaico[k].length; l++) {

					mosaico[k][l].dibujarFigura(j);

				}

				System.out.println();

				j++;

			}

		}

	}

}
