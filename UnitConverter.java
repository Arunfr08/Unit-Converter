import java.util.Scanner;

public class UnitConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Unit Converter =====");
            System.out.println("1. Length");
            System.out.println("2. Weight");
            System.out.println("3. Temperature");
            System.out.println("4. Time");
            System.out.println("5. Digital Storage");
            System.out.println("6. Speed");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt(sc);

            switch (choice) {
                case 1:
                    lengthFunction(sc);
                    break;
                case 2:
                    weightFunction(sc);
                    break;
                case 3:
                    tempFunction(sc);
                    break;
                case 4:
                    timeFunction(sc);
                    break;
                case 5:
                    digitalStorage(sc);
                    break;
                case 6:
                    speedFunction(sc);
                    break;
                case 7:
                    System.out.println("===== Program Terminated =====");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 7.");
            }
        } while (choice != 7);

        sc.close();
    }

    // Reads an integer safely without crashing if the user enters text.
    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter a whole number: ");
            sc.next(); 
        }
        return sc.nextInt();
    }

    // Reads a decimal number safely.
    private static double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next(); 
        }

        double value = sc.nextDouble();

        while (!Double.isFinite(value)) {
            System.out.print("Please enter a finite number: ");
            while (!sc.hasNextDouble()) {
                System.out.print("Invalid input! Enter a number: ");
                sc.next();
            }
            value = sc.nextDouble();
        }

        return value;
    }

    // Checks that a physical quantity is not negative.
    private static double readNonNegative(Scanner sc, String prompt) {
        double value;
        do {
            System.out.print(prompt);
            value = readDouble(sc);

            if (value < 0) {
                System.out.println("Value cannot be negative. Please try again.");
            }
        } while (value < 0);

        return value;
    }

    // Shared submenu choice reader. Option 0 returns to the main menu.
    private static int readSubmenuChoice(Scanner sc, int maxChoice) {
        int input;

        while (true) {
            System.out.print("Enter choice (0 to go back): ");
            input = readInt(sc);

            if (input >= 0 && input <= maxChoice) {
                return input;
            }

            System.out.println("Invalid choice! Please enter a number from 0 to " + maxChoice + ".");
        }
    }

    // Length conversions
    public static void lengthFunction(Scanner sc) {
        int input;

        do {
            System.out.println("\n===== Length Converter =====");
            System.out.println("1. Kilometer to Meter");
            System.out.println("2. Meter to Kilometer");
            System.out.println("3. Meter to Centimeter");
            System.out.println("4. Centimeter to Meter");
            System.out.println("5. Meter to Millimeter");
            System.out.println("6. Millimeter to Meter");
            System.out.println("0. Back to Main Menu");

            input = readSubmenuChoice(sc, 6);
            double value;
            double result;

            switch (input) {
                case 1:
                    value = readNonNegative(sc, "Enter length in kilometers: ");
                    result = value * 1000.0;
                    System.out.printf("Result => %.4f m%n", result);
                    break;
                case 2:
                    value = readNonNegative(sc, "Enter length in meters: ");
                    result = value / 1000.0;
                    System.out.printf("Result => %.4f km%n", result);
                    break;
                case 3:
                    value = readNonNegative(sc, "Enter length in meters: ");
                    result = value * 100.0;
                    System.out.printf("Result => %.4f cm%n", result);
                    break;
                case 4:
                    value = readNonNegative(sc, "Enter length in centimeters: ");
                    result = value / 100.0;
                    System.out.printf("Result => %.4f m%n", result);
                    break;
                case 5:
                    value = readNonNegative(sc, "Enter length in meters: ");
                    result = value * 1000.0;
                    System.out.printf("Result => %.4f mm%n", result);
                    break;
                case 6:
                    value = readNonNegative(sc, "Enter length in millimeters: ");
                    result = value / 1000.0;
                    System.out.printf("Result => %.4f m%n", result);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (input != 0);
    }

    // Weight conversions
    public static void weightFunction(Scanner sc) {
        int input;

        do {
            System.out.println("\n===== Weight Converter =====");
            System.out.println("1. Kilogram to Gram");
            System.out.println("2. Gram to Kilogram");
            System.out.println("3. Gram to Milligram");
            System.out.println("4. Milligram to Gram");
            System.out.println("5. Kilogram to Milligram");
            System.out.println("0. Back to Main Menu");

            input = readSubmenuChoice(sc, 5);
            double value;
            double result;

            switch (input) {
                case 1:
                    value = readNonNegative(sc, "Enter weight in kilograms: ");
                    result = value * 1000.0;
                    System.out.printf("Result => %.4f g%n", result);
                    break;
                case 2:
                    value = readNonNegative(sc, "Enter weight in grams: ");
                    result = value / 1000.0;
                    System.out.printf("Result => %.4f kg%n", result);
                    break;
                case 3:
                    value = readNonNegative(sc, "Enter weight in grams: ");
                    result = value * 1000.0;
                    System.out.printf("Result => %.4f mg%n", result);
                    break;
                case 4:
                    value = readNonNegative(sc, "Enter weight in milligrams: ");
                    result = value / 1000.0;
                    System.out.printf("Result => %.4f g%n", result);
                    break;
                case 5:
                    value = readNonNegative(sc, "Enter weight in kilograms: ");
                    result = value * 1_000_000.0;
                    System.out.printf("Result => %.4f mg%n", result);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (input != 0);
    }

    // temperature conversion

    public static void tempFunction(Scanner sc) {
        int input;

        do {
            System.out.println("\n===== Temperature Converter =====");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Celsius to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("0. Back to Main Menu");

            input = readSubmenuChoice(sc, 4);
            double value;
            double result;

            switch (input) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    value = readDouble(sc);
                    result = (value * 9.0 / 5.0) + 32.0;
                    System.out.printf("Result => %.2f °F%n", result);
                    break;
                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    value = readDouble(sc);
                    result = (value - 32.0) * 5.0 / 9.0;
                    System.out.printf("Result => %.2f °C%n", result);
                    break;
                case 3:
                    System.out.print("Enter temperature in Celsius: ");
                    value = readDouble(sc);
                    result = value + 273.15;
                    System.out.printf("Result => %.2f K%n", result);
                    break;
                case 4:
                    System.out.print("Enter temperature in Kelvin: ");
                    value = readNonNegative(sc, "Enter temperature in Kelvin: ");
                    result = value - 273.15;
                    System.out.printf("Result => %.2f °C%n", result);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (input != 0);
    }

    // time conversion

    public static void timeFunction(Scanner sc) {
        int input;

        do {
            System.out.println("\n===== Time Converter =====");
            System.out.println("1. Minutes to Seconds");
            System.out.println("2. Seconds to Minutes");
            System.out.println("3. Seconds to Milliseconds");
            System.out.println("4. Hours to Minutes");
            System.out.println("5. Minutes to Hours");
            System.out.println("0. Back to Main Menu");

            input = readSubmenuChoice(sc, 5);
            double value;
            double result;

            switch (input) {
                case 1:
                    value = readNonNegative(sc, "Enter time in minutes: ");
                    result = value * 60.0;
                    System.out.printf("Result => %.4f s%n", result);
                    break;
                case 2:
                    value = readNonNegative(sc, "Enter time in seconds: ");
                    result = value / 60.0;
                    System.out.printf("Result => %.4f min%n", result);
                    break;
                case 3:
                    value = readNonNegative(sc, "Enter time in seconds: ");
                    result = value * 1000.0;
                    System.out.printf("Result => %.4f ms%n", result);
                    break;
                case 4:
                    value = readNonNegative(sc, "Enter time in hours: ");
                    result = value * 60.0;
                    System.out.printf("Result => %.4f min%n", result);
                    break;
                case 5:
                    value = readNonNegative(sc, "Enter time in minutes: ");
                    result = value / 60.0;
                    System.out.printf("Result => %.4f h%n", result);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (input != 0);
    }

    // digital storage conversion
   
    public static void digitalStorage(Scanner sc) {
        int input;

        do {
            System.out.println("\n===== Digital Storage Converter =====");
            System.out.println("1. GB to MB");
            System.out.println("2. MB to GB");
            System.out.println("3. MB to KB");
            System.out.println("4. KB to MB");
            System.out.println("5. GB to KB");
            System.out.println("0. Back to Main Menu");

            input = readSubmenuChoice(sc, 5);
            double value;
            double result;

            switch (input) {
                case 1:
                    value = readNonNegative(sc, "Enter size in GB: ");
                    result = value * 1000.0;
                    System.out.printf("Result => %.4f MB%n", result);
                    break;
                case 2:
                    value = readNonNegative(sc, "Enter size in MB: ");
                    result = value / 1000.0;
                    System.out.printf("Result => %.4f GB%n", result);
                    break;
                case 3:
                    value = readNonNegative(sc, "Enter size in MB: ");
                    result = value * 1000.0;
                    System.out.printf("Result => %.4f KB%n", result);
                    break;
                case 4:
                    value = readNonNegative(sc, "Enter size in KB: ");
                    result = value / 1000.0;
                    System.out.printf("Result => %.4f MB%n", result);
                    break;
                case 5:
                    value = readNonNegative(sc, "Enter size in GB: ");
                    result = value * 1_000_000.0;
                    System.out.printf("Result => %.4f KB%n", result);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (input != 0);
    }

    // Speed conversions
    public static void speedFunction(Scanner sc) {
        int input;

        do {
            System.out.println("\n===== Speed Converter =====");
            System.out.println("1. Kilometers per hour to Miles per hour");
            System.out.println("2. Miles per hour to Kilometers per hour");
            System.out.println("3. Meters per second to Kilometers per hour");
            System.out.println("4. Kilometers per hour to Meters per second");
            System.out.println("0. Back to Main Menu");

            input = readSubmenuChoice(sc, 4);
            double value;
            double result;

            switch (input) {
                case 1:
                    value = readNonNegative(sc, "Enter speed in km/h: ");
                    result = value * 0.621371;
                    System.out.printf("Result => %.4f mph%n", result);
                    break;
                case 2:
                    value = readNonNegative(sc, "Enter speed in mph: ");
                    result = value * 1.60934;
                    System.out.printf("Result => %.4f km/h%n", result);
                    break;
                case 3:
                    value = readNonNegative(sc, "Enter speed in m/s: ");
                    result = value * 3.6;
                    System.out.printf("Result => %.4f km/h%n", result);
                    break;
                case 4:
                    value = readNonNegative(sc, "Enter speed in km/h: ");
                    result = value / 3.6;
                    System.out.printf("Result => %.4f m/s%n", result);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (input != 0);
    }
}
