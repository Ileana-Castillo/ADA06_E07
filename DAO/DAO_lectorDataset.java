package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * Clase que lee el archivo dataset y convierte la columna deseada en una lista.
 */
public class DAO_lectorDataset {
    private String rutaDataset;
    private int columna;
    private LinkedList<Double> listaDouble;
    private LinkedList<String> listaString;

    /**
     * Método constructor.
     * @param rutaDataset Recibe la ruta del archivo dataset.csv
     * @param columna Recibe la columna, seleccionada por el usuario, que desea convertir en lista.
     */
    public DAO_lectorDataset(String rutaDataset, int columna) {
        this.rutaDataset = rutaDataset;
        this.columna = columna;
        electorColumna();
        try {
            leerArchivo(rutaDataset);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de entrada CSV");
        }
    }

    /**
     * Método que lee el archivo y separa los elementos de la columna seleccionada por el usuario.
     * @param path
     * @throws IOException
     */
    public void leerArchivo(String path) throws IOException {

        String SEPARADOR = ",";
        BufferedReader bufferLectura = null;

        // Abre el archivo
        bufferLectura = new BufferedReader(new FileReader(path));

        // Leer una linea del archivo
        String fila = bufferLectura.readLine();

        while (fila != null) {
            agragegarDato(fila, SEPARADOR);
            fila = bufferLectura.readLine(); // Lee la siguiente línea del CSV
        }

        if (bufferLectura != null) {
            bufferLectura.close();
        }
    }

    /**
     * Método que crea la lista dependiendo del tipo de dato que la columna maneja (numérico o alfanumérico)
     */
    public void electorColumna() {
        if(this.columna == 5){
            this.listaString = new LinkedList<>();
        }else{
            this.listaDouble = new LinkedList<>();
        }
    }

    /**
     * Método para agregar dato a la lista ligada.
     * @param fila
     * @param SEPARADOR
     */
    public void agragegarDato(String fila, String SEPARADOR) {
        String[] elementosFila = fila.split(SEPARADOR);
        
        if(this.columna == 5){
            String elementoColumna = elementosFila[this.columna - 1];
            this.listaString.add(elementoColumna);
        }else{
            Double elementoColumna = Double.parseDouble(elementosFila[this.columna - 1]);
            this.listaDouble.add(elementoColumna);
        }
    }

    /**
     * Método que devuelve la ruta del dataset.
     * @return
     */
    public String getRutaDataset() {
        return this.rutaDataset;
    }

    /**
     * Método que devuelve la columna del dataset.
     * @return
     */
    public int getcolumna() {
        return this.columna;
    }

    /**
     * Método que devuelve la lista de elementos de tipo String.
     * @return
     */
    public LinkedList<String> getListaString() {
            return this.listaString;
    }

    /**
     * Método que devuelve la lista de elementos de tipo Double.
     * @return
     */
    public LinkedList<Double> getListaDouble() {
        return this.listaDouble;
    }

    /**
     * Método que imprime el dataset inicial.
     */
    public void imprimirDatasetInicial() {

        if(this.columna == 5){
            for (int i = 0; i < this.listaString.size(); i++) {
                System.out.print("{" + this.listaString.get(i) + "}, ");
            }
        }else{
            for (int i = 0; i < this.listaDouble.size(); i++) {
                System.out.print("{" + this.listaDouble.get(i) + "}, ");
            }
        }

        
    }

}
