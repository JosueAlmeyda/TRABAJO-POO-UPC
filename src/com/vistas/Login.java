package com.vistas;

import javax.swing.*;

public class Login {
    private static Login login = new Login();
    private JPanel myLogin;
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldPass;
    private JButton ingresarButton;
    private JButton exitButton;
    private JFrame frame = new JFrame();
    private Portal portal;

    private Login(){
            ingresarButton.addActionListener(e -> login());
            exitButton.addActionListener(e ->System.exit(0));
    }

        public void login(){
            //boolean validar = empresa.validarLogin(textUser.getText(),textPass.getText());
            boolean validar = true;
            if (textFieldUsuario.getText().equals("admin")&& passwordFieldPass.getText().equals("1234")){
                JOptionPane.showMessageDialog( null, "Bienvenido Administrador");
                portal = Portal.getInstance();
                portal.load();
            } else JOptionPane.showMessageDialog( null, "Inicio de sesión incorrecto");
        }

        public static Login getInstance(){
            return login;
        }

        public void load(){
            this.frame.add(myLogin); // agregar panel al objeto
            this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
            this.frame.setUndecorated(false); // mostrar ventanas windows
            this.frame.pack();  //mostrar contenido
            this.frame.setLocationRelativeTo(null); //mostrar al centro
            this.frame.setVisible(true);    // que sea visible
            this.frame.setResizable(false); // bloqueo cambiar tamaño de ventana
            this.frame.setSize(485,350);
        }
    }

