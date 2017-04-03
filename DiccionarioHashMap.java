package es.upm.dit.adsw.ej4;

import java.util.HashMap;
/**
 * 
 * @author Juan Álvarez Fernández Vallado
 * @version 22.03.2016
 *
 */
public class DiccionarioHashMap {
	private final HashMap<String, Registro> map;

	public DiccionarioHashMap() {
		map = new HashMap<>();
	}

	/**
	 * Mete un valor nuevo. Si ya existe uno con misma clave, reemplaza el
	 * valor.
	 *
	 * @param clave
	 * @param valor
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 * @throws RuntimeException
	 *             Si no cabe la clave.
	 */
	public void put(String clave, Registro valor) throws IllegalArgumentException, RuntimeException {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException();
		map.put(clave, valor);

	}

	/**
	 * Saca el valor asociado a la clave.
	 *
	 * @param clave
	 * @return null si no está la clave.
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 */
	public Registro get(String clave) {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException();

		return map.get(clave);
	}

	/**
	 * Elimina el objeto asociado a la clave, si está.
	 *
	 * @param clave
	 * @return devuelve el valor asociado si estaba la clave; devuelve null si
	 *         no está la clave
	 * @throws IllegalArgumentException
	 *             Si clave es null.
	 * @throws IllegalArgumentException
	 *             Si clave es la cadena vacia.
	 */
	public Registro remove(String clave) {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException();
		return map.remove(clave);

	}

	/**
	 * @return número de elementos almacenados.
	 */
	public int size() {
		return map.size();

	}

	/**
	 * Elimina todas las claves.
	 */
	public void clear() {
		map.clear();

	}
	/**
	 * Método para obtener el mapa de objetos.
	 * @return El mapa de objetos.
	 */
	public HashMap<String, Registro> getDatos(){
		return map;
	}

}