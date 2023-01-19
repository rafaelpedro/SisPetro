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

    @Test
    public void deveSomarVendaDeVariosProdutos(){
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Venda venda = new Venda();

        produto1.setPreco(10.0);
        produto2.setPreco(20.0);


        venda.atualizaValorTotalDaVenda(produto1,2);
        Assertions.assertEquals(20.0, venda.getValorTotalVendido());
        venda.atualizaValorTotalDaVenda(produto2,2);
        Assertions.assertEquals(60.0, venda.getValorTotalVendido());
    }
}
