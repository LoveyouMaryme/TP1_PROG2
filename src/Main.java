//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Tengwars test = new Tengwars();


    TengwarScript T =  TengwarScript.TINCO;

    //System.out.println(TengwarScript.values().length);

    //System.out.println(Tengwars.translateLatinLetter("T"));

    //test.breakdownSentences("LAURIE LAntAR LASSI SURINEN");

    // System.out.println(test.getLatinSequence("LAURIE"));
    // System.out.println(test.getLatinSequence("LAntAR"));
    System.out.println(test.separateUpperCase("LAntARuuqungwAnquV"));

    System.out.println(test.separateUpperCase("LAntARuuqungwAnqu"));

    System.out.println(test.parcourirStringToTranslate(test.separateUpperCase("LAntARuuqungwAnqu")));

    test.translateLatinLetter("V");







}