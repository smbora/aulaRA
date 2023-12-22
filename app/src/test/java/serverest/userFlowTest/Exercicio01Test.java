package serverest.userFlowTest;

import org.junit.Test;
import serverest.control.Usuario;

public class Exercicio01Test {

    @Test
    public void getUsuarios() {
        Usuario.listarUsuarios();
    }
}

