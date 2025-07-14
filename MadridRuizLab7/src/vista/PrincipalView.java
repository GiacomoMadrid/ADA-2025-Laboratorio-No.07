/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Giacomo
 */
import javax.swing.*;
import java.awt.*;

public class PrincipalView extends JFrame {
    private JButton btnAgregarCliente;
    private JButton btnBuscarCliente;
    private JButton btnCompararMetodos;
    private JButton btnSalir;

    public PrincipalView() {
        setTitle("Gestión de Clientes con Tabla Hash");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        btnAgregarCliente = new JButton("Agregar Cliente");
        btnAgregarCliente.setBackground(new Color (0,0,182));
        
        btnBuscarCliente = new JButton("Buscar Cliente");
        btnBuscarCliente.setBackground(new Color (0,0,182));
        
        btnCompararMetodos = new JButton("Comparar Métodos Hash");
        btnCompararMetodos.setBackground(new Color (0,0,182));
        
        btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color (0,0,182));
        
        panel.add(btnAgregarCliente);
        panel.add(btnBuscarCliente);
        panel.add(btnCompararMetodos);
        panel.add(btnSalir);
        
        add(panel);
    }

    public JButton getBtnAgregarCliente() { 
        return btnAgregarCliente; 
    }
    public JButton getBtnBuscarCliente() { 
        return btnBuscarCliente; 
    }
    public JButton getBtnCompararMetodos() { 
        return btnCompararMetodos; 
    }
    public JButton getBtnSalir() { 
        return btnSalir; 
    }
}
