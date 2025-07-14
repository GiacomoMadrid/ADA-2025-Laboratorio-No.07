/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Giacomo
 */
import modelo.Cliente;
import modelo.TablaHashArbol;
import modelo.TablaHashLineal;
import vista.BuscarClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarClienteController {
    private BuscarClienteView vista;
    private TablaHashLineal modeloLineal;
    private TablaHashArbol modeloArbol;

    public BuscarClienteController(BuscarClienteView vista, TablaHashLineal modeloLineal, TablaHashArbol modeloArbol) {
        this.vista = vista;
        this.modeloLineal = modeloLineal;
        this.modeloArbol = modeloArbol;
        
        this.vista.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });
        
        this.vista.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
            }
        });
    }

    private void buscarCliente() {
        String nombres = vista.getNombres();
        String apellidos = vista.getApellidos();
        
        if (nombres.isEmpty() || apellidos.isEmpty()) {
            vista.mostrarMensaje("Debe ingresar nombres y apellidos para buscar");
            return;
        }
        
        Cliente clienteLineal = modeloLineal.buscar(nombres, apellidos);
        Cliente clienteArbol = modeloArbol.buscar(nombres, apellidos);
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== Resultado con Reasignación Lineal ===\n");
        resultado.append("Tiempo de búsqueda: ").append(modeloLineal.getTiempoBusqueda()).append(" ns\n");
        if (clienteLineal != null) {
            resultado.append(clienteLineal.toString());
        } else {
            resultado.append("Cliente no encontrado");
        }
        
        resultado.append("\n\n=== Resultado con Árbol Binario ===\n");
        resultado.append("Tiempo de búsqueda: ").append(modeloArbol.getTiempoBusqueda()).append(" ns\n");
        if (clienteArbol != null) {
            resultado.append(clienteArbol.toString());
        } else {
            resultado.append("Cliente no encontrado");
        }
        
        vista.mostrarResultado(resultado.toString());
    }
    
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
