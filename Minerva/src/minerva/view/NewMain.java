package minerva.view;

import minerva.controller.LoginController;

/**
 *
 * @author L
 */
public class NewMain {
    public static void main(String[] args) {        
        boolean a = LoginController.validarCredenciales("admin", "1234");
    }
    
}
