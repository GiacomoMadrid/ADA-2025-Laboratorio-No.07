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
import vista.AgregarClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarClienteController {
    private AgregarClienteView vista;
    private TablaHashLineal modeloLineal;
    private TablaHashArbol modeloArbol;

    public AgregarClienteController(AgregarClienteView vista, TablaHashLineal modeloLineal, TablaHashArbol modeloArbol) {
        this.vista = vista;
        this.modeloLineal = modeloLineal;
        this.modeloArbol = modeloArbol;
        
        this.vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });
        
        this.vista.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
            }
        });
    }

    private void agregarCliente() {
        String codigo = vista.getCodigo();
        String nombres = vista.getNombres();
        String apellidos = vista.getApellidos();
        String telefono = vista.getTelefono();
        String correo = vista.getCorreo();
        String direccion = vista.getDireccion();
        String codigoPostal = vista.getCodigoPostal();
        
        if (codigo.isEmpty() || nombres.isEmpty() || apellidos.isEmpty()) {
            vista.mostrarMensaje("Código, nombres y apellidos son campos obligatorios");
            return;
        }
        
        Cliente nuevoCliente = new Cliente(codigo, nombres, apellidos, telefono, correo, direccion, codigoPostal);
        
        // Insertar en ambos modelos para comparación
        modeloLineal.insertar(nuevoCliente);
        modeloArbol.insertar(nuevoCliente);
        
        vista.mostrarMensaje("Cliente agregado exitosamente!\n" +
                            "Tiempo inserción lineal: " + modeloLineal.getTiempoInsercion() + " ns\n" +
                            "Tiempo inserción árbol: " + modeloArbol.getTiempoInsercion() + " ns");
        
        vista.limpiarCampos();
    }
    
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
