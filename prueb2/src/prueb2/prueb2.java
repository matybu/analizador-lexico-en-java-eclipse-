package prueb2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class prueb2 {
      
public static void main  (String []arg) { 
		
		File leer; 
		FileReader leer2; 
		BufferedReader leer3;
		
		File esc; 
		FileWriter esc2; 
		PrintWriter esc3; 
		BufferedWriter esc4; 
		
		File af; 
		FileReader ar; 
		BufferedReader br; 
		
		try 
		{ 
			
			
			leer=new File ("Palabras.txt"); 
			  leer2=new FileReader (leer); 
			  leer3=new BufferedReader(leer2); 
			  
			  esc=new File("simbolos.txt"); 
			  esc2=new FileWriter(esc); 
			  esc3=new PrintWriter(esc2); 
			  esc4=new BufferedWriter(esc3);
			  
			  String text; 
			  System.out.println("INGRESE UNA CADENA\n");
			  Scanner cadena=new Scanner (System.in); 
			  String entr=cadena.nextLine();
			  String[] arreglo=entr.split(""); 
			  int po=0; 
			  int cont2,cont4, cont=0;  
			  cont4=0; 
			   cont2=0; 
			  for (int x=0; x<arreglo.length;x++)
			  { 
				  for (int j=0; j<arreglo[x].length(); j++)
				  { 
					  int ascii =(int) arreglo[x].charAt(j); 
					  
				
					  if (ascii>=39 && ascii<=62 || ascii==46)
					  {  
						 
						 continue; 
					  }else 
					  { 
						  if (ascii>=65 && ascii<=90)
						  { 
							  
							  continue;
						  }else 
						  { 
							  if (ascii>=97 && ascii<=121  || ascii==32 )
							  { 
								  continue; 
							  }else 
							  { 
								  { 
									  System.out.println("EL SIMBOLO "+ arreglo[x].charAt(j)+ " NO ESTA PERMITIDO");
									  cont=1; 
									  cont2=cont2+1;
								  }
							  }
						  }
					  }
				  }
			  }
			  
			  if (entr!=null)
			  { 
				  cont=1; 
			  }
				  
			  
		if (cont==0 && entr!=null)	
		{ 
			  for(int x=0; x<arreglo.length; x++)
			  { 
				 
				  for (int i=0; i<arreglo[x].length(); i++)
				  { 
					  switch(arreglo[x].charAt(i))
					  { 
					  case '(': 
					  { 
						  esc3.println(" "); 
						  esc3.println("TOKEN PARENTESIS DE APERTURA ( ");
						  
						  break; 
					  } 
					  case ')': 
					  { 
						  esc3.println(" "); 
						  esc3.println("TOKEN PARENTESIS DE CERRE  ) ");
						  break;   
					  }   
					  case ';': 
					  { 
						  esc3.println(" "); 
						  esc3.println("TOKEN PUNTO Y COMA  ; ");
						  break; 
					  } 
					  case ',': 
					  { 
						  esc3.println(" "); 
						  esc3.println("TOKEN COMA , ");
						  break; 
					  } 
					  case '=': 
					  { 
						  esc3.println(" "); 
						  esc3.println("TOKEN IGUAL  = ");
						  break; 
					  } 
					  case '<': 
					  { 
						  esc3.println(" "); 
						  esc3.println("TOKEN MENOR QUE  < ");
						  break; 
					  } 
					  case '>': 
					  { 
						  esc3.println(" "); 
						  esc3.println("TOKEN MAYOR QUE  > ");
						  break; 
					  } 
					  
					  default: 
					  { 
						 int  ascii =(int) arreglo[x].charAt(i); 
						  
						 if (ascii==32)
						 { 
							 esc3.println(" ");
							 continue; 
						 }else 
						 { 
							 if (ascii==39)
							 { 
								 esc3.print(arreglo[x].charAt(i)); 
								 cont4=cont4+1; 
							 
							 if (cont4==2)
							 { 
								 
								 cont4=0; 
								 esc3.println(" "); 
							 }
							}else 
							{ 
								esc3.print(arreglo[x].charAt(i));
							}
								
								
						 }
					  }
					  
					  }
				  }
				  
			
			  }
			  esc3.println(" ");
			  
			   esc3.close();
			   esc2.close();
			  af=new File("simbolos.txt"); 
			  ar=new FileReader(af); 
			  br=new BufferedReader(ar);
			  int aux; 
			  
			   
			  while ((text=br.readLine())!=null)
			  { 
				  leer=new File ("Palabras.txt"); 
				  leer2=new FileReader (leer); 
				  leer3=new BufferedReader(leer2); 
				  String re;
				   cont4=0; 
				   boolean con;  con=true;
				  while((re=leer3.readLine())!=null)
				  { 
					  aux=0;
					
					  if (text.toUpperCase().contains(re))
					  {
						 
						  if (text.equalsIgnoreCase(" "))
						  { 
							  continue; 
						  }else 
						  { 
							   System.out.println("PALABRAS RESERVADAS TOKEN_"+text.toUpperCase()+"\n");
							
					
						  }
						  
					  }
					  else
						  
					  	{ 
							if (text.contains("TOKEN"))
							{ 
								System.out.println("SIMBOLO ESPECIAL");
								System.out.println(text.toUpperCase()+"\n");
								text=" ";
								 
							}else 
							{ 
								for (int x=0; x<text.length()-1;x++)
								{ 
									int ascii=(int) text.charAt(x); 
									
									if (ascii==46)
									{ 
										aux=ascii; 
										continue; 
									}	
									
									
									if (ascii==39)
									{ 
										cont4=cont4+1; 
										con=false; 
									}else 
									{ 
										if (ascii>=48 && ascii<=57)
										{ 
										
											continue; 
										}else 
										{ 
											con=false; 
										}
									}
								}
							
								
								
								
								if (cont4==2)
								{ 
									System.out.println("CADENA DE CARACTERES STRING "+text+"\n");
									
									
									
									text=" "; 
									cont4=0; 
									
								}else 
								{ 
									if (cont4==1)
									{ 
										System.out.println("(ERROR FALTA CERRAR APOSTROFE ' ) ");
										System.out.println("CADENA INCORRECTA: "+text);
										text=" "; 
										cont4=0; 
									}else 
									{ 
										if (con==true && text.length()>1)
										{ 
											
											if (text.charAt(text.length()-2)=='.' || (text.charAt(0)=='.'))
											{
												System.out.println("CONSTANTE NUMERICA NO VALIDA "+text+"\n");
												text=" ";
											}else 
											{ 
												System.out.println("CONSTANTE NUMERICA "+text+"\n");
												con=false; 
												
												    if (aux==46)
														{ 
															System.out.println("TOKEN PUNTO ."+"\n");
															text=" ";
														}
											} 
											
										}
									
									}
								}
							}
						}
					
				  }
				  leer3.close(); 
				  leer2.close(); 
			  }
		}else 
		{ 
			if (entr!=null)
			{ 
				System.out.println("CADENA VACIA");
				
			}else 
			{ 
			System.out.println("\nCORRIJA LA CADENA \n");
			System.out.println("CANTIDAD DE ERRORES "+cont2);
			}
		}
		
			  
			
			 
		}catch(Exception ex)
		{ 
			System.out.println("ERROR");
		}
}
}
