/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redes.browserproject;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author NiAS
 */
public class Browser {    
    
    private BrowserGraphic browsearch;
    private JTabbedPane pestañas;
    public PestañaBrowser pestaña;
    private String host;
    
    public Browser(){          
        browsearch= new BrowserGraphic(this);
        crearPestañas();        
        
    }
    
    public void crearPestañas(){
        pestañas= new JTabbedPane();
        pestaña=new PestañaBrowser();
        pestañas.addTab("Browsearch",null, pestaña,null);        
    }
        
}

//esto sirve para cerrar una ventana abierta ventana.dispose();