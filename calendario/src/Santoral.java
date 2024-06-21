import java.util.Date;
/**
 * Calcula el santoral del dia actual
 * 
 * @author BOo
 * @version 0.2
 */
public class Santoral
{
	private String santo = "";
    
	public Santoral()
	{
		Date hoy = new Date();
	    
	   new Santoral(hoy.getDate(),hoy.getMonth());
	   	                   
	}
	
	public Santoral(int dia, int mes)
	{
	    switch(mes)
	    {
	        case 0: {
	                    switch(dia)
	                    {
	                         case 1: santo = "A�o Nuevo"; break;
	                         case 2: santo = "S. Basilio - S. Gregorio N."; break;
	                         case 3: santo = "Sta. Genoveva"; break;
	                         case 4: santo = "S. Rigoberto - Sta. Yolanda"; break;
	                         case 5: santo = "Sta. Emilia (na)"; break;
	                         case 6: santo = "Sta. Wilma"; break;
	                         case 7: santo = "S. Raimundo"; break;
	                         case 8: santo = "S. Luciano - S. Eladio"; break;
	                         case 9: santo = "Sta. Lucrecia"; break;
	                         case 10: santo = "S. Gonzalo"; break;
	                         case 11: santo = "S. Alejandro"; break;
	                         case 12: santo = "S. Juli�n"; break;
	                         case 13: santo = "S. Hilario"; break;
	                         case 14: santo = "S. F�lix"; break;
	                         case 15: santo = "S. Mauro - Sta. Raquel"; break;
	                         case 16: santo = "S. Marcelo"; break;
	                         case 17: santo = "S. Antonio - S. Guido"; break;
	                         case 18: santo = "Ss. Prisca y Priscila - Sta. Ximena"; break;
	                         case 19: santo = "S. Mario"; break;
	                         case 20: santo = "S. Sebasti�n - S. Fabi�n"; break;
	                         case 21: santo = "Sta. In�s"; break;
	                         case 22: santo = "S. Vicente - Ba. Laura Vicu�a"; break;
	                         case 23: santo = "Sta. Virginia"; break;
	                         case 24: santo = "S. Francisco de Sales"; break;
	                         case 25: santo = "Sta. Elvira"; break;
	                         case 26: santo = "Ss. Timoteo y Tito - Sta. Paula (Paola)"; break;
	                         case 27: santo = "Sta. Angela"; break;
	                         case 28: santo = "Sto. Tom�s de Aquino"; break;
	                         case 29: santo = "S. Valerio"; break;
	                         case 30: santo = "Sta. Martina"; break;
	                         case 31: santo = "Sta. Marcela - S. Juan Bosco"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;     
	        case 1: {
	                    switch(dia)
	                    {
	                         case 1: santo = "S. Severiano - S. H�ctor"; break;
	                         case 2: santo = "Presentaci�n del Se�or"; break;
	                         case 3: santo = "S. Oscar - S. Blas"; break;
	                         case 4: santo = "S. Gilberto"; break;
	                         case 5: santo = "Sta. Agueda"; break;
	                         case 6: santo = "Sta. Doris"; break;
	                         case 7: santo = "S. Gat�n"; break;
	                         case 8: santo = "S. Jer�nimo - Sta Jacqueline"; break;
	                         case 9: santo = "Sta. Rebeca"; break;
	                         case 10: santo = "Sta. Escol�stica"; break;
	                         case 11: santo = "N. Sra. de Lourdes"; break;
	                         case 12: santo = "S. Panfilio - Sta. Pamela"; break;
	                         case 13: santo = "Sta. Beatriz"; break;
	                         case 14: santo = "S. Valent�n"; break;
	                         case 15: santo = "Ss. Fausto y Jovita"; break;
	                         case 16: santo = "S. Samuel"; break;
	                         case 17: santo = "S. Alexis"; break;
	                         case 18: santo = "Sta. Bernardita - S. Sime�n"; break;
	                         case 19: santo = "S. �lvaro"; break;
	                         case 20: santo = "S. Eleuterio"; break;
	                         case 21: santo = "S. Severino"; break;
	                         case 22: santo = "Sta. Eleonora"; break;
	                         case 23: santo = "S. Florencio"; break;
	                         case 24: santo = "S. Rub�n"; break;
	                         case 25: santo = "S. N�stor"; break;
	                         case 26: santo = "S. Augusto"; break;
	                         case 27: santo = "S. Gabriel - S. Leandro"; break;
	                         case 28: santo = "S. Rom�n"; break;
	                         case 29: santo = "S. Waldo"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 2: {
	                    switch(dia)
	                    {
	                         case 1: santo = "S. Rosendo"; break;
	                         case 2: santo = "S. Lucio"; break;
	                         case 3: santo = "S. Celedonio - Sta. Elisa"; break;
	                         case 4: santo = "S. Ariel"; break;
	                         case 5: santo = "Sta. Olivia"; break;
	                         case 6: santo = "Sta. Elcira"; break;
	                         case 7: santo = "Ss. Perpetua y Felicidad"; break;
	                         case 8: santo = "S. Juan de Dios"; break;
	                         case 9: santo = "Sta. Francisca Romana"; break;
	                         case 10: santo = "S. Macario"; break;
	                         case 11: santo = "S. Eulogio"; break;
	                         case 12: santo = "Sta. Norma"; break;
	                         case 13: santo = "S. Rodrigo"; break;
	                         case 14: santo = "Sta. Matilde"; break;
	                         case 15: santo = "Sta. Luisa de Merillac"; break;
	                         case 16: santo = "S. Heriberto"; break;
	                         case 17: santo = "S. Patricio"; break;
	                         case 18: santo = "S. Cirilio"; break;
	                         case 19: santo = "S. Jos�"; break;
	                         case 20: santo = "Sta. Alejandra"; break;
	                         case 21: santo = "Sta. Eugenia - Sta. Clementina"; break;
	                         case 22: santo = "Sta. Lila - Sta. Lea"; break;
	                         case 23: santo = "S. Toribio - S. Dimas"; break;
	                         case 24: santo = "Sta. Elba"; break;
	                         case 25: santo = "Anunciaci�n del Se�or"; break;
	                         case 26: santo = "S. Braulio"; break;
	                         case 27: santo = "S. Ruperto"; break;
	                         case 28: santo = "S. Octavio"; break;
	                         case 29: santo = "Sta. Gladys"; break;
	                         case 30: santo = "S. Artemio"; break;
	                         case 31: santo = "S. Benjam�n"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 3: {
	                    switch(dia)
	                    {
	                         case 1: santo = "S. Hugo"; break;
	                         case 2: santo = "Sta. Sandra"; break;
	                         case 3: santo = "S. Ricardo"; break;
	                         case 4: santo = "S. Isidoro"; break;
	                         case 5: santo = "S. Vicente Ferrer"; break;
	                         case 6: santo = "Sta. Edith"; break;
	                         case 7: santo = "S. Juan B. de La Salle"; break;
	                         case 8: santo = "Sta. Constanza"; break;
	                         case 9: santo = "S. Demetrio"; break;
	                         case 10: santo = "S. Ezequiel"; break;
	                         case 11: santo = "S. Estanislao"; break;
	                         case 12: santo = "S. Julio - S. Arnoldo"; break;
	                         case 13: santo = "S. Mart�n - Sta. Aida"; break;
	                         case 14: santo = "S. M�ximo"; break;
	                         case 15: santo = "S. Crescente"; break;
	                         case 16: santo = "S. Flavio"; break;
	                         case 17: santo = "S. Leopoldo"; break;
	                         case 18: santo = "S. Wladimir"; break;
	                         case 19: santo = "Sta. Ema"; break;
	                         case 20: santo = "S. Edgardo"; break;
	                         case 21: santo = "S. Anselmo"; break;
	                         case 22: santo = "Sta. Karina"; break;
	                         case 23: santo = "S. Jorge"; break;
	                         case 24: santo = "S. Fidel"; break;
	                         case 25: santo = "S. Marcos"; break;
	                         case 26: santo = "S. N�lson - Ss. Marcelino y Cleto"; break;
	                         case 27: santo = "N. Sra. de Montserrat - Sto. Toribio - Sta. Zita"; break;
	                         case 28: santo = "Sta. Valeria"; break;
	                         case 29: santo = "Sta. Catalina de Siena"; break;
	                         case 30: santo = "S. P�o V(P�a) - S. Amador"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 4: {
	                    switch(dia)
	                    {
	                         case 1: santo = "D�a del Trabajo (n/d)"; break;
	                         case 2: santo = "S. Atanasio - S. Boris"; break;
	                         case 3: santo = "La Santa Cruz"; break;
	                         case 4: santo = "Ss. Felipe y Santiago"; break;
	                         case 5: santo = "Sta. Judith"; break;
	                         case 6: santo = "S. Eleodoro"; break;
	                         case 7: santo = "Sta. Domitila"; break;
	                         case 8: santo = "S. Segundo"; break;
	                         case 9: santo = "S. Isa�as"; break;
	                         case 10: santo = "S. Antonino - Sta. Solange"; break;
	                         case 11: santo = "Sta. Estela"; break;
	                         case 12: santo = "Ss. Nereo, Aquiles y Pancracio"; break;
	                         case 13: santo = "N. Sra. de F�tima"; break;
	                         case 14: santo = "S. Mat�as"; break;
	                         case 15: santo = "S. Isidro - Sta. Denise"; break;
	                         case 16: santo = "S. Honorato"; break;
	                         case 17: santo = "S. Pascual"; break;
	                         case 18: santo = "S. Eric (a) - Sta. Corina"; break;
	                         case 19: santo = "S. Yvo (Yvonne)"; break;
	                         case 20: santo = "S. Bernardino"; break;
	                         case 21: santo = "S. Constantino"; break;
	                         case 22: santo = "Sta. Rita"; break;
	                         case 23: santo = "S. Desiderio"; break;
	                         case 24: santo = "Sta. Susana"; break;
	                         case 25: santo = "Sta. Sof�a - S. Gregorio"; break;
	                         case 26: santo = "Sta. Mariana"; break;
	                         case 27: santo = "S. Emilio"; break;
	                         case 28: santo = "S. Germ�n"; break;
	                         case 29: santo = "Sta. Hilda - S. Maximiano"; break;
	                         case 30: santo = "S. Fernando - S. Hern�n - Sta. Lorena"; break;
	                         case 31: santo = "Visitaci�n de la Virgen"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 5: {
	                    switch(dia)
	                    {
	                         case 1: santo = "S. Justino - S. Juvenal"; break;
	                         case 2: santo = "S. Erasmo - S. Marcelino"; break;
	                         case 3: santo = "S. Maximiliano"; break;
	                         case 4: santo = "Sta. Frida"; break;
	                         case 5: santo = "S. Salvador - S. Bonifacio"; break;
	                         case 6: santo = "S. Norberto"; break;
	                         case 7: santo = "S. Claudio"; break;
	                         case 8: santo = "S. Armando"; break;
	                         case 9: santo = "S. Efr�n (Efra�n)"; break;
	                         case 10: santo = "Sta. Paulina"; break;
	                         case 11: santo = "S. Bernab�"; break;
	                         case 12: santo = "S. Onofre"; break;
	                         case 13: santo = "S. Antonio de Padua"; break;
	                         case 14: santo = "S. Eliseo"; break;
	                         case 15: santo = "S. Leonidas"; break;
	                         case 16: santo = "S. Aurelio"; break;
	                         case 17: santo = "S. Ismael"; break;
	                         case 18: santo = "S. Salom�n"; break;
	                         case 19: santo = "S. Rumualdo"; break;
	                         case 20: santo = "S. Florentino (a)"; break;
	                         case 21: santo = "S. Luis G. - S. Ra�l"; break;
	                         case 22: santo = "S. Paulino de Nola"; break;
	                         case 23: santo = "S. Marcial"; break;
	                         case 24: santo = "S. Juan Bautista"; break;
	                         case 25: santo = "S. Guillermo"; break;
	                         case 26: santo = "S. Pelayo"; break;
	                         case 27: santo = "N. Sra. del Consuelo"; break;
	                         case 28: santo = "S. Ireneo"; break;
	                         case 29: santo = "S. Pedro y S. Pablo"; break;
	                         case 30: santo = "S. Adolfo"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 6: {
	                    switch(dia)
	                    {
	                         case 1: santo = "Sta. Ester"; break;
	                         case 2: santo = "Sta. Gloria"; break;
	                         case 3: santo = "Sto. Tom�s Ap�stol"; break;
	                         case 4: santo = "Sta. Eliana Mabel - Sta. Isabel"; break;
	                         case 5: santo = "Sta. Berta"; break;
	                         case 6: santo = "Sta. Mar�a Goretti"; break;
	                         case 7: santo = "S. Ferm�n"; break;
	                         case 8: santo = "S. Eugenio"; break;
	                         case 9: santo = "Sta. Ver�nica"; break;
	                         case 10: santo = "S. El�as"; break;
	                         case 11: santo = "S. Benito"; break;
	                         case 12: santo = "Sta. Filomena"; break;
	                         case 13: santo = "Sta. Teresa de Los Andes - S. Enrique"; break;
	                         case 14: santo = "S. Camilo"; break;
	                         case 15: santo = "Sta. Julia"; break;
	                         case 16: santo = "N. Sra. del Carmen"; break;
	                         case 17: santo = "Sta. Carolina"; break;
	                         case 18: santo = "S. Federico"; break;
	                         case 19: santo = "S. Arsenio - Sta. Natacha"; break;
	                         case 20: santo = "Sta. Marina"; break;
	                         case 21: santo = "S. Daniel"; break;
	                         case 22: santo = "Sta. Mar�a Magdalena"; break;
	                         case 23: santo = "Sta. Br�gida"; break;
	                         case 24: santo = "Sta. Cristina"; break;
	                         case 25: santo = "Sto. Santiago Ap�stol"; break;
	                         case 26: santo = "Ss. Ana y Joaqu�n"; break;
	                         case 27: santo = "Sta. Natalia - S. Aurelio"; break;
	                         case 28: santo = "S. Celso"; break;
	                         case 29: santo = "Sta. MArta"; break;
	                         case 30: santo = "S. Abd�n"; break;
	                         case 31: santo = "S. Ignacio de Loyola"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 7: {
	                    switch(dia)
	                    {
	                         case 1: santo = "S. Alfonso"; break;
	                         case 2: santo = "S. Eusebio"; break;
	                         case 3: santo = "Sta. Lidia"; break;
	                         case 4: santo = "S. Juan Mar�a Vianney"; break;
	                         case 5: santo = "S. Osvaldo"; break;
	                         case 6: santo = "Transfiguraci�n del Se�or"; break;
	                         case 7: santo = "S. Cayetano - Sta. Nadia"; break;
	                         case 8: santo = "Sto. Domingo"; break;
	                         case 9: santo = "S. Justo"; break;
	                         case 10: santo = "S. Lorenzo"; break;
	                         case 11: santo = "Sta. Clara"; break;
	                         case 12: santo = "Sta. Laura - S. Juli�n"; break;
	                         case 13: santo = "S. V�ctor"; break;
	                         case 14: santo = "S. Alfredo"; break;
	                         case 15: santo = "Asunci�n de la Virgen"; break;
	                         case 16: santo = "S. Roque - S. Esteban"; break;
	                         case 17: santo = "S. Jacinto"; break;
	                         case 18: santo = "Sta. Elena - Sta. Nelly - Bto. Alberto Hurtado"; break;
	                         case 19: santo = "S. Mariano"; break;
	                         case 20: santo = "S. Bernardo"; break;
	                         case 21: santo = "Sta. Graciela"; break;
	                         case 22: santo = "Sta. Mar�a Reina"; break;
	                         case 23: santo = "Sto. Donato"; break;
	                         case 24: santo = "S. Bartolom�"; break;
	                         case 25: santo = "S. Luis Rey"; break;
	                         case 26: santo = "Sta. Teresa Jornet - S. C�sar"; break;
	                         case 27: santo = "Sta. M�nica"; break;
	                         case 28: santo = "S. Agust�n"; break;
	                         case 29: santo = "Sta. Sabina"; break;
	                         case 30: santo = "Sta. Rosa de Lima"; break;
	                         case 31: santo = "Sto. Ram�n Nonato"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 8: {
	                    switch(dia)
	                    {
	                         case 1: santo = "S. Arturo"; break;
	                         case 2: santo = "S. Mois�s"; break;
	                         case 3: santo = "S. Gregorio"; break;
	                         case 4: santo = "Sta. Irma - Sta. Herminia"; break;
	                         case 5: santo = "S. Victorino (Victoriano)"; break;
	                         case 6: santo = "Sta. Eva"; break;
	                         case 7: santo = "Sta. Regina"; break;
	                         case 8: santo = "Natividad de Mar�a"; break;
	                         case 9: santo = "S. Segio - S. Omar"; break;
	                         case 10: santo = "S. Nicol�s de T."; break;
	                         case 11: santo = "Ss. Orlando y Rolando"; break;
	                         case 12: santo = "Sto. Nombre de Mar�a"; break;
	                         case 13: santo = "S. Juan Cris�stomo"; break;
	                         case 14: santo = "Sta. Imelda"; break;
	                         case 15: santo = "N. Sra. de los Dolores"; break;
	                         case 16: santo = "S. Cornelio - S. Cipriano"; break;
	                         case 17: santo = "S. Roberto - S. Belarmino"; break;
	                         case 18: santo = "S. Jos� de Cupertino"; break;
	                         case 19: santo = "S. Jenaro"; break;
	                         case 20: santo = "Sta. Amelia"; break;  //El Amuleto...
	                         case 21: santo = "S. Mateo"; break;
	                         case 22: santo = "S. Mauricio"; break;
	                         case 23: santo = "S. Lino (a)"; break;
	                         case 24: santo = "N. Sra. de la Merced"; break;
	                         case 25: santo = "Sta. Aurelia"; break;
	                         case 26: santo = "S. Cosme - S. Demi�n"; break;
	                         case 27: santo = "S. Vicente de Paul"; break;
	                         case 28: santo = "S. Wenceslao"; break;
	                         case 29: santo = "Ss. Gabriel, Miguel y Rafael"; break;
	                         case 30: santo = "S. Jer�nimo"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 9: {
	                    switch(dia)
	                    {
	                         case 1: santo = "Sta. Teresa del Ni�o Jes�s"; break;
	                         case 2: santo = "Ss. angeles Custodios"; break;
	                         case 3: santo = "S. Gerardo"; break;
	                         case 4: santo = "S. Francisco de As�s"; break;
	                         case 5: santo = "Sta. Flor"; break;
	                         case 6: santo = "S. Bruno"; break;
	                         case 7: santo = "N. Sra. del Rosario"; break;
	                         case 8: santo = "N. Sra. de Bego�a"; break;
	                         case 9: santo = "S. Dionisio"; break;
	                         case 10: santo = "S. Francisco de Borja"; break;
	                         case 11: santo = "Sta. Soledad"; break;
	                         case 12: santo = "N. Sra. del Pilar"; break;
	                         case 13: santo = "S. Eduardo"; break;
	                         case 14: santo = "S. Calixto"; break;
	                         case 15: santo = "Sta. Teresa de �vila"; break;
	                         case 16: santo = "Sta. Eduvigis - Sta. Margarita"; break;
	                         case 17: santo = "S. Ignacio de Antioqu�a - Sta. Isolina"; break;
	                         case 18: santo = "S. Lucas"; break;
	                         case 19: santo = "S. Renato"; break;
	                         case 20: santo = "Sta. Irene"; break;
	                         case 21: santo = "Sta. �rsula - Sta. Celinda"; break;
	                         case 22: santo = "Sta. Sara"; break;
	                         case 23: santo = "S. Remigio"; break;
	                         case 24: santo = "S. Antonio Mar�a Claret"; break;
	                         case 25: santo = "Sta. Olga"; break;
	                         case 26: santo = "S. Dar�o"; break;
	                         case 27: santo = "S. Gustavo"; break;
	                         case 28: santo = "S. Sim�n - S. Judas"; break;
	                         case 29: santo = "S. Narciso"; break;
	                         case 30: santo = "S. Alonso"; break;
	                         case 31: santo = "S. Quint�n"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 10: {
	                    switch(dia)
	                    {
	                         case 1: santo = "Todos Los Santos"; break;
	                         case 2: santo = "Todos los Difuntos"; break;
	                         case 3: santo = "S. Mart�n de Porres"; break;
	                         case 4: santo = "S. Carlos"; break;
	                         case 5: santo = "S. Silvia"; break;
	                         case 6: santo = "S. Leonardo"; break;
	                         case 7: santo = "S. Ernesto"; break;
	                         case 8: santo = "S. Godofredo - Ninfa"; break;
	                         case 9: santo = "S. Teodoro - Dora"; break;
	                         case 10: santo = "S. Le�n"; break;
	                         case 11: santo = "S. Mart�n de Tours"; break;
	                         case 12: santo = "S. Cristi�n"; break;
	                         case 13: santo = "S. Diego"; break;
	                         case 14: santo = "S. Humberto"; break;
	                         case 15: santo = "S. Alberto"; break;
	                         case 16: santo = "Sta. Margarita de Escocia - Sta. Gertrudis"; break;
	                         case 17: santo = "Sta. Isabel de Hungr�a"; break;
	                         case 18: santo = "Sta. Elsa - Sta. Elisa"; break;
	                         case 19: santo = "S. Andr�s Avelino"; break;
	                         case 20: santo = "S. Edmundo"; break;
	                         case 21: santo = "Presentaci�n de la Virgen"; break;
	                         case 22: santo = "Sta. Cecilia"; break;
	                         case 23: santo = "S. Clemente"; break;
	                         case 24: santo = "Sta. Flora"; break;
	                         case 25: santo = "Sta. Catalina Labour�"; break;
	                         case 26: santo = "Sta. Delfina"; break;
	                         case 27: santo = "S. Virgilio (a)"; break;
	                         case 28: santo = "Sta. Blanca"; break;
	                         case 29: santo = "S. Saturnino"; break;
	                         case 30: santo = "S. Andr�s (a)"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	        case 11: {
	                    switch(dia)
	                    {
	                         case 1: santo = "Sta. Florencia"; break;
	                         case 2: santo = "Sta. Viviana"; break;
	                         case 3: santo = "S. Francisco Javier"; break;
	                         case 4: santo = "Sta. B�rbara"; break;
	                         case 5: santo = "Sta. Ada"; break;
	                         case 6: santo = "S. Nicol�s"; break;
	                         case 7: santo = "S. Ambrosio"; break;
	                         case 8: santo = "Inmaculada Concepci�n"; break;
	                         case 9: santo = "Sta. Jessica"; break;
	                         case 10: santo = "N. Sra. de Loreto - Sta. Eulalia"; break;
	                         case 11: santo = "S. D�maso"; break;
	                         case 12: santo = "N. Sra. de Guadalupe"; break;
	                         case 13: santo = "Sta. Luc�a - Sta. Aurora"; break;
	                         case 14: santo = "Sto. Juan de la Cruz"; break;
	                         case 15: santo = "S. Reinaldo"; break;
	                         case 16: santo = "Sta. Alicia"; break;
	                         case 17: santo = "S. L�zaro"; break;
	                         case 18: santo = "Sta. Sonia"; break;
	                         case 19: santo = "S. Urbano - S. Nemesio"; break;
	                         case 20: santo = "Ss. Abraham, Isaac y Jacob"; break;
	                         case 21: santo = "S. Pedro Canisio"; break;
	                         case 22: santo = "Sta. Fabiola"; break;
	                         case 23: santo = "Sta. Victoria"; break;
	                         case 24: santo = "Sta. Adela"; break;
	                         case 25: santo = "Natividad del Se�or"; break;
	                         case 26: santo = "S. Esteban"; break;
	                         case 27: santo = "S. Juan Ap�stol"; break;
	                         case 28: santo = "Santos Inocentes"; break;
	                         case 29: santo = "Sto. Tom�s Becket - S. David"; break;
	                         case 30: santo = "S. Rogelio"; break;
	                         case 31: santo = "S. Silvestre"; break;
	                         default: santo = "Error en el d�a"; break;
	                    }
	                }                                        break;
	       default: santo = "Error en el mes"; break;
	   } 
	}

	
	public static String santoralHoy()
	{
		return "El Santoral de Hoy es : " + (new Santoral().elSanto())+"." ;
	}
	
	public String elSanto()
	{
	    return santo;
	}
}
