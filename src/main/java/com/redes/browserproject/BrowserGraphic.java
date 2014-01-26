/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redes.browserproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author NiAS
 */
public class BrowserGraphic extends JFrame implements ActionListener{
    
    public JButton google, facebook, twitter, youtube;
    private ImageIcon googleIcon,facebookIcon,twitterIcon, youtubeIcon;
    private JPanel favoritos, pestañas;
    private JEditorPane paginaWeb;
    public Browser browsearch;
        
    public BrowserGraphic(Browser browsearch){
        super("Browsearch");  
        this.browsearch=browsearch;
        this.setLayout(new BorderLayout());
        browserGraphic();        
    }   
    
    public void browserGraphic(){
        inicializarComponentes();
        editarComponentes();
        agregarComponentes();
        agregarListenersComponentes();
        caracteristicasBasicasJFrame(); 
    }
   
    public void inicializarComponentes(){
        googleIcon = new ImageIcon("src/main/resources/minimizarIcon.png");
        facebookIcon = new ImageIcon("src/main/resources/maximizarIcon.png");
        twitterIcon = new ImageIcon("src/main/resources/cerrarIcon.png");
        youtubeIcon = new ImageIcon("src/main/resources/cerrarIcon.png");
        
        google=new JButton(googleIcon);
        facebook=new JButton(facebookIcon);
        twitter=new JButton(twitterIcon);
        youtube=new JButton(youtubeIcon);
        
        favoritos= new JPanel();        
        pestañas= new JPanel();  
        
        paginaWeb=new JEditorPane();
        
    }
    
    public void editarComponentes(){
        paginaWeb.setContentType("text/html");
        paginaWeb.setEditable(false);
          
    }
    
    
    public void agregarComponentes(){
        favoritos.add(google);favoritos.add(facebook);favoritos.add(twitter);favoritos.add(youtube);
        
        
        this.getContentPane().add(favoritos, BorderLayout.NORTH);
        this.getContentPane().add(new JScrollPane(paginaWeb), BorderLayout.CENTER);
        this.getContentPane().add(pestañas, BorderLayout.SOUTH);
    }
    
        
    
    public void agregarListenersComponentes(){
        google.addActionListener(this);
        facebook.addActionListener(this);
        twitter.addActionListener(this);
        youtube.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==google){       
            paginaWeb.setContentType("text/html");
            
            paginaWeb.setText(this.browsearch.pestaña.crearConexion("www.google.com.ec"));
            System.out.println("comienzo encabezado"+browsearch.pestaña.conexion.codigocabecera);
            System.out.println("comienzo html"+browsearch.pestaña.codigohtml);
        }
        if(e.getSource()==facebook){
            JOptionPane.showMessageDialog(null, e.getActionCommand());
        }
        if(e.getSource()==twitter){
            JOptionPane.showMessageDialog(null, e.getActionCommand());
        }
        if(e.getSource()==youtube){
            paginaWeb.setContentType("text/html");            
            paginaWeb.setText(this.browsearch.pestaña.crearConexion("www.youtube.com"));
        }
    }

    public void caracteristicasBasicasJFrame(){          
        //setUndecorated(true);
        //Tamaño
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-40 );
        //Si es visible o no
        setVisible(true);
        //Cerrar todo   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}
