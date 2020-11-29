public class Main {

    public static void main(String[] args) {

        /**
         * En la clase principal simplemente le asignamos un numero al array de clientes y ccocineros
         * y los ponemos a hacer su trabajo el clientes consumir y el cocinero a hacer hamburguesas
         */

        Camarero c = new Camarero();

        Cliente[] clientes = new Cliente[3];
        Cocinero[] cocineros = new Cocinero[3];

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
