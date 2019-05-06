package Principal;

import Controladores.LoginController;
import Modelos.LoginBo;
import vistas.Login;

public class inicio {

  
    public static void main(String[] args) {

        LoginBo ModeloLgin = new LoginBo();
        Login VistaLogin = new Login();
        VistaLogin.setVisible(true);
        new LoginController(ModeloLgin, VistaLogin);
        
    }
}
