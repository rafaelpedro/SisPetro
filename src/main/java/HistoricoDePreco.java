import java.time.LocalDate;

public class HistoricoDePreco {
    private LocalDate dataDeAlteracao;
    private Double precoAnterior;
    private Double precoAtual;

    public LocalDate getDataDeAlteracao() {
        return dataDeAlteracao;
    }

    public void setDataDeAlteracao(LocalDate dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    public Double getPrecoAnterior() {
        return precoAnterior;
    }

    public void setPrecoAnterior(Double precoAnterior) {
        this.precoAnterior = precoAnterior;
    }

    public Double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(Double precoAtual) {
        this.precoAtual = precoAtual;
    }
}
