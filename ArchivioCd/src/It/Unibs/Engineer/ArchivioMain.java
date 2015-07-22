package It.Unibs.Engineer;

import MyClass.MyMenu;
import MyClass.MyScelta;
import MyClass.MyIO.MyIOconsole;
/**
 * Main del progetto ArchivioCd
 * @author Fapanni Tiziano & Simaz Andrea
 *
 */
public class ArchivioMain {
	
final static String TITOLO = "ARCHIVIO CD";
final static String[] SCELTE = { "aggiungi album",
	                             "visualizza album",
	                             "cerca album",
	                             "album casuale",
	                             "elimina album"
							};
final static String TIT_MENU_ALBUM = "MODIFICA ALBUM";
final static String[] SCELTE_ALBUM = { "aggiungi brano",
	                                   "visualizzi playlist",
	                                   "cerca brano",
	                                   "brano casuale",
	                                   "ritorna al menu Archivio CD"
							};
final static String INS_TIT = "Inserisci titolo : ";
final static String INS_AUT = "Inserisci autore : ";
final static String NUM_TRACK = "Inserisci numero traccia : ";

	public static void main(String[] args) {
		int scelta;
		boolean finito = false;
		boolean sceltaUscita = true;
		MyMenu menu = new MyMenu(TITOLO, SCELTE);
		ArchivioCD archivio = new ArchivioCD();
		MyScelta sceltaDue= new MyScelta('y', 'n', "(y/n)? ");
/**
 * Menù dell'archivioCd. Per ulteriori informazioni, guardare le classi utilizzate	
 */
		do{
			scelta = menu.scegli(sceltaUscita);
			
			switch(scelta){
				case 0 :
					System.out.println("sicuro di uscire");
					if(sceltaDue.sceltaDueVie()==true)
						finito = true;
					break;
				case 1 : 
					Cd cdNew = new Cd(MyIOconsole.leggiStringa(INS_TIT), MyIOconsole.leggiStringa(INS_AUT));
					boolean riuscito=archivio.inserisciCd(cdNew);
					if(riuscito){
						System.out.println("vuoi aggiungere altre informazioni per l'album  ");
						if(sceltaDue.sceltaDueVie()==true)
							ArchivioMain.menuAlbum(cdNew);
					}
					break;
				case 2 :
					System.out.print(archivio.toString());
					break;
				case 3 :
					Cd cd = archivio.cercaCd(MyIOconsole.leggiStringa(INS_TIT));
					if(cd != null){
					System.out.print(cd.toString());
					ArchivioMain.menuAlbum(cd);
					}
					else System.out.println("Album inesistente");
					break;
				case 4 :
					System.out.print(archivio.cdCasuale().toString());
					break;
				case 5 :
					archivio.eliminaCd(INS_TIT);
					break;
			}
				
				
				
		}while(!finito);
	}
	
	
private static void menuAlbum(Cd cd){
	boolean sceltaUscita = false;
	boolean finito = false;
	MyMenu menu = new MyMenu(TIT_MENU_ALBUM, SCELTE_ALBUM);
/**
 * Menù del Cd. Per ulteriori informazioni, guardare le classi utilizzate	
 */
	do{
		int scelta = menu.scegli(sceltaUscita);
		
		switch(scelta){
			case 1 : 
				cd.aggiungiBrano(new Brano(MyIOconsole.leggiStringa(INS_TIT), MyIOconsole.leggiIntero("durata : ")));
				break;
			case 2 :
				System.out.println(cd.toString());
				break;
			case 3 :
				try{
					System.out.println(cd.selezionaBrano(MyIOconsole.leggiIntero(NUM_TRACK)));
				}
				catch(IndexOutOfBoundsException exception){
					System.out.print("Brano non selezionabile");
				}
				break;
			case 4 :
				System.out.println(cd.branoCasuale().toString());
				break;
			case 5 : 
				finito = true;
				break;
			}
		
	}while(!finito);
	
}
}
