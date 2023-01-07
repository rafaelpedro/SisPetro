import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static final Integer SAIR = 10;
    public static void main(String[] args){

        ArrayList<Produto> todosOsProdutos = new ArrayList<>();
        ArrayList<Combustivel> todosOsCombustiveis = new ArrayList<>();

        Scanner ler = new Scanner(System.in);
        Integer proxCodBarrasProduto = 1;
        Integer proxCodBarrasCombustivel = 1;
        Integer opcao = 1;


        while(opcao != SAIR) {
            System.out.println("Selecione uma opção: ");
            System.out.println("1- Cadastrar Produto");
            System.out.println("2- Listar produtos");
            System.out.println("3- Deletar produto");
            System.out.println("4- Editar produto");
            System.out.println("5- Cadastrar Combustivel");
            System.out.println("6- Listar Combustiveis");
            System.out.println("7- Deletar Combustivel");
            System.out.println("8- Editar preço do Combustivel");
            System.out.println("9- Editar estoque do Combustivel");

            System.out.println("10- Sair");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1 -> {
                    cadastroDeProdutos(proxCodBarrasProduto, todosOsProdutos);
                    proxCodBarrasProduto += 1;
                }
                case 2 -> listagemDeProdutos(todosOsProdutos);
                case 3 -> deletarProduto(todosOsProdutos);
                case 4 -> editarProduto(todosOsProdutos);
                case 5 -> {
                    cadastroDeCombustiveis(proxCodBarrasCombustivel, todosOsCombustiveis);
                    proxCodBarrasCombustivel +=1;
                }
                case 6 -> listagemDeCombustiveis(todosOsCombustiveis);
                case 7 -> deletarCombustivel(todosOsCombustiveis);
                case 8 -> editarPrecoCombustivel(todosOsCombustiveis);
                // case 9 ->

                case 10 -> System.out.println("Obrigado por utilizar o SisPetro");
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
            //Java esta iterando a lista
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

    public static void editarProduto(ArrayList<Produto> todosOsProdutos){
        Scanner ler = new Scanner(System.in);
        Optional<Produto> produtoASerEditado;
        listagemDeProdutos(todosOsProdutos);
        System.out.println("Digite o código do produto que deseja editar: ");
        Integer codProdutoAEditar = ler.nextInt();
        produtoASerEditado = todosOsProdutos.stream().filter(produto -> produto.getCodigo() == codProdutoAEditar).findFirst();

        System.out.println("Digite a descrição do Produto: ");
        produtoASerEditado.get().setDescricao(ler.next());

        System.out.println("Digite o preço do produto: ");
        String gambiarra = ler.next();
        produtoASerEditado.get().setPreco(Double.parseDouble(gambiarra));

        System.out.println("Digite a quantidade a ser cadastrada no estoque: ");
        produtoASerEditado.get().setEstoque(ler.nextInt());
    }

    public static void cadastroDeCombustiveis(Integer proxCodBarrasCombustivel, ArrayList<Combustivel> todosOsCombustiveis){
        Scanner ler = new Scanner(System.in);
        System.out.println("Criação de novo Combustivel");
        Combustivel combustivel = new Combustivel();
        combustivel.setCodigo(proxCodBarrasCombustivel);

        // Aqui tem que fazer algo para só poder selecionar os combustiveis setados
        System.out.println("Segue os tipos de combustiveis validos para cadastro:");
        Stream.of(TipoDeCombustivel.values()).forEach(System.out::println);
        System.out.println("Digite o tipo de combustivel desejado:");
        String tipoDigitado = ler.next();
        TipoDeCombustivel gambiarra3 = TipoDeCombustivel.valueOf(tipoDigitado);
        combustivel.setTipo(gambiarra3);

        //TipoDeCombustivel[] todosOsTiposDeCombustiveis = TipoDeCombustivel.values();
        //List<TipoDeCombustivel> listaDoTipoDeCombustivel = Arrays.asList(todosOsTiposDeCombustiveis);
        //System.out.println(tipoDigitado + "existe na lista como:" + (listaDoTipoDeCombustivel.contains(tipoDigitado)));

        System.out.println("Digite o preço do combustivel: ");
        String gambiarra1 = ler.next();
        combustivel.setPreco(Double.parseDouble(gambiarra1));

        System.out.println("Digite a litragem a ser cadastrada no estoque: ");
        String gambirra2 = ler.next();
        combustivel.setLitragemEmEstoque(Double.parseDouble(gambirra2));
        //combustivel.baixaLitragemEmEstoque(1);

        todosOsCombustiveis.add(combustivel);
    }

    public static void listagemDeCombustiveis(ArrayList<Combustivel> todosOsCombustiveis){
        for(Combustivel c : todosOsCombustiveis){
            System.out.println(c.getCodigo() + "\t");
            System.out.println(c.getTipo() + "\t");
            System.out.println(c.getLitragemEmEstoque() + "\t");
            System.out.println(c.getPreco() + "\t");
        }
    }

    public static void deletarCombustivel(ArrayList<Combustivel> todosOsCombustiveis){
        Scanner ler = new Scanner(System.in);
        listagemDeCombustiveis(todosOsCombustiveis);
        System.out.println("Digite o códido do combustivel a ser deletado: ");
        Integer codigoADeletar = ler.nextInt();
        todosOsCombustiveis.removeIf( combustivel -> combustivel.getCodigo() == codigoADeletar);
    }

    public static void editarPrecoCombustivel(ArrayList<Combustivel> todosOsCombustiveis){
        Scanner ler = new Scanner(System.in);
        Optional<Combustivel> combustivelASerEditado;
        listagemDeCombustiveis(todosOsCombustiveis);
        do {
            System.out.println("Digite o código do combustivel a ser editado: ");
            Integer codCombustivelAEditar = ler.nextInt();
            combustivelASerEditado = todosOsCombustiveis.stream().filter(combustivel -> combustivel.getCodigo() == codCombustivelAEditar).findFirst();
            if (combustivelASerEditado.isEmpty()){
                System.out.println("Codigo Inválido");
            }
        }while (combustivelASerEditado.isEmpty());
        System.out.println("Digite o novo preço para o combustivel: ");
        String gabiarra = ler.next();
        combustivelASerEditado.get().setPreco(Double.parseDouble(gabiarra));
    }
}