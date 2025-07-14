/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package madridruizlab7;

import controlador.PrincipalController;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import modelo.TablaHashArbol;
import modelo.TablaHashLineal;
import vista.PrincipalView;

/**
 *
 * @author Giacomo
 */
public class MadridRuizLab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        int capacidadInicial = 20;
        
        TablaHashLineal modeloLineal = new TablaHashLineal(capacidadInicial);
        TablaHashArbol modeloArbol = new TablaHashArbol(capacidadInicial);
        
        PrincipalController cont = new PrincipalController(new PrincipalView(), modeloLineal, modeloArbol);
        cont.iniciar();
    }
}
    
