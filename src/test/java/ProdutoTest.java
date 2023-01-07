import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
    @Test
    public void deveConverterDescricaoParaMaiusculo(){
        Produto produto = new Produto();
        produto.setDescricao("banana");

        Assertions.assertEquals("BANANA", produto.getDescricao());
    }

    @Test
    public void deveSubtrairDoEstoqueAQuantidadeVendida(){
        Produto produto = new Produto();
        produto.setEstoque(30);
        produto.baixaEstoque(5);
        Assertions.assertEquals(25,produto.getEstoque());
    }

    @Test
    public void deveSomarNoEstoqueAQuantidadeAIncrementar(){
        Produto produto = new Produto();
        produto.setEstoque(200);
        produto.incrementoEstoque(60);
        Assertions.assertEquals(260,produto.getEstoque());
    }
}