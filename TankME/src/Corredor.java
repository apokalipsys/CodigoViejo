
//import java.lang.Thread;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
 
public class Corredor extends MIDlet implements CommandListener {
     
    private TanqueGame juego;
    
    private Command exitCmd  = new Command("Salir", Command.SCREEN, 3);
    
    public Corredor() {
	juego = new TanqueGame();
	juego.addCommand(exitCmd);
	juego.setCommandListener(this);
    }

    
    protected void destroyApp(boolean unconditional) {
	Display.getDisplay(this).setCurrent(null);
    }

    
    protected void pauseApp() {
    }

    
    protected void startApp() {
	Display.getDisplay(this).setCurrent(juego);
      /*
	try {
	    Thread myThread = new Thread(juego);
	    myThread.start();
	} catch (Error e) {
	    destroyApp(false);
	    notifyDestroyed();
	}*/
    }

    
    public void commandAction(Command c, Displayable d) {
        if (c == exitCmd) {
	    destroyApp(false);
	    notifyDestroyed();
        }	
     
    
    }

}



