
/**
 * Interpreta comandos lokos
 * 
 * @author ApokalipsyS
 * @version 0.1
 */
/* esta wea es mas bkn ke la conchasumare
 * :D
 */

public class Interprete
{
        private final static String print = "mostrar";
	private final static String if_ = "si";
	private static final String elif = "o si";
	private static final String else_ = "sino";
	private static final String then = "entonces";
	private static final String id_variable = "$";
	private static final String true_ = "verdadero";
	private static final String false_ = "falso";
	private static final String end = "fin";

	private static java.util.Vector<Variable> v = new java.util.Vector<Variable>(); 
	
	private static boolean then_flag = false;
        private static Consola con;
	
	public static void interpretar(String program, Consola console)
	{
                con = console;
		String inte[] = program.split("\n"); 
		
		for(int i = 0; i<inte.length; i++)
		{
		    String tmp = inte[i].trim();
		    String tmp2 = tmp.substring(0,tmp.indexOf(' ')!=-1?  tmp.indexOf(' '):tmp.length());
		    tmp = tmp.substring(tmp.indexOf(' ')+1, tmp.length());
		    
		    checkJob(tmp2,tmp);
		    
		}
	}
	
	private static void checkJob(String job, String todo)
	{
	    if(job.startsWith(id_variable)) variable(job,todo);
		else if(job.equals(print)) print(todo);
		else if(job.equals(if_)) ifJob(todo);
		else if(job.equals(else_) && then_flag) elseJob(todo);
		
		if(job.equals(end) && then_flag) then_flag = false;
	}
	
	private static void print(String p)
	{
	    if(p.equals(print))con.setText("");
	    else con.setText(p);
	}
	
	private static void variable(String n, String vo)
	{
	    Variable tmp = new Variable(n.substring(1,n.length()),vo.substring(2,vo.length()));
	    
	    if(v.contains(tmp)) v.add(v.indexOf(tmp),tmp);
	    else v.add(tmp);
	    
	}
	
	private static void ifJob(String verd)
	{
	    then_flag = true;
	    
	    
	    if(verd.startsWith(true_))
	    {
	        String h = verd.replaceFirst(then,"");
	        h = h.replaceFirst(true_,"");
	        h=h.trim();
	        interpretar(h,con);
                then_flag = false;
	    }
	    else if(verd.startsWith(id_variable))
	    {
	        Variable t = new Variable(verd.substring(1,verd.indexOf(' ')),"null");
	        String valor = (v.get(v.indexOf(t))).valor();
	        
	        verd = verd.substring(1,verd.length());
	        verd = verd.replaceFirst(t.nombre(),"");
	        ifJob(valor+verd);
	    }
	}
	
	private static void elseJob(String verd)
	{
	    then_flag = false;
	    interpretar(verd,con);
	}
}
