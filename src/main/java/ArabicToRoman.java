public class ArabicToRoman {
    public static String convert(int arabic) {
        String roman = "";
        int total = arabic;
        while(total != 0){
            if (total >= 4 && total < 6) {
                roman += "V";
                total -= 5;
            }
            else if(total >= 4 || total == 4){
                roman += "IV";
                total -= 4;
            }else {
                roman += "I";
                total -= 1;
            }
        }
        return roman;
    }
}