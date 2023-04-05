package servicos;

import entidades.Contrato;
import entidades.Parcela;

import java.time.LocalDate;

public class ServicoContrato {
    private ServicoPagamentoOnline servicoPagamentoOnline;

    public void processarContrato(Contrato contrato, int meses){
        LocalDate dataParcela = contrato.getData();
        double valorBrutoParcelas = contrato.getValorTotal() / meses;

        for(int mes = 1; mes <= meses; mes++) {
            double valor = valorBrutoParcelas + servicoPagamentoOnline.juro(valorBrutoParcelas, mes);
            Parcela parcela = new Parcela(dataParcela, valor);
            contrato.addParcela(parcela);
            dataParcela = dataParcela.plusMonths(1);
        }

    }
}

