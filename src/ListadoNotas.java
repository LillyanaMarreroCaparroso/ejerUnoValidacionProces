public class ListadoNotas {
    private int[] notas;
    private int[] resultados;

    //constructor
    public ListadoNotas() {
        notas = new int[100000];
        resultados = new int[10];

        for (int i = 0; i < 100000; i++) {
            notas[i] = (int) (Math.random() * 10);
        }
    }

    public int[] getNotas() {
        return notas;
    }

    //guardamos los resultados de cada hilo
    //synchronized permite que solo un subproceso acceda al método a la vez
    public synchronized void addResultado(int hilo, int resultado) {
        resultados[hilo] = resultado;
    }

    public int[] getResultados() {
        return resultados;
    }
}
