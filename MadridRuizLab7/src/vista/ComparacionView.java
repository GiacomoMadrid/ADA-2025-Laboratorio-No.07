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

public class ComparacionView extends JFrame {
    private JTextArea txtComparacion;
    private JButton btnCerrar;

    public ComparacionView() {
        setTitle("Comparación de Métodos Hash");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        txtComparacion = new JTextArea();
        txtComparacion.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtComparacion);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        btnCerrar = new JButton("Cerrar");
        panel.add(btnCerrar, BorderLayout.SOUTH);
        
        add(panel);
    }

    public void setComparacion(String texto) {
        txtComparacion.setText(texto);
    }

    public JButton getBtnCerrar() { return btnCerrar; }
}
