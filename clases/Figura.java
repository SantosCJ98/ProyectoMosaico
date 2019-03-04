package clases;

import colores.ColoresEnum;

/**
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 *Esta clase se usará para crear figuras.
 */
public abstract class Figura {

	/**Esté metodo dibuja la figura.
	 * @param linea La linea que dibuja la figura.
	 */

	protected abstract void dibujarFigura(int linea);
	
	/**
	 * Constructor por defecto
	 */
	protected Figura() {

	}

	/**
	 * 
	 * Constructor a partir de los colores.
	 * 
	 * @param colorfigura Color de la figura
	 * @param fondo	Color del fondo.
	 */
	protected Figura(ColoresEnum colorfigura, ColoresEnum fondo) {

		this.colorfigura = colorfigura;

		this.fondo = fondo;

	}

	/**
	 * Constructor a partir de otro objeto figura (clonador)
	 * @param original Objeto a clonar.
	 */
	protected Figura(Figura original) {

		this(original.colorfigura, original.fondo);

	}

	protected ColoresEnum colorfigura;

	protected ColoresEnum fondo;

	/**
	 * Tamaño de todas las figuras.
	 */
	protected static int tamaño;

	/**
	 * @param eleccion Color que se asigna a una figura (1 = Rojo, 2 = Azul, 3 = Verde, 4 = Amarillo)
	 */
	void setColorfigura(int eleccion) {

		switch (eleccion) {

		case 1:
			this.colorfigura = ColoresEnum.ROJO;

			break;

		case 2:
			this.colorfigura = ColoresEnum.AZUL;

			break;

		case 3:
			this.colorfigura = ColoresEnum.VERDE;

			break;

		case 4:
			this.colorfigura = ColoresEnum.AMARILLO;

			break;

		}

	}

	/**
	 * @param eleccion Color que se asigna al fondo de una figura (1 = Negro, 2 = Morado, 3 = Celeste, 4 = Blanco)
	 */
	void setFondo(int eleccion) {

		switch (eleccion) {

		case 1:
			this.fondo = ColoresEnum.NEGRO;

			break;

		case 2:
			this.fondo = ColoresEnum.MORADO;

			break;

		case 3:
			this.fondo = ColoresEnum.CELESTE;

			break;

		case 4:
			this.fondo = ColoresEnum.BLANCO;

			break;

		}

	}

	// El tamaño de las figuras debe ser mayor a 4 y menor que 16.

	/**
	 * @param tamaño Tamaño que se asigna a las figuras
	 */
	static void setTamaño(int tamaño) {

		if (tamaño < 5 && tamaño > 15) {

			throw new IllegalArgumentException("El tamaño de las figuras debe ser mayor a 4 y menor que 16");

		}

		else if (tamaño % 2 == 0) {

			throw new IllegalArgumentException("El tamaño de las figuras debe ser impar");

		}

		Figura.tamaño = tamaño;

	}

	/**
	 * @return tamaño
	 */
	static int getTamaño() {

		return tamaño;

	}

}
