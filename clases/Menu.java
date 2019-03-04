package clases;

import static teclado.Teclado.*;

public class Menu {

	private Mosaico mosaico = new Mosaico();

	private static int opcion;

	// Menu del programa con 4 opciones. (1 = Crear mosaico. 2 = Mostrar mosaico. 3
	// = Clonar Mosaico. 4 = Salir)

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

	// Método que da a elegir entre crear un mosaico de forma manual o
	// aleatoriamente.

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
