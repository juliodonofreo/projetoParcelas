package servicos;

public interface ServicoPagamentoOnline {

    public double taxaPagamento(double valor);
    public double juro(double valor, int mes);
}
