public class Main {

    public static void main(String[] args) {
        Camarero c = new Camarero();

        Cliente[] clientes = new Cliente[15000];
        Cocinero[] cocineros = new Cocinero[15000];

        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(i,c);
        }

        for (int i = 0; i < cocineros.length; i++) {
            cocineros[i] = new Cocinero(i,c);
        }

        for (Cliente cliente : clientes) {
            cliente.start();
        }

        for (Cocinero cocinero : cocineros) {
            cocinero.start();
        }


    }
}
