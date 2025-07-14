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

public class BuscarClienteView extends JFrame {
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JButton btnBuscar;
    private JButton btnCancelar;
    private JTextArea txtResultado;

    public BuscarClienteView() {
        setTitle("Buscar Cliente");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel panelBusqueda = new JPanel(new GridLayout(3, 2, 10, 10));
        panelBusqueda.add(new JLabel("Nombres:"));
        txtNombres = new JTextField();
        panelBusqueda.add(txtNombres);
        
        panelBusqueda.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panelBusqueda.add(txtApellidos);
        
        btnBuscar = new JButton("Buscar");
        panelBusqueda.add(btnBuscar);
        
        btnCancelar = new JButton("Cancelar");
        panelBusqueda.add(btnCancelar);
        
        panel.add(panelBusqueda, BorderLayout.NORTH);
        
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        add(panel);
    }

    public String getNombres() { return txtNombres.getText(); }
    public String getApellidos() { return txtApellidos.getText(); }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnCancelar() { return btnCancelar; }

    public void mostrarResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}