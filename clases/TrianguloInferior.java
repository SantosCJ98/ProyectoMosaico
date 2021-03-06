package clases;

import static colores.Colores.*;

import colores.ColoresEnum;

/**
 * Esta clase crea triangulos inferiores.
 * 
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 *
 */

public class TrianguloInferior extends Figura {

	// Constructores

	/**
	 * Constructor a partir de los colores.
	 * 
	 * @param colorfigura Color de la figura.
	 * @param fondo       Color del fondo.
	 */

	protected TrianguloInferior(ColoresEnum colorfigura, ColoresEnum fondo) {

		super(colorfigura, fondo);

	}

	/**
	 * Contructor a partir de otro objeto de la misma clase (clonador)
	 * 
	 * @param original Objeto a clonar
	 */

	protected TrianguloInferior(Figura original) {

		this(original.colorfigura, original.fondo);
	}
	
	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof TrianguloInferior && ((Figura) obj).colorfigura == colorfigura && ((Figura) obj).fondo == fondo) {
			resultado = true;
		}

		return resultado;
	}

	// Método que dibuja un triángulo inferior (según la línea)

	protected void dibujarFigura(int linea) {

		int fondos = linea - 1;

		int triangulo = altura - fondos;

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

			else if (fondo.equals(ColoresEnum.AZUL)) {

				System.out.print(FONDO_AZUL + "   " + RESET);

			}

			else if (fondo.equals(ColoresEnum.VERDE)) {

				System.out.print(FONDO_VERDE + "   " + RESET);

			}

			else if (fondo.equals(ColoresEnum.AMARILLO)) {

				System.out.print(FONDO_AMARILLO + "   " + RESET);

			}

		}

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

	}

}
