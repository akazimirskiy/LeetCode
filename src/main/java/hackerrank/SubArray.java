package hackerrank;

public class SubArray {

    public static void main(String[] args) {
        System.out.println(getMinLength("BABB"));
    }
    public static int getMinLength(String seq) {
        return rec(seq).length();
    }

    private static String rec(String str) {
        if (str.length() <= 1) return str;
        //if (str.indexOf(seq) == -1) return str;

        String newStr = str;
        if (newStr.indexOf("AB") != -1) {
            newStr = rec(str.replace("AB", ""));
        }
        if (newStr.indexOf("BB") != -1) {
            newStr = rec(str.replace("BB", ""));
        }
        return newStr;
    }
}
