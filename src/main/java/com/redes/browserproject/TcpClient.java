/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redes.browserproject;

/**
 *
 * @author NiAS
 */
import java.io.*;
import java.net.*;

public class TcpClient {
    public String host = "localhost";
    final int PUERTO=80;
    Socket socket=null;
    PrintWriter request;
    String codigocabecera="",codigohtml="";
    
    //Cliente
    public String initClient(String host){
        this.host=host;
            try{  
                socket=new Socket (host, PUERTO);  
                
                //HACER EL HTTP REQUEST AL WEB SERVER
                httpRequest();         
                //LEER EL INDEX
                codigoRecibidoWebServer();
                
                socket.close();
                return codigohtml;
            }catch(IOException e){
                return("error"+e.toString());
            }         
    }
    
    public void httpRequest() throws IOException{
        request = new PrintWriter(socket.getOutputStream());
        request.print("GET "+"/"+" HTTP/1.1\r\n"+"Host: "+host+"\r\n"+"Connection: close\r\n\r\n"); 
        request.flush( );
    }
    
    public String codigoRecibidoWebServer() throws IOException{
        boolean html=false;
        InputStream inStream = socket.getInputStream( ); 
        BufferedReader rd = new BufferedReader( new InputStreamReader(inStream));
        String line;
        
        while ((line = rd.readLine()) != null) { 
            if(!html && (line.contains("<!DOCTYPE") || line.contains("<html"))){
                html=true;
            }
            if(!html){
                codigocabecera+=(line+"\n");
            }else{
                codigohtml+=(line+"\n");
            }   
        }       
        return codigohtml;        
                
    }

}