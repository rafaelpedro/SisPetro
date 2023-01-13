import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void deveDeixarAsPrimeirasLetrasDeTodasAsPalavrasDaStringMaiuscula(){
        Usuario usuario = new Usuario();
        usuario.setNome("EDSON arAntes dO NascimENTO");
        Assertions.assertEquals("Edson Arantes Do Nascimento", usuario.getNome());
    }
}
