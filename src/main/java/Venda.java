import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venda {

    private ArrayList<Produto> listaDeProdutosVendidos = new ArrayList<>();

    private Usuario usuarioResponsavel;

    private LocalDateTime horarioDaVenda;

    private Double valorTotalVendido = 0D;

    public ArrayList<Produto> getListaDeProdutosVendidos() {
        return listaDeProdutosVendidos;
    }

    public void atualizaValorTotalDaVenda(Produto produtoVendido, Integer quantidadeVendida){
        Double valorAIncrementar;
        valorAIncrementar = quantidadeVendida * produtoVendido.getPreco();
        valorTotalVendido += valorAIncrementar;
    }

    public void adicionaProduto(Produto produtoASerVendido){
        listaDeProdutosVendidos.add(produtoASerVendido);
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    public LocalDateTime getHorarioDaVenda() {
        return horarioDaVenda;
    }

    public void setHorarioDaVenda(LocalDateTime horarioDaVenda) {
        this.horarioDaVenda = horarioDaVenda;
    }

    public Double getValorTotalVendido() {
        return valorTotalVendido;
    }

    public void setValorTotalVendido(Double valorTotalVendido) {
        this.valorTotalVendido = valorTotalVendido;
    }
}
