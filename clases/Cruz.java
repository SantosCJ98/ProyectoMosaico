package clases;

import static colores.Colores.FONDO_AMARILLO;
import static colores.Colores.FONDO_AZUL;
import static colores.Colores.FONDO_BLANCO;
import static colores.Colores.FONDO_CELESTE;
import static colores.Colores.FONDO_MORADO;
import static colores.Colores.FONDO_NEGRO;
import static colores.Colores.FONDO_ROJO;
import static colores.Colores.FONDO_VERDE;
import static colores.Colores.RESET;

import colores.ColoresEnum;

/**Esta clase crea cruces.
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 *
 */

public class Cruz extends Figura {

	// Constructores.

		/**
		 * Constructor por defecto.
		 */
	
	protected Cruz() {

	}

	/**
	 * Constructor a partir de los colores.
	 * @param colorfigura Color de la figura.
	 * @param fondo	Color del fondo.
	 */
	
	protected Cruz(ColoresEnum colorfigura, ColoresEnum fondo) {

		this.colorfigura = colorfigura;

		this.fondo = fondo;

	}

	/**Contructor a partir de otro objeto de la misma clase (clonador)
	 * @param original Objeto a clonar
	 */
	
	protected Cruz(Figura original) {

		this(original.colorfigura, original.fondo);

	}

	// Método que dibuja una cruz. (Según la linea).  

	protected void dibujarFigura(int linea) {

		int fondos = 2;

		int cruz = altura - 2 - 2;

		if ((linea - 1 == 0 || linea - 1 == 1) || (linea - 1 == altura - 2 || linea - 1 == altura - 1)) {

			for (int i = 0; i < fondos; i++) {

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

			for (int i = 0; i < cruz; i++) {

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

			for (int i = 0; i < fondos; i++) {

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

		else {

			for (int i = 0; i < fondos + cruz + fondos; i++) {

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

	}

}
