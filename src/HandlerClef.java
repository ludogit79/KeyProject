

import java.util.Scanner;

public class HandlerClef {
	int taille = 50;
	Clef clef[]= new Clef[taille];
	
	public static void List(int taille, Clef clef[]) // Affichage de la liste des clefs
	{
		int compteur = 0;
		for (int i = 0 ; i < taille-1 ; i++ )
		{
			if (clef[i] == null){
				
			}
			else{
				AffichageClef(clef, i); // Affichage d'une clef
				compteur++;
			}
		}
		System.out.println("\n" + "Nombre de clef : " + compteur);
	}
	
	//////////////////////////////////////////////////
	
	public static boolean isPresentId(int id,int taille ,Clef clef[]) // Vérification de la présence de ID clef dans le trouseau de clef.
	{
		boolean present =false;
		int compteur = 0;
		do
		{
			if(clef[compteur] == null)
			{
				present = false;
			}
			else if(id == clef[compteur].GetId())
			{
				present = true;
			}
			compteur++;
		}while((!present) && (compteur < taille));
		
			return present;
	}
	
		
	/////////////////////////////////////////////////////
		
	public static int ReturnIndiceId(int id, Clef clef[], int taille)  // Retourne l'indice de la l'ID clef recherché
	{
		int compteur = 0; 
		int i = 0;
		
		do {
			if(clef[i] != null && id == clef[i].GetId())
			{
				compteur = i;
			}
				i++;			
		}while(( clef[i-1] == null || id != clef[i-1].GetId() ) && i-1 < taille);   //problème évaluation condition
			
		return compteur;
	}
	
	////////////////////////////////////////////
	public static void AddClef(int id, int indiceTabDispo, Clef clef[])
	{
			String choix, porte, marque, matiere, proprietaire;
			String technologie = "";
			char techno;
			boolean control = false;
			char disponibilite = ' ';
			boolean dispo;
			
			Scanner sc = new Scanner (System.in) ;
			
			System.out.println("veuillez saisir le type de porte : ");
			porte = sc.nextLine();
			
			System.out.println("veuillez saisir la marque de la clef : ");
			marque = sc.nextLine();
			
			do
			{
				System.out.println("veuillez saisir la techno. de la clef : m pour mécanique, n pour numérique ");
				techno = sc.nextLine().charAt(0);	
				
				if(techno == 'm')
				{
					technologie = "mécanique";
					control = false;
				}
				else if(techno == 'n')
				{
					technologie = "numérique";
					control = false;
				}
				else
				{
					System.out.println("Problème de saisie");
					control = true;
				}
			}while(control);
			
			System.out.println("veuillez saisir la matière : ");
			matiere = sc.nextLine();
			
			System.out.println("veuillez saisir la disponibilite de la clef O/N: ");
			disponibilite = sc.nextLine().toUpperCase().charAt(0);
			dispo = (disponibilite == 'O') ? true : false;
			
			System.out.println("veuillez saisir le propriétaire de la clef : ");
			proprietaire = sc.nextLine();
			
			Clef clef1 = new Clef(id, porte, marque, technologie, matiere, dispo, proprietaire);
			 clef[indiceTabDispo] = clef1;
	}
	
	////////////////////////////////////////////
	
	public static Clef AddChamp(int id,Clef clef[])  // Update des champs d'une clef spécifiée.
	{
		Scanner sc = new Scanner (System.in) ;
		System.out.println("Quel champs voulez vous modifier : (p)orte,(m)arque, (t)echno, (ma)tiere, (d)ispo, (pr)oprio ?");
		String reponse = sc.nextLine();
		boolean disponibilite;
		
		switch(reponse)
		{
			case "p":
				System.out.println("Quelle est la nouvelle valeur de la porte ? ");
				clef[id].SetPorte(sc.nextLine());
			break;
			
			case "m":
				System.out.println("Quelle est la nouvelle valeur de la marque ? ");
				clef[id].SetMarque(sc.nextLine());
			break;
			
			case "t":
				
				String technologie = "";
				boolean control = false;
				char techno;
				
				do
				{
					System.out.println("Quelle est la nouvelle valeur de la technologie ? : m pour mécanique, n pour numérique ");
					techno = sc.nextLine().charAt(0);	
					
					if(techno == 'm')
					{
						technologie = "mécanique";
						control = false;
					}
					else if(techno == 'n')
					{
						technologie = "numérique";
						control = false;
					}
					else
					{
						System.out.println("Problème de saisie");
						control = true;
					}
				}while(control);
				
				clef[id].SetTechnologie(technologie);
			break;
			
			case "ma":
				System.out.println("Quelle est la nouvelle valeur de la matiere ? ");
				clef[id].SetMatiere(sc.nextLine());
			break;
			
			case "d":
				System.out.println("Quelle est la nouvelle valeur de la disponibilite o/n ? ");
				disponibilite = ((sc.nextLine().charAt(0) == 'o') ? true : false);
				clef[id].SetIsDisponibilite(disponibilite);
			break;
			
			case "pr" : 
				System.out.println("Quelle est le nouveau nom du propiétaire ? ");
				clef[id].SetProprietaire(sc.nextLine());
			break;
			
			default: System.out.println("Mauvaise saisie");
		}
		return  clef[id];
	}
	
	/////////////////////////////////////
	
	public static void Search(Clef clef[],int taille)   // Fonction de recherche par champs
	{
		Scanner sc = new Scanner (System.in) ;
		System.out.println("================================================");
	    System.out.println("|                MENU  RECHERCHE               |");
	    System.out.println("================================================");
	    System.out.println("| Options:                                     |");
	    System.out.println("|      1. Rechercher des portes                 |");
	    System.out.println("|      2. Rechercher par marque de clef        |");
	    System.out.println("|      3. Rechercher par technologie de clef   |");
	    System.out.println("|      4. Rechercher par matière               |");
	    System.out.println("|      5. Rechercher les clefs disponibles      |");
	    System.out.println("|      6. Rechercher les clefs indisponibles    |");
	    System.out.println("|      7. Rechercher par propriétaire          |");
	    System.out.println("================================================");
	    System.out.println(" Votre choix ?");
		String reponse = sc.nextLine();
		boolean disponibilite;
		
		switch(reponse) 
		{		case "1":
						System.out.println("Quelle valeur pour le champs , pour porte ?");
						String valeur = sc.nextLine();			
						System.out.println("Clef(s) correspondant(es) à la recherche");
						for (int i = 0 ; i<=taille-1; i++)
						{
							if( (clef[i] != null) && (clef[i].GetPorte().equals(valeur) ))
							{
								AffichageClef(clef, i);
							}
						}
				break;
				
				case "2":
					System.out.println("Quelle valeur pour le champs pour marque ?");
						String valeur_marque = sc.nextLine();			
						System.out.println("Clef(s) correspondant(es) à la recherche");
						for (int i = 0 ; i<=taille-1; i++)
						{
							if( (clef[i] != null) && (clef[i].GetMarque().equals(valeur_marque) ))
							{
								AffichageClef(clef, i);
							}
						}					
				break;
				
				case "3":
					System.out.println("Quelle valeur pour le champs technologie ?");
						String valeur_tech = sc.nextLine();			
						System.out.println("Clef(s) correspondant(es) à la recherche");
						for (int i = 0 ; i<=taille-1; i++)
						{
							if( (clef[i] != null) && (clef[i].GetTechnologie().equals(valeur_tech) ))
							{
								AffichageClef(clef, i);
							}
						}
				break;
	
				case "4":
						System.out.println("Quelle valeur pour le champs matière ?");
						String valeur_mat = sc.nextLine();			
						System.out.println("Clef(s) correspondant(es) à la recherche");
						for (int i = 0 ; i<=taille-1; i++)
						{
							if( (clef[i] != null) && (clef[i].GetMatiere().equals(valeur_mat) ))
							{
								AffichageClef(clef, i);
							}
						}					
				break;
				
				case "5":
						System.out.println("les clefs diponibles sont : ");
									
						for (int i = 0 ; i<=taille-1; i++)
						{
							if( (clef[i] != null) && (clef[i].GetIsDisponibilite() ))
							{
								AffichageClef(clef, i);
							}
						}			
				break;
				
				case "6":
					System.out.println("les clefs indiponibles sont : ");
								
					for (int i = 0 ; i<=taille-1; i++)
					{
						if( (clef[i] != null) && (!clef[i].GetIsDisponibilite() ))
						{
							AffichageClef(clef, i);
						}
					}			
			break;
				
				case "7" : 
						System.out.println("Quelle valeur pour le champs propriétaire ?");
						String valeur_proprio = sc.nextLine();
			
						System.out.println("Clef(s) correspondant(es) à la recherche");
						for (int i = 0 ; i<=taille-1; i++)
						{
							if( (clef[i] != null) && (clef[i].GetProprietaire().equals(valeur_proprio) ))
							{
								AffichageClef(clef, i);
							}
						}			
				break;
				default: System.out.println("Mauvaise saisie");
		}
	}
	
	///////////////////////////////////////
	
	public static int PremierEmplVide(Clef clef[], int taille)
	{
		int id = 0; 
		int i = 0;	
		//retourne le premier emlpacement vide
		do {
			if(clef[i] == null)
			{
				id = i;
			}
			else
			{
				i++;
				id = i;
			}
		}while(clef[i] != null && i < taille);
			
		return id;
	}
	
	/////////////////////////////////////////
	
	public static void AffichageClef(Clef clef[], int indice)
	{	
			System.out.println("Pour la clef " 
				 + "ID : " + clef[indice].GetId() + " / " 
				 + "Porte : " +clef[indice].GetPorte() + " / " 
				 + "Marque : " +clef[indice].GetMarque() + " / " 
				 + "Technologie : " +clef[indice].GetTechnologie() + " / "
				 + "Matière : " +clef[indice].GetMatiere() + " / "
				 + "Disponibilité : " +clef[indice].GetIsDisponibilite() + " / "
				 + "Propriétaire : " +clef[indice].GetProprietaire() ) ;
	}
	
}
