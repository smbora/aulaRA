package serverest.contractTest;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.junit.Test;
import serverest.control.Usuario;
import serverest.model.UsuarioDTO;
import serverest.util.Mensagem;

public class UsuarioContractTest {

    Faker faker = new Faker();

    @Test
    public void contractTestListarUsuarios() {
        Usuario.listarUsuarios();
    }

    @Test
    public void contractTestCadastrarUsuarioComSucesso() {
        //Pr�-condi��o
        String nome = faker.name().firstName();
        String email = nome + "@contracttest.com";
        String password = "teste";
        String administrador = "true";
        UsuarioDTO usuarioDTO = new UsuarioDTO(nome, email, password, administrador);
        //Esta � a valida��o principal deste caso de teste
        Usuario.cadastrarUsuario(usuarioDTO, HttpStatus.SC_CREATED, Mensagem.cadastroSucesso);
    }

    @Test
    public void contractTestEmailJaExistente() {
        //Pr�-condi��o
        String nome = faker.name().firstName();
        String email = nome + "@contracttest.com";
        String password = "teste";
        String administrador = "true";
        UsuarioDTO usuarioDTO = new UsuarioDTO(nome, email, password, administrador);
        Usuario.cadastrarUsuario(usuarioDTO, HttpStatus.SC_CREATED, Mensagem.cadastroSucesso);
        //Esta � a valida��o principal deste caso de teste
        Usuario.cadastrarUsuario(usuarioDTO, HttpStatus.SC_BAD_REQUEST, Mensagem.emailJaUsado);
    }

}