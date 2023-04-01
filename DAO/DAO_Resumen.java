package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

//lineas [0] = "Datos" + " , " + "Tiempo Ejecucion: " + " , " + "Num Comparaciones: " + " , " + "Num Intercambios: "
//lineas [1] = "BIS" + " , " + tiempoEjecucion + " , " + numcomparaciones + " , " + numIntercambios
//lineas [2] = "MS" + " , " + tiempoEjecucion + " , " + numcomparaciones + " , " + numIntercambios
//lineas [3] = "QS" + " , " + tiempoEjecucion + " , " + numcomparaciones + " , " + numIntercambios
//lineas [4] = "RS" + " , " + tiempoEjecucion + " , " + numcomparaciones + " , " + numIntercambios
/**
 * Clase que escribe las métricas de cada algoritmo de ordenamiento en el archivo resumen.txt
 */
public class DAO_Resumen {
    private String ruta;
    private String[] lineas;
    private String nombAlgoritmo;
    private long tiempoEjecucion;
    private int numComparaciones;
    private int numIntercambios;

    /**
     * Método constructor de la clase DAO_Resumen
     * @param ruta
     * @param nombAlgoritmo
     * @param tiempoEjecucion
     * @param numComparaciones
     * @param numIntercambios
     */
    public DAO_Resumen(String ruta, String nombAlgoritmo, long tiempoEjecucion, int numComparaciones, int numIntercambios) {
        this.nombAlgoritmo = nombAlgoritmo;
        this.ruta = ruta;
        this.tiempoEjecucion = tiempoEjecucion;
        this.numComparaciones = numComparaciones;
        this.numIntercambios = numIntercambios;
        this.lineas = new String[5];

        BufferedReader bufferLectura = null;

        try {
            // Abrir el .txt en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(this.ruta));
            String linea = bufferLectura.readLine(); // Leer una linea del archivo
            int i = 0;
            while (linea != null) {
                lineas[i] = linea; // Añade cada linea leída a un arreglo de lineas
                linea = bufferLectura.readLine(); // Volver a leer otra línea del fichero
                i++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error con el archivo");
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error con el cierre finally del bufferLectura");
                }
            }
        }

    }

    /**
     * Método que actualiza la información de cada algoritmo de ordenamiento ejecutado.
     */
    public void actualizarLinea() {
        int numAlgoritmo;

        switch (this.nombAlgoritmo) {
            case "Binary Insertion Sort":
                this.nombAlgoritmo = "BIS";
                numAlgoritmo = 1;
                break;
            case "Merge Sort":
                this.nombAlgoritmo = "MS";
                numAlgoritmo = 2;
                break;
            case "Quick Sort":
                this.nombAlgoritmo = "QS";
                numAlgoritmo = 3;
                break;
            case "Radix Sort":
                this.nombAlgoritmo = "RS";
                numAlgoritmo = 4;
                break;
            default:
                throw new AssertionError();
        }

        lineas[numAlgoritmo] = this.nombAlgoritmo + " , " + this.tiempoEjecucion + " , " + this.numComparaciones + " , "
                + this.numIntercambios + " , ";
    }

    /**
     * Método que escribe el resumen de las métricas de todos los algoritmos de ordenamiento.
     * @return
     */
    public int escribirResumen() {
        // Actualizando la linea donde esta el algoritmo
        actualizarLinea();
        // Actualizando el archivo .TXT con la linea modificada
        try {
            FileWriter writer = new FileWriter(this.ruta, false);
            for (int i = 0; i < this.lineas.length; i++) {
                writer.write(this.lineas[i] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error con el archivo de salida: " + this.ruta);
        }

        System.out.println("Resumen exitoso");
        imprimirResumen();
        return 0; // Añadido exitósamente
    }

    /**
     * Método para imprimir el contenido de resumen.txt en la consola.
     */
    public final void imprimirResumen() {
        for (int i = 0; i < this.lineas.length; i++) {
            System.out.println(this.lineas[i]);
        }
    }

}
