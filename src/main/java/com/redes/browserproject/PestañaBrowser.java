/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redes.browserproject;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author NiAS
 */
public class PestañaBrowser extends JPanel{

    
    public TcpClient conexion;
    public String codigohtml;
    
    public PestañaBrowser(){
        conexion= new TcpClient();
    }
    
    public String crearConexion(String host){
        codigohtml=conexion.initClient(host);
        return codigohtml;
    }
}
