import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 *  1 -> I
 *  2 -> II
 *  3 -> III
 *  4 -> IV
 *  5 -> V
 *  6 -> VI
 *  7 -> VII
 *  8 -> VIII
 *  9 -> IX
 * 10 -> X
 */
public class ArabicToRomanTest {

    @Test
    public void shouldConvertOne() {
        assertEquals("I", ArabicToRoman.convert(1));
    }

    @Test
    public void shouldConvertTwo() {
        assertEquals("II", ArabicToRoman.convert(2));
   }
    @Test
    public void shouldConvertThree(){
        assertEquals("III", ArabicToRoman.convert(3));
    }
    @Test
    public void shouldConvertFour(){
        assertEquals("IV", ArabicToRoman.convert(4));
    }
    @Test
    public void shouldConvertFive(){
        assertEquals("V", ArabicToRoman.convert(5));
    }
//    @Test
//    public void shouldConvertSix(){
//        assertEquals("VI", ArabicToRoman.convert("6"));
//    }
//    @Test
//    public void shouldConvertSeven(){
//        assertEquals("VII", ArabicToRoman.convert("7"));
//    }
//    @Test
//    public void shouldConvertEight(){
//        assertEquals("VIII", ArabicToRoman.convert("8"));
//    }
//    @Test
//    public void shouldConvertNine(){
//        assertEquals("IX", ArabicToRoman.convert("9"));
//    }
//    @Test
//    public void shouldConvertTen(){
//        assertEquals("X", ArabicToRoman.convert("10"));
//    }

}

