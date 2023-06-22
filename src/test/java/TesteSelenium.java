import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteSelenium {
    private BasePage basePage;

    @BeforeEach
    public void beforeEach() {
        this.basePage = new BasePage();
    }

    @Test
    public void validarPesquisaCargoNaEmpresaNttdata() throws InterruptedException {
        basePage.pesquisarAlgoNoGoogle("NTTDATA");
        basePage.acessarPesquisa("NTT DATA: Global IT Services Provider & Consultant");
        basePage.termoDeUsabilidade("Aceitar");
        basePage.acessarCarreiras();
        basePage.mudarDeAba();
        basePage.termoDeUsabilidade("Accept");
        basePage.procurarCarreira("Pessoa Engenheira de dados");
        assertEquals("PESSOA ENGENHEIRA DE DADOS - HÍBRIDO", basePage.carreiraEncontrada());
    }

    @AfterEach
    public void fecharDriver(){
        this.basePage.fechar();
    }
}
