package minerva.view;

import minerva.controller.LoginController;

/**
 *
 * @author L
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        boolean a = LoginController.validarCredenciales("admin", "1234");
        System.out.println(a);
    }
    
}
