import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static final Integer SAIR = 16;
    public static void main(String[] args){

        ArrayList<Produto> todosOsProdutos = new ArrayList<>();
        ArrayList<Combustivel> todosOsCombustiveis = new ArrayList<>();
        ArrayList<Usuario> todosOsUsuarios = new ArrayList<>();

        Scanner ler = new Scanner(System.in);
        Integer proxCodBarrasProduto = 1;
        Integer proxCodBarrasCombustivel = 1;
        Integer proxCodDeUsuario = 1;
        Integer opcao = 1;


        while(opcao != SAIR) {
            System.out.println("Selecione uma opção: ");
            System.out.println("1- Cadastrar produto");
            System.out.println("2- Listar produtos");
            System.out.println("3- Deletar produto");
            System.out.println("4- Editar produto");
            System.out.println("5- Incrementar estoque do produto");
            System.out.println("6- Cadastrar combustivel");
            System.out.println("7- Listar combustiveis");
            System.out.println("8- Deletar combustivel");
            System.out.println("9- Editar preço do combustivel");
            System.out.println("10- Editar estoque do combustivel");
            System.out.println("11- Incrementar estoque de combustivel");
            System.out.println("12- Cadastro de usuário");
            System.out.println("13- Listar usuários");

            System.out.println("16- Sair");
            opcao = Integer.parseInt(ler.nextLine());
            switch (opcao) {
                case 1 -> {
                    cadastroDeProdutos(proxCodBarrasProduto, todosOsProdutos);
                    proxCodBarrasProduto += 1;
                }
                case 2 -> listagemDeProdutos(todosOsProdutos);
                case 3 -> deletarProduto(todosOsProdutos);
                case 4 -> editarProduto(todosOsProdutos);
                case 5 -> incrementoNoEstoqueDeProduto(todosOsProdutos);
                case 6 -> {
                    cadastroDeCombustiveis(proxCodBarrasCombustivel, todosOsCombustiveis);
                    proxCodBarrasCombustivel +=1;
                }
                case 7 -> listagemDeCombustiveis(todosOsCombustiveis);
                case 8 -> deletarCombustivel(todosOsCombustiveis);
                case 9 -> editarPrecoCombustivel(todosOsCombustiveis);
                case 10 -> editarEstoqueCombustivel(todosOsCombustiveis);
                case 11 -> incrementoNoEstoqueDeCombustivel(todosOsCombustiveis);
                case 12 -> {
                    cadastroDeUsuario(proxCodDeUsuario, todosOsUsuarios);
                    proxCodDeUsuario += 1;
                }
                case 13 -> listagemDeUsuarios(todosOsUsuarios);
                //case 14 -> ;
                //case 15 -> ;

                case 16 -> System.out.println("Obrigado por utilizar o SisPetro");
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
        produto.setDescricao(ler.nextLine());

        System.out.println("Digite o preço do produto: ");
        String gambiarra = ler.nextLine();
        produto.setPreco(Double.parseDouble(gambiarra));

        System.out.println("Digite a quantidade a ser cadastrada no estoque: ");
        produto.setEstoque(Integer.parseInt(ler.nextLine()));
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
        Boolean removeu;
        do {
            System.out.println("Digite o código do produto que deseja deletar: ");
            Integer codigoADeletar = Integer.parseInt(ler.nextLine());
            removeu = todosOsProdutos.removeIf(produto -> produto.getCodigo() == codigoADeletar);
            if(removeu == false){
                System.out.println("Código Inválido");
            }
        }while (removeu == false);
    }

    public static void editarProduto(ArrayList<Produto> todosOsProdutos){
        Scanner ler = new Scanner(System.in);
        Optional<Produto> produtoASerEditado;
        listagemDeProdutos(todosOsProdutos);
        do {
            System.out.println("Digite o código do produto que deseja editar: ");
            Integer codProdutoAEditar = Integer.parseInt(ler.nextLine());
            produtoASerEditado = todosOsProdutos.stream().filter(produto -> produto.getCodigo() == codProdutoAEditar).findFirst();
            if(produtoASerEditado.isEmpty()){
                System.out.println("Código Inválido");
            }
        }while (produtoASerEditado.isEmpty());

        System.out.println("Digite a descrição do Produto: ");
        produtoASerEditado.get().setDescricao(ler.nextLine());

        System.out.println("Digite o preço do produto: ");
        String gambiarra = ler.nextLine();
        produtoASerEditado.get().setPreco(Double.parseDouble(gambiarra));

        System.out.println("Digite a quantidade a ser cadastrada no estoque: ");
        produtoASerEditado.get().setEstoque(Integer.parseInt(ler.nextLine()));
    }

    public static void incrementoNoEstoqueDeProduto(ArrayList<Produto> todosOsProdutos){
        Scanner ler = new Scanner(System.in);
        listagemDeProdutos(todosOsProdutos);
        Optional<Produto> produtoASerIncrementado;
        do{
            System.out.println("Digite o código do produto a ser incrementado: ");
            Integer codProdutoAIncrementar = Integer.parseInt(ler.nextLine());
            produtoASerIncrementado = todosOsProdutos.stream().filter(produto -> produto.getCodigo() == codProdutoAIncrementar).findFirst();
            if(produtoASerIncrementado.isEmpty()){
                System.out.println("Código Inválido");
            }
        }while (produtoASerIncrementado.isEmpty());
        System.out.println("Digite o valor a ser incrementado: ");
        Integer valorAIncrementar = Integer.parseInt(ler.nextLine());
        produtoASerIncrementado.get().incrementoEstoque(valorAIncrementar);
        //Integer valorEmEstoque = produtoASerIncrementado.get().getEstoque();
        //Integer novoEstoque = valorEmEstoque + valorAIncrementar;
        //produtoASerIncrementado.get().setEstoque(novoEstoque);
    }

    public static void cadastroDeCombustiveis(Integer proxCodBarrasCombustivel, ArrayList<Combustivel> todosOsCombustiveis){
        Scanner ler = new Scanner(System.in);
        System.out.println("Criação de novo Combustivel");
        Combustivel combustivel = new Combustivel();
        combustivel.setCodigo(proxCodBarrasCombustivel);

        // Aqui tem que fazer algo para só poder selecionar os combustiveis setados
        System.out.println("Segue os tipos de combustiveis validos para cadastro:");
        Stream.of(TipoDeCombustivel.values()).forEach(System.out::println);
        Optional<Combustivel> combustivelASerComparado = null;
        TipoDeCombustivel gambiarra = null;
        boolean excecao;
        do {
            System.out.println("Digite o tipo de combustivel desejado:");
            String tipoDigitado = ler.nextLine();
            tipoDigitado = tipoDigitado.toUpperCase();

            try {
                excecao = false;
                gambiarra = TipoDeCombustivel.valueOf(tipoDigitado);
                TipoDeCombustivel finalGambiarra = gambiarra;
                combustivelASerComparado = todosOsCombustiveis.stream().filter(combustivel1 -> combustivel1.getTipo() == finalGambiarra).findFirst();
                if(combustivelASerComparado.isPresent()) {
                    System.out.println("Combustivel já cadastrado");
                }
            }catch (Exception exception){
                excecao = true;
                System.out.println("Opção Inválida");
            }
        }while (excecao || combustivelASerComparado.isPresent());

        combustivel.setTipo(gambiarra);
        //TipoDeCombustivel[] todosOsTiposDeCombustiveis = TipoDeCombustivel.values();
        //List<TipoDeCombustivel> listaDoTipoDeCombustivel = Arrays.asList(todosOsTiposDeCombustiveis);
        //System.out.println(tipoDigitado + "existe na lista como:" + (listaDoTipoDeCombustivel.contains(tip

        System.out.println("Digite o preço do combustivel: ");
        String gambiarra1 = ler.nextLine();
        combustivel.setPreco(Double.parseDouble(gambiarra1));

        System.out.println("Digite a litragem a ser cadastrada no estoque: ");
        String gambirra2 = ler.nextLine();
        combustivel.setLitragemEmEstoque(Double.parseDouble(gambirra2));
        //combustivel.baixaLitragemEmEstoque(1);

        todosOsCombustiveis.add(combustivel);
    }

    public static void listagemDeCombustiveis(ArrayList<Combustivel> todosOsCombustiveis){
        for(Combustivel c : todosOsCombustiveis){
            System.out.print(c.getCodigo() + "\t");
            System.out.print(c.getTipo() + "\t");
            System.out.print(c.getLitragemEmEstoque() + "\t");
            System.out.println(c.getPreco() + "\t");
            System.out.println("Data Alteração \t Preço Anterior \t Preço Atual");
            for(HistoricoDePreco h : c.getHistoricoDePrecos()) {
                System.out.print(h.getDataDeAlteracao() + "\t \t \t");
                System.out.print(h.getPrecoAnterior() + "\t \t \t");
                System.out.println(h.getPrecoAtual() + "\t");
            }
        }
    }

    public static void deletarCombustivel(ArrayList<Combustivel> todosOsCombustiveis) {
        Scanner ler = new Scanner(System.in);
        listagemDeCombustiveis(todosOsCombustiveis);
        Boolean removeu;
        do {
            System.out.println("Digite o códido do combustivel a ser deletado: ");
            Integer codigoADeletar = Integer.parseInt(ler.nextLine());
            removeu = todosOsCombustiveis.removeIf(combustivel -> combustivel.getCodigo() == codigoADeletar);
            if (removeu == false) {
                System.out.println("Código Inválido");
            }
        } while (removeu == false);
    }

    public static void editarPrecoCombustivel(ArrayList<Combustivel> todosOsCombustiveis) {
        Scanner ler = new Scanner(System.in);
        listagemDeCombustiveis(todosOsCombustiveis);
        Optional<Combustivel> combustivelASerEditado;
        do {
            System.out.println("Digite o código do combustivel a ser editado: ");
            Integer codCombustivelAEditar = Integer.parseInt(ler.nextLine());
            combustivelASerEditado = todosOsCombustiveis.stream().filter(combustivel -> combustivel.getCodigo() == codCombustivelAEditar).findFirst();
            if (combustivelASerEditado.isEmpty()){
                System.out.println("Codigo Inválido");
            }
        }while (combustivelASerEditado.isEmpty());
        System.out.println("Digite o novo preço para o combustivel: ");
        String gabiarra = ler.nextLine();
        Double novoPreco = Double.parseDouble(gabiarra);
        HistoricoDePreco novoHistorico = combustivelASerEditado.get().criaHistoricoDePreco(novoPreco);
        combustivelASerEditado.get().setPreco(novoPreco);
        combustivelASerEditado.get().addHistoricoDePrecos(novoHistorico);
    }

    public static void editarEstoqueCombustivel(ArrayList<Combustivel> todosOsCombustiveis){
        Scanner ler = new Scanner(System.in);
        listagemDeCombustiveis(todosOsCombustiveis);
        Optional<Combustivel> combustivelASerEditado;
        do{
            System.out.println("Digite o código do combustivel a ser editado: ");
            Integer codCombustivelAEditar = Integer.parseInt(ler.nextLine());
            combustivelASerEditado = todosOsCombustiveis.stream().filter(combustivel -> combustivel.getCodigo() == codCombustivelAEditar).findFirst();
            if(combustivelASerEditado.isEmpty()){
                System.out.println("Código Inválido");
            }
        }while (combustivelASerEditado.isEmpty());
        System.out.println("Digite a nova litragem em estoque: ");
        String gambiarra = ler.nextLine();
        combustivelASerEditado.get().setLitragemEmEstoque(Double.parseDouble(gambiarra));
    }

    public static void incrementoNoEstoqueDeCombustivel(ArrayList<Combustivel> todosOsCombustiveis){
        Scanner ler = new Scanner(System.in);
        listagemDeCombustiveis(todosOsCombustiveis);
        Optional<Combustivel> combustivelAIncrementar;
        do {
            System.out.println("Digite o código do combustivel a ser incrementado");
            Integer codCombustivelAIncrementar = Integer.parseInt(ler.nextLine());
            combustivelAIncrementar = todosOsCombustiveis.stream().filter(combustivel -> combustivel.getCodigo() == codCombustivelAIncrementar).findFirst();
            if (combustivelAIncrementar.isEmpty()){
                System.out.println("Código Inválido");
            }
        }while (combustivelAIncrementar.isEmpty());
        System.out.println("Digite o valor a ser incrementado: ");
        String gambiarra = ler.nextLine();
        Double valorASerIncrementado = Double.parseDouble(gambiarra);
        combustivelAIncrementar.get().incrementoEstoque(valorASerIncrementado);
    }

    public static void cadastroDeUsuario(Integer proxCodDeUsuario, ArrayList<Usuario> todosOsUsuarios){
        Scanner ler = new Scanner(System.in);
        System.out.println("Criação de novo Usuário");
        Usuario usuario = new Usuario();
        usuario.setCodigo(proxCodDeUsuario);
        Cargo gambiarra = null;
        boolean excecao;

        System.out.println("Segue os cargos elegiveis para cadastro: ");
        Stream.of(Cargo.values()).forEach(System.out::println);

        do {
            excecao = false;
            System.out.println("Digite o cargo a ser cadastrado: ");
            String cargoDigitado = ler.nextLine();
            cargoDigitado = cargoDigitado.toUpperCase();
            try {
                gambiarra = Cargo.valueOf(cargoDigitado);
            } catch (Exception exception) {
                excecao = true;
                System.out.println("Opção inválida");
            }
        }while (excecao);
        usuario.setCargo(gambiarra);
        
        System.out.println("Digite o nome do usuário: ");
        String gambi = ler.nextLine();
        usuario.setNome(gambi);

        todosOsUsuarios.add(usuario);
    }

    public static void listagemDeUsuarios(ArrayList<Usuario> todosOsUsuarios){
        for(Usuario u : todosOsUsuarios) {
            System.out.print(u.getCodigo() + "\t");
            System.out.print(u.getNome() + "\t");
            System.out.println(u.getCargo() + "\t");
        }
    }

}