import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CombustivelTest {

    @Test
    public void deveSubtrairDoEstoqueAQuantidadeVendida(){
        Combustivel combustivel = new Combustivel();
        combustivel.setLitragemEmEstoque(30D);
        combustivel.baixaLitragemEmEstoque(5D);
        Assertions.assertEquals(25,combustivel.getLitragemEmEstoque());
    }

    @Test
    public void deveSomarNoEstoqueAQuantidadeAIncrementar(){
        Combustivel combustivel = new Combustivel();
        combustivel.setLitragemEmEstoque(200D);
        combustivel.incrementoEstoque(60D);
        Assertions.assertEquals(260,combustivel.getLitragemEmEstoque());
    }

    @Test
    public void deveAdicionarHistoricoNaListaHistoricoDePrecos(){
        Combustivel combustivel = new Combustivel();
        HistoricoDePreco novoHistorico = new HistoricoDePreco();
        novoHistorico.setPrecoAnterior(20D);
        novoHistorico.setPrecoAtual(30D);
        novoHistorico.setDataDeAlteracao(LocalDate.now());
        combustivel.addHistoricoDePrecos(novoHistorico);
        Assertions.assertEquals(1, combustivel.getHistoricoDePrecos().size());
        Assertions.assertEquals(20D,combustivel.getHistoricoDePrecos().get(0).getPrecoAnterior());
        Assertions.assertEquals(30D,combustivel.getHistoricoDePrecos().get(0).getPrecoAtual());
    }

    @Test
    public void deveCriar
}
