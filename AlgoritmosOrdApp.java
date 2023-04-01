
import Control.Control_AlgoOrd;
import Vista.Vista_AlgoOrd;

public class AlgoritmosOrdApp {

    /**
     * Función principal del programa AlgoritmosOrdApp
     * @param args
     */
    public static void main(String[] args) {
        String csv;
        csv = "dataset.csv";

        Vista_AlgoOrd vistaMain = new Vista_AlgoOrd();
        new Control_AlgoOrd(vistaMain, csv);
        vistaMain.setVisible(true);

    }

}
