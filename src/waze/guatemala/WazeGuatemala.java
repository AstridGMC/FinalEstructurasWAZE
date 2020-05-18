/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waze.guatemala;

import UI.Principal;

/**
 *
 * @author astridmc
 */
public class WazeGuatemala {
static int numero;
static String direccionPng = "nada.png";
static String direccionDot="nada.dot";
    /**
     * @param arg
     */
    public static void main(String []arg) {
        //dibujar( "/home/astridmc/NetBeansProjects/Waze Guatemala/src/UI/Imagenes/dibujo.dot",  "/home/astridmc/NetBeansProjects/Waze Guatemala/nada.png" );
        Principal principal = new Principal();
        principal.setVisible(true);
        
    }
	
    public static  void dibujar( String direccionDot, String direccionPng ){
		try
		{       
			ProcessBuilder pbuilder;
		    
			/*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
			 */
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", direccionPng, direccionDot );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
	}
    
    public static void CalcularMinClaves(int num) {
    if (num % 2 != 0) {
        System.out.println(" Impar");
        numero = num/2 +1;
    } else {
        System.out.println("par");
        numero = num/2;
        
    }
}
}
