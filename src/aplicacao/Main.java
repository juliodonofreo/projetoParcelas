package aplicacao;

import entidades.Contrato;
import entidades.Parcela;
import servicos.ServicoContrato;
import servicos.ServicoPaypal;
import validacoes.Validacoes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ServicoContrato servicoContrato = new ServicoContrato(new ServicoPaypal());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");
        int numero = Validacoes.validarInteiro("Número: ");
        LocalDate data = Validacoes.validarData("Data (dd/mm/yyyy): ", fmt);
        double valor = Validacoes.validarDouble("Valor do contrato: ");
        int quantidadeParcelas = Validacoes.validarInteiro("Entre com o número de parcelas: ");

        Contrato contrato = new Contrato(numero, data, valor);
        servicoContrato.processarContrato(contrato, quantidadeParcelas);
        List<Parcela> parcelas = contrato.getParcelas();

        System.out.println("Parcelas: ");
        for(Parcela parcela: parcelas)
            System.out.println(parcela);
    }
}
