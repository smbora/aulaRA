package serverest.userFlowTest;

import org.apache.http.HttpStatus;
import org.junit.Test;
import serverest.control.Carrinho;
import serverest.control.Produto;
import serverest.control.Usuario;
import serverest.model.ProdutoDTO;
import serverest.model.UsuarioDTO;
import serverest.util.Mensagem;

public class Exercicio04Test {
    @Test
    public void validarUsuario()

    {
        UsuarioDTO usuarioDTO = new UsuarioDTO("true");
        //Cadastrar um usuário
        String userId = Usuario.cadastrarUsuario(usuarioDTO, HttpStatus.SC_CREATED, Mensagem.cadastroSucesso);
        //Autenticar usuário
        String userToken = Usuario.autenticarUsuario(usuarioDTO, HttpStatus.SC_OK, Mensagem.loginSucesso);
        //Cadstrar um produto
        ProdutoDTO produtoDTO = Produto.gerarPokemon(100, 100);
        String productId = Produto.cadastrarProduto(produtoDTO, userToken, HttpStatus.SC_CREATED, Mensagem.cadastroSucesso);
        //Cadastrar carrinho
        Carrinho.cadastrarCarrinho(productId, 1, userToken, HttpStatus.SC_CREATED, Mensagem.cadastroSucesso);
        //Verificar deletar usuario

    }
}