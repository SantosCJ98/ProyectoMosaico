package teclado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {

	// enums

	public enum Equivalencias {

		MAYORIGUAL, MENORIGUAL, MAYOR, MENOR

	}

	public enum Rangos {

		AMBOSIN, AMBOSEX, MININMAXEX, MINEXMAXIN

	}

	// Clase keyboard

	static Scanner keyboard = new Scanner(System.in);

	// Función para cerrar el teclado.

	public static void closekb() {

		keyboard.close();

	}

	// Función para leer caracter

	public static char readChar() {

		String x = "";

		do {

			x = keyboard.nextLine();

		} while (x.equals("")); // Como un caracter no puede valer '', hasta que no sea distinto a ese valor
								// seguira pidiendolo.

		return x.charAt(0);

	}

	// Función para leer cadena

	public static String readString() {

		String x;

		do {

			x = keyboard.nextLine();

		} while (x.equals(""));

		return x;

	}

	// Función para leer booleano (Respuesta 1 o 2)

	public static boolean readBoolean(String mensaje, String mensaje2, String mensaje3) {

		int res;

		System.out.printf("%s%n1.%s%n2.%s%n", mensaje, mensaje2, mensaje3);

		res = readRange(1, 2, Rangos.AMBOSIN);

		return res == 1;

	}

	// Función para leer booleano (Respuesta s/n || S/N)

	public static boolean readBoolean(String mensaje) {

		char y;

		do {

			System.out.printf("%s (s/n)%n", mensaje);

			y = Character.toLowerCase(readChar());

		} while (y != 's' && y != 'n');

		return y == 's';

	}

	// Funciones para leer números (Pide el número y si no se introduce un número, o
	// esta fuera del rango, da error, y vuelve a pedirlo)

	public static int readInt() {

		int x = 0;

		boolean error = false;

		do {

			try {

				x = keyboard.nextInt();

				error = false;

			}

			catch (InputMismatchException e) {

				System.out.println("Error: No has introducido un número entero");

				error = true;

			}

			finally {

				keyboard.nextLine();

			}

		} while (error);

		return x;

	}

	public static byte readByte() {

		byte x = 0;

		boolean error = false;

		do {

			try {

				x = keyboard.nextByte();

				error = false;

			}

			catch (InputMismatchException e) {

				System.out.println("Error: No has introducido un número byte");

				error = true;

			}

			finally {

				keyboard.nextLine();

			}

		} while (error == true);

		return x;

	}

	public static short readShort() {

		short x = 0;

		boolean error = false;

		do {

			try {

				x = keyboard.nextShort();

				error = false;

			}

			catch (InputMismatchException e) {

				System.out.println("Error: No has introducido un número short");

				error = true;

			}

			finally {

				keyboard.nextLine();

			}

		} while (error);

		return x;

	}

	public static double readDouble() {

		double x = 0;

		boolean error = false;

		do {

			try {

				x = keyboard.nextDouble();

				error = false;

			}

			catch (InputMismatchException e) {

				System.out.println("Error: No has introducido un número double");

				error = true;

			}

			finally {

				keyboard.nextLine();

			}

		} while (error);

		return x;

	}

	public static float readFloat() {

		float x = 0;

		boolean error = false;

		do {

			try {

				x = keyboard.nextFloat();

				error = false;

			}

			catch (InputMismatchException e) {

				System.out.println("Error: No has introducido un número decimal");

				error = true;

			}

			finally {

				keyboard.nextLine();

			}

		} while (error);

		return x;

	}

	public static long readLong() {

		long x = 0;

		boolean error = false;

		do {

			try {

				x = keyboard.nextLong();

				error = false;

			}

			catch (InputMismatchException e) {

				System.out.println("Error: No has introducido un número long");

				error = true;

			}

			finally {

				keyboard.nextLine();

			}

		} while (error);

		return x;

	}

	// Funciones para leer numeros con equivalencias.

	public static int readEqui(int x, Equivalencias equi) {

		int num = 0;

		switch (equi) {

		case MAYORIGUAL: // Introducir un número mayor o igual al del primer parámetro.

			do {

				num = readInt();

			} while (num < x);

			break;

		case MENORIGUAL: // Introducir un número menor o igual al del primer parámetro.

			do {

				num = readInt();

			} while (num > x);

			break;

		case MAYOR: // Introducir un número mayor al del primer parámetro.

			do {

				num = readInt();

			} while (num <= x);

			break;

		case MENOR: // Introducir un número menor al del primer parámetro.

			do {

				num = readInt();

			} while (num >= x);

			break;

		}

		return num;

	}

	public static double readEqui(double x, Equivalencias equi) {

		double num = 0;

		switch (equi) {

		case MAYORIGUAL: // Introducir un número mayor o igual al del primer parámetro.

			do {

				num = readDouble();

			} while (num < x);

			break;

		case MENORIGUAL: // Introducir un número menor o igual al del primer parámetro.

			do {

				num = readDouble();

			} while (num > x);

			break;

		case MAYOR: // Introducir un número mayor al del primer parámetro.

			do {

				num = readDouble();

			} while (num <= x);

			break;

		case MENOR: // Introducir un número menor al del primer parámetro.

			do {

				num = readDouble();

			} while (num >= x);

			break;

		}

		return num;

	}

	public static short readEqui(short x, Equivalencias equi) {

		short num = 0;

		switch (equi) {

		case MAYORIGUAL: // Introducir un número mayor o igual al del primer parámetro.

			do {

				num = readShort();

			} while (num < x);

			break;

		case MENORIGUAL: // Introducir un número menor o igual al del primer parámetro.

			do {

				num = readShort();

			} while (num > x);

			break;

		case MAYOR: // Introducir un número mayor al del primer parámetro.

			do {

				num = readShort();

			} while (num <= x);

			break;

		case MENOR: // Introducir un número menor al del primer parámetro.

			do {

				num = readShort();

			} while (num >= x);

			break;

		}

		return num;

	}

	public static byte readEqui(byte x, Equivalencias equi) {

		byte num = 0;

		switch (equi) {

		case MAYORIGUAL: // Introducir un número mayor o igual al del primer parámetro.

			do {

				num = readByte();

			} while (num < x);

			break;

		case MENORIGUAL: // Introducir un número menor o igual al del primer parámetro.

			do {

				num = readByte();

			} while (num > x);

			break;

		case MAYOR: // Introducir un número mayor al del primer parámetro.

			do {

				num = readByte();

			} while (num <= x);

			break;

		case MENOR: // Introducir un número menor al del primer parámetro.

			do {

				num = readByte();

			} while (num >= x);

			break;

		}

		return num;

	}

	public static float readEqui(float x, Equivalencias equi) {

		float num = 0;

		switch (equi) {

		case MAYORIGUAL: // Introducir un número mayor o igual al del primer parámetro.

			do {

				num = readFloat();

			} while (num < x);

			break;

		case MENORIGUAL: // Introducir un número menor o igual al del primer parámetro.

			do {

				num = readFloat();

			} while (num > x);

			break;

		case MAYOR: // Introducir un número mayor al del primer parámetro.

			do {

				num = readFloat();

			} while (num <= x);

			break;

		case MENOR: // Introducir un número menor al del primer parámetro.

			do {

				num = readFloat();

			} while (num >= x);

			break;

		}

		return num;

	}

	public static long readEqui(long x, Equivalencias equi) {

		long num = 0;

		switch (equi) {

		case MAYORIGUAL: // Introducir un número mayor o igual al del primer parámetro.

			do {

				num = readLong();

			} while (num < x);

			break;

		case MENORIGUAL: // Introducir un número menor o igual al del primer parámetro.

			do {

				num = readLong();

			} while (num > x);

			break;

		case MAYOR: // Introducir un número mayor al del primer parámetro.

			do {

				num = readLong();

			} while (num <= x);

			break;

		case MENOR: // Introducir un número menor al del primer parámetro.

			do {

				num = readLong();

			} while (num >= x);

			break;

		}

		return num;

	}

	// Funciones para leer números comprendidos entre un rango.

	public static int readRange(int min, int max, Rangos ran) {

		int num = 0;

		if (min > max || (max - min < 2 && ran == Rangos.AMBOSEX)) {

			throw new IllegalArgumentException("Rango no valido"); // Si el extremo máximo es menor que el mínimo,
																	// lanzar excepcion.

		}

		else if (min <= max) {

			switch (ran) {

			case AMBOSIN: // Ambos extremos incluidos.

				do {

					num = readInt();

				} while (num < min || num > max);

				break;

			case AMBOSEX: // Ambos extremos excluidos.

				do {

					num = readInt();

				} while (num <= min || num >= max);

				break;

			case MININMAXEX: // Extremo inferior incluido y exterior incluido

				do {

					num = readInt();

				} while (num < min || num >= max);

				break;

			case MINEXMAXIN: // Extremo inferior incluido y exterior excluido.

				do {

					num = readInt();

				} while (num <= min || num > max);

				break;

			}

		}

		return num;

	}

	public static double readRange(double min, double max, Rangos ran) {

		double num = 0;

		if (min > max || (max - min < 2 && ran == Rangos.AMBOSEX)) {

			throw new IllegalArgumentException("Rango no valido"); // Si el extremo máximo es menor que el mínimo,
																	// lanzar excepcion.

		}

		else if (min <= max) {

			switch (ran) {

			case AMBOSIN: // Ambos extremos incluidos.

				do {

					num = readDouble();

				} while (num < min || num > max);

				break;

			case AMBOSEX: // Ambos extremos excluidos.

				do {

					num = readDouble();

				} while (num <= min || num >= max);

				break;

			case MININMAXEX: // Extremo inferior incluido y exterior incluido

				do {

					num = readDouble();

				} while (num < min || num >= max);

				break;

			case MINEXMAXIN: // Extremo inferior incluido y exterior excluido.

				do {

					num = readDouble();

				} while (num <= min || num > max);

				break;

			}

		}

		return num;

	}

	public static byte readRange(byte min, byte max, Rangos ran) {

		byte num = 0;

		if (min > max || (max - min < 2 && ran == Rangos.AMBOSEX)) {

			throw new IllegalArgumentException("Rango no valido"); // Si el extremo máximo es menor que el mínimo,
																	// lanzar excepcion.

		}

		else if (min <= max) {

			switch (ran) {

			case AMBOSIN: // Ambos extremos incluidos.

				do {

					num = readByte();

				} while (num < min || num > max);

				break;

			case AMBOSEX: // Ambos extremos excluidos.

				do {

					num = readByte();

				} while (num <= min || num >= max);

				break;

			case MININMAXEX: // Extremo inferior incluido y exterior incluido

				do {

					num = readByte();

				} while (num < min || num >= max);

				break;

			case MINEXMAXIN: // Extremo inferior incluido y exterior excluido.

				do {

					num = readByte();

				} while (num <= min || num > max);

				break;

			}

		}

		return num;

	}

	public static short readRange(short min, short max, Rangos ran) {

		short num = 0;

		if (min > max || (max - min < 2 && ran == Rangos.AMBOSEX)) {

			throw new IllegalArgumentException("Rango no valido"); // Si el extremo máximo es menor que el mínimo,
																	// lanzar excepcion.

		}

		else if (min <= max) {

			switch (ran) {

			case AMBOSIN: // Ambos extremos incluidos.

				do {

					num = readShort();

				} while (num < min || num > max);

				break;

			case AMBOSEX: // Ambos extremos excluidos.

				do {

					num = readShort();

				} while (num <= min || num >= max);

				break;

			case MININMAXEX: // Extremo inferior incluido y exterior incluido

				do {

					num = readShort();

				} while (num < min || num >= max);

				break;

			case MINEXMAXIN: // Extremo inferior incluido y exterior excluido.

				do {

					num = readShort();

				} while (num <= min || num > max);

				break;

			}

		}

		return num;

	}

	public static float readRange(float min, float max, Rangos ran) {

		float num = 0;

		if (min > max || (max - min < 2 && ran == Rangos.AMBOSEX)) {

			throw new IllegalArgumentException("Rango no valido"); // Si el extremo máximo es menor que el mínimo,
																	// lanzar excepcion.

		}

		else if (min <= max) {

			switch (ran) {

			case AMBOSIN: // Ambos extremos incluidos.

				do {

					num = readFloat();

				} while (num < min || num > max);

				break;

			case AMBOSEX: // Ambos extremos excluidos.

				do {

					num = readFloat();

				} while (num <= min || num >= max);

				break;

			case MININMAXEX: // Extremo inferior incluido y exterior incluido

				do {

					num = readFloat();

				} while (num < min || num >= max);

				break;

			case MINEXMAXIN: // Extremo inferior incluido y exterior excluido.

				do {

					num = readFloat();

				} while (num <= min || num > max);

				break;

			}

		}

		return num;

	}

	public static long readRange(long min, long max, Rangos ran) {

		long num = 0;

		if (min > max || (max - min < 2 && ran == Rangos.AMBOSEX)) {

			throw new IllegalArgumentException("Rango no valido"); // Si el extremo máximo es menor que el mínimo,
																	// lanzar excepcion.

		}

		else if (min <= max) {

			switch (ran) {

			case AMBOSIN: // Ambos extremos incluidos.

				do {

					num = readLong();

				} while (num < min || num > max);

				break;

			case AMBOSEX: // Ambos extremos excluidos.

				do {

					num = readLong();

				} while (num <= min || num >= max);

				break;

			case MININMAXEX: // Extremo inferior incluido y exterior incluido

				do {

					num = readLong();

				} while (num < min || num >= max);

				break;

			case MINEXMAXIN: // Extremo inferior incluido y exterior excluido.

				do {

					num = readLong();

				} while (num <= min || num > max);

				break;

			}

		}

		return num;

	}

	public static void main(String args[]) {

		boolean salir = false;

		System.out.println("CARACTERES");

		do {

			System.out.println("Introduce un caracter para probarlo:");

			System.out.println(readChar());

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		System.out.println("CADENAS");

		do {

			System.out.println("Introduce una cadena para probarlo:");

			System.out.println(readString());

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		System.out.println("BOOLEANO");

		do {

			System.out.println(readBoolean("Introduce 1 o 2", "Uno", "Dos"));

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		System.out.println("INT");

		do {

			System.out.println("Introduce un INT para probarlo:");

			System.out.println(readInt());

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		System.out.println("DOUBLE");

		do {

			System.out.println("Introduce un double para probarlo:");

			System.out.println(readDouble());

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		System.out.println("Short");

		do {

			System.out.println("Introduce un short para probarlo:");

			System.out.println(readShort());

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		System.out.println("Byte");

		do {

			System.out.println("Introduce un Byte para probarlo:");

			System.out.println(readByte());

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		System.out.println("Float");

		do {

			System.out.println("Introduce un float para probarlo:");

			System.out.println(readFloat());

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		System.out.println("Long");

		do {

			System.out.println("Introduce un long para probarlo:");

			System.out.println(readLong());

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		System.out.println("LIMITES");

		salir = false;

		do {

			System.out.println("Introduce un número mayor o igual que 9:");

			System.out.println(readEqui(9, Equivalencias.MAYORIGUAL));

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		do {

			System.out.println("Introduce un número menor o igual que 7,5:");

			System.out.println(readEqui(7.5, Equivalencias.MENORIGUAL));

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		do {

			System.out.println("Introduce un número menor que 4:");

			System.out.println(readEqui((byte) 4, Equivalencias.MENOR));

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		do {

			System.out.println("Introduce un número mayor que 0,5:");

			System.out.println(readEqui(0.5f, Equivalencias.MAYOR));

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		System.out.println("LIMITES");

		do {

			System.out.println("Introduce un número entre 0 y 10,5: (Incluidos)");

			System.out.println(readRange(0, 10.5, Rangos.AMBOSIN));

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		do {

			System.out.println("Introduce un número entre 0 y 10,5: (Min Excluido)");

			System.out.println(readRange(0, 10.5, Rangos.MINEXMAXIN));

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		salir = false;

		do {

			System.out.println("Introduce un número entre 0 y 10,5: (Max Excluido)");

			System.out.println(readRange(0, 10.5, Rangos.MININMAXEX));

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

		do {

			System.out.println("Introduce un número entre 0 y 10,5: (Excluidos)");

			System.out.println(readRange(0, 10.5, Rangos.AMBOSEX));

			salir = readBoolean("¿Quieres probar otra vez?");

		} while (salir);

	}

}