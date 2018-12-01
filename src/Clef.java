

public class Clef {
	private int id;
	private String porte, marque, matiere, proprietaire,technologie;
	private boolean isDisponibilite;
	
	//Clef clef[];
	
	public Clef(int id, String porte, String marque,String technologie, String matiere, boolean isDisponibilite, String proprietaire){
		
		this.id = id;
		this.porte = porte;
		this.marque = marque;
		this.technologie = technologie;
		this.matiere = matiere;
		this.isDisponibilite = isDisponibilite;
		this.proprietaire = proprietaire;
	    }
	
	public int GetId()
	{
		return this.id;
	}
	public String GetPorte()
	{
		return this.porte;
	}
	public int SetId(int id)
	{
		 return this.id = id;
	}
	public String SetPorte(String porte)
	{
		 return this.porte = porte;
	}

	public String SetMarque(String marque)
	{
		 return this.marque = marque;
	}
	public String SetTechnologie(String technologie)
	{
		 return this.technologie = technologie;
	}
	public boolean SetIsDisponibilite(boolean disponibilite)
	{
		 return this.isDisponibilite = disponibilite;
	}
	public String SetMatiere(String matiere)
	{
		 return this.matiere = matiere;
	}
	public String SetProprietaire(String proprietaire)
	{
		 return this.proprietaire = proprietaire;
	}
	public String GetMarque()
	{
		return this.marque;
	}
	public String GetTechnologie()
	{
		return this.technologie;
	}
	public String GetMatiere()
	{
		return this.matiere;
	}
	
	public boolean GetIsDisponibilite()
	{
		return this.isDisponibilite;
	}	
	public String GetProprietaire()
	{
		return this.proprietaire;
	}
	
	
}
