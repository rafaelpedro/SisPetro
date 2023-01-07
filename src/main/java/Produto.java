import java.security.PublicKey;

public class Produto {
       private Integer codigo;
       private String descricao;
       private Double preco;
       private Integer quantidadeEstoque;

       public void setCodigo(Integer codigo){
              this.codigo = codigo;
       }

       public void setDescricao(String descricao){
              this.descricao = descricao.toUpperCase();
       }

       public void setPreco(Double preco){
              this.preco = preco;
       }

       public void setEstoque(Integer quantidadeEstoque){
              this.quantidadeEstoque = quantidadeEstoque;
       }

       public void baixaEstoque(Integer quantidadeVendida){
              this.quantidadeEstoque -= quantidadeVendida;
       }

       public void incrementoEstoque(Integer quantidadeAIncrementar){
              this.quantidadeEstoque += quantidadeAIncrementar;
       }


       public Integer getCodigo(){
              return this.codigo;
       }

       public String getDescricao(){
              return this.descricao;
       }

       public Double getPreco(){
              return this.preco;
       }

       public Integer getEstoque(){
              return this.quantidadeEstoque;
       }
}