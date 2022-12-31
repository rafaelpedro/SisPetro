import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Produto> todosOsProdutos = new ArrayList<>();

        Scanner ler = new Scanner(System.in);
        Integer cod = 1;
        Integer opcao = 1;

        while(opcao == 1) {
            System.out.println("Selecione uma opção: ");
            System.out.println("1- Cadastrar Produto");
            System.out.println("2- Breve");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Criação de novo Produto");
                    Produto produto = new Produto();
                    produto.setCodigo(cod);
                    cod += 1;

                    System.out.println("Digite a descrição do Produto: ");
                    produto.setDescricao(ler.next());


                    System.out.println("Digite o preço do produto: ");
                    String gambiarra = ler.next();
                    produto.setPreco(Double.parseDouble(gambiarra));

                    System.out.println("Digite a quantidade a ser cadastrada no estoque: ");
                    produto.setEstoque(ler.nextInt());
                    produto.baixaEstoque(1);

                    todosOsProdutos.add(produto);
                    break;
                case 2:
                    System.out.println("Nada ainda");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }
    }
}
