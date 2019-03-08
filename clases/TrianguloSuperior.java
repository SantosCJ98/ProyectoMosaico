package clases;

import static colores.Colores.*;

import colores.ColoresEnum;

/**
 * Esta clase crea triangulos superiores.
 * 
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 *
 */

public class TrianguloSuperior extends Figura {

	// Constructores

	/**
	 * Constructor a partir de los colores.
	 * 
	 * @param colorfigura Color de la figura.
	 * @param fondo       Color del fondo.
	 */

	protected TrianguloSuperior(ColoresEnum colorfigura, ColoresEnum fondo) {

		super(colorfigura, fondo);

	}

	/**
	 * Contructor a partir de otro objeto de la misma clase (clonador)
	 * 
	 * @param original Objeto a clonar
	 */

	protected TrianguloSuperior(Figura original) {

		this(original.colorfigura, original.fondo);

	}

	// Método que dibuja un triángulo superior (según la línea)

	protected void dibujarFigura(int linea) {

		int triangulo = linea;

		int fondos = Math.abs(triangulo - altura);

		for (int i = 0; i < triangulo; i++) {

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

}
