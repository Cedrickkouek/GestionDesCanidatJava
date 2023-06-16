package entities;

//import java.util.List;

public class Matiere {
    private String nomMatiere;
    private double note;

   // private List<String> ListMatiere; 

    public Matiere(){}; //Le constructeur Matiere
    
    public Matiere(String nomM, double noteM){
        this.nomMatiere = nomM;
        this.note = noteM;
    }

    //Cette methode retourne la valeur de nomMatiere
    public String getnomMatiere()
    {
        return this.nomMatiere;
    }

    //Cette methode retourne la valeur de note
    public Double getNote(){
        return this.note;
    }

    //Cette methode attribut une nouvelle valeur au nom de la matiere
    public void setNomMatiere(String n)
    {
        this.nomMatiere = n;
    }

    //Cette methode attribut une nouvelle valeur à la note de la matiere
    public void setNote(double noteM)
    {
        this.note = noteM;
    }

   /* public List<String> getListMatiere()
    {

    } */

    enum nomMatiere{
        MATH,
        PHY,
        CHE,
        BIO,
        GEO,
        FRE,
        ENG,
        LIT,
        ECO,
        CSC
    }
}


