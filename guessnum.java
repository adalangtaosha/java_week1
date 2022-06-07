import java.util.Scanner;

public class guessnum {
    public static void main(String[] args) {
        Scanner num_in = new Scanner(System.in);
        boolean bool = true;
        while(bool){
            System.out.println("请输入开始范围");
            int start_scope = num_in.nextInt();
            System.out.println("请输入结束范围");
            int end_scope = num_in.nextInt();

            int mod = end_scope - start_scope;
            if (start_scope < 0 || end_scope < 0){
                System.out.println("开始或结束值必须是正数或者0");
            }else if (mod <= 1){   //将mod==1，修改为mod<=1,考虑到结束小于开始的场景
                System.out.println("非法的数字范围:("+start_scope+","+end_scope+")");
            }else{
                System.out.println("请输入游戏次数");
                int print_count = num_in.nextInt();
                System.out.println("本次游戏的数字范围为("+start_scope+","+end_scope+"),可输入次数为"+print_count);
                int correct_count = 0;//游戏正确次数
                boolean game_end = false;//是否继续游戏
                int game_count = 0;//游戏次数

                //生成一个范围内的随机数
                while(!game_end){
                    game_count++;
                    int big_num = (int)(Math.random() * end_scope * 100);
                    int num_toguess = (big_num % mod) + start_scope;
                    if (num_toguess <= start_scope){
                        num_toguess = start_scope + 1;
                    }else if (num_toguess > end_scope){
                        num_toguess = end_scope - 1;
                    }
                    //            System.out.println("要猜的数为"+num_toguess);
                    //            剩余猜测次数
                    int left_toguess = print_count;
                    System.out.println("请输入要猜测的数字，范围在("+start_scope+","+end_scope+")");
                    while (left_toguess > 0){
                        int guess = num_in.nextInt();
                        left_toguess--;
                        if (guess < 0){
                            game_end = true;
                            System.out.println("退出游戏");
                            bool = false;
                            game_count--;
                            break;
                        }
                        if (guess <= start_scope || guess >= end_scope){
                            System.out.println("猜测数字不在规定范围内，请重新输入范围在("+start_scope+","+end_scope+")内的数");
                        }
                        if (guess > num_toguess){
                            System.out.println("输入数字比目标数字大");
                        }else if (guess < num_toguess){
                            System.out.println("输入数字比目标数字小");
                        }else{
                            correct_count++;
                            System.out.println("输入数字正确！");
                            break;
                        }
                        if (left_toguess == 0){
                            System.out.println("本轮猜测数字失败，正确数字为:"+num_toguess);
                        }
                        if (left_toguess != 0) {
                            System.out.println("本轮剩余次数为：" + left_toguess);
                        }
                    }
                    System.out.println("共进行了"+game_count+"轮游戏，其中赢了"+correct_count+"轮");
                }
            }


        }
    }
}
