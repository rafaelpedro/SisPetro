import java.time.LocalDate;
import java.util.ArrayList;

public class Combustivel {
    private Integer codigo; //não vai poder ser alterado
    private TipoDeCombustivel tipo; // não vai poder ser alterado
    private Double preco;
    private Double litragemEmEstoque;

    private ArrayList<HistoricoDePreco> historicoDePrecos = new ArrayList<>();

    public  void addHistoricoDePrecos(HistoricoDePreco novoHistorico){
        historicoDePrecos.add(novoHistorico);
    }

    public HistoricoDePreco criaHistoricoDePreco(Double novoPreco){
        Double precoAtual = this.getPreco();
        HistoricoDePreco novoHistorico = new HistoricoDePreco();
        novoHistorico.setPrecoAnterior(precoAtual);
        novoHistorico.setPrecoAtual(novoPreco);
        novoHistorico.setDataDeAlteracao(LocalDate.now());
        return novoHistorico;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setTipo(TipoDeCombustivel tipo) {
        this.tipo = tipo;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setLitragemEmEstoque(Double litragemEmEstoque) {
        this.litragemEmEstoque = litragemEmEstoque;
    }

    public void baixaLitragemEmEstoque(Double quantidadeVendida) {
        this.litragemEmEstoque -= quantidadeVendida;
    }

    public void incrementoEstoque(Double quantidadeAIncrementar){
        this.litragemEmEstoque += quantidadeAIncrementar;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public TipoDeCombustivel getTipo() {
        return this.tipo;
    }

    public Double getPreco() {
        return this.preco;
    }

    public Double getLitragemEmEstoque() {
        return this.litragemEmEstoque;
    }

    public ArrayList<HistoricoDePreco> getHistoricoDePrecos(){
        return this.historicoDePrecos;
    }

}
