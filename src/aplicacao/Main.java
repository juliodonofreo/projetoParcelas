package aplicacao;

import entidades.Contrato;
import servicos.ServicoContrato;
import servicos.ServicoPaypal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        ServicoContrato servicoContrato = new ServicoContrato(new ServicoPaypal());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Contrato contrato = new Contrato(8028, LocalDate.parse("25/06/2018", fmt), 600.0);
        servicoContrato.processarContrato(contrato, 3);
        System.out.println(contrato.getParcelas().get(1).getDataVencimento()+ " "  + contrato.getParcelas().get(1).getValor());
    }
}
