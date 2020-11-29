public class Camarero {
    private int burgersEnCola;

    public Camarero() {

    }

    public synchronized void consumir(int idCliente) {
        System.out.println("El cliente " + idCliente + " tiene hambre! Quedan "+ burgersEnCola +" disponibles");
        while(!puedeConsumir()) {
            try {
                System.out.println("El cliente "+idCliente+" está esperando");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.burgersEnCola--;
        System.out.println("El cliente " + idCliente + " ha comido una burger! Quedan "+ burgersEnCola +" disponibles");
        notify();
    }


    public synchronized  void generar(int idCocinero) {
        this.burgersEnCola++;
        System.out.println("El cocinero " + idCocinero + " ha hecho una burger! Quedan "+ burgersEnCola +" disponibles");
        notify();
    }

    private boolean puedeConsumir() {
        return burgersEnCola>0;
    }






}
