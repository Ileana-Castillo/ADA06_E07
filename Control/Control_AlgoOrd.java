package Control;

import Modelo.AlgoritmoOrdenamiento;
import Modelo.BinaryInsertionSort;
import Modelo.MergeSort;
import Modelo.QuickSort;
import Modelo.RadixSort;
import Vista.Vista_AlgoOrd;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase define los métodos para controlar la interfaz de usuario del programa.
 * @author Endrick Pool
 */
public class Control_AlgoOrd implements ActionListener {

    private Vista_AlgoOrd vista;
    private String rutaDataset;

    /**
     * Método constructor para crear la interfaz.
     * @param vista
     * @param rutaDataset
     */
    public Control_AlgoOrd(Vista_AlgoOrd vista, String rutaDataset) {
        this.vista = vista;
        this.rutaDataset = rutaDataset;

        this.vista.getjAlgoritmo().addActionListener(this);
        this.vista.getjColumna().addActionListener(this);
        this.vista.getjModoOrdenamiento().addActionListener(this);
        this.vista.getjOrdenar().addActionListener(this);
    }

    /**
     * Método para imprimir la ruta del dataset.
     */
    public void imprimirRutaDataset() {
        System.out.println("Dataset: " + this.rutaDataset);
    }

    /**
     * Método para asignar los archivos csv ordenados dependiendo del algoritmo de ordenamiento seleccionado.
     * @return
     */
    public AlgoritmoOrdenamiento algoritmo() {
        String rutaOrdenadoCsv;
        int numAlgo = this.vista.getjAlgoritmo().getSelectedIndex() + 1;
        int columnaDataset = this.vista.getjColumna().getSelectedIndex() + 1;

        switch (numAlgo) {

            case 1:
                rutaOrdenadoCsv = "BinaryInsertionSort_ordenado.csv";
                return new BinaryInsertionSort(rutaDataset, rutaOrdenadoCsv, columnaDataset);

            case 2:
                rutaOrdenadoCsv = "MergeSort_ordenado.csv";
                return new MergeSort(rutaDataset, rutaOrdenadoCsv, columnaDataset);

            case 3:
                rutaOrdenadoCsv = "QuickSort_ordenado.csv";
                return new QuickSort(rutaDataset, rutaOrdenadoCsv, columnaDataset);

            case 4:
                rutaOrdenadoCsv = "RadixSort_ordenado.csv";
                return new RadixSort(rutaDataset, rutaOrdenadoCsv, columnaDataset);

            default:
                throw new AssertionError();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.vista.getjOrdenar() == e.getSource()) {

            AlgoritmoOrdenamiento algoritmo = algoritmo();

            String modo = this.vista.getjModoOrdenamiento().getSelectedItem().toString();

            switch (modo) {

                case "Menor a mayor":
                    this.vista.getjTextArea1()
                            .setText("Ordenando de menor a mayor en " + algoritmo.nombAlgoritmo() + "...\n");
                    algoritmo.menorMayor();
                    break;

                case "Mayor a menor":
                    this.vista.getjTextArea1()
                            .setText("Ordenando de mayor a menor en " + algoritmo.nombAlgoritmo() + "... \n");
                    algoritmo.mayorMenor();
                    break;

                case "Orden alfabetico":
                    this.vista.getjTextArea1()
                            .setText("Ordenando en orden alfabetico " + algoritmo.nombAlgoritmo() + "...\n");
                    algoritmo.alfabetico();
                    break;

                case "Inverso al alfabetico":
                    this.vista.getjTextArea1().setText(
                            "Ordenando en orden inverso al alfabetico en " + algoritmo.nombAlgoritmo() + "... \n");
                    algoritmo.inversoDeAlfabetico();
                    break;

                default:
                    throw new AssertionError();
            }

            algoritmo.generarArchivos();
        }
    }

}
