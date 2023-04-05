package servicos;

import entidades.Contrato;
import entidades.Parcela;

import java.time.LocalDate;

public class ServicoContrato {
    private ServicoPagamentoOnline servicoPagamentoOnline;

    public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
        this.servicoPagamentoOnline = servicoPagamentoOnline;
    }
    public void processarContrato(Contrato contrato, int meses){
        LocalDate dataParcela = contrato.getData().plusMonths(1);
        double valorBrutoParcelas = contrato.getValorTotal() / meses;

        for(int mes = 1; mes <= meses; mes++) {
            double juroParcela = servicoPagamentoOnline.juro(valorBrutoParcelas, mes);
            double taxaPagamentoParcela = servicoPagamentoOnline.taxaPagamento(valorBrutoParcelas + juroParcela);
            double valor = (valorBrutoParcelas + juroParcela) + taxaPagamentoParcela;
            Parcela parcela = new Parcela(dataParcela, valor);
            contrato.addParcela(parcela);
            dataParcela = dataParcela.plusMonths(1);
        }

    }
}

