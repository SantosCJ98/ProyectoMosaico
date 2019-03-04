package clases;

import colores.ColoresEnum;

/**Esta clase se usará para crear figuras.
 * @author Santos CJ
 * @version 1.0
 * @since 1.0 
 */
public abstract class Figura {

	/**
	 * Este metodo dibuja la figura.
	 * 
	 * @param linea La linea que dibuja la figura.
	 */

	protected abstract void dibujarFigura(int linea);

	/**
	 * Constructor por defecto
	 */
	protected Figura() {

	}

	/**Constructor a partir de los colores.
	 * @param colorfigura Color de la figura
	 * @param fondo       Color del fondo.
	 */
	protected Figura(ColoresEnum colorfigura, ColoresEnum fondo) {

		this.colorfigura = colorfigura;

		this.fondo = fondo;

	}

	/** Constructor a partir de otro objeto figura (clonador).
	 * @param original Objeto a clonar.
	 */
	protected Figura(Figura original) {

		this(original.colorfigura, original.fondo);

	}

	/**
	 * Color de la figura
	 */
	protected ColoresEnum colorfigura;

	/**
	 * Color del fondo.
	 */
	protected ColoresEnum fondo;

	/**
	 * Tamaño de todas las figuras.
	 */
	protected static int altura;

	/**
	 * @param eleccion Color que se asigna a una figura (1 = Rojo, 2 = Azul, 3 =
	 * Verde, 4 = Amarillo)
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
	 * @param eleccion Color que se asigna al fondo de una figura (1 = Negro, 2 =
	 * Morado, 3 = Celeste, 4 = Blanco)
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
	
	/**Devuelve el color de la figura.
	 * @return colorfigura
	 */
	 ColoresEnum getColorfigura() {
		
		return colorfigura;
		
	}
	
	/**Devuelve el color de fondo
	 * @return fondo
	 */
	ColoresEnum getFondo() {
		
		return fondo;
		
	}

	/**Establece la altura de la figura, comprendida entre 4 y 16
	 * @param altura Altura que se asigna a las figuras
	 */
	static void setAltura(int altura) {

		if (altura < 5 && altura > 15) {

			throw new IllegalArgumentException("La altura de las figuras debe ser mayor a 4 y menor que 16");

		}

		else if (altura % 2 == 0) {

			throw new IllegalArgumentException("El tamaño de las figuras debe ser impar");

		}

		Figura.altura = altura;

	}

	/**Devuelve el tamaño de la figura.
	 * @return altura
	 */
	static int getAltura() {

		return altura;

	}
	
	/**Muestra información sobre una figura.
	 * @param color_figura Color de la figura
	 * @param color_fondo Color del fondo de la figura
	 * @return Tipo de la figura junto a su color y color de fondo en una cadena
	 */
	protected String info_figura (ColoresEnum color_figura, ColoresEnum color_fondo) {
		
		String colorfig = null;
		
		String colorfon = null;
		
		String figura = null;
		
		switch (color_figura) {
		
		case ROJO: colorfig = "Rojo";
		
		break;
		
		case AZUL: colorfig = "Azul";
		
		break;
		
		case VERDE: colorfig = "Verde";
		
		break;
		
		case AMARILLO: colorfig = "Amarillo";
		
		break;
		
		}
		
		switch (color_fondo) {
		
		case NEGRO: colorfon = "Negro";
		
		break;
		
		case MORADO: colorfon = "Morado";
		
		break;
		
		case CELESTE: colorfon = "Celeste";
		
		break;
		
		case BLANCO: colorfon = "Blanco";
		
		break;
		
		}
		
		if (this instanceof TrianguloSuperior) {
			
			figura = "Triangulo Superior";
			
		}
		
		else if (this instanceof TrianguloInferior) {
			
			figura = "Triangulo Inferior";
			
		}
		
		else if (this instanceof Rombo) {
			
			figura = "Rombo";
			
		}
		
		else if (this instanceof Circulo) {
			
			figura = "Circulo";
			
		}
		
		else if (this instanceof Cruz) {
			
			figura = "Cruz";
			
		}
		
		return String.format("%s %s con fondo %s", figura, colorfig, colorfon);
	}

}
