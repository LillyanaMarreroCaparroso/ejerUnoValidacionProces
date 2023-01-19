
public class Main {
    public static void main(String[] args) {

        //ListadoNotas objeto que tendrá 100000 calificaciones aleatorias
        ListadoNotas listado = new ListadoNotas();

        //Objto de Hilo
        Hilo[] hilo = new Hilo[10];

        //creamos 10 hilos
        //pasamos el id y el listado de notas
        for (int i = 0; i < 10; i++) {
            hilo[i] = new Hilo(i, listado);
            hilo[i].start();
        }

        //utilizamos el método join para que bloquee el subproceso principal
        //se bloquea hasta que finalice la ejecución
        for (int i = 0; i < 10; i++) {
            try {
                hilo[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int sumaTotal = 0;

        //sumamos cada una de las notas
        for (int i = 0; i < 10; i++) {
            sumaTotal += listado.getResultados()[i];
        }

        //calculamos el promedio
        double promedio = (double) sumaTotal / 100000;
        System.out.println("La media aritmética es: " + promedio);
    }
}