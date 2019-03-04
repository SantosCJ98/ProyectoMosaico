package clases;

import static colores.Colores.*;

import colores.ColoresEnum;

/**Esta clase crea rombos.
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 *
 */

public class Rombo extends Figura {
	
	// Constructores

		/**
		 * Constructor por defecto.
		 */

	protected Rombo() {

	}
	
	/**
	 * Constructor a partir de los colores.
	 * @param colorfigura Color de la figura.
	 * @param fondo	Color del fondo.
	 */

	protected Rombo(ColoresEnum colorfigura, ColoresEnum fondo) {

		this.colorfigura = colorfigura;

		this.fondo = fondo;

	}
	
	/**Contructor a partir de otro objeto de la misma clase (clonador)
	 * @param original Objeto a clonar
	 */

	protected Rombo(Figura original) {

		this(original.colorfigura, original.fondo);

	}

	// Metodo que dibuja un rombo (según la linea)

	public void dibujarFigura(int linea) {

		int fondos = (tamaño - linea * 2 - 1) / 2;

		int rombo = linea * 2 - 1;

		// Si estamos en la mitad superior, pintamos una pirámide superior.

		if (linea <= tamaño / 2) {
			for (int i = 0; i <= fondos; i++) {

				if (fondo.equals(ColoresEnum.NEGRO)) {

					System.out.print(FONDO_NEGRO + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.MORADO)) {

					System.out.print(FONDO_MORADO + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.CELESTE)) {

					System.out.print(FONDO_CELESTE + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.BLANCO)) {

					System.out.print(FONDO_BLANCO + "   " + RESET);

				}

			}

			for (int i = 0; i < rombo; i++) {

				if (colorfigura.equals(ColoresEnum.ROJO)) {

					System.out.print(FONDO_ROJO + "   " + RESET);

				}

				else if (colorfigura.equals(ColoresEnum.AZUL)) {

					System.out.print(FONDO_AZUL + "   " + RESET);

				}

				else if (colorfigura.equals(ColoresEnum.VERDE)) {

					System.out.print(FONDO_VERDE + "   " + RESET);

				}

				else if (colorfigura.equals(ColoresEnum.AMARILLO)) {

					System.out.print(FONDO_AMARILLO + "   " + RESET);

				}

			}

			for (int i = 0; i <= fondos; i++) {

				if (fondo.equals(ColoresEnum.NEGRO)) {

					System.out.print(FONDO_NEGRO + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.MORADO)) {

					System.out.print(FONDO_MORADO + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.CELESTE)) {

					System.out.print(FONDO_CELESTE + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.BLANCO)) {

					System.out.print(FONDO_BLANCO + "   " + RESET);

				}

			}

		}

		// Si estamos en la mitad, lo llenamos todo de "asteriscos"

		else if (linea == tamaño / 2 + 1)

		{
			for (int i = 0; i < tamaño; i++) {
				if (colorfigura.equals(ColoresEnum.ROJO)) {

					System.out.print(FONDO_ROJO + "   " + RESET);

				}

				else if (colorfigura.equals(ColoresEnum.AZUL)) {

					System.out.print(FONDO_AZUL + "   " + RESET);

				}

				else if (colorfigura.equals(ColoresEnum.VERDE)) {

					System.out.print(FONDO_VERDE + "   " + RESET);

				}

				else if (colorfigura.equals(ColoresEnum.AMARILLO)) {

					System.out.print(FONDO_AMARILLO + "   " + RESET);

				}

			}

		}

		// Si estamos en la mitad inferior, pintamos una pirámide inferior.

		else {

			for (int i = 0; i < (tamaño - ((tamaño - linea) * 2 + 1)) / 2; i++) {

				if (fondo.equals(ColoresEnum.NEGRO)) {

					System.out.print(FONDO_NEGRO + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.MORADO)) {

					System.out.print(FONDO_MORADO + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.CELESTE)) {

					System.out.print(FONDO_CELESTE + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.BLANCO)) {

					System.out.print(FONDO_BLANCO + "   " + RESET);

				}

			}

			for (int i = 0; i < (tamaño - linea) * 2 + 1; i++) {

				if (colorfigura.equals(ColoresEnum.ROJO)) {

					System.out.print(FONDO_ROJO + "   " + RESET);

				}

				else if (colorfigura.equals(ColoresEnum.AZUL)) {

					System.out.print(FONDO_AZUL + "   " + RESET);

				}

				else if (colorfigura.equals(ColoresEnum.VERDE)) {

					System.out.print(FONDO_VERDE + "   " + RESET);

				}

				else if (colorfigura.equals(ColoresEnum.AMARILLO)) {

					System.out.print(FONDO_AMARILLO + "   " + RESET);

				}

			}

			for (int i = 0; i < (tamaño - ((tamaño - linea) * 2 + 1)) / 2; i++) {

				if (fondo.equals(ColoresEnum.NEGRO)) {

					System.out.print(FONDO_NEGRO + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.MORADO)) {

					System.out.print(FONDO_MORADO + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.CELESTE)) {

					System.out.print(FONDO_CELESTE + "   " + RESET);

				}

				else if (fondo.equals(ColoresEnum.BLANCO)) {

					System.out.print(FONDO_BLANCO + "   " + RESET);

				}

			}
		}

	}

}
