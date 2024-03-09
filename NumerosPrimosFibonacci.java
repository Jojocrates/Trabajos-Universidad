package com.mycompany.numerosprimosfibonacci;

import java.util.Scanner;

public class NumerosPrimosFibonacci {
    private int cantidadNumeros;

    // Constructor
    public NumerosPrimosFibonacci(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
    }

    // Método para calcular números primos
    public int[] calcularNumerosPrimos() {
        int[] primos = new int[cantidadNumeros];
        int count = 0;
        int num = 2;

        while (count < cantidadNumeros) {
            if (esPrimo(num)) {
                primos[count] = num;
                count++;
            }
            num++;
        }
        return primos;
    }

    // Método para verificar si un número es primo
    private boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método para calcular la sucesión de Fibonacci
    public int[] calcularFibonacci() {
        int[] fibonacci = new int[cantidadNumeros];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < cantidadNumeros; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    // Método para imprimir los números primos
    public void imprimirNumerosPrimos(int[] primos) {
        System.out.print("Números primos:\n");
        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.print(primos[i]);
            if (i < cantidadNumeros - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Método para imprimir la sucesión de Fibonacci
    public void imprimirFibonacci(int[] fibonacci) {
        System.out.print("\nSucesión de Fibonacci:\n");
        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.print(fibonacci[i]);
            if (i < cantidadNumeros - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repetir = true;

        while (repetir) {
            System.out.println("¿Qué operación deseas realizar?");
            System.out.println("1. Calcular números primos");
            System.out.println("2. Calcular la sucesión de Fibonacci");
            System.out.print("Ingresa el número de la opción: ");
            int opcion = scanner.nextInt();

            System.out.print("Ingresa la cantidad de números a calcular: ");
            int cantidad = scanner.nextInt();

            NumerosPrimosFibonacci programa = new NumerosPrimosFibonacci(cantidad);

            switch (opcion) {
                case 1:
                    int[] primos = programa.calcularNumerosPrimos();
                    programa.imprimirNumerosPrimos(primos);
                    break;
                case 2:
                    int[] fibonacci = programa.calcularFibonacci();
                    programa.imprimirFibonacci(fibonacci);
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

            System.out.print("¿Deseas realizar otra operación? (Y/N): ");
            String continuar = scanner.next();
            repetir = continuar.equalsIgnoreCase("Y");
        }
        scanner.close();
    }
}
