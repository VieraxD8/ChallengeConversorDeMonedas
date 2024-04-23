import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

     /*  ConsultandoCambio consulta = new ConsultandoCambio();

        Monedas monedas = consulta.obtenerTasasCambio("USD");

        System.out.println(monedas);*/

        Scanner scanner = new Scanner(System.in);
        ConsultandoCambio consultor = new ConsultandoCambio();

        System.out.println("****************************************\n" +
                "\n" +
                "Bienvenido al conversor de moneda \n" +
                "\n" +
                "*****************************************"+"\n" );


        while (true) {
            System.out.println("1) Dolar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dolar");
            System.out.println("5) Dolar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dolar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirMoneda("USD", "ARS", consultor);
                    break;
                case 2:
                    convertirMoneda("ARS", "USD", consultor);
                    break;
                case 3:
                    convertirMoneda("USD", "BRL", consultor);
                    break;
                case 4:
                    convertirMoneda("BRL", "USD", consultor);
                    break;
                case 5:
                    convertirMoneda("USD", "COP", consultor);
                    break;
                case 6:
                    convertirMoneda("COP", "USD", consultor);
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Por favor, ingrese una opción válida.");
            }
        }

    }

    private static void convertirMoneda(String monedaOrigen, String monedaDestino, ConsultandoCambio consultas) {

        Monedas tasasCambio = consultas.obtenerTasasCambio(monedaOrigen);
        System.out.println(tasasCambio);

        if (tasasCambio == null) {
            System.out.println("No se pudieron obtener las tasas de cambio. Intente nuevamente más tarde.");
            return;
        }

        double tasaCambio = 1.0;

        switch (monedaDestino) {

            case "ARS":
                tasaCambio= tasasCambio.ARS();
                break;

            case "BRL":
                tasaCambio= tasasCambio.BRL();
                break;
            case "COP":
                tasaCambio= tasasCambio.COP();
                break;
            case "USD":
                tasaCambio = tasasCambio.USD();
                break;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de " + monedaOrigen + " a convertir: " );
        double cantidad = scanner.nextDouble();
        double resultado = cantidad * tasaCambio;
        System.out.println(cantidad + " " + monedaOrigen + " equivale a " + resultado + " " + monedaDestino+"\n" );



    }

}
