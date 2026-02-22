//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Tengwars test = new Tengwars("LAURIE LAntAR LASSI SURINEN");


    TengwarScript T =  TengwarScript.TINCO;

    //System.out.println(TengwarScript.values().length);

    //System.out.println(Tengwars.translateLatinLetter("T"));

    //test.breakdownSentences("LAURIE LAntAR LASSI SURINEN");

    // System.out.println(test.getLatinSequence("LAURIE"));
    // System.out.println(test.getLatinSequence("LAntAR"));
    //System.out.println(test.separateUpperCase("LAntARuuqungwAnquV"));

    //System.out.println(test.separateUpperCase("LAntARuuqungwAnqu"));
    //System.out.println(Tengwars.quenyaVersTengwarLaTeX("LAURIE LAntAR LASSI SURINEN"));

    //String phraseTengwar = Tengwars.quenyaVersTengwarLaTeX("LAURIE LAntAR LASSI SURINEN");
    String phraseTengwar = Tengwars.quenyaVersTengwarLaTeX("AndUNE PELLA");
    Scanner scanner = new Scanner(phraseTengwar);

    while (scanner.hasNext()){
        System.out.println(scanner.next());
    }

    scanner.close();
    //System.out.println(Tengwars.quenyaVersTengwarLaTeX("AndUNE PELLA"));

    //System.out.println(test.parcourirStringToTranslate(test.separateUpperCase("AndUNE")));

    //test.translateLatinLetter("V");







}