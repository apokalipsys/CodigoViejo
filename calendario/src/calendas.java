import java.awt.*;
//import "Moret.class"    //Las funciones usadas por el programa estan aqui
/**
 * funciones del calendario perpetuo Moret, centro de calculos
 * 
 * @author BOo
 * @version 0.2j
 */

public class calendas
{
    int dd, mm, ss, aa;     // variables
    int tablaii;
    boolean bisi = false;
    
    public calendas(int dia, int mes, int year)
    {
         dd = dia;
         mm = mes;
         aa = year;
    }
    
    public void procesar(TextArea TAP, TextArea TA)
    {
       int tablai;
       String pasar = "", fecha = "";
              
     separarano();  //separando el a�o
     pasar = ("Procesando . . .\n") + (Moret.test_fecha(dd,mm,ss,aa))+"\n";//revisando fecha
     TA.setText(pasar);
   
   /* parte medular del programa.
      esta es la zona donde se calcula el dia, 
      un proceso largo debido a que no lo pense mucho */
   
   if(Moret.correcto)
   {
    if (ss==15 && aa==82 && (mm<10 || (mm==10 && dd<=4)))
    {
         tablai= 2;
         tablaii=Moret.tabla2_n(tablai,mm);      
         fecha = Moret.print_dia(dd, tablaii);
         bisi = false;
    }   
    
    else 
      if (ss==15 && aa==82 && (mm>10 ||(mm==10 && dd>=15)))
      {
            tablai= 6;
            tablaii=Moret.tabla2_n(tablai,mm);      
            fecha = Moret.print_dia(dd, tablaii);
            bisi = false;
      }
    
    else 
      if (ss==15 && aa>82) 
      {  
              if (aa==84 || aa==88 || aa==92 || aa==96)
              {
                   tablai= Moret.tabla1_ab10(aa);
                   tablaii = Moret.tabla2_b(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = true;
              }//fin if-bisiesto
              else                //principio a�os normales
              { 
                   tablai = Moret.tabla1_an10(aa);
                   tablaii = Moret.tabla2_n(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = false;
              } //fin else-normal
      }
    else
      if (ss==15 && aa<82)
      {
            if (aa==0 || aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80)
                {
                     tablai= Moret.tabla1_ab2(aa);
                     tablaii = Moret.tabla2_b(tablai,mm);
                     fecha = Moret.print_dia(dd,tablaii);
                     bisi = true;
                }            //fin if-bisiesto
                else       //principio a�os normales
                { 
                     tablai = Moret.tabla1_an2(aa);
                     tablaii = Moret.tabla2_n(tablai,mm);
                     fecha = Moret.print_dia(dd,tablaii);
                     bisi = false;
                }              //fin else-normal

      }
    else 
      if (ss<15)
      { 
           if (ss==0 || ss==7 || ss== 14)
           {
                if (aa==0 || aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
                {
                     tablai= Moret.tabla1_ab1(aa);
                     tablaii = Moret.tabla2_b(tablai,mm);
                     fecha = Moret.print_dia(dd,tablaii);
                     bisi = true;
                }                                  //fin if-bisiesto
                else //principio a�os normales
                { 
                     tablai = Moret.tabla1_an1(aa);
                     tablaii = Moret.tabla2_n(tablai,mm);
                     fecha = Moret.print_dia(dd,tablaii);
                     bisi = false;
                }            //fin else-normal
           }                //fin if siglo   

           if (ss==1 || ss==8)
           {
                if (aa==0 || aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
                {
                     tablai= Moret.tabla1_ab2(aa);
                     tablaii = Moret.tabla2_b(tablai,mm);
                     fecha = Moret.print_dia(dd,tablaii);
                     bisi = true;
                }            //fin if-bisiesto
                else       //principio a�os normales
                { 
                     tablai = Moret.tabla1_an2(aa);
                     tablaii = Moret.tabla2_n(tablai,mm);
                     fecha = Moret.print_dia(dd,tablaii);
                     bisi = false;
                }              //fin else-normal
            }                      //fin if siglo   

            if (ss==2 || ss==9)
            {
                 if (aa==0 || aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
                 {
                      tablai= Moret.tabla1_ab3(aa);
                      tablaii = Moret.tabla2_b(tablai,mm);
                      fecha = Moret.print_dia(dd,tablaii);
                      bisi = true;
                 }              //fin if-bisiesto
                 else             //principio a�os normales
                 { 
                      tablai = Moret.tabla1_an3(aa);
                      tablaii = Moret.tabla2_n(tablai,mm);
                      fecha = Moret.print_dia(dd,tablaii);
                      bisi = false;
                 } //fin else-normal
            } //fin if siglo   

            if (ss==3 || ss==10)
            {
                 if (aa==0 || aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
                 {
                      tablai= Moret.tabla1_ab4(aa);
                      tablaii = Moret.tabla2_b(tablai,mm);
                      fecha = Moret.print_dia(dd,tablaii);
                      bisi = true;
                 }                 //fin if-bisiesto
                 else              //principio a�os normales
                 { 
                      tablai = Moret.tabla1_an4(aa);
                      tablaii = Moret.tabla2_n(tablai,mm);
                      fecha = Moret.print_dia(dd,tablaii);
                      bisi = false;
                 } //fin else-normal
            } //fin if siglo   

            if (ss==4 || ss==11)
            {
                 if (aa==0 || aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
                 {
                      tablai = Moret.tabla1_ab5(aa);
                      tablaii = Moret.tabla2_b(tablai,mm);
                      fecha = Moret.print_dia(dd,tablaii);
                      bisi = true;
                 }//fin if-bisiesto
                 else      //principio a�os normales
                 { 
                      tablai = Moret.tabla1_an5(aa);
                      tablaii = Moret.tabla2_n(tablai,mm);
                      fecha = Moret.print_dia(dd,tablaii);
                      bisi = false;
                 } //fin else-normal
            } //fin if siglo   

            if (ss==5 || ss==12)
            {
                 if (aa==0 || aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
                 {
                      tablai = Moret.tabla1_ab6(aa);
                      tablaii = Moret.tabla2_b(tablai,mm);
                      fecha = Moret.print_dia(dd,tablaii);
                      bisi = true;
                 }//fin if-bisiesto
                 else     //principio a�os normales
                 { 
                      tablai = Moret.tabla1_an6(aa);
                      tablaii = Moret.tabla2_n(tablai,mm);
                      fecha = Moret.print_dia(dd,tablaii);
                      bisi = false;
                 } //fin else-normal
            } //fin if siglo   

            if (ss==6 || ss==13)
            {
                 if (aa==0 || aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
                 {
                      tablai= Moret.tabla1_ab7(aa);
                      tablaii = Moret.tabla2_b(tablai,mm);
                      fecha = Moret.print_dia(dd,tablaii);
                      bisi = true;
                  }//fin if-bisiesto
                  else       //principio a�os normales
                  { 
                       tablai = Moret.tabla1_an7(aa);
                       tablaii = Moret.tabla2_n(tablai,mm);
                       fecha = Moret.print_dia(dd,tablaii);
                       bisi = false;
                  } //fin else-normal
          } //fin if siglo   
    }//fin if-antes de la reforma            
          
 
    else      // a�os correspondientes a despues de la reforma
    {
         if (ss==17 || ss==21)
         {
              if (aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
              {
                   tablai = Moret.tabla1_ab8(aa);
                   tablaii = Moret.tabla2_b(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = true;
              }                     //fin if-bisiesto
              else                 //principio a�os normales
              { 
                   tablai = Moret.tabla1_an8(aa);
                   tablaii = Moret.tabla2_n(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = false;
              } //fin else-normal
         } //fin if siglo   
            
         if (ss==18 || ss==22)
         {
              if (aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
              {
                   tablai= Moret.tabla1_ab9(aa);
                   tablaii = Moret.tabla2_b(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = true;
              }//fin if-bisiesto
              else    //principio a�os normales
              { 
                   tablai = Moret.tabla1_an9(aa);
                   tablaii = Moret.tabla2_n(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = false;
              } //fin else-normal
         } //fin if siglo   
            
         if (ss==19 || ss==23)
         {
              if (aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
              {
                   tablai= Moret.tabla1_ab10(aa);
                   tablaii = Moret.tabla2_b(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = true;
              }//fin if-bisiesto
              else                //principio a�os normales
              { 
                   tablai = Moret.tabla1_an10(aa);
                   tablaii = Moret.tabla2_n(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = false;
              } //fin else-normal
         } //fin if siglo   
            
         if (ss==16 || ss==20 || ss==24)
         {
              if (aa==0 || aa==4 || aa==8 || aa==12 || aa==16 || aa==20 || aa==24 || aa==28 || aa==32 || aa==36 || aa==40 || aa==44 || aa==48 || aa==52 || aa==56 || aa==60 || aa==64 || aa==68 || aa==72 || aa==76 || aa==80 || aa==84 || aa==88 || aa==92 || aa==96)
              {
                   tablai = Moret.tabla1_ab6(aa);
                   tablaii = Moret.tabla2_b(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = true;
              }//fin if-bisiesto
              else       //principio a�os normales
              { 
                   tablai = Moret.tabla1_an6(aa);
                   tablaii = Moret.tabla2_n(tablai,mm);
                   fecha = Moret.print_dia(dd,tablaii);
                   bisi = false;
              } //fin else-normal
         } //fin if siglo   
    }//fin else-despues de la reforma
    
   // EXIT
    
    
    TAP.setText(fecha);
   }
 } 
/*-------------------------------------------------------------------------------*/

public void separarano()
{ 
     ss=aa/100; 
     aa=(aa-ss*100);
}

public boolean esBisiesto()
{
    return bisi;
}

}





