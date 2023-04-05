package aplicacao;

import entidades.Contrato;
import entidades.Parcela;
import servicos.ServicoContrato;
import servicos.ServicoPaypal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ServicoContrato servicoContrato = new ServicoContrato(new ServicoPaypal());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");
        System.out.print("Número: ");
        int numero = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double valor = sc.nextDouble();
        System.out.print("Entre com o número de parcelas: ");
        int quantidadeParcelas = sc.nextInt();

        Contrato contrato = new Contrato(numero, data, valor);
        servicoContrato.processarContrato(contrato, quantidadeParcelas);
        List<Parcela> parcelas = contrato.getParcelas();

        System.out.println("Parcelas: ");
        for(Parcela parcela: parcelas)
            System.out.println(parcela);
    }
}
