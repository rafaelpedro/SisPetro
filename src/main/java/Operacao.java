import java.time.LocalDate;

public class Operacao {

    private LocalDate dataDeAlteracao;

    private String operacaoRealizda;

    private Usuario usuarioResponsavel;


    public LocalDate getDataDeAlteracao() {
        return dataDeAlteracao;
    }

    public void setDataDeAlteracao(LocalDate dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    public String getOperacaoRealizda() {
        return operacaoRealizda;
    }

    public void setOperacaoRealizda(String operacaoRealizda) {
        this.operacaoRealizda = operacaoRealizda;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }
}