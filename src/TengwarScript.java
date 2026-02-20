
/**
 * Ce type enumere contient les lettres de l'alphabet Tengwar, une ecriture invente par J. R. R. Tolkien.
 * Ce type contient une romanisation modifie afin qu'il n'y ait pas de conflit entre les lettres.
 * Ce qui rend l'information erronee, mais permet de faire une translitaration sans avoir a utiliser de
 * mecanisme de deambiguisation.
 */
public enum TengwarScript {
    // Tengwar
    TINCO(             "T",   "T",  "T",   '\uE000', "\\Ttinco" ),
    PARMA(             "P",   "P",  "P",   '\uE001', "\\Tparma" ),
    CALMA(             "C",   "C",  "tsh", '\uE002', "\\Tcalma" ),
    QUESSE(            "qu",  "",   "C",   '\uE003', "\\Tquesse" ),
    ANDO(              "nd",  "D",  "D",   '\uE004', "\\Tando" ),
    UMBAR(             "mb",  "B",  "B",   '\uE005', "\\Tumbar" ),
    ANGA(              "ng",  "G",  "dzn", '\uE006', "\\Tanga" ),
    UNGWE(             "ngw", "",   "G",   '\uE007', "\\Tungwe" ),
    THULE(             "S",   "th", "th",  '\uE008', "\\Tthuule" ),
    FORMEN(            "F",   "F",  "F",   '\uE009', "\\Tformen" ),
    HARMA(             "ch",  "ch", "sh",  '\uE00A', "\\Taha" ),
    HWESTA(            "hw",  "",   "ch",  '\uE00B', "\\Thwesta" ),
    ANRO(              "nt",  "dh", "dh",  '\uE00C', "\\Tanto" ),
    AMPA(              "mp",  "V",  "V",   '\uE00D', "\\Tampa" ),
    ANCA(              "nc",  "",   "zh",  '\uE00E', "\\Tanca" ),
    UNQUE(             "nqu", "",   "gh",  '\uE00F', "\\Tunque" ),
    NUMEN(             "N",   "nn", "N",   '\uE010', "\\Tnuumen" ),
    MALTA(             "M",   "mm", "M",   '\uE011', "\\Tmalta" ),
    NGOLDO(            "",    "ng", "",    '\uE012', "\\Tnoldo" ),
    NGWALME(           "nw",  "",   "ng",  '\uE013', "\\Tnwalme" ),
    ORE(               "R",   "N",  "R",   '\uE014', "\\Toore" ),
    VALA(              "V",   "M",  "W",   '\uE015', "\\Tvala" ),
    ANNA(              "",    "O",  "Y",   '\uE016', "\\Tanna" ),
    VILYA(             "",    "W",  "",    '\uE017', "\\Tvilya" ),
    ROMEN(             "",    "R",  "",    '\uE018', "\\Troomen" ),
    ARDA(              "rd",  "rh", "rh",  '\uE019', "\\Tarda" ),
    LAMBE(             "L",   "L",  "L",   '\uE01A', "\\Tlambe" ),
    ALDA(              "ld",  "lh", "lh",  '\uE01B', "\\Talda" ),
    SILME(             "",    "S",  "S",   '\uE01C', "\\Tsilme" ),
    SILME_NUQUERNA(    "",    "Y",  "",    '\uE01D', "\\Tsilmenuquerna" ),
    ESSE(              "Z",   "",   "ss",  '\uE01E', "\\Tesse" ),
    ESSE_NUQUERNA(     "",    "",   "",    '\uE01F', "\\Tessenuquerna" ),
    HYARNEN(           "hy",  "H",  "H",   '\uE020', "\\Thyarmen" ),
    HWESTA_SINDARINWA( ""  ,  "hw", "hw",  '\uE021', "\\Thwestasindarinwa" ),
    YANTA(             "",    "E",  "",    '\uE022', "\\Tyanta" ),
    URE(               "",    "U",  "",    '\uE023', "\\Tuure" ),
    HALLA(             "",    "",   "",    '\uE024', "\\Thalla" ),
    TELCO(             "",    "I",  "",    '\uE025', "\\Ttelco" ),
    ARA(               "",    "ii", "",    '\uE026', "\\Taara" ),

    // Tehtar
    AMATIXE_3(         "A",   "",   "A",   '\uE040', "\\TTthreedots" ),
    UNUTIXE_3(         "",    "",   "",    '\uE041', "\\TTthreedotsbelow" ),
    AMATIXE_2(         "ii",  "",   "ii",  '\uE042', "\\TTtwodots" ),
    UNUTIXE_2(         "",    "",   "",    '\uE043', "\\TTtwodotsbelow" ),
    AMATIXE_1(         "I",   "",   "I",   '\uE044', "\\TTdot" ),
    UNUTIXE_1(         "",    "",   "",    '\uE045', "\\TTdotbelow" ),
    TECO(              "E",   "",   "E",   '\uE046', "\\TTacute" ),
    TECO_DOUBLE(       "ee",  "",   "ee",  '\uE047', "\\TTdoubleacute" ),
    REMPE(             "O",   "",   "O",   '\uE048', "\\TTrightcurl" ),
    REMPE_DOUBLE(      "oo",  "",   "oo",  '\uE049', "\\TTdoublerightcurl" ),
    REMPENUQUERNA(     "U",   "",   "U",   '\uE04A', "\\TTleftcurl" ),
    REMPENUQUERNA_DOUBLE( "uu", "", "uu",  '\uE04B', "\\TTdoubleleftcurl"),

    ;

    /**
     * Division entre les Tengwar et les Tehtar
     */
    private static final TengwarScript DERNIER_TENGWAR = ARA;

    private String classic;
    private String bereliand;
    private String general;
    private int code_CSUR;
    private String commandeLaTeX;

    TengwarScript( String classic, String bereliand, String general, int code_CSUR, String commandeLaTeX ) {
        this.classic = classic;
        this.bereliand = bereliand;
        this.general = general;
        this.code_CSUR = code_CSUR;
        this.commandeLaTeX = commandeLaTeX;
    }

    public String getClassic() {
        return classic;
    }

    public String getBereliand() {
        return bereliand;
    }

    public String getGeneral() {
        return general;
    }

    /**
     * Construit une version unicode pour les pages HTML.
     * @return Une chaine de caracteres contenant l'unicode pret pour les pages HTML.
     */
    public String getCodeHtml() {
        StringBuilder stringBuilder = new StringBuilder( "&#" );
        stringBuilder.append( code_CSUR );
        stringBuilder.append( ';' );
        return stringBuilder.toString();
    }

    /**
     * Retourne la commande LaTeX pour le tengwar.
     * @return la commande LaTeX.
     */
    public String getCommandeLaTeX() {
        return commandeLaTeX;
    }

    public boolean estTengwar() {
        return compareTo( DERNIER_TENGWAR ) <= 0;
    }

    public boolean estTehtar() {
        return 0 < compareTo( DERNIER_TENGWAR );
    }

    public boolean estVoyelleCourte() {
        return equals( AMATIXE_3 ) || equals( AMATIXE_1 ) || equals( TECO ) || equals( REMPE )
                || equals( REMPENUQUERNA );
    }

    public boolean estVoyelleLongue() {
        return equals( AMATIXE_2 ) || equals( TECO_DOUBLE ) || equals( REMPE_DOUBLE ) || equals( REMPENUQUERNA_DOUBLE );
    }
}
