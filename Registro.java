package es.upm.dit.adsw.ej4;

/**
 * Contenedor para asociar un contador a una palabra.
 *@author Juan Álvarez Fernández Vallado
 * @author jose a. manas
 * @version 8.3.2016
 */
public class Registro implements Comparable<Registro>{
    private final String palabra;
    private int cnt;

    /**
     * Constructor.
     * El contador se inicaliza a 1.
     *
     * @param clave palabra.
     */
    Registro(String clave) {
        this.palabra = clave;
        this.cnt = 1;
    }

    /**
     * Getter.
     *
     * @return palabra.
     */
    public String getClave() {
        return palabra;
    }

    /**
     * Getter.
     *
     * @return contador.
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * Incrementa el contador.
     */
    public void inc() {
        this.cnt++;
    }
/**
 * Método a través de el cual definimos la diferencia de objetos <class> Registro </class>
 */
	@Override
	public int compareTo(Registro o) {
		
		return cnt-o.cnt;
	}
	
}