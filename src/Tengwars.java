import java.lang.classfile.ClassTransform;
import java.util.ArrayList;
import java.util.Scanner;

public class Tengwars {

    String phrase;
    public static String quenyaVersTengwarLaTeX( String entrees ) {

        Tengwars translation = new Tengwars(entrees);

        String[] mots = translation.breakdownSentences(entrees);

        StringBuilder motsTraduits = new StringBuilder();

        for (int i = 0; i < mots.length; i++) {
            //prend le mot courant et le transforme en array de caractères légaux
            ArrayList<String> lettresSeparees = translation.separateUpperCase(mots[i]);
            //traduit le caractère courant en tengwar
            ArrayList<String> lettresTraduites = translation.parcourirStringToTranslate(lettresSeparees);

            //on ajoute chaque lettre traduite dans la phrase traduite
            for (int j = 0; j < lettresTraduites.size(); j++) {
                motsTraduits.append(lettresTraduites.get(j));
            }
            if (i < mots.length - 1){
                motsTraduits.append(" ");
            }
        }
        return motsTraduits.toString();
    }

    public Tengwars(String phrase){
        this.phrase = phrase;
    }


    public static String translateLatinLetter(String latinLetters){

        TengwarScript [] alphabeticalTengar =  TengwarScript.values();
        String translatedLetter = "";

        for(int i = 0; i < alphabeticalTengar.length ; i++){

            if(latinLetters.equals(alphabeticalTengar[i].getClassic())){
                    translatedLetter = alphabeticalTengar[i].getCommandeLaTeX();
            }
        }

        if (translatedLetter.isEmpty()){
            throw new PasDuQuenyaException("Cette phrase n'existe pas en Quenya.");
        }

        return translatedLetter;
    }


    public ArrayList<String> parcourirStringToTranslate( ArrayList<String> word){

        ArrayList<String> translatedWord = new ArrayList<>();


        for(int i = 0; i < word.size(); i++ ){
            String translatedLetter = translateLatinLetter( word.get(i));
            translatedWord.add(translatedLetter);

        }

        return translatedWord;

    }


    public boolean isCapitalizedLetter(char letter){
        boolean isCapitalized = true;
        int zCharNumber = 90;

        if(letter >=  zCharNumber){
            isCapitalized = false;
        }


        return isCapitalized;
    }

    public String[] breakdownSentences(String phrase){

        String[] words = phrase.split(" ");

        return words;
    }

    public ArrayList<String> separateUpperCase(String word) {

        ArrayList<String> separatedUpperCase = new ArrayList<>();
        char[] array_sentence = word.toCharArray();
        int wordLength = array_sentence.length;

        for(int i = wordLength - 1; i >= 0; i--){

            char letter = array_sentence[i];

            // Case 1: Capital letter -> 1-letter cluster
            if (isCapitalizedLetter(letter)) {
            separatedUpperCase.addFirst(String.valueOf(letter));

            // Case 2: 3-letters cluster ( n + ? + u/w )
            } else if( (letter == 'u' || letter == 'w')) {

                if (array_sentence[i - 2] == 'n') {

                    String lowerCase = "" + array_sentence[i - 2] + array_sentence[i - 1] + letter;
                    separatedUpperCase.addFirst(lowerCase);

                    i -= 2;


                // Case 3: 2-letters cluster
                } else {
                    String lowerCase = "" + array_sentence[i - 1] + letter;
                    separatedUpperCase.addFirst(lowerCase);
                    i -= 1;

                }
            }
            // Case 3: 2-letters cluster
            else {
                String lowerCase = ""   + array_sentence[i-1] + letter ;
                separatedUpperCase.addFirst(lowerCase);
                i -= 1;
            }
        }

        return separatedUpperCase;
    }

}
