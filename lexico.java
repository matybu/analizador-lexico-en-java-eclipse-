package ejercicio;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer; 

public class lexico {
	
	public static void main (String []arg)
	{ 
		File arch; 
		FileWriter arch2; 
		BufferedWriter arch3; 
		try 
		{ 
			char[] arreglo3=new char[64]; 
			String [] fun =new String[6]; 
			fun[0]="AVG"; 
			fun[1]="SUM"; 
			fun[3]="MAX"; /*funciones del lenguaje*/
			fun[4]="COUNT";
			fun[5]="MIN";
			
			char [] caracter=new char[3]; 
			arch=new File("simbolos.txt"); 
			arch2=new FileWriter(arch);
			arch3=new BufferedWriter(arch2); 
			new PrintWriter(arch3); 
			
			char [] sim=new char[13]; 
			sim[0]='(';
			sim[1]=')'; 
			sim[2]='='; 
			sim[3]='!'; 
			sim[4]=':'; 
			sim[5]='>'; 
			sim[6]=';'; 
			sim[7]='<';  /*simbolos del lenguaje*/
			sim[8]='/';
			sim[9]='+'; 
			sim[10]='-';
			sim[11]='*'; 
			sim[12]=','; 
			
			String [] arreglo2=new String[13]; 
			arreglo2[0]="create"; 
			arreglo2[1]="table"; 
			arreglo2[2]="if"; 
			arreglo2[3]="select"; /*palabra reservada del lenguaje*/
			arreglo2[4]="from"; 
			arreglo2[5]="and"; 
			arreglo2[6]="or";
			arreglo2[7]="ORDER";
			arreglo2[10]="WHERE";
			arreglo2[11]="BY";
			arreglo2[12]="GROUP";
			
			
			System.out.println("INGRESE UNA CADENA");
			Scanner entr=new Scanner (System.in); 
			String cad; 
			cad=entr.nextLine();
			String txt2; 
			txt2=cad;
			
			
			/*escribe en un archivo de txt los simbolos especiales que corresponde al lenguaje sql*/
			for (int j=0; j<cad.length(); j++)
			{ 
				for (int x=0; x<13; x++)
				{ 
					if (cad.charAt(j)==sim[x])
					{ 
						arch3.append(cad.charAt(j)); 
					}
					
				}
				}
			
			
			
			arch3.close(); 
			arch2.close(); 
			
			/*recorre la cadena caracter a caracter y elimina los simbolos especiales*/
			
			for (int i=0; i<cad.length();i++)
			{ 
				switch(cad.charAt(i))
				{ 
				case '(': 
				{ 
					cad=cad.replace("(", " "); 
					i=0; 
					break; 
				}
				case ')': 
				{ 
					cad=cad.replace(")", " "); 
					i=0; 
					break; 
				}
				case '=': 
				{ 
					cad=cad.replace("=", " "); 
					i=0;
					break; 
				}
				case '!': 
				{ 
					cad=cad.replace("!", " "); 
					i=0;
					break; 
				}
				case '<': 
				{ 
					cad=cad.replace("<", " "); 
					i=0;
					break; 
				}
				case '>': 
				{ 
					cad=cad.replace(">", " "); 
					i=0;
					break; 
				}
				case ':': 
				{ 
					cad=cad.replace(":", " "); 
					i=0;
					break; 
				}
				case ';': 
				{ 
					cad=cad.replace(";", " "); 
					i=0;
					break;
				}
				case '+': 
				{ 
					cad=cad.replace("+", " "); 
					i=0;
					break;
				}
				case '/': 
				{ 
					cad=cad.replace("/", " "); 
					i=0;
					break;
				}
				case '-': 
				{ 
					cad=cad.replace("-", " "); 
					i=0;
					break;
				}
				case '*': 
				{ 
					cad=cad.replace("*", " "); 
					i=0;
					break;
				}
				case ',': 
				{ 
					cad=cad.replace(",", " "); 
					i=0;
					break;
				}
				}
			}
			String arreglo[]=cad.split(" "); /*declaro un arreglo que va a contener un conjunto de caracteres separado por el 
			 									delimitador espacio en blanco*/

			File func; 
			FileWriter func2; 
			BufferedWriter func3; 
			PrintWriter func4; 
			
			func=new File("funciones.txt"); 
			func2=new FileWriter(func); 
			func3=new BufferedWriter(func2); 
			func4=new PrintWriter(func3); 
			
			System.out.println("\nFUNCIONES SOBRE CAMPOS AGREGADOS");
			
			/*almacena en un archivo txt las funciones del lenguaje sql y lo elimina de la variable e entrada con la funcion replace*/
			for (int j=0; j<arreglo.length; j++)
			{ 
				for (int x=0; x<6; x++)
				{ 
					if (arreglo[j].equalsIgnoreCase(fun[x]))
					{ 
						func3.append(arreglo[j]+"  TOKEN_"+arreglo[j]); 
						cad=cad.replace(arreglo[j], " ");
					}
				}
			}
			
			func3.close(); 
			func2.close();
			
			File abrir; 
			FileReader abrir2; 
			BufferedReader abrir3; 
			
			abrir=new File("funciones.txt"); 
			abrir2=new FileReader(abrir); 
			abrir3=new BufferedReader(abrir2);
			String entr3; 
			/*imprime las funciones el lenguaje sql*/
			while ((entr3=abrir3.readLine())!=null)
			{ 
				System.out.println(entr3.toUpperCase());
			}
			
			abrir2.close(); 
			abrir3.close(); 
			System.out.println("\nPALABRA RESERVADA");	
			/*imprime las palabras reservadas*/ 
			for (int j=0; j<arreglo.length;j++)
			{ 
				for (int x=0; x<13;x++)
				{ 
					if (arreglo[j].equalsIgnoreCase(arreglo2[x]))
					{ 
						System.out.println("TOKEN_"+arreglo[j].toUpperCase());
						cad=cad.replace(arreglo[j], " ");
					}
				}
			}
			/*imprime los identificadores*/
			System.out.println("\nIDENTICADORES");
			StringTokenizer letra=new StringTokenizer(cad); 
			while(letra.hasMoreTokens())
			{ 
				System.out.println("TOKEN_"+letra.nextToken().toUpperCase());
			}
			
			int numero; 
			File nuevo; 
			FileReader nuevo2; 
			BufferedReader nuevo3; 
			
			nuevo=new File ("simbolos.txt"); 
			nuevo2=new FileReader (nuevo); 
			nuevo3=new BufferedReader(nuevo2); 
			
			System.out.println("\nSIMBOLOS ESPECIALES");
			char aux; 
			aux=' '; 
	
			
			
			/*la siguiente instruccion muestra los simbolos especiales (tokens)
			 **/
			while ((numero=nuevo3.read())!=-1)
				{ 
				   char c=(char) numero;									
				   
				   
					switch(c)
					{ 
					case '(': 
					{ 
						 System.out.println(""+c+" TOKEN PARENTESIS DE APERTURA");
						 																
						 break;
					}
					case ')': 
					{ 
						System.out.println(""+c+" TOKEN PARENTESIS DE CIERRE");
						
						 break;
					} 
					case '=': 
					{  
						caracter[2]='=';
						 break;
					}
					case '!': 
					{ 
						aux='!'; 
						 break;
					}
					case '<': 
					{ 
						caracter[0]='<'; 
						aux='<'; 
						 break;
					}
					case '>': 
					{ 
						
						caracter[1]='>'; 
						 aux='>'; 
						 break;
					}
					case ':': 
					{ 
						aux=':';
						 break;
					}
					case ';': 
					{ 
						System.out.println(""+c+" TOKEN PUNTO Y COMA");
						
						 break;
					}
					case '+': 
					{ 
						System.out.println(""+c+" TOKEN OPERACION SUMA");
					
						 break;
					}
					case '/': 
					{ 
						System.out.println(""+c+" TOKEN OPERACION DIVISION");
						 break;
					}
					case '-': 
					{ 
						System.out.println(""+c+" TOKEN OPERACION RESTA");
						
						 break;
					}
					case '*': 
					{ 
						System.out.println(""+c+" TOKEN OPERACION MULTIPLICACION");
						
						 break;
					}
					case ',': 
					{ 
						System.out.println(""+c+" TOKEN COMA");
						
						 break;
					}
					}
					if ((aux== ':') && (c=='='))
					   { 
						   
						   System.out.print(""+aux+c+"TOKEN_ASIGNACION\n");
						   aux=' '; 
					   }
					   else 
					   { 
						   if (aux=='!' && c=='=')
						   { 
							  
							   System.out.println(""+aux+c+" TOKEN_DISTINTO "); 
							   aux=' '; 
							   
						   }else 
						   { 
							  if (aux=='>'&& c=='=')
							  { 
							
								  System.out.println( ""+aux+c+" TOKEN_MAYOR IGUAL QUE"); 
								  caracter[1]=' '; 
								  caracter[2]=' '; 
								  System.out.println(caracter[2]);
								  aux= ' '; 
							  }else 
							  { 
								  if (aux=='<'&& c=='=')
								  { 
									  System.out.println(""+aux+c+" TOKEN_MENOR IGUAL QUE");
									  aux=' '; 
									  caracter[0]= ' '; 
									  caracter[2]= ' '; 
								  }
							  }
							  
						   }
					   }
                     }
			
			 /*muestra los operadores relacionales que pueden aparecer combinado con otro operador relacional o solo*/ 
			
				for (int j=0; j<3; j++)
				{ 
					{ 
						if (caracter[j]=='>')
						{ 
							System.out.println(""+caracter[j]+" TOKEN MAYOR QUE");
						}else 
						{  
							if (caracter[j]=='<')
							{
								System.out.println(""+caracter[j]+" TOKEN MENOR QUE");
							}else 
							{ 
								if (caracter[j]=='=')
								{ 
								System.out.println(""+caracter[j]+" TOKEN IGUAL");
								}
							}
							
						}
					}
				}
			
			
			
			
			
			nuevo2.close(); 
			nuevo3.close(); 
			
			
			
				
		}
		catch(Exception ex)
		{ 
		  System.out.println("Error"); 
		}
		
		 	
		
		}
		

}
