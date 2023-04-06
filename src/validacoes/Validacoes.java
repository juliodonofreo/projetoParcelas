package validacoes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validacoes {
    private static Scanner sc = new Scanner(System.in);

    public static int validarInteiro(String texto) {
        Integer valor = null;

        do {
            try{
                System.out.print(texto);
                valor = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("O valor deve ser um número inteiro, digite novamente. ");
                sc.nextLine();
            }
        }while (valor == null);

        return valor;
    }

    public static LocalDate validarData(String texto, DateTimeFormatter fmt) {
        LocalDate valor = null;

        do {
            try{
                System.out.print(texto);
                valor = LocalDate.parse(sc.next(), fmt);
            }
            catch (DateTimeParseException e) {
                System.out.print("O valor deve seguir o formato especificado, digite novamente. ");
                sc.nextLine();
            }
        }while (valor == null);

        return valor;
    }

    public static double validarDouble(String texto) {
        Double valor = null;

        do {
            try{
                System.out.print(texto);
                String valorString = sc.next();
                valor = Double.parseDouble(valorString.replace(',', '.'));
            }
            catch (NumberFormatException e) {
                System.out.print("O valor deve ser um número, digite novamente. ");
                sc.nextLine();
            }
        }while (valor == null);

        return valor;
    }


}
