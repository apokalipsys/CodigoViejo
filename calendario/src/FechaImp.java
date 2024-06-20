import java.awt.event.*;
import java.awt.*;
import java.applet.Applet;
/**
 * Interface fechas importantes
 * 
 * @author BOo
 * @version 0.1b
 */
public class FechaImp extends Frame implements ActionListener
{
	List lista;
	Fechar fechas[];
	TextArea u;
	Button b;

	
	public FechaImp()
	{
		setSize(400,310);
        setTitle("Fechas Importantes");
        setLayout(new FlowLayout());
        setResizable(false);
        
        crearFechas();
        
        lista = new List(5,false);
        
        for(int i=0; i<=20;i++)
          lista.add(fechas[i].toString());
        
        b = new Button("Ver Dia");
        b.addActionListener(this);
        Panel arriba = new Panel();
        arriba.add(lista);
        arriba.add(b);
        add("North", arriba);
        
        Panel abajo = new Panel();
        u = new TextArea("",10,50);
        u.setEditable(false);
        abajo.add(u);
        add("Center", abajo);
        
        this.setVisible(true);
        
        this.addWindowListener
        (
           new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
              {
                   dispose();
              }
           }   
        );
        
        this.setIconImage(makeIcon.iFechaImp);
	}

	public void actionPerformed(ActionEvent e)
	{
	    if(e.getSource() == b)
	    {
	        String aux = "";
	        String ListaSeleccion = lista.getSelectedItem();
	        TextArea ta = new TextArea("",20,20);
	        
	        for(int i=0; i<=20;i++)
	        {
	            if(ListaSeleccion.equals(fechas[i].toString()))
	            {
	                 calendas fecha1 = new calendas(fechas[i].Dia(), fechas[i].Mes(), fechas[i].Year());
	                 aux = fechas[i].toString()+"\n";
	                 aux = aux+fechas[i].numToString()+"\n";
                     fecha1.procesar(ta, ta);
                     aux = aux+ta.getText();
                     u.setText(aux);
	            }
	        }
	    }
	}
	
	public void crearFechas()
	{
		fechas = new Fechar[20];
		
		fechas[0] = new Fechar("Descubrimiento de Am�rica",12,10,1492);
		fechas[1] = new Fechar("Primera Junta Nacional de Gobierno",18,9,1810);
		fechas[3] = new Fechar("Hombre en la Luna",21,7,1969);
		fechas[4] = new Fechar("Hombre en Orbita", 12,4,1961);
		fechas[5] = new Fechar("Primeras Imagenes via satelite",11,7,1962);
		fechas[6] = new Fechar("Primer Vuelo del Hombre",21,11,1783);
		fechas[7] = new Fechar("Primera Prueba de Locomotora a vapor",24,2,1804);
		fechas[8] = new Fechar("Primera Radiografia",22,12,1895);
		fechas[9] = new Fechar("Metro de Paris",16,7,1900);
		fechas[10] = new Fechar("Primer Avi�n",17,12,1903);
		fechas[11] = new Fechar("Vuelo a traves del Canal de La Mancha",25,7,1909);
		fechas[12] = new Fechar("Vuelo sin escalas por el Atl�ntico",21,5,1927);
		fechas[13] = new Fechar("Bomba A sobre Nagasaki",9,8,1945);
		fechas[14] = new Fechar("Transplante de Corazon",3,12,1967);
		fechas[15] = new Fechar("Sputnik 1(comienzo era espacial)",4,10,1957);
		fechas[16] = new Fechar("I Guerra Mundial (Francisco-Fernando asesinado)",28,6,1914);
		fechas[17] = new Fechar("Tratado de Versalles",28,6,1919);
		fechas[18] = new Fechar("II Guerra Mundial (Alemania invade Polonia)",1,9,1939);
		fechas[19] = new Fechar("Bomba A sobre Hiroshima",6,8,1945);
		fechas[2] = new Fechar("Dia D",6,6,1944);
	}
}
