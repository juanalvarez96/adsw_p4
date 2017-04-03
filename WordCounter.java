package es.upm.dit.adsw.ej4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Analizador de textos.
 *
 * @author Juan Álvarez Fernández del Vallado.
 * @source pepe mañas
 * @version 22.03.2016
 * 
 */
public class WordCounter {
	private DiccionarioHashMap tabla1;
	private Registro[] datos;

	public WordCounter() {
		tabla1 = new DiccionarioHashMap();

	}

	/**
	 * Método con el que cargamos un fichero de texto. Vamos a ir contando las
	 * palabras y a su vez las que sean nuevas creando un contador. Las que se
	 * repitan, incrementarán su contador.
	 * 
	 * @param file
	 *            El archivo que queremos cargar. Tendrá que encontrarse en la
	 *            carpeta Ejercicio 4.
	 * @throws IOException
	 *             Si no se encuentra el archivo o no es ejecutable.
	 */
	public void load(File file) throws IOException {
		Scanner scanner = new Scanner(file, "UTF-8");
		scanner.useDelimiter("[^\\p{javaLowerCase}\\p{javaUpperCase}]+");
		while (scanner.hasNext()) {
			String word = scanner.next().toLowerCase();
			// Si existe, incrementamos
			if (tabla1.get(word) != null) {
				tabla1.get(word).inc();
			}
			// Si no existe, creamos
			if (tabla1.get(word) == null) {
				tabla1.put(word, new Registro(word));
			}
		}
		scanner.close();
	}

	/**
	 * Método privado con el que descargamos las palabras con sus registros a un
	 * array de tipo registro.
	 * 
	 * @param dict
	 *            La tabla que queremos convertir en array de Registros.
	 * @return El array con todos los registros de la tabla.
	 */
	private Registro[] descarga(Map<String, Registro> dict) {
		Registro[] datos = new Registro[dict.size()];
		int at = 0;
		for (Registro registro : dict.values())
			datos[at++] = registro;
		return datos;
	}

	/**
	 * Método que devuelve el número de pablabras distintas que se encuentran en
	 * la tabla. Atención, no se cuentan las palabras repetidas.
	 * 
	 * @return El número de palabras distintas.
	 */
	public int size() {
		return tabla1.size();
	}

	/**
	 * Método que devuelve las n palabras que se usan mas veces. Si n es
	 * negativo, entónces devolverá las n palabras menos usadas.
	 * 
	 * @param n
	 *            El número de palabras que queremos que devuelva.
	 * @return Un ArrayList de de tipo Registro con las palabras.
	 */
	public ArrayList<Registro> getTop(int n) {
		datos = descarga(tabla1.getDatos());
		Arrays.sort(datos);
		if (Math.abs(n) > datos.length)
			return null;
		if (n == datos.length) {
			ArrayList<Registro> up = new ArrayList<Registro>();

			for (int i = 0; i < datos.length; i++) {
				up.add(datos[i]);
			}
			return up;
		}
		if (n > 0) {
			ArrayList<Registro> up = new ArrayList<Registro>();

			for (int i = datos.length - n; i < datos.length; i++) {
				up.add(datos[i]);
			}
			return up;
		}

		if (n < 0) {
			ArrayList<Registro> down = new ArrayList<Registro>();
			n = Math.abs(n);
			for (int i = 0; i < n; i++) {
				down.add(datos[i]);

			}
			return down;
		}
		return null;

	}

	/**
	 * Devuelve cuantas palabras hay por debajo de un umbral c.
	 * 
	 * @param c
	 *            El umbral
	 * @return El número de palabras
	 */
	public int countBelow(int c) {
		datos = descarga(tabla1.getDatos());
		Arrays.sort(datos);
		if (datos.length == 0)
			return 0;
		if (c <= 0)
			return 0;
		if (c >= datos[datos.length - 1].getCnt())
			return datos[datos.length - 1].getCnt();
		if (datos.length == 0)
			return 0;
		int cuenta = 0;
		while (datos[cuenta].getCnt() < c) {
			cuenta++;
		}
		return cuenta;

	}

}
