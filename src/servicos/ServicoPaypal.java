package servicos;

public class ServicoPaypal implements ServicoPagamentoOnline{


    @Override
    public double taxaPagamento(double valor) {
        return valor * 0.02;
    }

    @Override
    public double juro(double valor, int mes) {
        return (valor * 0.01) * mes;
    }
}
