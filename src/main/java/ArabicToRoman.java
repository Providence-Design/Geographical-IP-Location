public class ArabicToRoman {
    public static String convert(int arabic) {
        String roman = "";
        int total = arabic;
        while(total != 0) {
            if (total >= 4 && total < 5) {
                roman += "IV";
                total -= 4;
            }
//            else if (total == 5){
//                roman += "V";
//                total -= 5;

//            }
            else if (total >= 5 && total < 6) {
                roman += "V";
                total -= 5;
            } else if (total >= 6 && total < 7) {
                roman += "VI";
                total -= 6;

            } else if (total >= 7 && total < 8) {
                roman += "VII";
                total -= 7;

            } else if (total >= 8 && total < 9) {
                roman += "VIII";
                total -= 8;
            } else if (total >= 9 && total < 10) {
                roman += "IX";
                total -= 9;
            }else if (total >= 10 && total < 11) {
                roman += "X";
                total -= 10;
            }else {
                roman += "I";
                total -= 1;
            }
        }

        return roman;
    }
}