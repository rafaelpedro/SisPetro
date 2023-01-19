import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VendaTest {
    @Test
    public void deveSomarOValorDosProdutosVendidos(){
        Produto produto = new Produto();
        Venda venda = new Venda();

        produto.setPreco(30.0);

        venda.atualizaValorTotalDaVenda(produto,2);
        Assertions.assertEquals(60.0, venda.getValorTotalVendido());
    }
}
