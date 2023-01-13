public class Usuario {

    private Integer codigo;

    private String nome;

    private Cargo cargo;


    public void setCodigo(Integer codigo){
        this.codigo = codigo;
    }

    public void setNome(String nome){
        nome = nome.toLowerCase();
        String[] partes = nome.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < partes.length; i++) {
            String word = partes[i];
            word = word.substring(0, 1).toUpperCase() + word.substring(1);
            sb.append(" ").append(word);
        }
       this.nome = sb.toString().replaceFirst(" ", "");
    }

    public void setCargo(Cargo cargo){
        this.cargo = cargo;
    }

    public Integer getCodigo(){
        return this.codigo;
    }
    public String getNome(){
        return this.nome;
    }
    public Cargo getCargo(){
        return this.cargo;
    }

}
