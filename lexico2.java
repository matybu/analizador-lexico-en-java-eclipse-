package ejercicio;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer; 

public class lexico {
	
	public static void main (String []arg)
	{ 
		File leer; 
		FileReader leer2; 
		BufferedReader leer3; 
		try 
		{ 
		  leer=new File ("Palabras.txt"); 
		  leer2=new FileReader (leer); 
		  leer3=new BufferedReader(leer2); 
		  String text; 
		  
		  Scanner cadena=new Scanner (System.in); 
		  String entr=cadena.nextLine();
		  String[] arreglo=entr.split(" "); 
		  int est;
		  while ((text=leer3.readLine())!=null)
		  { 
			  for (int x=0; x<arreglo.length; x++)
			  { 
				   est=x+1; 
				  if (text.contains(arreglo[x]))
				  {  
					    
					     System.out.println("PALABRAS RESERVADA");
						 System.out.println("TOKEN_"+arreglo[x]+" POSICION: "+est+"\n");	 
					 }else 
					 { 
						 System.out.println("IDENTIFICADOR:\n"+arreglo[x]+" POSICION: "+est+"\n");
					 }
					 
					 
				  }
			  }
		  
		  
		  leer3.close(); 
		  leer2.close(); 
		  
		}
		catch(Exception ex)
		{ 
			System.out.println("ERROR");
		}
	}
}