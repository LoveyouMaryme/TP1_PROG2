import java.util.ArrayList;

/**
 *
 * Permet de traduire un texte écrit en Quenya (lettres latines)
 * en commande LaTeX représentent des caractères Tengwar.
 *
 * Cette classe, en partenariat avec {@link TengwarScript}, permet de gérer les sous-groupes
 * de lettres latines afin de trouver leur bon correspondant en commande LaTeX.
 *
 */

public class Tengwars {


    public Tengwars(){}

    /**
     * Traduit les phrases écrites en Quenya (lettres latines) en phrase Tengwar avec des commandes LaTeX.
     *
     *  @param entrees : la phrase écrite en caractères latins à traduire.
     * @return La phrase traduite en Tengwar avec des commandes LaTeX.
     *
     */

    public static String quenyaVersTengwarLaTeX( String entrees ) {

        Tengwars translation = new Tengwars();

        String[] mots = translation.separePhraseEnMots(entrees);

        StringBuilder motsTraduits = new StringBuilder();

        for (int i = 0; i < mots.length; i++) {
            //prend le mot courant et le transforme en array de caractères légaux
            ArrayList<String> lettresSeparees = translation.separeMotEnSousGroupe(mots[i]);
            //traduit le caractère courant en tengwar
            ArrayList<String> lettresTraduites = translation.traduireMotDeQuenyaEnTengwar(lettresSeparees);

            //Si le mot contient des voyelles, on ajoute \Telco ou \Ara au début du mot traduit selon le cas
             motsTraduits.append(translation.ajoutPrefixeVoyelle(lettresSeparees));

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

    /**
     * Traduit un mot (sous forme de liste de sous-groupes de lettres) en Tengwar
     * avec commandes LaTeX.
     *
     * @param mot Liste de sous-groupes de lettres à traduire.
     * @return Liste des sous-groupes traduits en commandes LaTeX.
     */

    public ArrayList<String> traduireMotDeQuenyaEnTengwar(ArrayList<String> mot){

        ArrayList<String> motTraduit = new ArrayList<>();

        for(int i = 0; i < mot.size(); i++ ){
            String lettreTraduite = TengwarScript.traduitLettresLatines(mot.get(i));
            motTraduit.add(lettreTraduite);

        }

        return motTraduit;

    }


    /**
     * Vérifie si la lettre est en majuscule ou en minuscule
     *
     * @param lettre : Une lettre latine à vérifier.
     * @return true si la lettre latine est en majuscule, false si elle ne l'est pas.
     */
    public boolean estLettreMajuscule(char lettre){
        boolean estEnMajuscule = true;

        if(lettre >= 'Z'){
            estEnMajuscule = false;
        }

        return estEnMajuscule;
    }

    /**
     * Sépare une phrase en ses différents mots.
     *
     * @param phrase : La phrase écrite en lettre latine en Quenya.
     * @return Un tableau contenant les différents mots de la phrase.
     */
    public String[] separePhraseEnMots(String phrase){

        String[] mots = phrase.split(" ");

        return mots;
    }

    /**
     * Sépare un mot en sous-groupes de lettres afin de préparer la traduction
     * en commandes LaTeX.
     *
     * Règles de séparation :
     * <ul>
     *     <li>Majuscule : sous-groupe d'une seule lettre.</li>
     *     <li>Lettre 'u' ou 'w' précédée de 'n' deux positions avant : sous-groupe
     *         de 3 lettres (n + ? + u/w).</li>
     *     <li>Sinon : sous-groupe de 2 lettres.</li>
     * </ul>
     *
     * @param mot Le mot en Quenya (lettres latines).
     * @return Une liste de sous-groupes de lettres, prête pour la traduction.
     */
    public ArrayList<String> separeMotEnSousGroupe(String mot) {

        ArrayList<String> motSepareEnSousGroupe = new ArrayList<>();
        char[] motEnTableau = mot.toCharArray();
        int motLongueur = motEnTableau.length;

        for(int i = motLongueur - 1; i >= 0; i--){

            char lettre = motEnTableau[i];

            // Case 1: Lettre en majuscule -> Sous-groupe de 1 lettre
            if (this.estLettreMajuscule(lettre)) {
            motSepareEnSousGroupe.addFirst(String.valueOf(lettre));

            // Case 2: Sous-groupe de 3 lettres ( n + ? + u/w )
            } else if( (lettre == 'u' || lettre == 'w')) {

                if (motEnTableau[i - 2] == 'n') {

                    String lowerCase = "" + motEnTableau[i - 2] + motEnTableau[i - 1] + lettre;
                    motSepareEnSousGroupe.addFirst(lowerCase);

                    i -= 2;


                // Case 3: 2-letters cluster
                } else {
                    String lowerCase = "" + motEnTableau[i - 1] + lettre;
                    motSepareEnSousGroupe.addFirst(lowerCase);
                    i -= 1;

                }
            }
            // Case 3: 2-letters cluster
            else {
                String lowerCase = ""   + motEnTableau[i-1] + lettre;
                motSepareEnSousGroupe.addFirst(lowerCase);
                i -= 1;
            }
        }

        return motSepareEnSousGroupe;
    }

    /**
     * Vérifie si le premier sous-groupe d'un mot commence par une voyelle courte en Quenya.
     *
     * @param mot Liste de sous-groupes de lettres formant un mot en Quenya.
     * @return true si le mot commence par une voyelle courte ("A", "E", "I", "O", "U"), false sinon.
     */
    public boolean commenceAvecVoyelleCourte(ArrayList<String> mot){

        boolean commenceAvecVoyelleCourte = false;

        if (!mot.isEmpty()){
            switch (mot.getFirst()){
                case "A", "E", "I", "O", "U" ->{
                    commenceAvecVoyelleCourte = true;
                }
            }
        }

        return commenceAvecVoyelleCourte;
    }


    /**
     * Vérifie si le premier sous-groupe d'un mot commence par une voyelle longue en Quenya.
     *
     * @param mot Liste de sous-groupes de lettres formant un mot en Quenya.
     * @return true si le mot commence par une voyelle longue ("ee", "ii", "oo", "uu"), false sinon.
     */
    public boolean commenceAvecLongueVoyelle(ArrayList<String> mot){
        boolean commenceAvecLongueVoyelle = false;

        if (!mot.isEmpty()){
            switch (mot.getFirst()){
                case "ee", "ii", "oo", "uu" ->{
                    commenceAvecLongueVoyelle = true;
                }
            }
        }
        return commenceAvecLongueVoyelle;
    }

    /**
     * Ajoute le préfixe Tengwar correspondant à la voyelle initiale d'un mot si applicable.
     *
     * Renvoie la commande LaTeX associée à une voyelle courte ou longue
     * située au début d'un mot Quenya. Si le mot ne commence pas par une voyelle,
     * la chaîne renvoyée est vide.
     *
     * @param lettresSeparees Tableau de sous-groupes de lettres formant un mot en Quenya.
     * @return La commande LaTeX correspondant à la voyelle initiale, ou chaîne vide si aucune voyelle.
     */
    public String ajoutPrefixeVoyelle(ArrayList<String> lettresSeparees){

        String voyelleTengarAjoutee = "";

        if (commenceAvecVoyelleCourte(lettresSeparees)){
            voyelleTengarAjoutee = TengwarScript.TELCO.getCommandeLaTeX();
        } else if (commenceAvecLongueVoyelle(lettresSeparees)) {
            voyelleTengarAjoutee = TengwarScript.ARA.getCommandeLaTeX();
        }
        return voyelleTengarAjoutee;
    }

}
