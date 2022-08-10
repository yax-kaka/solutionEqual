import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String equation = in.nextLine();
        Solution solution = new Solution();
        System.out.println(solution.solveEquation(equation));
    }

    public String solveEquation(String equation) {
        boolean haveAnswer = false;
        String answer = "x=", notAnswer = "No solution";
        double value = 0;
        int indexOfEqualSign = equation.indexOf("=");
        //=号分割
        String leftEquation = equation.substring(0, indexOfEqualSign);
        String rightEquation = equation.substring(indexOfEqualSign +1, equation.length());

        if(countNumberOfX(leftEquation) != countNumberOfX(rightEquation)) {//两边x数量不相等，有解
            //x放到左边算，数字到右边算
            double numberOfX = countNumberOfX(leftEquation) - countNumberOfX(rightEquation);
            double numberOfValue = countOfValue(rightEquation) - countOfValue(leftEquation);
            if(numberOfX < 0) {
                numberOfValue = -numberOfValue;
                numberOfX = -numberOfX;
            }
            value = numberOfValue / numberOfX;
            haveAnswer = true;
        }else if(countNumberOfX(leftEquation) == countNumberOfX(rightEquation) && countOfValue(leftEquation) == countOfValue(rightEquation)) {
            notAnswer = "Infinite solutions";
        }
        int IntValue = (int) value;
        answer += String.valueOf(IntValue);
        return haveAnswer ? "" + answer + "": notAnswer;
    }


    /**
     * 计算数字运算的值
     * @param str
     * @return
     */
    private double countOfValue(String str) {
        double value = 0;
        boolean havenative = false;
        if (str.charAt(0) == '-') {
            havenative = true;
            str = str.substring(1);
        }
        String headNumber = str.substring(0,getSignIndex(0,str) == 99999 ? str.length() : getSignIndex(0,str));
        if(!headNumber.contains("x")) {
            value = havenative ? value - Double.parseDouble(headNumber) : value + Double.parseDouble(headNumber);
        }
        str = str.substring(headNumber.length());
        while(str.contains("+") || str.contains("-")) {
            int p = getSignIndex(0,str), q = getSignIndex(p+1, str);
            if(q == 99999) {
                q = str.length();
            }
            String number = str.substring(p + 1, q);
            if(!number.contains("x")) {
                switch (str.charAt(p)) {
                    case '-' : {
                        value -= Double.parseDouble(number);
                        break;
                    }
                    case '+' : {
                        value += Double.parseDouble(number);
                        break;
                    }
                    default:break;
                }
            }
            str = str.substring(q);
        }
        return value;
    }

    /**
     * 计算x的符号数
     * @param str
     * @return
     */
    private double countNumberOfX(String str) {
        double value = 0;
        boolean havenative = false;
        if (str.charAt(0) == '-') {
            havenative = true;
            str = str.substring(1);
        }
        String headNumber = str.substring(0,getSignIndex(0,str)==99999?str.length():getSignIndex(0,str));
        if(headNumber.contains("x")) {
            //System.out.println(headNumber);
            String notX = headNumber.replaceAll("x","");
            double change = notX.isEmpty()? 1 :Double.parseDouble(notX);
            value = havenative ? value - change : value + change;
        }
        str = str.substring(headNumber.length());
        while(str.contains("x")) {
            int p = getSignIndex(0,str), q = getSignIndex(p+1, str);
            if(q == 99999) {
                q = str.length();
            }
            String number = str.substring(p + 1, q);
            if(number.contains("x")) {
                String notX = number.replaceAll("x","");
                double v = notX.isEmpty()? 1 : Double.parseDouble(notX);
                switch (str.charAt(p)) {
                    case '-' : {
                        value -= v;
                        break;
                    }
                    case '+' : {
                        value += v;
                        break;
                    }
                    default:break;
                }
            }
            str = str.substring(q);
        }
        return value;
    }

    /**
     * 获取加减号的索引
     * @param fromIndex
     * @param str
     * @return
     */
    private int getSignIndex(int fromIndex,String str) {
        int index1 = str.indexOf("+", fromIndex);
        int index2 = str.indexOf("-", fromIndex);
        if (index1 == -1) index1 = 99999;
        if (index2 == -1) index2 = 99999;
        return Math.min(index1, index2);
    }

    /**
     * 计算x的符号数
     * @param str
     * @return
     */
    private double countXNumber(String str) {
        int count = 0;
        if(str.charAt(0) == 'x') {
            count += 1;
            str = str.substring(1);
        }
        while (str.contains("x")) {
            switch (str.charAt(str.indexOf("x")-1)) {
                case '-' : {
                    count -= 1;
                    break;
                }
                case '+' : {
                    count += 1;
                    break;
                }
                default:break;
            }
            str = str.substring(str.indexOf("x") +1);
        }
        return count;
    }
}
