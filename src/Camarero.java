public class Camarero {

    /**
     * La clase camarero es la que se encarga de repartir las burgers que estan en cola
     *  y restarlas de la cola, ademas tambien se encarga de saber cuando un cliente tiene hambre
     *  y de saber cuantas burgers hay en la cola disponibles para los clientes
     */


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
