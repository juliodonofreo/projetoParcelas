package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {

    LocalDate dataVencimento;
    double valor;

    public Parcela(LocalDate dataVencimento, double valor) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return  String.format("%s - RS%.2f", dataVencimento.format(fmt), valor);
    }
}
