public class Hilo extends Thread {
    private int identificador;
    private ListadoNotas listado;

    public Hilo(int identificador, ListadoNotas listado) {
        this.identificador = identificador;
        this.listado = listado;
    }

    public void run() {
        int inicio = identificador * 10000;
        int fin = inicio + 10000;
        int suma = 0;

        for (int i = inicio; i < fin; i++) {
            suma += listado.getNotas()[i];
        }
        listado.addResultado(identificador, suma);

        System.out.println("El hilo " + identificador +
                ", que empezó en el índice " + inicio +
                " y ha contado " + (fin - inicio) +
                " calificaciones, ha sumado un total de: " + suma);
    }
}