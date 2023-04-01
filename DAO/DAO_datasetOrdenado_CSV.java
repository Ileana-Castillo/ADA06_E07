package DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * Clase que escribe los datos de salida en los archivos BinaryInsertionSort_ordenado.csv,
 * MergeSort_ordenado.csv, QuickSort_ordenado.csv y RadixSort_ordenado.csv
 */
public class DAO_datasetOrdenado_CSV {

    private String ruta;

    /**
     * Método constructor. Crea los archivos de salida si estos no existen.
     * @param ruta
     */
    public DAO_datasetOrdenado_CSV(String ruta) {
        this.ruta = ruta;

        try {
            File file = new File(this.ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error con el archivo de salida: " + this.ruta);
        }

    }

    /**
     * Método que recibe la lista ligada ya ordenada y la escribe en su archivo csv correspondiente.
     * @param ordenado
     */
    public void escribirDatasetOrdenado(LinkedList ordenado) {

        String SEPARADOR = " , ";

        try {
            FileWriter writer = new FileWriter(this.ruta, false);
            for (int i = 0; i < ordenado.size(); i++) {
                if(((i % 10) == 0) && i!=0){
                    writer.write("\n");
                }
                writer.write("{" + ordenado.get(i) + "}" + SEPARADOR);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
