package clases;

import static teclado.Teclado.*;

/**Esta clase es para crear el menu del programa de creacion, visualizacion y clonacion de mosaicos.
 * @author Santos CJ
 * @version 1.0
 * @since 1.0
 * 
 */
public class Menu {

	/**
	 * Mosaico actual.
	 */
	private Mosaico mosaico = new Mosaico();

	/**
	 * Accion elegida por el usuario.
	 */
	private static int opcion;

	/**
	 * Menu principal
	 */
	public void menu_principal() {

		System.out.println("Esto es un programa para crear mosaicos");

		while (opcion != 4) {

			System.out.println(
					"Selecciona una opción\n1. Crear mosaico nuevo\n2. Ver mosaico actual\n3. Clonar mosaico actual\n4. Salir del programa");

			opcion = readRange(1, 4, Rangos.AMBOSIN);

			switch (opcion) {

			case 1:

				this.crear_mosaico();

				break;

			case 2:
				this.mosaico.mostrar_mosaico();

				break;

			case 3:
				this.mosaico.clonar_mosaico();

				break;

			case 4:
				System.out.println("¡Gracias! ¡Hasta luego!");

				break;

			}

		}

	}

	/**Submenu que da elegir al usuario entre crear un mosaico manualmente o aleatoriamente.
	 * @return res
	 */
	private Figura[][] crear_mosaico() {

		Figura[][] res = null;

		System.out.println("¿Como deseas crear el mosaico?\n1. Por mi cuenta\n2. De forma aleatoria");

		int opcion = readRange(1, 2, Rangos.AMBOSIN);

		switch (opcion) {

		case 1:
			res = this.mosaico.crear_conf();

			break;

		case 2:
			res = this.mosaico.crear_random();

			break;

		}

		if (res != null) {

			System.out.println("Mosaico creado exitosamente");

		}

		else if (res == null) {

			throw new IllegalArgumentException("El mosaico no se ha creado correctamente");

		}

		return res;

	}

}
