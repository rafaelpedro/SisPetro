import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final Integer SAIR = 4;
    public static void main(String[] args){

        ArrayList<Produto> todosOsProdutos = new ArrayList<>();

        Scanner ler = new Scanner(System.in);
        Integer proxCodBarrasProduto = 1;
        Integer opcao = 1;


        while(opcao != SAIR) {
            System.out.println("Selecione uma opção: ");
            System.out.println("1- Cadastrar Produto");
            System.out.println("2- Listar produtos");
            System.out.println("3- Deletar produto");
            System.out.println("4- Sair");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1 -> {
                    cadastroDeProdutos(proxCodBarrasProduto, todosOsProdutos);
                    proxCodBarrasProduto += 1;
                }
                case 2 -> listagemDeProdutos(todosOsProdutos);
                case 3 -> deletarProduto(todosOsProdutos);
                case 4 -> System.out.println("Obrigado por utilizar o SisPetro");
                default -> System.out.println("Opção invalida");
            }

        }
    }
    public static void cadastroDeProdutos(Integer proxCodBarrasProduto, ArrayList<Produto> todosOsProdutos){
        Scanner ler = new Scanner(System.in);
        System.out.println("Criação de novo Produto");
        Produto produto = new Produto();
        produto.setCodigo(proxCodBarrasProduto);

        System.out.println("Digite a descrição do Produto: ");
        produto.setDescricao(ler.next());


        System.out.println("Digite o preço do produto: ");
        String gambiarra = ler.next();
        produto.setPreco(Double.parseDouble(gambiarra));

        System.out.println("Digite a quantidade a ser cadastrada no estoque: ");
        produto.setEstoque(ler.nextInt());
        //produto.baixaEstoque(1);

        todosOsProdutos.add(produto);
    }

    public static void listagemDeProdutos(ArrayList<Produto> todosOsProdutos){
        /*for(int x=0; x < todosOsProdutos.size(); x++){
            System.out.print(todosOsProdutos.get(x).getCodigo() + "\t");
            System.out.print(todosOsProdutos.get(x).getDescricao()+ "\t");
            System.out.print(todosOsProdutos.get(x).getPreco()+ "\t");
            System.out.println(todosOsProdutos.get(x).getEstoque()+ "\t");
        }*/
        for(Produto p : todosOsProdutos){
            System.out.print(p.getCodigo() + "\t");
            System.out.print(p.getDescricao()+ "\t");
            System.out.print(p.getPreco()+ "\t");
            System.out.println(p.getEstoque()+ "\t");
        }
    }

    public static void deletarProduto(ArrayList<Produto> todosOsProdutos){
        Scanner ler = new Scanner(System.in);
        listagemDeProdutos(todosOsProdutos);
        System.out.println("Digite o código do produto que deseja deletar: ");
        Integer codigoADeletar = ler.nextInt();
        todosOsProdutos.removeIf( produto -> produto.getCodigo() == codigoADeletar);
    }
}
