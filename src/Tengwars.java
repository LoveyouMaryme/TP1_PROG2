import java.lang.classfile.ClassTransform;
import java.util.ArrayList;
import java.util.Scanner;

public class Tengwars {

    String phrase;
    public static String quenyaVersTengwarLaTeX( String entrees ) {
        return "";
    }

    public Tengwars(String phrase){
        this.phrase = phrase;
    }

//    public String translateCharacters(String latinLetter){
//
//        TengwarScript[] TengwarLetters = TengwarScript.values();
//        for(int i = 0; i < TengwarLetters.length; i++){
//
//            System.out.println("Day at index " + i + ": " + TengwarLetters[i]);
//
//            TengwarScript test = new TengwarScript(TengwarLetters[i]);
//
//            if(latinLetter.equals(TengwarLetters[i])){
//
//                System.out.println("yay");
//
//            }
//
//
//
//        }
//
//        return "";
//
//
//    }

    public static String translateLatinLetter(String latinLetters){

        TengwarScript [] alphabeticalTengar =  TengwarScript.values();
        String translatedLetter = "";

        for(int i = 0; i < alphabeticalTengar.length ; i++){

            if(latinLetters.equals(alphabeticalTengar[i].getClassic())){

                translatedLetter = alphabeticalTengar[i].getCommandeLaTeX();
            }

        }

        return translatedLetter;
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

    public ArrayList<Character> getLatinSequenceUpperCase(String word) {

        ArrayList<Character> latinSequenceUpperCase = new ArrayList<>();
        char[] array_sentence = word.toCharArray();
        int wordLength = array_sentence.length;
        char letter = array_sentence[wordLength - 1];

        if (isCapitalizedLetter(letter)) {
            latinSequenceUpperCase.add(letter);

        }
        return latinSequenceUpperCase;
    }

    public ArrayList<String> separateUpperCase(String word) {

        ArrayList<String> separatedUpperCase = new ArrayList<>();
        char[] array_sentence = word.toCharArray();
        int wordLength = array_sentence.length;

        for(int i = wordLength - 1; i >= 0; i--){

            char letter = array_sentence[i];

            if (isCapitalizedLetter(letter)) {
            separatedUpperCase.addFirst(String.valueOf(letter));
            } else if( (letter == 'u' || letter == 'w')) {

                if (array_sentence[i - 2] == 'n') {

                    String lowerCase = "" + array_sentence[i - 2] + array_sentence[i - 1] + letter;
                    separatedUpperCase.addFirst(lowerCase);

                    i -= 2;

                } else {
                    String lowerCase = "" + array_sentence[i - 1] + letter;
                    separatedUpperCase.addFirst(lowerCase);
                    i--;

                }

            }
            else {
                String lowerCase = ""   + array_sentence[i-1] + letter ;
                separatedUpperCase.addFirst(lowerCase);
                i -= 1;
            }
        }

//
//
//        if (letter == 'u' || letter == 'w'){
//        }
        return separatedUpperCase;
    }

    public ArrayList<Character> getLatinSequenceLowerCase(String word){

        ArrayList<Character> latinSequenceLowerCase = new ArrayList<>();

        char[] array_sentence = word.toCharArray();
        int wordLength = array_sentence.length;

        for (int i = wordLength - 1; i >= 0; i--) {

            char letter = array_sentence[i];

            if (!isCapitalizedLetter(letter)) {
                latinSequenceLowerCase.add(letter);
            }


        }
        return latinSequenceLowerCase;
    }


}
