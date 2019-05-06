package Controladores;

import Modelos.LoginBo;
import Modelos.LoginVo;
import Modelos.PrincipalBo;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rojeru_san.RSPanelsSlider;
import vistas.Login;
import vistas.Principal;

public class LoginController implements ActionListener {

    LoginBo Modelo;
    Login Vista;

    public LoginController(LoginBo Modelo, Login Vista) {
        this.Modelo = Modelo;
        this.Vista = Vista;
        this.Vista.btningresar.addActionListener(this);
        this.Vista.btncerrar.addActionListener(this);
        this.Vista.btnminimizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.btningresar) {

            LoginVo atributos = new LoginVo(Vista.txtuser.getText(), Vista.txtpass.getText());
            if (atributos.getUsername().isEmpty() || atributos.getPassword().isEmpty()) {
                Vista.lblestatus.setText("INGRSE SU USUARIO Y CONTRASEÑA");
            } else {
                if (Modelo.ConsultaLogin(atributos)) {
                    Vista.rSPanelsSlider2.setPanelSlider(1, Vista.pnlCargando, RSPanelsSlider.DIRECT.RIGHT);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                                Vista.dispose();
                                PrincipalBo ModeloPrincipal = new PrincipalBo();
                                Principal ventanaprincipal = new Principal();
                                ventanaprincipal.setVisible(true);
                                new PrincipalController(ventanaprincipal, ModeloPrincipal, Vista.txtuser.getText());
                            } catch (InterruptedException e) {

                            }
                        }
                    }).start();
                } else {
                    Vista.lblestatus.setText("Usuario y/o Contraseña Incorrectos");
                }
            }
        } else if (e.getSource() == Vista.btncerrar) {
            System.exit(0);
        } else if (e.getSource() == Vista.btnminimizar) {
            Vista.setExtendedState(ICONIFIED);
        }

    }
}
