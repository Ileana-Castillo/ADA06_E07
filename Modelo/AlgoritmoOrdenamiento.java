package Modelo;

import java.util.LinkedList;

import DAO.DAO_Resumen;
import DAO.DAO_datasetOrdenado_CSV;
import DAO.DAO_lectorDataset;

/**
 * Clase de la que los distintos algoritmos de ordenamiento heredarán sus atributos y además escribe en los archivos de salida.
 */
public abstract class AlgoritmoOrdenamiento {

    protected String nombAlgoritmo;
    protected long tiempoEjecucion;
    protected int numComparaciones;
    protected int numIntercambios;
    protected String rutaOrdenadoCsv;
    protected String rutaResumen;
    protected LinkedList<Double> listaOrdenarDouble;
    protected LinkedList<String> listaOrdenarString;

    /**
     * Método constructor de esta clase abstracta.
     * @param rutaDataset
     * @param rutaOrdenadoCsv
     * @param columnaDataset
     */
    protected AlgoritmoOrdenamiento(String rutaDataset, String rutaOrdenadoCsv, int columnaDataset) {
        this.rutaOrdenadoCsv = rutaOrdenadoCsv;
        this.rutaResumen = "resumen.txt";

        System.out.println("Dataset : " + rutaDataset + "\nOrdenado: " + rutaOrdenadoCsv + "\nResumen: " + rutaResumen
                + "\nColumna Dataset: " + columnaDataset);

        DAO_lectorDataset daoD = new DAO_lectorDataset(rutaDataset, columnaDataset);
        if (columnaDataset == 5) {
            this.listaOrdenarString = daoD.getListaString();
            this.listaOrdenarDouble = null;
        } else {
            this.listaOrdenarDouble = daoD.getListaDouble();
            this.listaOrdenarString = null;
        }

        this.tiempoEjecucion = 0;
        this.numComparaciones = 0;
        this.numIntercambios = 0;
    }

    /**
     * Método para ordenar los datos de menor a mayor.
     */
    public void menorMayor() {
    }

    /**
     * Método para ordenar los datos de mayor a menor.
     */
    public void mayorMenor() {
    }

    /**
     * Método para ordenar los datos alfabéticamente.
     */
    public void alfabetico() {
    }

    /**
     * Método para ordenar los datos en inverso alfabético.
     */
    public void inversoDeAlfabetico() {
    }

    /**
     * Método que escribe los archivos de salida.
     */
    public void generarArchivos() {
        DAO_Resumen daoR = new DAO_Resumen(this.rutaResumen, this.nombAlgoritmo, this.tiempoEjecucion,
                this.numComparaciones, this.numIntercambios);
        daoR.escribirResumen();
        DAO_datasetOrdenado_CSV daoData = new DAO_datasetOrdenado_CSV(rutaOrdenadoCsv);

        if (this.listaOrdenarDouble != null) {
            daoData.escribirDatasetOrdenado(this.listaOrdenarDouble);
        } else {
            daoData.escribirDatasetOrdenado(this.listaOrdenarString);
        }

    }

    /**
     * Método que devuelve el nombre del algoritmo de ordenamiento solicitado.
     * @return
     */
    public String nombAlgoritmo() {
        return this.nombAlgoritmo;
    }
}
