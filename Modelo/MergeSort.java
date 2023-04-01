package Modelo;

/**
 * Clase que hereda los atributos y métodos de la clase AlgoritmoOrdenamiento y
 * ordena los elementos de la lista a través del método Merge Sort.
 */
public class MergeSort extends AlgoritmoOrdenamiento {

    /**
     * Método constructor del MergeSort
     * @param rutaDataset
     * @param rutaOrdenadoCsv
     * @param columnaDataset
     */
    public MergeSort(String rutaDataset, String rutaOrdenadoCsv, int columnaDataset) {
        super(rutaDataset, rutaOrdenadoCsv, columnaDataset);
        this.nombAlgoritmo = "Merge Sort";
    }

    /**
     * Método que invoca los diferentes métodos recursivos del MergeSort dependiendo de la manera en la que
     * los datos serán ordenados.
     * @param modo
     */
    public void mergeSort(int modo) { // Esto se puede editar luego sin los if de modo
        if (this.listaOrdenarDouble != null) { // Se trabajará con valores Double
            double[] workSpace = new double[this.listaOrdenarDouble.size()];
            if (modo == 0) { // Menor a Mayor (Double)
                recMergeSort(workSpace, 0, this.listaOrdenarDouble.size() - 1, modo);
            } else { // Mayor a Menor (Double)
                recMergeSortMayorMenor(workSpace, 0, this.listaOrdenarDouble.size() - 1, modo);
            }
        } else {// Se trabajará con valores String
            String[] workSpace = new String[this.listaOrdenarString.size()];
            if (modo == 0) { // Menor a Mayor (String)
                recMergeSort(workSpace, 0, this.listaOrdenarString.size() - 1, modo);
            } else { // Mayor a Menor (String)
                recMergeSortMayorMenor(workSpace, 0, this.listaOrdenarString.size() - 1, modo);
            }
        }
    }

    /**
     * Método recursivo del MergeSort para valores Double y ordenarlos de menor a mayor.
     * @param workSpace
     * @param lowerBound
     * @param upperBound
     * @param modo
     */
    private void recMergeSort(double[] workSpace, int lowerBound, int upperBound, int modo) {
        if (lowerBound != upperBound) { // if range is 1 no use sorting
            this.numComparaciones++; // Se registra la anterior comparación
            int mid = (lowerBound + upperBound) / 2; // find midpoint
            recMergeSort(workSpace, lowerBound, mid, modo); // sort low half
            recMergeSort(workSpace, mid + 1, upperBound, modo); // sort high half
            merge(workSpace, lowerBound, mid + 1, upperBound, modo); // merge them
        }
    }

    /**
     * Método recursivo del MergeSort para valores String y ordenarlos de menor a mayor.
     * @param workSpace
     * @param lowerBound
     * @param upperBound
     * @param modo
     */
    private void recMergeSort(String[] workSpace, int lowerBound, int upperBound, int modo) {
        if (lowerBound != upperBound) { // if range is 1 no use sorting
            this.numComparaciones++; // Se registra la anterior comparación
            int mid = (lowerBound + upperBound) / 2; // find midpoint
            recMergeSort(workSpace, lowerBound, mid, modo); // sort low half
            recMergeSort(workSpace, mid + 1, upperBound, modo); // sort high half
            merge(workSpace, lowerBound, mid + 1, upperBound, modo); // merge them
        }
    }

    /**
     * Método merge para valores String y ordenarlos de menor a mayor.
     * @param workSpace
     * @param lowPtr
     * @param highPtr
     * @param upperBound
     * @param modo
     */
    private void merge(double[] workSpace, int lowPtr, int highPtr, int upperBound, int modo) {
        int j;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items

        j = 0; // workspace index
        while (lowPtr <= mid && highPtr <= upperBound) { // 1ra comparación
            if (this.listaOrdenarDouble.get(lowPtr) < this.listaOrdenarDouble.get(highPtr)) { // 2da comparación
                workSpace[j++] = this.listaOrdenarDouble.get(lowPtr++);
            } else {
                workSpace[j++] = this.listaOrdenarDouble.get(highPtr++);
            }
            this.numComparaciones += 2; // Se registran las 2 comparaciones
        }
        while (lowPtr <= mid) { // Comparación
            this.numComparaciones++; // Se registra la comparación
            workSpace[j++] = this.listaOrdenarDouble.get(lowPtr++);
        }
        while (highPtr <= upperBound) { // Comparación
            this.numComparaciones++; // Se registra la comparación
            workSpace[j++] = this.listaOrdenarDouble.get(highPtr++);
        }
        for (j = 0; j < n; j++) {
            double elemento = workSpace[j];
            this.listaOrdenarDouble.remove((lowerBound + j));
            this.listaOrdenarDouble.add(lowerBound + j, elemento);
            this.numIntercambios++;
        }
    }

    /**
     * Método merge para valores String y ordenarlos de menor a mayor.
     * @param workSpace
     * @param lowPtr
     * @param highPtr
     * @param upperBound
     * @param modo
     */
    private void merge(String[] workSpace, int lowPtr, int highPtr, int upperBound, int modo) {
        int j;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items

        j = 0; // workspace index
        while (lowPtr <= mid && highPtr <= upperBound) { // 1ra comparación
            if (this.listaOrdenarString.get(lowPtr).hashCode() < this.listaOrdenarString.get(highPtr).hashCode()) { // 2da comparación
                workSpace[j++] = this.listaOrdenarString.get(lowPtr++);
            } else {
                workSpace[j++] = this.listaOrdenarString.get(highPtr++);
            }
            this.numComparaciones += 2; // Se registran las 2 comparaciones
        }
        while (lowPtr <= mid) { // Comparación
            this.numComparaciones++; // Se registra la comparación
            workSpace[j++] = this.listaOrdenarString.get(lowPtr++);
        }
        while (highPtr <= upperBound) { // Comparación
            this.numComparaciones++; // Se registra la comparación
            workSpace[j++] = this.listaOrdenarString.get(highPtr++);
        }
        for (j = 0; j < n; j++) {
            String elemento = workSpace[j];
            this.listaOrdenarString.remove((lowerBound + j));
            this.listaOrdenarString.add(lowerBound + j, elemento);
            this.numIntercambios++;
        }
    }

    // Aquí empiezan los experimentos...

    /**
     * Método recursivo del MergeSort para ordenar datos Double de mayor a menor.
     * @param workSpace
     * @param lowerBound
     * @param upperBound
     * @param modo
     */
    private void recMergeSortMayorMenor(double[] workSpace, int lowerBound, int upperBound, int modo) {
        if (lowerBound != upperBound) { // if range is 1 no use sorting
            this.numComparaciones++; // Se registra la anterior comparación
            int mid = (lowerBound + upperBound) / 2; // find midpoint
            recMergeSort(workSpace, lowerBound, mid, modo); // sort low half
            recMergeSort(workSpace, mid + 1, upperBound, modo); // sort high half
            mergeMayorMenor(workSpace, mid, lowerBound, upperBound, modo);// merge them
        }
    }

    /**
     * Método recursivo del MergeSort para ordenar datos String de mayor a menor.
     * @param workSpace
     * @param lowerBound
     * @param upperBound
     * @param modo
     */
    private void recMergeSortMayorMenor(String[] workSpace, int lowerBound, int upperBound, int modo) {
        if (lowerBound != upperBound) { // if range is 1 no use sorting
            this.numComparaciones++; // Se registra la anterior comparación
            int mid = (lowerBound + upperBound) / 2; // find midpoint
            recMergeSort(workSpace, lowerBound, mid, modo); // sort low half
            recMergeSort(workSpace, mid + 1, upperBound, modo); // sort high half
            mergeMayorMenor(workSpace, lowerBound, mid + 1, upperBound, modo); // merge them
        }
    }

    /**
     * Método merge para comparar y unir los elementos numéricos de la lista de mayor a menor.
     * @param workSpace
     * @param lowPtr
     * @param highPtr
     * @param upperBound
     * @param modo
     */
    private void mergeMayorMenor(double[] workSpace, int lowPtr, int highPtr, int upperBound, int modo) {
        int j;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items
    
        j = 0; // workspace index
        while (lowPtr <= mid && highPtr <= upperBound) { // 1ra comparación
            if (this.listaOrdenarDouble.get(lowPtr) > this.listaOrdenarDouble.get(highPtr)) { // 2da comparación (modified)
                workSpace[j++] = this.listaOrdenarDouble.get(lowPtr++);
            } else {
                workSpace[j++] = this.listaOrdenarDouble.get(highPtr++);
            }
            this.numComparaciones += 2; // Se registran las 2 comparaciones
        }
        while (lowPtr <= mid) { // Comparación
            this.numComparaciones++; // Se registra la comparación
            workSpace[j++] = this.listaOrdenarDouble.get(lowPtr++);
        }
        while (highPtr <= upperBound) { // Comparación
            this.numComparaciones++; // Se registra la comparación
            workSpace[j++] = this.listaOrdenarDouble.get(highPtr++);
        }
        for (j = 0; j < n; j++) {
            double elemento = workSpace[j];
            this.listaOrdenarDouble.remove((lowerBound + j));
            this.listaOrdenarDouble.add(lowerBound + j, elemento);
            this.numIntercambios++;
        }
    }

    /**
     * Método para comparar y unir los elementos String de la lista de manera ordenada.
     * @param workSpace
     * @param lowPtr
     * @param highPtr
     * @param upperBound
     * @param modo
     */
    private void mergeMayorMenor(String[] workSpace, int lowPtr, int highPtr, int upperBound, int modo) {
        int j;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items
    
        j = 0; // workspace index
        while (lowPtr <= mid && highPtr <= upperBound) { // 1ra comparación
            if (this.listaOrdenarString.get(lowPtr).compareTo(this.listaOrdenarString.get(highPtr)) > 0) { // 2da comparación
                workSpace[j++] = this.listaOrdenarString.get(lowPtr++);
            } else {
                workSpace[j++] = this.listaOrdenarString.get(highPtr++);
            }
            this.numComparaciones += 2; // Se registran las 2 comparaciones
        }
        while (lowPtr <= mid) { // Comparación
            this.numComparaciones++; // Se registra la comparación
            workSpace[j++] = this.listaOrdenarString.get(lowPtr++);
        }
        while (highPtr <= upperBound) { // Comparación
            this.numComparaciones++; // Se registra la comparación
            workSpace[j++] = this.listaOrdenarString.get(highPtr++);
        }
        for (j = 0; j < n; j++) {
            String elemento = workSpace[j];
            this.listaOrdenarString.remove((lowerBound + j));
            this.listaOrdenarString.add(lowerBound + j, elemento);
            this.numIntercambios++;
        }
    }
    
    @Override
    public void menorMayor() {

        this.tiempoEjecucion = System.currentTimeMillis();
        mergeSort(0);
        this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;

    }

    @Override
    public void mayorMenor() {

        this.tiempoEjecucion = System.currentTimeMillis();
        mergeSort(1);
        this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;

    }

    @Override
    public void alfabetico() {

        this.tiempoEjecucion = System.currentTimeMillis();
        mergeSort(0);
        this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;

    }

    @Override
    public void inversoDeAlfabetico() {
        
        this.tiempoEjecucion = System.currentTimeMillis();
        mergeSort(1);
        this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;

    }
}
