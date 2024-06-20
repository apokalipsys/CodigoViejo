
/**
 * funciones del calendario perpetuo Moret
 * 
 * @author BOo
 * @version 0.2j
 */
public class Moret
{
	public static boolean correcto = true;
	
	
	public static String test_fecha(int dd,int mm,int ss,int aa) //comprueba error en la fecha ingresada
    {
         String aviso = "";
         
         if( ss== 0 &&aa == 0) 
         {
             aviso = ("El año ingresado es virtual...Existe el año Cero?/n");
         }    
     
         if (4<dd && dd<15 && mm==10 && ss==15 && aa==82)
         {
             aviso = ("Esta fecha no existe, lea sobre la reforma gregoriana del calendario\n");
             correcto = false; 
         }
         
         switch (mm)
         {
          case 1:
          case 3:
          case 5:
          case 7:
          case 8:
          case 10:
          case 12: {   
                        if (dd<=0 || dd>31)
                        {
                             aviso = aviso+("error en el dia\n");
                             correcto = false;
                        }
                   }; break;
          case 4:
          case 6:
          case 9:
          case 11: { 
                        if (dd<=0 || dd>30)
                        {
                             aviso = aviso+("error en el dia\n");
                             correcto = false;
                        }
                   }; break;
          case 2: { 
                       if (dd<=0 || dd>29)
                       {
                            aviso = aviso+("error en el dia\n");
                             correcto = false;
                       }
                  }; break;
          default : { 
                         aviso = aviso+("error en el mes\n");
                             correcto = false;
                    }
     }
     if (correcto)       
        aviso = aviso+("Fecha ingresada correctamente, se comenzara a analizar\n");
     
     return aviso;
        
}//fin test_fecha

public static int tabla1_ab1(int agno) // le da el valor a tablai para años bisiestos (s. 0, 7 y 14)
{
     int devolver = 7;
     
     switch (agno)
     {
          case 0:
          case 28:
          case 56:
          case 84: devolver = 6; break;
          case 12:
          case 40:
          case 68:
          case 96: devolver = 0; break;
          case 24:
          case 52:
          case 80: devolver = 1; break;
          case 8:
          case 36:
          case 64:
          case 92: devolver = 2; break;
          case 20:
          case 48:
          case 76: devolver = 3; break;
          case 4:
          case 32:
          case 60:
          case 88: devolver = 4; break;
          case 16:
          case 44:
          case 72: devolver = 5;break;
     }
     
     return devolver;
}//fin tabla1_b

public static int tabla2_b (int tablaI,int mm)//este le da el valor a tablaii en años bisiestos
{
     int aux = 0;
     
     switch (tablaI)
     {
          case 0:{
                      if (mm==1)
                          aux = 6;
                      else 
                        if (mm==2)
                            aux = 2;
                      else 
                        if (mm==3)
                            aux = 3;
                      else 
                        if (mm==4)
                            aux = 6;
                      else 
                        if (mm==5)
                            aux = 1;          
                      else 
                        if (mm==6)
                            aux = 4;
                      else 
                        if (mm==7)
                            aux = 6;
                      else 
                        if (mm==8)
                            aux = 2;
                      else 
                        if (mm==9)
                            aux = 5;
                      else 
                        if (mm==10)
                            aux = 0;
                      else 
                        if (mm==11)
                            aux = 3;
                      else 
                        if (mm==12)
                            aux = 5;
                 }      break;
          case 1:{
                      if (mm==1){
                       aux = 0;}
                  else if (mm==2){
                       aux = 3;}
                  else if (mm==3){
                       aux = 4;}
                  else if (mm==4){
                       aux = 0;}
                  else if (mm==5){
                       aux = 2;}                
                  else if (mm==6){
                       aux = 5;}
                  else if (mm==7){
                       aux = 0;}
                  else if (mm==8){
                       aux = 3;}
                  else if (mm==9){
                       aux = 6;}
                  else if (mm==10){
                       aux = 1;}
                  else if (mm==11){
                       aux = 4;}
                  else if (mm==12){
                       aux = 6;}} break;
          case 2:{if (mm==1){
                       aux = 1;}
                  else if (mm==2){
                       aux = 4;}
                  else if (mm==3){
                       aux = 5;}
                  else if (mm==4){
                       aux = 1;}
                  else if (mm==5){
                       aux = 3;}          
                  else if (mm==6){
                       aux = 6;}
                  else if (mm==7){
                       aux = 1;}
                  else if (mm==8){
                       aux = 4;}
                  else if (mm==9){
                       aux = 0;}
                  else if (mm==10){
                       aux = 2;}
                  else if (mm==11){
                       aux = 5;}
                  else if (mm==12){
                       aux = 0;}} break;
          case 3:{if (mm==1){
                       aux = 2;}
                  else if (mm==2){
                       aux = 5;}
                  else if (mm==3){
                       aux = 6;}
                  else if (mm==4){
                       aux = 2;}
                  else if (mm==5){
                       aux = 4;}          
                  else if (mm==6){
                       aux = 0;}
                  else if (mm==7){
                       aux = 2;}
                  else if (mm==8){
                       aux = 5;}
                  else if (mm==9){
                       aux = 1;}
                  else if (mm==10){
                       aux = 3;}
                  else if (mm==11){
                       aux = 6;}
                  else if (mm==12){
                       aux = 1;}} break;
          case 4:{if (mm==1){
                       aux = 3;}
                  else if (mm==2){
                       aux = 6;}
                  else if (mm==3){
                       aux = 0;}
                  else if (mm==4){
                       aux = 3;}
                  else if (mm==5){
                       aux = 5;}          
                  else if (mm==6){
                       aux = 1;}
                  else if (mm==7){
                       aux = 3;}
                  else if (mm==8){
                       aux = 6;}
                  else if (mm==9){
                       aux = 2;}
                  else if (mm==10){
                       aux = 4;}
                  else if (mm==11){
                       aux = 0;}
                  else if (mm==12){
                       aux = 2;}} break;
          case 5:{if (mm==1){
                       aux = 4;}
                  else if (mm==2){
                       aux = 0;}
                  else if (mm==3){
                       aux = 1;}
                  else if (mm==4){
                       aux = 4;}
                  else if (mm==5){
                       aux = 6;}          
                  else if (mm==6){
                       aux = 2;}
                  else if (mm==7){
                       aux = 4;}
                  else if (mm==8){
                       aux = 0;}
                  else if (mm==9){
                       aux = 4;}
                  else if (mm==10){
                       aux = 5;}
                  else if (mm==11){
                       aux = 1;}
                  else if (mm==12){
                       aux = 4;}} break;
          case 6:{if (mm==1){
                       aux = 5;}
                  else if (mm==2){
                       aux = 1;}
                  else if (mm==3){
                       aux = 2;}
                  else if (mm==4){
                       aux = 5;}
                  else if (mm==5){
                       aux = 0;}          
                  else if (mm==6){
                       aux = 3;}
                  else if (mm==7){
                       aux = 5;}
                  else if (mm==8){
                       aux = 1;}
                  else if (mm==9){
                       aux = 4;}
                  else if (mm==10){
                       aux = 6;}
                  else if (mm==11){
                       aux = 2;}
                  else if (mm==12){
                       aux = 4;}} break;}
                       
        return aux;
 
 }//fin tabla2_b
 
   
 
public static String print_dia (int dia,int tablaii)//esto imprime el dia que le corresponde a la fecha
 {
      String fecha = "";
      
      switch (dia)
      {
           case 1:
           case 8:
           case 15:
           case 22:
           case 29: switch (tablaii)
                         {
                       	case 1:{
                                	fecha = ("Ese dia fue, es o sera Domingo\n");
                                }; break;
                       	case 2:{
                                 	fecha = ("Ese dia fue, es o sera Lunes\n");
                                }; break;
                       	case 3:{
                                 	fecha = ("Ese dia fue, es o sera Martes\n");
                                }; break;
                       	case 4:{
                                	fecha = ("Ese dia fue, es o sera Miercoles\n");
                                }; break;
                       	case 5:{
                                	fecha = ("Ese dia fue, es o sera Jueves\n");
                                }; break;
                       	case 6:{
                                	fecha = ("Ese dia fue, es o sera Viernes\n");
                                }; break;
                       	case 0:{
                                 	fecha = ("Ese dia fue, es o sera Sabado\n");
                                }; break;
                                              
                         } break;
          case 2:
          case 9:
          case 16:
          case 23:
          case 30: 
                      	switch (tablaii)
                      	{
                         		case 1:{
                                   		fecha = ("Ese dia fue, es o sera Lunes\n");
                                   	   }; break;
                         		case 2:{
                                   		fecha = ("Ese dia fue, es o sera Martes\n");
                                   	    }; break;
                         		case 3:{
                                   		fecha = ("Ese dia fue, es o sera Miercoles\n");
                                   	   }; break;
                         		case 4:{
                                   		fecha = ("Ese dia fue, es o sera Jueves\n");
                                   		}; break;
                         		case 5:{
                                   		fecha = ("Ese dia fue, es o sera Viernes\n");
                                   		}; break;
                         		case 6:{
                                   		fecha = ("Ese dia fue, es o sera Sabado\n");
                                   		}; break;
                         		case 0:{
                                   		fecha = ("Ese dia fue, es o sera Domingo\n");
                                   		}; break;
                                	            
                     	}   break;
         case 3:
         case 10:
         case 17:
         case 24:
         case 31: switch (tablaii)
                    {    
                    case 1:{
                        		fecha = ("Ese dia fue, es o sera Martes\n");
                        	}; break;
                          case 2:{
                         		fecha = ("Ese dia fue, es o sera Miercoles\n");
                         		}; break;
                         case 3:{
                         		fecha = ("Ese dia fue, es o sera Jueves\n");
                         		}; break;
                         case 4:{
                         		fecha = ("Ese dia fue, es o sera Viernes\n");
                         		}; break;
                         case 5:{
                        		 fecha = ("Ese dia fue, es o sera Sabado\n");
                         		};break;
                        case 6:{
                         		fecha = ("Ese dia fue, es o sera Domingo\n");
                         		}; break;
                    case 0:{
                         fecha = ("Ese dia fue, es o sera Lunes\n");
                         };break;
                      
                   } break;
        case 4:
        case 11:
        case 18:
        case 25: switch (tablaii)
                 {
                    case 1:{
                        fecha = ("Ese dia fue, es o sera Miercoles\n");
                        };break;
                    case 2:{
                         fecha = ("Ese dia fue, es o sera Jueves\n");
                         };break;
                    case 3:{
                         fecha = ("Ese dia fue, es o sera Viernes\n");
                         };break;
                    case 4:{
                         fecha = ("Ese dia fue, es o sera Sabado\n");
                         };break;
                    case 5:{
                         fecha = ("Ese dia fue, es o sera Domingo\n");
                         };break;
                    case 6:{
                         fecha = ("Ese dia fue, es o sera Lunes\n");
                         };break;
                    case 0:{
                         fecha = ("Ese dia fue, es o sera Martes\n");
                         };break;
                   } break;  
       case 5:
       case 12:
       case 19:
       case 26: switch (tablaii)
                {
                      case 1:{
                        fecha = ("Ese dia fue, es o sera Jueves\n");
                        };break;
                    case 2:{
                         fecha = ("Ese dia fue, es o sera Viernes\n");
                         };break;
                    case 3:{
                         fecha = ("Ese dia fue, es o sera Sabado\n");
                         };break;
                    case 4:{
                         fecha = ("Ese dia fue, es o sera Domingo\n");
                         };break;
                    case 5:{
                         fecha = ("Ese dia fue, es o sera Lunes\n");
                         };break;
                    case 6:{
                         fecha = ("Ese dia fue, es o sera Martes\n");
                         };break;
                    case 0:{
                         fecha = ("Ese dia fue, es o sera Miercoles\n");
                         };break;
                   } break;  
      case 6:
      case 13:
      case 20:
      case 27: switch (tablaii)
               {
                   case 1:{
                        fecha = ("Ese dia fue, es o sera Viernes\n");
                        };break;
                    case 2:{
                         fecha = ("Ese dia fue, es o sera Sabado\n");
                         };break;
                    case 3:{
                         fecha = ("Ese dia fue, es o sera Domingo\n");
                         };break;
                    case 4:{
                         fecha = ("Ese dia fue, es o sera Lunes\n");
                         };break;
                    case 5:{
                         fecha = ("Ese dia fue, es o sera Martes\n");
                         };break;
                    case 6:{
                         fecha = ("Ese dia fue, es o sera Miercoles\n");
                         };break;
                    case 0:{
                         fecha = ("Ese dia fue, es o sera Jueves\n");
                         };break;
                   } break;
      case 7:
      case 14:
      case 21:
      case 28: switch (tablaii)
               { case 1:{
                        fecha = ("Ese dia fue, es o sera Sabado\n");
                        };break;
                    case 2:{
                         fecha = ("Ese dia fue, es o sera Domingo\n");
                         };break;
                    case 3:{
                         fecha = ("Ese dia fue, es o sera Lunes\n");
                         };break;
                    case 4:{
                         fecha = ("Ese dia fue, es o sera Martes\n");
                         };break;
                    case 5:{
                         fecha = ("Ese dia fue, es o sera Miercoles\n");
                         };break;
                    case 6:{
                         fecha = ("Ese dia fue, es o sera Jueves\n");
                         };break;
                    case 0:{
                         fecha = ("Ese dia fue, es o sera Viernes\n");
                         };break;
                   } break; }
                   
             return fecha;      
 }//fin de print_dia
 
 public static int tabla1_an1 (int agno)// le da el valor a tablai para años normales (s. 0, 7 y 14)
 { 
     int ret = 0;
     
     switch (agno){
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: ret = 6; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: ret = 0; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: ret = 1; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: ret = 2; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: ret = 3; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: ret = 4; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: ret = 5;break;}
            
      return ret;
      
  }//fin de tabla1_an1
  
 public static int tabla2_n (int tablaI, int mm)//le da el valor a tablaii en años normales
 {
     int retor = 0;
 
 switch (tablaI){
          case 0:{if (mm==1){
                       retor = 0;}
                  else if (mm==2){
                       retor = 3;}
                  else if (mm==3){
                       retor = 3;}
                  else if (mm==4){
                       retor = 6;}
                  else if (mm==5){
                       retor = 1;}          
                  else if (mm==6){
                       retor = 4;}
                  else if (mm==7){
                       retor = 6;}
                  else if (mm==8){
                       retor = 2;}
                  else if (mm==9){
                       retor = 5;}
                  else if (mm==10){
                       retor = 0;}
                  else if (mm==11){
                       retor = 3;}
                  else if (mm==12){
                       retor = 5;}} break;
          case 1:{if (mm==1){
                       retor = 1;}
                  else if (mm==2){
                       retor = 4;}
                  else if (mm==3){
                       retor = 4;}
                  else if (mm==4){
                       retor = 0;}
                  else if (mm==5){
                       retor = 2;}          
                  else if (mm==6){
                       retor = 5;}
                  else if (mm==7){
                       retor = 0;}
                  else if (mm==8){
                       retor = 3;}
                  else if (mm==9){
                       retor = 6;}
                  else if (mm==10){
                       retor = 1;}
                  else if (mm==11){
                       retor = 4;}
                  else if (mm==12){
                       retor = 6;}} break;
          case 2:{if (mm==1){
                       retor = 2;}
                  else if (mm==2){
                       retor = 5;}
                  else if (mm==3){
                       retor = 5;}
                  else if (mm==4){
                       retor = 1;}
                  else if (mm==5){
                       retor = 3;}          
                  else if (mm==6){
                       retor = 6;}
                  else if (mm==7){
                       retor = 1;}
                  else if (mm==8){
                       retor = 4;}
                  else if (mm==9){
                       retor = 0;}
                  else if (mm==10){
                       retor = 2;}
                  else if (mm==11){
                       retor = 5;}
                  else if (mm==12){
                       retor = 0;}} break;
          case 3:{if (mm==1){
                       retor = 3;}
                  else if (mm==2){
                       retor = 6;}
                  else if (mm==3){
                       retor = 6;}
                  else if (mm==4){
                       retor = 2;}
                  else if (mm==5){
                       retor = 4;}          
                  else if (mm==6){
                       retor = 0;}
                  else if (mm==7){
                       retor = 2;}
                  else if (mm==8){
                       retor = 5;}
                  else if (mm==9){
                       retor = 1;}
                  else if (mm==10){
                       retor = 3;}
                  else if (mm==11){
                       retor = 6;}
                  else if (mm==12){
                       retor = 1;}} break;
          case 4:{if (mm==1){
                       retor = 4;}
                  else if (mm==2){
                       retor = 0;}
                  else if (mm==3){
                       retor = 0;}
                  else if (mm==4){
                       retor = 3;}
                  else if (mm==5){
                       retor = 5;}          
                  else if (mm==6){
                       retor = 1;}
                  else if (mm==7){
                       retor = 3;}
                  else if (mm==8){
                       retor = 6;}
                  else if (mm==9){
                       retor = 2;}
                  else if (mm==10){
                       retor = 4;}
                  else if (mm==11){
                       retor = 0;}
                  else if (mm==12){
                       retor = 2;}} break;
          case 5:{if (mm==1){
                       retor = 5;}
                  else if (mm==2){
                       retor = 1;}
                  else if (mm==3){
                       retor = 1;}
                  else if (mm==4){
                       retor = 4;}
                  else if (mm==5){
                       retor = 6;}          
                  else if (mm==6){
                       retor = 2;}
                  else if (mm==7){
                       retor = 4;}
                  else if (mm==8){
                       retor = 0;}
                  else if (mm==9){
                       retor = 3;}
                  else if (mm==10){
                       retor = 5;}
                  else if (mm==11){
                       retor = 1;}
                  else if (mm==12){
                       retor = 3;}} break;
          case 6:{if (mm==1){
                       retor = 6;}
                  else if (mm==2){
                       retor = 2;}
                  else if (mm==3){
                       retor = 2;}
                  else if (mm==4){
                       retor = 5;}
                  else if (mm==5){
                       retor = 0;}          
                  else if (mm==6){
                       retor = 3;}
                  else if (mm==7){
                       retor = 5;}
                  else if (mm==8){
                       retor = 1;}
                  else if (mm==9){
                       retor = 4;}
                  else if (mm==10){
                       retor = 6;}
                  else if (mm==11){
                       retor = 2;}
                  else if (mm==12){
                       retor = 4;}} break;}
 
        return retor;
        
 }//fin tabla2_n
 
public static int tabla1_an2 (int agno)//obtiene tablai normal antes de 1582 (s. 1, 8 y 15)
{ 
    int valor = 0;

  switch (agno){
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: valor = 5; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: valor = 6; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: valor = 0; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: valor = 1; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: valor = 2; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: valor = 3; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: valor = 4;break;}
            
       return valor;     
            
  }//fin de tabla1_an2
public static int tabla1_ab2 (int agno)//obtiene tablai bisiesto antes de 1582 (s. 1, 8 y 15)
{
  int valor = 0;

switch (agno){
            case 0:
            case 28:
            case 56:
            case 84: valor = 5; break;
            case 12:
            case 40:
            case 68:
            case 96: valor = 6; break;
            case 24:
            case 52:
            case 80: valor = 0; break;
            case 8:
            case 36:
            case 64:
            case 92: valor = 1; break;
            case 20:
            case 48:
            case 76: valor = 2; break;
            case 4:
            case 32:
            case 60:
            case 88: valor = 3; break;
            case 16:
            case 44:
            case 72: valor = 4;break;}
            
  return valor;

}//fin tabla2_b
public static int tabla1_an3 (int agno)//obtiene tablai normal antes de 1582 (s. 2 y 9)
{ 
     int valor = 0;

switch (agno){
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: valor = 4; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: valor = 5; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: valor = 6; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: valor = 0; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: valor = 1; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: valor = 2; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: valor = 3;break;}
            
      return valor;      
            
  }//fin de tabla1_an3
public static int tabla1_ab3 (int agno)//obtiene tablai bisiesto antes de 1582 (s. 2 y 9)
{
     int valor = 0;

switch (agno){
            case 0:
            case 28:
            case 56:
            case 84: valor = 4; break;
            case 12:
            case 40:
            case 68:
            case 96: valor = 5; break;
            case 24:
            case 52:
            case 80: valor = 6; break;
            case 8:
            case 36:
            case 64:
            case 92: valor = 0; break;
            case 20:
            case 48:
            case 76: valor = 1; break;
            case 4:
            case 32:
            case 60:
            case 88: valor = 2; break;
            case 16:
            case 44:
            case 72: valor = 3;break;}
            
      return valor;

}//fin tabla3_b
public static int tabla1_an4 (int agno)//obtiene tablai normal antes de 1582 (s. 3 y 10)
{ 
      int valor = 0;

switch (agno){
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: valor = 3; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: valor = 4; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: valor = 5; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: valor = 6; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: valor = 0; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: valor = 1; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: valor = 2;break;}
       
       return valor;
  
  }//fin de tabla1_an4
public static int tabla1_ab4 (int agno)//obtiene tablai bisiesto antes de 1582 (s. 3 y 10)
{
      int valor = 0;

switch (agno){
            case 0:
            case 28:
            case 56:
            case 84: valor = 3; break;
            case 12:
            case 40:
            case 68:
            case 96: valor = 4; break;
            case 24:
            case 52:
            case 80: valor = 5; break;
            case 8:
            case 36:
            case 64:
            case 92: valor = 6; break;
            case 20:
            case 48:
            case 76: valor = 0; break;
            case 4:
            case 32:
            case 60:
            case 88: valor = 1; break;
            case 16:
            case 44:
            case 72: valor = 2;break;}
          
          return valor;
          
}//fin tabla4_b
public static int tabla1_an5 (int agno)//obtiene tablai normal antes de 1582 (s. 4 y 11)
{ 
    int valor = 0;
 
  switch (agno){
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: valor = 2; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: valor = 3; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: valor = 4; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: valor = 5; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: valor = 6; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: valor = 0; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: valor = 1;break;}
  
   return valor;
  
  }//fin de tabla1_an5
public static int tabla1_ab5 (int agno)//obtiene tablai bisiesto antes de 1582 (s. 4 y 11)
{
      int valor = 0;

switch (agno){
            case 0:
            case 28:
            case 56:
            case 84: valor = 2; break;
            case 12:
            case 40:
            case 68:
            case 96: valor = 3; break;
            case 24:
            case 52:
            case 80: valor = 4; break;
            case 8:
            case 36:
            case 64:
            case 92: valor = 5; break;
            case 20:
            case 48:
            case 76: valor = 6; break;
            case 4:
            case 32:
            case 60:
            case 88: valor = 0; break;
            case 16:
            case 44:
            case 72: valor = 1;break;}
            
      return valor;      
            
}//fin tabla5_b
public static int tabla1_an6 (int agno)//obtiene tablai normal antes de 1582 (s. 5 y 12)
{ 
      int valor = 0;

switch (agno){
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: valor = 1; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: valor = 2; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: valor = 3; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: valor = 4; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: valor = 5; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: valor = 6; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: valor = 0;break;}
            
       return valor;   
          
  }//fin de tabla1_an6
public static int tabla1_ab6 (int agno)//obtiene tablai bisiesto antes de 1582 (s. 5 y 12)
{
    int valor = 0;

switch (agno){
            case 0:
            case 28:
            case 56:
            case 84: valor = 1; break;
            case 12:
            case 40:
            case 68:
            case 96: valor = 2; break;
            case 24:
            case 52:
            case 80: valor = 3; break;
            case 8:
            case 36:
            case 64:
            case 92: valor = 4; break;
            case 20:
            case 48:
            case 76: valor = 5; break;
            case 4:
            case 32:
            case 60:
            case 88: valor = 6; break;
            case 16:
            case 44:
            case 72: valor = 0;break;}
            
      return valor;      
            
}//fin tabla6_b

public static int tabla1_an7 (int agno)//obtiene tablai normal antes de 1582 (s. 6 y 13)
{ 
     int valor = 0;
     
switch (agno){
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: valor = 0; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: valor = 1; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: valor = 2; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: valor = 3; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: valor = 4; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: valor = 5; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: valor = 6;break;}
  
       return valor;
  
  }//fin de tabla1_an7

public static int tabla1_ab7 (int agno)//obtiene tablai bisiesto antes de 1582 (s. 6 y 13)
{
       int valor = 0;

switch (agno){
            case 0:
            case 28:
            case 56:
            case 84: valor = 0; break;
            case 12:
            case 40:
            case 68:
            case 96: valor = 1; break;
            case 24:
            case 52:
            case 80: valor = 2; break;
            case 8:
            case 36:
            case 64:
            case 92: valor = 3; break;
            case 20:
            case 48:
            case 76: valor = 4; break;
            case 4:
            case 32:
            case 60:
            case 88: valor = 5; break;
            case 16:
            case 44:
            case 72: valor = 6;break;}
       
       return valor;
       
}//fin tabla7_b

public static int tabla1_an8 (int agno)//obtiene tablai normal despues de 1582 (s. 17 y 21)
{ 
    int valor = 0;

switch (agno){
            case 0:
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: valor = 6; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: valor = 0; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: valor = 1; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: valor = 2; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: valor = 3; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: valor = 4; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: valor = 5;break;}
  
         return valor;
  
  }//fin de tabla1_an8
public static int tabla1_ab8 (int agno)//obtiene tablai bisiesto despues de 1582 (s. 17 y 21)
{
       int valor = 0;

switch (agno){
            case 28:
            case 56:
            case 84: valor = 6; break;
            case 12:
            case 40:
            case 68:
            case 96: valor = 0; break;
            case 24:
            case 52:
            case 80: valor = 1; break;
            case 8:
            case 36:
            case 64:
            case 92: valor = 2; break;
            case 20:
            case 48:
            case 76: valor = 3; break;
            case 4:
            case 32:
            case 60:
            case 88: valor = 4; break;
            case 16:
            case 44:
            case 72: valor = 5;break;}
            
       return valor;     
            
}//fin tabla8_b

public static int tabla1_an9 (int agno)//obtiene tablai normal despues de 1582 (s. 18 y 22)
{ 
       int valor = 0;

switch (agno){
            case 0:
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: valor = 4; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: valor = 5; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: valor = 6; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: valor = 0; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: valor = 1; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: valor = 2; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: valor = 3;break;}
  
       return valor;
  
  }//fin de tabla1_an9
public static int tabla1_ab9 (int agno)//obtiene tablai bisiesto despues de 1582 (s. 18 y 22)
{
     int valor = 0;

switch (agno){
            case 28:
            case 56:
            case 84: valor = 4; break;
            case 12:
            case 40:
            case 68:
            case 96: valor = 5; break;
            case 24:
            case 52:
            case 80: valor = 6; break;
            case 8:
            case 36:
            case 64:
            case 92: valor = 0; break;
            case 20:
            case 48:
            case 76: valor = 1; break;
            case 4:
            case 32:
            case 60:
            case 88: valor = 2; break;
            case 16:
            case 44:
            case 72: valor = 3;break;}
            
      return valor;      
            
}//fin tabla9_b
public static int tabla1_an10 (int agno)//obtiene tablai normal despues de 1582 (s. 15, 19 y 23)
{ 
       int valor = 0;

switch (agno){
            case 0:
            case 6:
            case 17:
            case 23:
            case 34:
            case 45:
            case 51:
            case 62:
            case 73:
            case 79:
            case 90: valor = 2; break;
            case 1:
            case 7:
            case 18:
            case 29:
            case 35:
            case 46:
            case 57:
            case 63:
            case 74:
            case 85:
            case 91: valor = 3; break;
            case 2:
            case 13:
            case 19:
            case 30:
            case 41:
            case 47:
            case 58:
            case 69:
            case 75:
            case 86:
            case 97: valor = 4; break;
            case 3:
            case 14:
            case 25:
            case 31:
            case 42:
            case 53:
            case 59:
            case 70:
            case 81:
            case 87:
            case 98: valor = 5; break;
            case 9:
            case 15:
            case 26:
            case 37:
            case 43:
            case 54:
            case 65:
            case 71:
            case 82:
            case 93:
            case 99: valor = 6; break;
            case 10:
            case 21:
            case 27:
            case 38:
            case 49:
            case 55:
            case 66:
            case 77:
            case 83:
            case 94: valor = 0; break;
            case 5:
            case 11:
            case 22:
            case 33:
            case 39:
            case 50:
            case 61:
            case 67:
            case 78:
            case 89:
            case 95: valor = 1;break;}
  
     return valor;
  
  }//fin de tabla1_an10

public static int tabla1_ab10 (int agno)//obtiene tablai bisiesto despues de 1582 (s. 15, 19 y 23)
{
      int valor = 0;

switch (agno){
            case 28:
            case 56:
            case 84: valor = 2; break;
            case 12:
            case 40:
            case 68:
            case 96: valor = 3; break;
            case 24:
            case 52:
            case 80: valor = 4; break;
            case 8:
            case 36:
            case 64:
            case 92: valor = 5; break;
            case 20:
            case 48:
            case 76: valor = 6; break;
            case 4:
            case 32:
            case 60:
            case 88: valor = 0; break;
            case 16:
            case 44:
            case 72: valor = 1;break;}
            
     return valor;       
            
}//fin tabla10_b


}
