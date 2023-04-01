package Modelo;
/**
 * Clase que hereda los atributos y métodos de la clase AlgoritmoOrdenamiento y
 * ordena los elementos de la lista a través del método Binary Insertion Sort.
 */
public class BinaryInsertionSort extends AlgoritmoOrdenamiento {

    /**
     * Método constructor
     * @param rutaDataset
     * @param rutaOrdenadoCsv
     * @param columnaDataset
     */
    public BinaryInsertionSort(String rutaDataset, String rutaOrdenadoCsv, int columnaDataset) {
        super(rutaDataset, rutaOrdenadoCsv, columnaDataset);
        this.nombAlgoritmo = "Binary Insertion Sort";
    }

    /**
     * Método que realiza la búsqueda binaria y compara los elementos de la lista con
     * el parametro item.
     * @param item
     * @param low
     * @param high
     * @param modo
     * @return
     */
    public double binarySearch(double item, int low, int high, int modo) {
        while (low <= high) {// 1ra Comparación
            int mid = low + (high - low) / 2;
            if (item == this.listaOrdenarDouble.get(mid)) {// 2ra Comparación
                this.numComparaciones += 2; // Se registran las 2 comparaciones y termina
                return (mid + 1); // Regresó con 2 comparaciones
            } else if ((modo == 0) && (item > this.listaOrdenarDouble.get(mid))) { // 3ra Comparación por método
                low = mid + 1;
            } else if ((modo == 1) && (item < this.listaOrdenarDouble.get(mid))) { // 3ra Comparación por método
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        this.numComparaciones += 3; // Se registran las 3 comparaciones y termina
        return low; // Regresó con 3 comparaciones
    }

    /**
     * Método que inserta un elemento en la posición adecuada.
     * @param modo
     */
    public void binaryInsertionSort(int modo) {
        int i;
        int j;
        double loc;
        double selected;

        for (i = 1; i < this.listaOrdenarDouble.size(); ++i) {
            j = i - 1;
            selected = this.listaOrdenarDouble.get(i);

            // encuentra la posicion donde debe ser insertado el elemento
            loc = binarySearch(selected, 0, j, modo);

            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) { // Se hace una comparación
                this.numComparaciones++; // Se registra la comparación
                double element = this.listaOrdenarDouble.get(j);
                this.listaOrdenarDouble.remove(j + 1);
                this.listaOrdenarDouble.add(j + 1, element); // se realiza un intercambio
                this.numIntercambios++; // Se registra el intercambio
                j--;
            }
            this.listaOrdenarDouble.remove(j + 1); // Se hace un intercambio
            this.numIntercambios++; // se registra el intercambio
            this.listaOrdenarDouble.add(j + 1, selected);
        }
    }

    /**
     * Método que realiza la búsqueda binaria y compara los elementos de la lista con el
     * parámetro item (String)
     * @param item
     * @param low
     * @param high
     * @param modo
     * @return
     */
    public double binarySearchHashCode(String item, int low, int high, int modo) {
        while (low <= high) {// 1ra Comparación
            int mid = low + (high - low) / 2;
            if ((item.equals(this.listaOrdenarString.get(mid)))) {// 2ra Comparación
                this.numComparaciones += 2; // Se registran las 2 comparaciones y termina
                return (mid + 1); // Regresó con 2 comparaciones
            } else if ((modo == 0) && (item.hashCode() > this.listaOrdenarString.get(mid).hashCode())) { // 3ra Comparación por método
                low = mid + 1;
            } else if ((modo == 1) && (item.hashCode() < this.listaOrdenarString.get(mid).hashCode())) { // 3ra Comparación por método
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        this.numComparaciones += 3; // Se registran las 3 comparaciones y termina
        return low; // Regresó con 3 comparaciones
    }

    /**
     * Método que inserta un elemento en la posición adecuada (String).
     * @param modo
     */
    public void binaryInsertionSortHashCode(int modo) {
        int i;
        int j;
        double loc;
        String selected;

        for (i = 1; i < this.listaOrdenarString.size(); ++i) {
            j = i - 1;
            selected = this.listaOrdenarString.get(i);

            // encuentra la posicion donde debe ser insertado el elemento
            loc = binarySearchHashCode(selected, 0, j, modo);

            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) { // Se hace una comparación
                this.numComparaciones++; // Se registra la comparación
                String element = this.listaOrdenarString.get(j);
                this.listaOrdenarString.remove(j + 1);
                this.listaOrdenarString.add(j + 1, element); // se realiza un intercambio
                this.numIntercambios++; // Se registra el intercambio
                j--;
            }
            this.listaOrdenarString.remove(j + 1); // Se hace un intercambio
            this.numIntercambios++; // se registra el intercambio
            this.listaOrdenarString.add(j + 1, selected);
        }
    }

    @Override
    public void menorMayor() {

        if (this.listaOrdenarDouble != null) {
            this.tiempoEjecucion = System.currentTimeMillis();
            binaryInsertionSort(0);
            this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
        } else {
            alfabetico();
        }

    }

    @Override
    public void mayorMenor() {

        if (this.listaOrdenarDouble != null) {
            this.tiempoEjecucion = System.currentTimeMillis();
            binaryInsertionSort(1);
            this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
        } else {
            inversoDeAlfabetico();
        }

    }

    @Override
    public void alfabetico() {

        if (this.listaOrdenarString != null) {
            this.tiempoEjecucion = System.currentTimeMillis();
            binaryInsertionSortHashCode(0);
            this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
        } else {
            menorMayor();
        }

    }

    @Override
    public void inversoDeAlfabetico() {

        if (this.listaOrdenarString != null) {
            this.tiempoEjecucion = System.currentTimeMillis();
            binaryInsertionSortHashCode(1);
            this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
        } else {
            mayorMenor();
        }

    }
}
