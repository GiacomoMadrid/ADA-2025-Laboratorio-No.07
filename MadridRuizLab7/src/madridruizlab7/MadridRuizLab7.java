/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package madridruizlab7;

import controlador.PrincipalController;
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
        
        // Crear modelos
        TablaHashLineal modeloLineal = new TablaHashLineal(capacidadInicial);
        TablaHashArbol modeloArbol = new TablaHashArbol(capacidadInicial);
        
        // Crear vista principal
        PrincipalView vista = new PrincipalView();
        
        // Crear controlador principal
        PrincipalController cont = new PrincipalController(vista, modeloLineal, modeloArbol);
        cont.iniciar();
        
        // Mostrar la vista principal
        vista.setVisible(true);
    }
}
    
