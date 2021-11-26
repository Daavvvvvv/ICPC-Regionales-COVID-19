import java.util.Scanner;

// Tres clases para tres casos de >, < o =
class Helpers {

    // Hace que se ingresen datos mayores o iguales a 0 (No negativos).
    public static boolean isZero(int a, int b) {
        return a >= 0 && b >= 0;
    }

    // Evalua si los datos son menores o iguales a la otra variable.
    public static boolean lessThan(int a, int b, boolean isEqualMajor) {
        // Los : sirven para separar true y false, a < b == true, a <= b == false
        return isEqualMajor ? a < b : a <= b;
    }

    // Evalua si los datos son mayores o iguales a la otra variable.
    public static boolean majorThan(int a, int b, boolean isMajorEqual) {
        // Los : sirven para separar true y false, a > b == true, a >= b == false
        return isMajorEqual ? a > b : a >= b;
    }
}

// Determina el color de la gravedad de los casos posibles.
class Messages {

    public static String white = "WHITE";
    public static String yellow = "YELLOW";
    public static String red = "RED";
    public static String error = "ERROR";

    // Metodo para hacer print en el main.
    public static void printMessage(String type) {

        switch (type) {

        case "WHITE":
            System.out.println(white);
            break;

        case "YELLOW":
            System.out.println(yellow);
            break;

        case "RED":
            System.out.println(red);
            break;

        case "ERROR":
            System.out.println(error);
            break;

        default:
            System.out.println("No category");
        }

    }
}

class CovidMejorado {

    // Las dos variables variables principales
    public static int casos;
    public static int hospitalizaciones;

    public static void main(String[] args) {

        // Se piden las variables por pantalla.
        Scanner sc = new Scanner(System.in);
        casos = sc.nextInt();
        hospitalizaciones = sc.nextInt();

        // Se cierra el scanner para ahorrar memoria.
        sc.close();

        // Son todos los casos con las definiciones de la clase helper.
        // Se evalua con los ifs dependiendo de lo que se ingrese por pantalla.
        if (Helpers.isZero(casos, hospitalizaciones)) {
            if (Helpers.lessThan(hospitalizaciones, casos, false) && Helpers.lessThan(casos, 1000, false)
                    && Helpers.lessThan(hospitalizaciones, 500, false)) {

                if (Helpers.lessThan(hospitalizaciones, 10, false)) {
                    Messages.printMessage(Messages.white);

                } else if (Helpers.majorThan(hospitalizaciones, 10, true)
                        && Helpers.lessThan(hospitalizaciones, 30, true)) {
                    Messages.printMessage(Messages.yellow);
                } else if (Helpers.majorThan(hospitalizaciones, 30, false)) {

                    Messages.printMessage(Messages.red);
                }

            } else {
                Messages.printMessage(Messages.error);

            }

        } else {
            Messages.printMessage(Messages.error);
        }
    }
}
