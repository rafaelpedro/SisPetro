public class Produto {
       private Integer codigo;
       private String descricao;
       private Double preco;
       private Integer quantideEstoque;

       public void setCodigo(Integer cod){
              this.codigo = cod;
       }

       public void setDescricao(String descri){
              this.descricao = descri.toUpperCase();
       }

       public void setPreco(Double prec){
              this.preco = prec;
       }

       public void setEstoque(Integer quantEstoque){
              this.quantideEstoque = quantEstoque;
       }

       public void baixaEstoque(Integer quantVendida){
              this.quantideEstoque -= quantVendida;
       }
}