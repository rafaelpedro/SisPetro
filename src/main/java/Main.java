import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static final Integer SAIR = 15;
    public static final String ADMIN_LOGIN = "ADMIN";
    public static final Integer ADMIN_SENHA = 123456;
    public static ArrayList<Produto> todosOsProdutos = new ArrayList<>();
    public static ArrayList<Combustivel> todosOsCombustiveis = new ArrayList<>();
    public static ArrayList<Usuario> todosOsUsuarios = new ArrayList<>();
    public static Integer proxCodBarrasProduto = 1;
    public static Integer proxCodBarrasCombustivel = 1;
    public static Integer proxCodDeUsuario = 1;


    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Integer opcao = 1;
        Usuario usuarioAdmin = new Usuario(0, "Mayza Yuri", Cargo.ADMINISTRADOR, ADMIN_LOGIN, ADMIN_SENHA);
        todosOsUsuarios.add(usuarioAdmin);
        Integer menu = 1;
        do {
            Usuario usuarioLogado = menuLogin();
            switch (usuarioLogado.getCargo()) {
                case ADMINISTRADOR -> menuDoUsuarioAdmin(usuarioLogado);
                case GERENTE -> menuDoUsuarioGerente(usuarioLogado);
                case ATENDENTE -> menuDoUsuarioAtendente(usuarioLogado);
                case FRENTISTA -> menuDoUsuarioFrentista(usuarioLogado);
            }
        }while (true);

        /*
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
            System.out.println("14- Editar cargo de usuario");

            System.out.println("15- Sair");
            opcao = Integer.parseInt(ler.nextLine());
            switch (opcao) {
                case 1 -> {
                    cadastroDeProdutos();
                    proxCodBarrasProduto += 1;
                }
                case 2 -> listagemDeProdutos();
                case 3 -> deletarProduto();
                case 4 -> editarProduto();
                case 5 -> incrementoNoEstoqueDeProduto();
                case 6 -> {
                    cadastroDeCombustiveis();
                    proxCodBarrasCombustivel +=1;
                }
                case 7 -> listagemDeCombustiveis();
                case 8 -> deletarCombustivel();
                case 9 -> editarPrecoCombustivel();
                case 10 -> editarEstoqueCombustivel();
                case 11 -> incrementoNoEstoqueDeCombustivel();
                case 12 -> {
                    cadastroDeUsuario();
                    proxCodDeUsuario += 1;
                }
                case 13 -> listagemDeUsuarios();
                case 14 -> editarCargoDeUsuario();


                case 15 -> System.out.println("Obrigado por utilizar o SisPetro");
                default -> System.out.println("Opção invalida");

            }
        } */
    }


    public static Usuario menuLogin() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Bem-Vindo ao SisPetro");
        Optional<Usuario> optionalUsuario;
        boolean eSenhaCorreta = false;
        do {
            System.out.println("Digite o seu login: ");
            String loginDigitado = ler.nextLine();
            loginDigitado = loginDigitado.toUpperCase();
            System.out.println("Digite a sua senha numérica: ");
            Integer senhaDigitada = Integer.parseInt(ler.nextLine());
            String finalLoginDigitado = loginDigitado;
            optionalUsuario = todosOsUsuarios.stream().filter(usuario -> usuario.getLogin().equals(finalLoginDigitado)).findFirst();
            if (optionalUsuario.isPresent()) {
                eSenhaCorreta = optionalUsuario.get().getSenha().equals(senhaDigitada);
            }
            if (optionalUsuario.isEmpty() || !eSenhaCorreta) {
                System.out.println("Usuario não encontrado");
            }
        } while (optionalUsuario.isEmpty() || !eSenhaCorreta);
        return optionalUsuario.get();
    }

    public static void cadastroDeProdutos() {
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

    public static void listagemDeProdutos() {
        /*for(int x=0; x < todosOsProdutos.size(); x++){
            System.out.print(todosOsProdutos.get(x).getCodigo() + "\t");
            System.out.print(todosOsProdutos.get(x).getDescricao()+ "\t");
            System.out.print(todosOsProdutos.get(x).getPreco()+ "\t");
            System.out.println(todosOsProdutos.get(x).getEstoque()+ "\t");
        }*/
        for (Produto p : todosOsProdutos) {
            //Java esta iterando a lista
            System.out.print(p.getCodigo() + "\t");
            System.out.print(p.getDescricao() + "\t");
            System.out.print(p.getPreco() + "\t");
            System.out.println(p.getEstoque() + "\t");
        }
    }

    public static void deletarProduto() {
        Scanner ler = new Scanner(System.in);
        listagemDeProdutos();
        Boolean removeu;
        do {
            System.out.println("Digite o código do produto que deseja deletar: ");
            Integer codigoADeletar = Integer.parseInt(ler.nextLine());
            removeu = todosOsProdutos.removeIf(produto -> produto.getCodigo() == codigoADeletar);
            if (removeu == false) {
                System.out.println("Código Inválido");
            }
        } while (removeu == false);
    }

    public static void editarProduto() {
        Scanner ler = new Scanner(System.in);
        Optional<Produto> produtoASerEditado;
        listagemDeProdutos();
        do {
            System.out.println("Digite o código do produto que deseja editar: ");
            Integer codProdutoAEditar = Integer.parseInt(ler.nextLine());
            produtoASerEditado = todosOsProdutos.stream().filter(produto -> produto.getCodigo() == codProdutoAEditar).findFirst();
            if (produtoASerEditado.isEmpty()) {
                System.out.println("Código Inválido");
            }
        } while (produtoASerEditado.isEmpty());

        System.out.println("Digite a descrição do Produto: ");
        produtoASerEditado.get().setDescricao(ler.nextLine());

        System.out.println("Digite o preço do produto: ");
        String gambiarra = ler.nextLine();
        produtoASerEditado.get().setPreco(Double.parseDouble(gambiarra));

        System.out.println("Digite a quantidade a ser cadastrada no estoque: ");
        produtoASerEditado.get().setEstoque(Integer.parseInt(ler.nextLine()));
    }

    public static void incrementoNoEstoqueDeProduto() {
        Scanner ler = new Scanner(System.in);
        listagemDeProdutos();
        Optional<Produto> produtoASerIncrementado;
        do {
            System.out.println("Digite o código do produto a ser incrementado: ");
            Integer codProdutoAIncrementar = Integer.parseInt(ler.nextLine());
            produtoASerIncrementado = todosOsProdutos.stream().filter(produto -> produto.getCodigo() == codProdutoAIncrementar).findFirst();
            if (produtoASerIncrementado.isEmpty()) {
                System.out.println("Código Inválido");
            }
        } while (produtoASerIncrementado.isEmpty());
        System.out.println("Digite o valor a ser incrementado: ");
        Integer valorAIncrementar = Integer.parseInt(ler.nextLine());
        produtoASerIncrementado.get().incrementoEstoque(valorAIncrementar);
        //Integer valorEmEstoque = produtoASerIncrementado.get().getEstoque();
        //Integer novoEstoque = valorEmEstoque + valorAIncrementar;
        //produtoASerIncrementado.get().setEstoque(novoEstoque);
    }

    public static void cadastroDeCombustiveis() {
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
                if (combustivelASerComparado.isPresent()) {
                    System.out.println("Combustivel já cadastrado");
                }
            } catch (Exception exception) {
                excecao = true;
                System.out.println("Opção Inválida");
            }
        } while (excecao || combustivelASerComparado.isPresent());

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

    public static void listagemDeCombustiveis() {
        for (Combustivel c : todosOsCombustiveis) {
            System.out.print(c.getCodigo() + "\t");
            System.out.print(c.getTipo() + "\t");
            System.out.print(c.getLitragemEmEstoque() + "\t");
            System.out.println(c.getPreco() + "\t");
            System.out.println("Data Alteração \t Preço Anterior \t Preço Atual");
            for (HistoricoDePreco h : c.getHistoricoDePrecos()) {
                System.out.print(h.getDataDeAlteracao() + "\t \t \t");
                System.out.print(h.getPrecoAnterior() + "\t \t \t");
                System.out.println(h.getPrecoAtual() + "\t");
            }
        }
    }

    public static void deletarCombustivel() {
        Scanner ler = new Scanner(System.in);
        listagemDeCombustiveis();
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

    public static void editarPrecoCombustivel() {
        Scanner ler = new Scanner(System.in);
        listagemDeCombustiveis();
        Optional<Combustivel> combustivelASerEditado;
        do {
            System.out.println("Digite o código do combustivel a ser editado: ");
            Integer codCombustivelAEditar = Integer.parseInt(ler.nextLine());
            combustivelASerEditado = todosOsCombustiveis.stream().filter(combustivel -> combustivel.getCodigo() == codCombustivelAEditar).findFirst();
            if (combustivelASerEditado.isEmpty()) {
                System.out.println("Codigo Inválido");
            }
        } while (combustivelASerEditado.isEmpty());
        System.out.println("Digite o novo preço para o combustivel: ");
        String gabiarra = ler.nextLine();
        Double novoPreco = Double.parseDouble(gabiarra);
        HistoricoDePreco novoHistorico = combustivelASerEditado.get().criaHistoricoDePreco(novoPreco);
        combustivelASerEditado.get().setPreco(novoPreco);
        combustivelASerEditado.get().addHistoricoDePrecos(novoHistorico);
    }

    public static void editarEstoqueCombustivel() {
        Scanner ler = new Scanner(System.in);
        listagemDeCombustiveis();
        Optional<Combustivel> combustivelASerEditado;
        do {
            System.out.println("Digite o código do combustivel a ser editado: ");
            Integer codCombustivelAEditar = Integer.parseInt(ler.nextLine());
            combustivelASerEditado = todosOsCombustiveis.stream().filter(combustivel -> combustivel.getCodigo() == codCombustivelAEditar).findFirst();
            if (combustivelASerEditado.isEmpty()) {
                System.out.println("Código Inválido");
            }
        } while (combustivelASerEditado.isEmpty());
        System.out.println("Digite a nova litragem em estoque: ");
        String gambiarra = ler.nextLine();
        combustivelASerEditado.get().setLitragemEmEstoque(Double.parseDouble(gambiarra));
    }

    public static void incrementoNoEstoqueDeCombustivel() {
        Scanner ler = new Scanner(System.in);
        listagemDeCombustiveis();
        Optional<Combustivel> combustivelAIncrementar;
        do {
            System.out.println("Digite o código do combustivel a ser incrementado");
            Integer codCombustivelAIncrementar = Integer.parseInt(ler.nextLine());
            combustivelAIncrementar = todosOsCombustiveis.stream().filter(combustivel -> combustivel.getCodigo() == codCombustivelAIncrementar).findFirst();
            if (combustivelAIncrementar.isEmpty()) {
                System.out.println("Código Inválido");
            }
        } while (combustivelAIncrementar.isEmpty());
        System.out.println("Digite o valor a ser incrementado: ");
        String gambiarra = ler.nextLine();
        Double valorASerIncrementado = Double.parseDouble(gambiarra);
        combustivelAIncrementar.get().incrementoEstoque(valorASerIncrementado);
    }

    public static void cadastroDeUsuario() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Criação de novo Usuário");
        Cargo cargoSelecionado = null;
        boolean excecao;

        System.out.println("Segue os cargos elegiveis para cadastro: ");
        Stream.of(Cargo.values()).forEach(System.out::println);

        do {
            excecao = false;
            System.out.println("Digite o cargo a ser cadastrado: ");
            String cargoDigitado = ler.nextLine();
            cargoDigitado = cargoDigitado.toUpperCase();
            try {
                cargoSelecionado = Cargo.valueOf(cargoDigitado);
            } catch (Exception exception) {
                excecao = true;
                System.out.println("Opção inválida");
            }
        } while (excecao);

        System.out.println("Digite o nome do funcionario: ");
        String nomeDigitado = ler.nextLine();

        System.out.println("Crie um login para o funcionario: ");
        String loginDigitado = ler.nextLine();

        System.out.println("Crie uma senha para o funcionario: ");
        Integer senhaDigitada = Integer.parseInt(ler.nextLine());

        Usuario usuario = new Usuario(proxCodDeUsuario, nomeDigitado, cargoSelecionado, loginDigitado, senhaDigitada);
        todosOsUsuarios.add(usuario);


    }

    public static void listagemDeUsuarios() {
        for (Usuario u : todosOsUsuarios) {
            System.out.print(u.getCodigo() + "\t");
            System.out.print(u.getNome() + "\t");
            System.out.println(u.getCargo() + "\t");
        }
    }

    public static void editarCargoDeUsuario() {
        Scanner ler = new Scanner((System.in));
        listagemDeUsuarios();
        Optional<Usuario> usuarioASerEditado;
        Cargo gambiarra = null;
        boolean excecao;


        do {
            System.out.println("Digite o código do usuário a ser editado: ");
            Integer codUsuarioAEditar = Integer.parseInt(ler.nextLine());
            usuarioASerEditado = todosOsUsuarios.stream().filter(usuario -> usuario.getCodigo() == codUsuarioAEditar).findFirst();
            if (usuarioASerEditado.isEmpty()) {
                System.out.println("Código Inválido");
            }
        } while (usuarioASerEditado.isEmpty());

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
        } while (excecao);
        // Cargo novoCargo = gambiarra;
        usuarioASerEditado.get().setCargo(gambiarra);
    }

    public static void menuDoUsuarioAdmin(Usuario usuario) {
        Scanner ler = new Scanner(System.in);
        Integer opcao = 0;
        do {
            System.out.println("Bem-vindo " + usuario.getNome());
            System.out.println("1 - Cadastro de Usuários");
            System.out.println("2 - Sair");
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            opcao = Integer.parseInt(ler.nextLine());
            switch (opcao) {
                case 1 -> {
                    cadastroDeUsuario();
                }
            }
        } while (opcao != 2);
    }

    public static void menuDoUsuarioGerente(Usuario usuario) {
        Scanner ler = new Scanner(System.in);
        Integer opcao = 0;
        do {
            System.out.println("Bem-vindo " + usuario.getNome());
            System.out.println("1 - Cadastro de Usuários");
            System.out.println("2 - Cadastro de Produtos");
            System.out.println("3 - Cadastro de Combustiveis");
            //System.out.println("4 - Gerar Relatórios");
            System.out.println("4 - Sair");
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            opcao = Integer.parseInt(ler.nextLine());
            switch (opcao) {
                case 1 -> cadastroDeUsuario();
                case 2 -> cadastroDeProdutos();
                case 3 -> cadastroDeCombustiveis();
                //case 4 -> geradorDeRelatorios();
            }
        } while (opcao != 4);
    }

    public static void menuDoUsuarioAtendente(Usuario usuario) {
        Scanner ler = new Scanner(System.in);
        Integer opcao = 0;
        do {
            System.out.println("Bem-vindo " + usuario.getNome());
            System.out.println("1 - Venda de Produtos");
            System.out.println("2 - Sair");
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            opcao = Integer.parseInt(ler.nextLine());
            switch (opcao) {
                case 1 -> System.out.println("Venda de Produtos");
            }
        } while (opcao != 2);
    }

    public static void menuDoUsuarioFrentista(Usuario usuario) {
        Scanner ler = new Scanner(System.in);
        Integer opcao = 0;
        do {
            System.out.println("Bem-vindo " + usuario.getNome());
            System.out.println("1 - Venda de Combustivél");
            System.out.println("2 - Sair");
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            opcao = Integer.parseInt(ler.nextLine());
            switch (opcao) {
                case 1 -> System.out.println("Venda de Combustivél");
            }
        } while (opcao != 2);
    }
}