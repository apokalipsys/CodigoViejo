package startup;


/**
 * @author BOo
 * @version 0.2
 */


public class Hexa {
	
	/* Hexa a Cadena by BOo */
               /* Original de PDU Format Converter */

               public static String HextoString(String s)
               {
                       byte[] palabra = fromHexString(s);
                       String ret = ""; 
                       for(int i = 0; i< palabra.length; i++)
                             ret += (char) palabra[i];

                       return ret;
                }
	
	public static byte[] fromHexString ( String s ) 
{ 
int stringLength = s.length() ; 
if ( (stringLength & 0x1) != 0 ) 
{ 
throw new IllegalArgumentException ( "fromHexString requires an even number of hex characters" ); 
} 
byte[] b = new byte[ stringLength / 2 ]; 

for ( int i=0 ,j= 0; i< stringLength; i+= 2,j ++ ) 
{ 
int high= charToNibble(s.charAt ( i )); 
int low = charToNibble( s.charAt ( i+1 ) ); 
b[ j ] = (byte ) ( ( high << 4 ) | low ); 
} 
return b; 
} 


/** 
* convert a single char to corresponding nibble. 
* 
* @param c char to convert. must be 0-9 a-f A-F, no 
* spaces, plus or minus signs. 
* 
* @return corresponding integer 
*/ 
private static int charToNibble ( char c ) 
{ 
if ( '0' <= c && c <= '9' ) 
{ 
return c - '0' ; 
} 
else if ( 'a' <= c && c <= 'f' ) 
{ 
return c - 'a' + 0xa ; 
} 
else if ( 'A' <= c && c <= 'F' ) 
{ 
return c - 'A' + 0xa ; 
} 
else 
{ 
throw new IllegalArgumentException ( "Invalid hex character: " + c ) ; 
} 
} 


                /* Cadena a Hexa by BOo */
                /* Original de PDU Format Converter */

                public static String toHexString(String palaura)
                {
                            return     toHexString(palaura.getBytes());
                 }

                 public static String toHexString ( byte[] b ) 
                 { 
	         StringBuffer sb = new StringBuffer( b.length * 2 ); 
	         for ( int i=0 ; i<b.length ; i++ ) 
	        { 
 
	               sb.append( hexChar [ ( b[ i] & 0xf0 ) >>> 4 ] ) ; 

                              sb.append( hexChar [ b[ i] & 0x0f ] ) ; 
                         } 
                        return sb.toString() ;  
                   } 


                    static char[] hexChar = 
                    { 
		'0' , '1' , '2' , '3' , 
		'4' , '5' , '6' , '7' , 
		'8' , '9' , 'A' , 'B' , 
		'C' , 'D' , 'E' , 'F' } 
		;  

                  /* Fin Cadena a Hexa by BOo */
	
}
