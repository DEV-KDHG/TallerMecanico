/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;
import Conexion.Conections;
import Gui.ServicesMenu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CLogin {

    public void validationUser(JTextField user, JPasswordField password) {
        try {
            ResultSet res = null;
            PreparedStatement ps = null;
            Conections ConnectionObject = new Conections();
            String consult = "SELECT * FROM users WHERE users.ingresoUusuario = ? AND users.ingresoContraseña = ?";
            
            // Create a connection and prepared statement
            ps = ConnectionObject.EstableceConexion().prepareStatement(consult);
            
            // Set parameters for the prepared statement
            ps.setString(1, user.getText());
            ps.setString(2, String.valueOf(password.getPassword()));
            
            // Execute the query
            res = ps.executeQuery();
JPanel panel = new JPanel();

            if (res.next()) {
  JOptionPane.showMessageDialog(panel, "<html><body><p style='text-align:center'>The user is correct</p></body></html>");
                ServicesMenu servicesMenu = new ServicesMenu();
                servicesMenu.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "The user is incorrect, please try again");
            }
            
            // Close the resources (result set, statement, and connection)
            if (res != null) {
                res.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (ConnectionObject != null) {
                ConnectionObject.EstableceConexion().close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }
    }
}
