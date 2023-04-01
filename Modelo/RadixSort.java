package Modelo;

public class RadixSort extends AlgoritmoOrdenamiento {

    public RadixSort(String rutaDataset, String rutaOrdenadoCsv, int columnaDataset) {
        super(rutaDataset, rutaOrdenadoCsv, columnaDataset);
        this.nombAlgoritmo = "Radix Sort";
    }

    @Override
    public void menorMayor() {
        this.tiempoEjecucion = System.currentTimeMillis();

        // código

        this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
    }

    @Override
    public void mayorMenor() {
        this.tiempoEjecucion = System.currentTimeMillis();

        this.numComparaciones = 10;

        // código

        this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
    }

    @Override
    public void alfabetico() {
        this.tiempoEjecucion = System.currentTimeMillis();

        this.numComparaciones = 20;

        // código

        this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
    }

    @Override
    public void inversoDeAlfabetico() {
        this.tiempoEjecucion = System.currentTimeMillis();

        this.numComparaciones = 30;

        // código

        this.tiempoEjecucion = System.currentTimeMillis() - this.tiempoEjecucion;
    }
}
