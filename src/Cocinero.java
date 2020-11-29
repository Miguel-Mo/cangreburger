import java.util.Random;

public class Cocinero extends Thread {
    /**
     * Clase clientes/cocineto en lq que asignamos id y en el caso del cliente un tiempo randmo de consumicion entre uno
     * y tres segundos y en el caso del cocinero un tiempo random de produccion entre uno y tres segundos
     */

    private int idCocinero;
    private Camarero camarero;

    public Cocinero(int idCocinero, Camarero c) {
        super();
        this.idCocinero = idCocinero;
        this.camarero = c;
    }


    public void producir() {
        this.camarero.generar(idCocinero);
        //Duerme durante 1-3s
        try {
            Random r = new Random();
            int low = 1000;
            int high = 3000;
            int result = r.nextInt(high-low) + low;
            Thread.sleep(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * El cliente consume constantemente.
     */
    public void run() {
        while(true) {
            producir();
        }
    }
}
