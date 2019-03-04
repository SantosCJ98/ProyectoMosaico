package clases;

import static colores.Colores.*;

import colores.ColoresEnum;

/**Esta clase crea circulos.
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 *
 */
public class Circulo extends Figura {

	// Constructores

	/**
	 * Constructor por defecto.
	 */
	protected Circulo() {

	}

	/**
	 * Constructor a partir de los colores.
	 * @param colorfigura Color de la figura.
	 * @param fondo	Color del fondo.
	 */
	protected Circulo(ColoresEnum colorfigura, ColoresEnum fondo) {

		this.colorfigura = colorfigura;

		this.fondo = fondo;

	}

	/**Contructor a partir de otro objeto de la misma clase (clonador)
	 * @param original Objeto a clonar
	 */
	protected Circulo(Figura original) {

		this(original.colorfigura, original.fondo);

	}

	// Método que dibuja un círculo (según la linea pasada por parámetro).

	protected void dibujarFigura(int linea) {

		int espaciosiniciales = ((altura / 2) + 1) / 2;

		int espacios;

		int asteriscos;

		// Si estamos entre la primera línea y el primer tercio del circulo...

		if (linea >= 1 && linea <= espaciosiniciales) {

			espacios = espaciosiniciales - (linea - 1);

			asteriscos = altura - 2 * espacios;

			// Dibujamos los espacios y "asteriscos" correspondientes.

			for (int i = 0; i < espacios; i++) {

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

			for (int i = 0; i < asteriscos; i++) {

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

			for (int i = 0; i < espacios; i++) {

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

		// Si estamos en la mitad del circulo, llenamos la linea de "asteriscos"

		else if (linea > espaciosiniciales && linea < (altura - espaciosiniciales)) {

			espacios = 0;

			asteriscos = altura;

			for (int i = 0; i < asteriscos; i++) {

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

		// Si estamos en el último tercio del círculo...

		else if (linea >= (altura - espaciosiniciales) && linea <= altura) {

			espacios = espaciosiniciales - (altura - linea);

			asteriscos = altura - 2 * espacios;

			// Dibujamos los espacios y "asteriscos" correspondientes.

			for (int i = 0; i < espacios; i++) {

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

			for (int i = 0; i < asteriscos; i++) {

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

			for (int i = 0; i < espacios; i++) {

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
