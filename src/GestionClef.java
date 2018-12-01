

import java.util.Scanner;

public class GestionClef {
	static final int NB_CLEF = 50;
	
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner (System.in))
		{
			// variables
			int id, indiceTabDispo = 0 ;
			Clef clef[]= new Clef[NB_CLEF];
			String choix;
			boolean exit = true;
			boolean present = false;
			
			//saisie du choix de l'utilisateur				
				do
				{
						System.out.println("=================================");
					    System.out.println("|             MENU              |");
					    System.out.println("=================================");
					    System.out.println("| Options:                      |");
					    System.out.println("|        1. Ajouter une clef    |");
					    System.out.println("|        2. Supprimer une clef  |");
					    System.out.println("|        3. Modifier une clef   |");
					    System.out.println("|        4. Liste des clefs     |");
					    System.out.println("|        5. Rechecher           |");
					    System.out.println("|        6. Sortir              |");
					    System.out.println("=================================");
					    System.out.println(" Votre choix ?");
					
					choix = sc.nextLine();
				
					switch(choix)
					{
						case "1":  //Ajout d'une clef
							 do {
									System.out.println("veuillez saisir l'id de la clef : "); //récupération de l'id de la clé a rentrer
									id = sc.nextInt();
									sc.nextLine();
									indiceTabDispo = HandlerClef.PremierEmplVide(clef, NB_CLEF);
									present = HandlerClef.isPresentId(id,NB_CLEF, clef);
															
									if (!present)
									{
										HandlerClef.AddClef(id,indiceTabDispo,clef);//										
									}
									else
									{
										System.out.println("L'id est déjà présent");
									}
																	
								}while(present);
								
							break;
						
						case "2": //Suppresson d'une clef
							do
							{
								System.out.println("veuillez saisir l'id de la clef à supprimer: ");
		
								id = sc.nextInt();
								sc.nextLine();
								
								//indiceTabDispo = HandlerClef.PremierEmplVide(clef, NB_CLEF);
								present = HandlerClef.isPresentId(id,NB_CLEF, clef);
								if (present)
								{
									clef[HandlerClef.ReturnIndiceId(id, clef, NB_CLEF)]= null;
									System.out.println("La clef n° " + id + " est supprimée.");
								}
								else
								{
									System.out.println("L'ID n'est pas présent");
								}
							}while(!(present));	
						break;
						
						case "3":
							do
							{
								System.out.println("veuillez saisir l'id de la clef à modifier: ");
		
								id = sc.nextInt();
								sc.nextLine();
								
								indiceTabDispo = HandlerClef.PremierEmplVide(clef, NB_CLEF);
																					
								if(HandlerClef.isPresentId(id, NB_CLEF , clef))
								{
									clef[HandlerClef.ReturnIndiceId(id, clef, indiceTabDispo)]= HandlerClef.AddChamp(HandlerClef.ReturnIndiceId(id, clef, indiceTabDispo),clef);
								}		
								else
								{
									System.out.println("L'ID n'est pas présent.");
								}
							}while(!(HandlerClef.isPresentId(id,NB_CLEF, clef)));
						break;
						
						case "4":
									HandlerClef.List(NB_CLEF, clef);
						break;
						
						case "5":
									HandlerClef.Search(clef, NB_CLEF);
						break;
												
						case "6":
								exit = false;
						break;
						default : System.out.println("Erreur de saisie");
				}		
								
			}while (exit);
		
		}
	}
}
