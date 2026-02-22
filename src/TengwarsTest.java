
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TengwarsTest {

    @Test
    void quenyaVersTengwarLaTeX_1() {
        assertEquals( "\\Ttinco\\TTacute\\Tungwe\\TTthreedots\\Toore",
                Tengwars.quenyaVersTengwarLaTeX( "TEngwAR" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_2() {
        assertEquals( "\\Tlambe\\TTthreedots\\TTleftcurl\\Toore\\TTdot\\TTacute \\Tlambe\\TTthreedots\\Tanto\\TTthreedots\\Toore \\Tlambe\\TTthreedots\\Tthuule\\Tthuule\\TTdot \\Tthuule\\TTleftcurl\\Toore\\TTdot\\Tnuumen\\TTacute\\Tnuumen",
                Tengwars.quenyaVersTengwarLaTeX( "LAURIE LAntAR LASSI SURINEN" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_3() {
        assertEquals( "\\Ttelco\\TTthreedots\\Tando\\TTleftcurl\\Tnuumen\\TTacute \\Tparma\\TTacute\\Tlambe\\Tlambe\\TTthreedots",
                Tengwars.quenyaVersTengwarLaTeX( "AndUNE PELLA" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_consonnes_1() {
        assertEquals( "\\Ttinco",
                Tengwars.quenyaVersTengwarLaTeX( "T" ) );
        assertEquals( "\\Tparma",
                Tengwars.quenyaVersTengwarLaTeX( "P" ) );
        assertEquals( "\\Tthuule",
                Tengwars.quenyaVersTengwarLaTeX( "S" ) );
        assertEquals( "\\Tformen",
                Tengwars.quenyaVersTengwarLaTeX( "F" ) );
        assertEquals( "\\Tvala",
                Tengwars.quenyaVersTengwarLaTeX( "V" ) );
        assertEquals( "\\Tesse",
                Tengwars.quenyaVersTengwarLaTeX( "Z" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_consonnes_2() {
        assertEquals( "\\Tcalma",
                Tengwars.quenyaVersTengwarLaTeX( "C" ) );
        assertEquals( "\\Tnuumen",
                Tengwars.quenyaVersTengwarLaTeX( "N" ) );
        assertEquals( "\\Tmalta",
                Tengwars.quenyaVersTengwarLaTeX( "M" ) );
        assertEquals( "\\Toore",
                Tengwars.quenyaVersTengwarLaTeX( "R" ) );
        assertEquals( "\\Tlambe",
                Tengwars.quenyaVersTengwarLaTeX( "L" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_consonnes_3() {
        assertEquals( "\\Tquesse",
                Tengwars.quenyaVersTengwarLaTeX( "qu" ) );
        assertEquals( "\\Taha",
                Tengwars.quenyaVersTengwarLaTeX( "ch" ) );
        assertEquals( "\\Tarda",
                Tengwars.quenyaVersTengwarLaTeX( "rd" ) );
        assertEquals( "\\Talda",
                Tengwars.quenyaVersTengwarLaTeX( "ld" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_consonnes_4() {
        assertEquals( "\\Tumbar",
                Tengwars.quenyaVersTengwarLaTeX( "mb" ) );
        assertEquals( "\\Tampa",
                Tengwars.quenyaVersTengwarLaTeX( "mp" ) );
        assertEquals( "\\Thwesta",
                Tengwars.quenyaVersTengwarLaTeX( "hw" ) );
        assertEquals( "\\Thyarmen",
                Tengwars.quenyaVersTengwarLaTeX( "hy" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_consonnes_5() {
        assertEquals( "\\Tando",
                Tengwars.quenyaVersTengwarLaTeX( "nd" ) );
        assertEquals( "\\Tanto",
                Tengwars.quenyaVersTengwarLaTeX( "nt" ) );
        assertEquals( "\\Tanca",
                Tengwars.quenyaVersTengwarLaTeX( "nc" ) );
        assertEquals( "\\Tanga",
                Tengwars.quenyaVersTengwarLaTeX( "ng" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_consonnes_6() {
        assertEquals( "\\Tungwe",
                Tengwars.quenyaVersTengwarLaTeX( "ngw" ) );
        assertEquals( "\\Tunque",
                Tengwars.quenyaVersTengwarLaTeX( "nqu" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_voyelles_1() {
        assertEquals( "\\Tformen\\TTthreedots",
                Tengwars.quenyaVersTengwarLaTeX( "FA" ) );
        assertEquals( "\\Tformen\\TTdot",
                Tengwars.quenyaVersTengwarLaTeX( "FI" ) );
        assertEquals( "\\Tformen\\TTacute",
                Tengwars.quenyaVersTengwarLaTeX( "FE" ) );
        assertEquals( "\\Tformen\\TTrightcurl",
                Tengwars.quenyaVersTengwarLaTeX( "FO" ) );
        assertEquals( "\\Tformen\\TTleftcurl",
                Tengwars.quenyaVersTengwarLaTeX( "FU" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_voyelles_2() {
        assertEquals( "\\Tformen\\TTtwodots",
                Tengwars.quenyaVersTengwarLaTeX( "Fii" ) );
        assertEquals( "\\Tformen\\TTdoubleacute",
                Tengwars.quenyaVersTengwarLaTeX( "Fee" ) );
        assertEquals( "\\Tformen\\TTdoublerightcurl",
                Tengwars.quenyaVersTengwarLaTeX( "Foo" ) );
        assertEquals( "\\Tformen\\TTdoubleleftcurl",
                Tengwars.quenyaVersTengwarLaTeX( "Fuu" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_voyelles_3() {
        assertEquals( "\\Taara\\TTtwodots",
                Tengwars.quenyaVersTengwarLaTeX( "ii" ) );
        assertEquals( "\\Taara\\TTdoubleacute",
                Tengwars.quenyaVersTengwarLaTeX( "ee" ) );
        assertEquals( "\\Taara\\TTdoublerightcurl",
                Tengwars.quenyaVersTengwarLaTeX( "oo" ) );
        assertEquals( "\\Taara\\TTdoubleleftcurl",
                Tengwars.quenyaVersTengwarLaTeX( "uu" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_voyelles_4() {
        assertEquals( "\\Ttelco\\TTthreedots",
                Tengwars.quenyaVersTengwarLaTeX( "A" ) );
        assertEquals( "\\Ttelco\\TTdot",
                Tengwars.quenyaVersTengwarLaTeX( "I" ) );
        assertEquals( "\\Ttelco\\TTacute",
                Tengwars.quenyaVersTengwarLaTeX( "E" ) );
        assertEquals( "\\Ttelco\\TTrightcurl",
                Tengwars.quenyaVersTengwarLaTeX( "O" ) );
        assertEquals( "\\Ttelco\\TTleftcurl",
                Tengwars.quenyaVersTengwarLaTeX( "U" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_sequence_1() {
        assertEquals( "\\Tnuumen\\Tcalma",
                Tengwars.quenyaVersTengwarLaTeX( "NC" ) );
        assertEquals( "\\Tanca\\Thyarmen",
                Tengwars.quenyaVersTengwarLaTeX( "nchy" ) );
        assertEquals( "\\Tnuumen\\Taha",
                Tengwars.quenyaVersTengwarLaTeX( "Nch" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_sequence_2() {
        assertEquals( "\\Tthuule\\TTacute\\TTacute",
                Tengwars.quenyaVersTengwarLaTeX( "SEE" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_exception_1() {
        assertThrows( PasDuQuenyaException.class,
                () -> Tengwars.quenyaVersTengwarLaTeX( "aa" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_exception_2() {
        assertThrows( PasDuQuenyaException.class,
                () ->c);
    }

    @Test
    void quenyaVersTengwarLaTeX_exception_3() {
        assertThrows( PasDuQuenyaException.class,
                () -> Tengwars.quenyaVersTengwarLaTeX( "HY" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_exception_4() {
        assertThrows( PasDuQuenyaException.class,
                () -> Tengwars.quenyaVersTengwarLaTeX( "ngW" ) );
    }

    @Test
    void quenyaVersTengwarLaTeX_exception_5() {
        assertThrows( PasDuQuenyaException.class,
                () -> Tengwars.quenyaVersTengwarLaTeX( "quAC, FI" ) );
    }
}