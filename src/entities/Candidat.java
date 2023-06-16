package entities;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import enumeration.Decision;
//import entities.Matiere;
import entities.Matiere.nomMatiere;

public class Candidat {
    private String nom;
    private String prenom;
    private int age;
    private long ncin;
    private double moy;
    private ArrayList<Boolean> etatN = new ArrayList<Boolean>();
    private ArrayList<Matiere> matieres =  new ArrayList<Matiere>();   
    private Decision decision;


    //ecrire un constructeur pour nom, age, NCIN ensuite ecrivez les differentes 
    //methodes qui nous permettront de modifier et d'avoir accès au contenu des different candidats

    public Candidat(){};

    public Candidat(String nom, String prenom, int age, long ncin /*List<Matiere> matieres, Decision decision*/)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ncin = ncin;

        lireCandidat();
        /*this.matieres = matieres;
        this.decision = decision;*/
    }

     //Cette methode retourne le nom
     public String getNom(){
        return this.nom;
     }

     //Cette methode retourne le prenom
     public String getPrenom(){
        return this.prenom;
     }

     //Cette methode retourne l'age
     public int getAge(){
        return this.age;
     }

     //Cette methode retourne le numero de CNI
     public long getNcin(){
        return this.ncin;
     }

     //Cette methode retourne la liste des matières
     public List<Matiere> getMatiere(){
        return this.matieres;
     }

     //Cette methode retourner le nom
     public Decision getDecision(){
        return this.decision;
     }
    
          //Cette methode retourner le nom
     public void setNom(String nom){
        this.nom = nom;
     }

     //Cette methode retourner le prenom
     public void setPrenom(String prenom){
        this.prenom = prenom;
     }

     //Cette methode retourner l'age
     public void setAge(int age){
        this.age = age;
     }

     //Cette methode retourner le numero de CNI
     public void setNcin(long ncin){
        this.ncin =  ncin;
     }

     //Cette methode modifie la liste des matieres
     public void setMatiere(ArrayList<Matiere> matieres){
        this.matieres = matieres;
     }

     //Cette methode modifie la decision
     public void setDecision(Decision decision){
        this.decision = decision;
     }

     public void saisirNote()
     {
      try(Scanner scanner = new Scanner(System.in))
      {
         System.out.println("\nVeuillez entrer les notes du candidate "+this.nom+" "+this.prenom);

         for(nomMatiere nomM : nomMatiere.values())
         {
            Matiere m = new Matiere();

            m.setNomMatiere(nomM.toString());
            System.out.println("Entrez la note de "+nomM.toString());
            double note = scanner.nextDouble();
            m.setNote(note);
            matieres.add(m);

            System.out.println();
         }
         etatNote();
         moyC();
         Decision(this.moy);
         afficherNote();
      }
     
    }

      
      /*try (Scanner Scanner = new Scanner(System.in)) {
         
         Matiere classObj = new Matiere(); 

         System.out.println("Entrez le numero de la CNI du Candidat :");
         long cni = Scanner.nextLong();
         setNcin(cni);

         System.out.println("Entrez le nom du Candidat :");
         String nom = Scanner.nextLine();
         setNom(nom);

         System.out.println("Entrez le prenom du Candidat :");
         String prenom = Scanner.nextLine();
         setPrenom(prenom);

         System.out.println("Entrez l'age du Candidat :");
         int age = Scanner.nextInt();
         setAge(age);

         System.out.println("Entrez les  notes du candiat "+nom);
         for(int i=0; i<10; i++)
         {
            System.out.println("Entrez la note de la matiere ");
            int note = Scanner.nextInt();
            this.matieres.add(i, classObj.setNote(note));
         }
      }*/
     

     private void afficherNote()
      {
         System.out.println("\tMatiere\t|\tNote\n");
         System.out.println("-------------------------");
         for (Matiere matiere: this.matieres)
         {
            System.out.println("\t"+matiere.getnomMatiere()+"\t|\t"+matiere.getNote());
            System.out.println("-------------------------");
         }
         System.out.println("\n\t");
         System.out.println("La moyenne du candidat "+this.nom+" "+this.prenom+" est: "+this.moy);
         System.out.println("\n -------------------------\n");
         System.out.println("La Decision du candidat "+this.nom+" "+this.prenom+" est: "+this.decision);
         System.out.println("\n -------------------------\n");

      }

      private void moyC()
      {
         double sum = 0, moyenne = 0;
         for(Matiere note: this.matieres)
         {
            sum = sum + note.getNote();
         }
         moyenne = sum/10;
         this.moy = moyenne;
      }

      //La methode etatNote() permet de verifier si au moins une des 
      // des 10 notes du candidat est inferieur à 10 ou non.
      private void etatNote()
      {
         boolean etat;
         for(Matiere note: this.matieres)
         {
            if(note.getNote() < 10)
            {
               etat=false;
               etatN.add(etat);
            }
            else if(note.getNote() >= 10)
            {
               etat=true;
               etatN.add(etat);
            }
         }
      }

      private void Decision(double moye)
      {
         for(Boolean etat: this.etatN)
         {
            if((moye>10) && (etat == true))
            {
               this.decision = Decision.ADMIS; //La valeur de decision sera determinée par la dernière valeur de etat, 
               continue;                                //vu que moy est une valeur fixe dès le depart.
            }
            else if((moye>10) && (etat == false))
            {
               this.decision = Decision.AJOURNE;
               break;
            }
            else
            {
               this.decision = Decision.REFUSE;
               break;
            }
         }
      }

      public void lireCandidat()
      {
         try(Scanner scanner = new Scanner(System.in))
         {
            System.out.println("\t\nVeuillez entrer les informations du Candidat: \n\n");
         
            System.out.println("\t\nVeuillez entrer le nom du Candidat: \n");
            String nom = scanner.nextLine();
            setNom(nom);

            System.out.println("\t\nVeuillez entrer le prenom du Candidat "+this.nom+" : \n");
            String prenom = scanner.nextLine();
            setPrenom(prenom);

            System.out.println("\t\nVeuillez entrer l'age du Candidat "+this.nom+" "+this.prenom+" : \n");
            int age = scanner.nextInt();
            setAge(age);

            System.out.println("\t\nVeuillez entrer le numero de CNI du Candidat "+this.nom+" "+this.prenom+" : \n");
            long cni = scanner.nextLong();
            setNcin(cni);

            saisirNote();
         }
         
      }

      public void Description()
      {
         System.out.println("\t\t\t\n-------------LES INFORMATIONS DU CANDIDAT SONT COMME SUIT-------------\n\n");
         System.out.println("\t Nom du Candidat: "+this.nom+"\n\n");
         System.out.println("\t Prenom du Candidat: "+this.prenom+"\n\n");
         System.out.println("\t Age du Candidat: "+this.age+"\n\n");
         System.out.println("\t Numero de la cni du Candidat: "+this.ncin+"\n\n");
         etatNote();
         moyC();
         Decision(this.moy);
         afficherNote();
      }
}
