
package vista;

/**
 *
 * @author Giacomo
 */

import javax.swing.*;
import java.awt.*;


public class AgregarClienteView extends JFrame {
    private JTextField txtCodigo;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JTextField txtDireccion;
    private JTextField txtCodigoPostal;
    private JButton btnAgregar;
    private JButton btnCancelar;

    public AgregarClienteView() {
        setTitle("Agregar Nuevo Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panel.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panel.add(txtCodigo);
        
        panel.add(new JLabel("Nombres:"));
        txtNombres = new JTextField();
        panel.add(txtNombres);
        
        panel.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panel.add(txtApellidos);
        
        panel.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);
        
        panel.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        panel.add(txtCorreo);
        
        panel.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panel.add(txtDireccion);
        
        panel.add(new JLabel("Código Postal:"));
        txtCodigoPostal = new JTextField();
        panel.add(txtCodigoPostal);
        
        btnAgregar = new JButton("Agregar");
        panel.add(btnAgregar);
        
        btnCancelar = new JButton("Cancelar");
        panel.add(btnCancelar);
        
        add(panel);
    }

    // Getters para los campos y botones
    public String getCodigo() { return txtCodigo.getText(); }
    public String getNombres() { return txtNombres.getText(); }
    public String getApellidos() { return txtApellidos.getText(); }
    public String getTelefono() { return txtTelefono.getText(); }
    public String getCorreo() { return txtCorreo.getText(); }
    public String getDireccion() { return txtDireccion.getText(); }
    public String getCodigoPostal() { return txtCodigoPostal.getText(); }
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnCancelar() { return btnCancelar; }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtCodigoPostal.setText("");
    }
}