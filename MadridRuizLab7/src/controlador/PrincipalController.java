/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Giacomo
 */
import vista.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.TablaHashArbol;
import modelo.TablaHashLineal;
import vista.AgregarClienteView;
import vista.BuscarClienteView;
import vista.ComparacionView;

public class PrincipalController {
    private PrincipalView vista;
    private TablaHashLineal modeloLineal;
    private TablaHashArbol modeloArbol;
    private AgregarClienteController contAgregar;
    private BuscarClienteController contBuscar;
    private ComparacionController contComparacion;

    public PrincipalController(PrincipalView vista, TablaHashLineal modeloLineal, TablaHashArbol modeloArbol) {
        this.vista = vista;
        this.modeloLineal = modeloLineal;
        this.modeloArbol = modeloArbol;
        
        this.vista.getBtnAgregarCliente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAgregarCliente();
            }
        });
        
        this.vista.getBtnBuscarCliente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirBuscarCliente();
            }
        });
        
        this.vista.getBtnCompararMetodos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirComparacion();
            }
        });
        
        this.vista.getBtnSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void abrirAgregarCliente() {
        if(contAgregar == null){
            contAgregar = new AgregarClienteController(new AgregarClienteView(), modeloLineal, modeloArbol);
        }
        contAgregar.iniciar();
        this.vista.dispose();
    }

    private void abrirBuscarCliente() {
        if(contBuscar == null){
            contBuscar = new BuscarClienteController(new BuscarClienteView(), modeloLineal, modeloArbol);
        }
        contBuscar.iniciar();
        this.vista.dispose();
    }

    private void abrirComparacion() {
        if(contComparacion == null){
            contComparacion = new ComparacionController(new ComparacionView(), modeloLineal, modeloArbol);
        }
        contComparacion.iniciar();
        this.vista.dispose();
    }

    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}