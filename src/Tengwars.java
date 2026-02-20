import java.util.Scanner;

public class Tengwars {

    String phrase;
    public static String quenyaVersTengwarLaTeX( String entrees ) {
        return "";
    }

    public Tengwars(String phrase){
        this.phrase = phrase;
    }

    public String translateCharacters(String latinLetter){

        TengwarScript[] TengwarLetters = TengwarScript.values();
        for(int i = 0; i < TengwarLetters.length; i++){

            System.out.println("Day at index " + i + ": " + TengwarLetters[i]);

            TengwarScript test = new TengwarScript(TengwarLetters[i]);

            if(latinLetter.equals(TengwarLetters[i])){

                System.out.println("yay");

            }



        }

        return "";


    }
    public String parcourirChaineCaractere(String phrase){

         Scanner sc = new Scanner(phrase).useDelimiter(".");

         while(sc.hasNext()){
             System.out.println(sc.next());
         }

         sc.close();

        return "";
    }
}
