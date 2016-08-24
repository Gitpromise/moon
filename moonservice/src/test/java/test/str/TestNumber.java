package test.str;

/**
 * Created by maguoqiang on 16/6/30.
 *
 */
public class TestNumber {
    private int num1=0;
    public static int num2=0;

    public static void main(String[] args) {
        TestNumber number1=new TestNumber();
        TestNumber number2=new TestNumber();
        number1.num1++;
        number1.num2++;
        number2.num2++;
        System.out.println("number1:num1="+number1.num1+",num2="+number1.num2);
        System.out.println("number2:num1="+number2.num1+",num2="+number2.num2);
    }
}
class TestNumber2{
    public static void main(String[] args){
        int a=TestNumber.num2;
        System.out.println(a);

    }
}
