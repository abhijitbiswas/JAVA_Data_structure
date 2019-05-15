package Algo.string;

public class FindOpenCloseParentheses {
    public static void main(String[] args) {

        String str = "((q,e),e,r))((2,4)()())))";
        System.out.println(findClosingParen(str.toCharArray(), 1));

        System.out.println(findOpenParen(str.toCharArray(), 5));
    }

    //find close bracket
    public static int findClosingParen(char[] text, int openPos) {
        int closePos = openPos;
        int counter = 1;
        while (counter > 0) {
            char c = text[++closePos];
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter--;
            }
        }
        return closePos;
    }

    //find open bracket

    public static int findOpenParen(char[] text, int closePos) {
        int openPos = closePos;
        int counter = 1;
        while (counter > 0) {
            char c = text[--openPos];
            if (c == '(') {
                counter--;
            } else if (c == ')') {
                counter++;
            }
        }
        return openPos;
    }


}
