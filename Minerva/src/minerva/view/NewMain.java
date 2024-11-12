/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minerva.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import minerva.model.Producto;
import minerva.model.ProductoDTO;

/**
 *
 * @author L
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (ProductoDTO productoDTO : Producto.listarProductoDTO()) {
                System.out.println(productoDTO.getNombre());
            }
            System.out.println("CREO QUE SI HAY ALGO");
        } catch (Exception ex) {
            System.out.println("NO HAY NADADADADADA");
        }
    }
    
}
