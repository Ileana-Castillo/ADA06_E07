package Modelo;

/**
 * Clase que hereda los atributos y métodos de la clase AlgoritmoOrdenamiento y
 * ordena los elementos de la lista a través del método Quick Sort.
 */
public class QuickSort extends AlgoritmoOrdenamiento {

    /**
     * Método constructor de la clase QuickSort
     * @param rutaDataset
     * @param rutaOrdenadoCsv
     * @param columnaDataset
     */
    public QuickSort(String rutaDataset, String rutaOrdenadoCsv, int columnaDataset) {
        super(rutaDataset, rutaOrdenadoCsv, columnaDataset);
        this.nombAlgoritmo = "Quick Sort";
    }

    /**
     * Método recursivo del Quick Sort.
     * @param low
     * @param high
     */
    void recQSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            recQSort(low, pi - 1);
            recQSort(pi + 1, high);
        }
    }


    /**
     * Método que genera las particiones del Quick Sort.
     * @param low
     * @param high
     * @return
     */
    int partition(int low, int high) {

        int i = (low - 1);

        if (this.listaOrdenarDouble != null) {
            double pivot = this.listaOrdenarDouble.get(high);
            for (int j = low; j <= high - 1; j++) {
                if (this.listaOrdenarDouble.get(j) < pivot) {
                    i++;
                    swap(i, j);
                }
            }
        } else {
            String pivot = this.listaOrdenarString.get(high);
            for (int j = low; j <= high - 1; j++) {
                if (this.listaOrdenarString.get(j).hashCode() < pivot.hashCode()) {
                    i++;
                    swap(i, j);
                }
            }
        }

        swap(i + 1, high);
        return (i + 1);
    }

    /**
     * Método que cambia de posición un elemento para ordenarlo.
     * @param i
     * @param j
     */
    void swap(int i, int j) {
        if (this.listaOrdenarDouble != null) {
            double temp = this.listaOrdenarDouble.get(i);

            double element = this.listaOrdenarDouble.get(j);
            this.listaOrdenarDouble.remove(i);
            this.listaOrdenarDouble.add(i, element);

            this.listaOrdenarDouble.remove(j);
            this.listaOrdenarDouble.add(j, temp);

        } else {
            String temp = this.listaOrdenarString.get(i);

            String element = this.listaOrdenarString.get(j);
            this.listaOrdenarString.remove(i);
            this.listaOrdenarString.add(i, element);

            this.listaOrdenarString.remove(j);
            this.listaOrdenarString.add(j, temp);

        }

    }

    @Override
    public void menorMayor() {

        if (this.listaOrdenarDouble != null) {
            this.tiempoEjecucion = System.currentTimeMillis();
            recQSort(0, this.listaOrdenarDouble.size() - 1);
            this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
        } else {
            alfabetico();
        }

    }

    @Override
    public void mayorMenor() {

        if (this.listaOrdenarDouble != null) {
            this.tiempoEjecucion = System.currentTimeMillis();
            recQSort(this.listaOrdenarDouble.size()-1, 0);
            this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
        } else {
            inversoDeAlfabetico();
        }
    }

    @Override
    public void alfabetico() {

        if (this.listaOrdenarString != null) {
            this.tiempoEjecucion = System.currentTimeMillis();
            recQSort(0, this.listaOrdenarString.size() - 1);
            this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
        } else {
            menorMayor();
        }

    }

    @Override
    public void inversoDeAlfabetico() {
        
        if (this.listaOrdenarString != null) {
            this.tiempoEjecucion = System.currentTimeMillis();
            recQSort(this.listaOrdenarString.size() - 1, 0);
            this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
        } else {
            mayorMenor();
        }
    }
}
