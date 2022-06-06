import java.util.Arrays;
import java.util.Scanner;

public class bubblesort {
    public static void main(String[] args) {
        System.out.println("请输入:");
        Scanner IN = new Scanner(System.in);
        String ch_str = IN.nextLine();

        int len = ch_str.length();//字符串长度
        int[] num_str = new int[len];
        char[] ch_arr = ch_str.toCharArray();//将字符串转换为字符数组

        //冒泡排序
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if ((int) ch_arr[j] < (int) ch_arr[j + 1]) {
                    char t = ch_arr[j + 1];
                    ch_arr[j + 1] = ch_arr[j];
                    ch_arr[j] = t;
                }
            }
        }
        System.out.print("有序字符串：");
        System.out.println(ch_arr);

//        字符转为ascii码，并存入数组
        for (int i = 0; i < len; i++) {
            num_str[i] = (int) ch_arr[i];
        }
        String num_sort = Arrays.toString(num_str);//方便输出数组,以中括号内有逗号的格式
        System.out.println("ASCII码:"+num_sort);

    }
}

