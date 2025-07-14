/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Giacomo
 */
import modelo.TablaHashArbol;
import modelo.TablaHashLineal;
import vista.ComparacionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComparacionController {
    private ComparacionView vista;
    private TablaHashLineal modeloLineal;
    private TablaHashArbol modeloArbol;

    public ComparacionController(ComparacionView vista, TablaHashLineal modeloLineal, TablaHashArbol modeloArbol) {
        this.vista = vista;
        this.modeloLineal = modeloLineal;
        this.modeloArbol = modeloArbol;
        
        mostrarComparacion();
        
        this.vista.getBtnCerrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
            }
        });
    }

    private void mostrarComparacion() {
        StringBuilder comparacion = new StringBuilder();
        
        comparacion.append("COMPARACIÓN DE MÉTODOS DE RESOLUCIÓN DE COLISIONES\n\n");
        
        comparacion.append("1. Reasignación Lineal:\n");
        comparacion.append("   - Ventajas:\n");
        comparacion.append("     * Implementación simple\n");
        comparacion.append("     * Buen rendimiento cuando la tabla no está muy llena\n");
        comparacion.append("   - Desventajas:\n");
        comparacion.append("     * Puede sufrir de agrupamiento primario\n");
        comparacion.append("     * El rendimiento se degrada cuando la tabla se llena\n");
        comparacion.append("   - Complejidad Asintótica:\n");
        comparacion.append("     * Inserción: O(1) caso promedio, O(n) peor caso\n");
        comparacion.append("     * Búsqueda: O(1) caso promedio, O(n) peor caso\n\n");
        
        comparacion.append("2. Encadenamiento con Árbol Binario:\n");
        comparacion.append("   - Ventajas:\n");
        comparacion.append("     * Maneja mejor las colisiones múltiples\n");
        comparacion.append("     * Tiempos de búsqueda más consistentes\n");
        comparacion.append("   - Desventajas:\n");
        comparacion.append("     * Implementación más compleja\n");
        comparacion.append("     * Mayor uso de memoria por los nodos del árbol\n");
        comparacion.append("   - Complejidad Asintótica:\n");
        comparacion.append("     * Inserción: O(1) para hash + O(log k) para insertar en árbol\n");
        comparacion.append("     * Búsqueda: O(1) para hash + O(log k) para buscar en árbol\n");
        comparacion.append("     (donde k es el número de colisiones en esa posición)\n\n");
        
        comparacion.append("RECOMENDACIÓN:\n");
        comparacion.append("El método de encadenamiento con árboles binarios es mejor cuando se esperan\n");
        comparacion.append("muchas colisiones, ya que mantiene tiempos logarítmicos de búsqueda incluso\n");
        comparacion.append("con múltiples colisiones en la misma posición de la tabla hash.\n");
        
        vista.setComparacion(comparacion.toString());
    }
    
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}