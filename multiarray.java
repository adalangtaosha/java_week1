import java.util.Scanner;

public class multiarray {
    public static void main(String[] args) {
//        声明每门课的名字
        String[] names = new String[6];
        names[0] = "语文";
        names[1] = "数学";
        names[2] = "英语";
        names[3] = "物理";
        names[4] = "化学";
        names[5] = "生物";
        int scorecount = names.length;

        Scanner IN = new Scanner(System.in);
        System.out.println("请问要保存几年的成绩？");
        int yearcount = IN.nextInt();
        double[][] scores = new double[yearcount][names.length];
        for (int i = 0; i < yearcount; i++) {
            for (int j = 0; j < names.length; j++) {
                scores[i][j] = 80 + Math.random() * 20;
                System.out.println("第" + (i + 1) + "年" + names[j] + "成绩为：" + scores[i][j]);
            }
        }
        boolean flag = true;
        while (flag) {
            System.out.println("请进行如下操作：");
            System.out.println("1:求某年最好成绩\n" + "2:求某年平均成绩\n" +
                    "3:求所有年份最好成绩\n" + "4:求某门课历年最好成绩");
        int operation = IN.nextInt();
//        int year = 0;
            switch (operation) {
                case 1:
                    //输入年份获得当年最好成绩
                    System.out.println("请输入指定年份，获得当年最好成绩");
                    int year = IN.nextInt();
                    if (year <= 0 || year > yearcount) {
                        System.out.println("非法年份：" + year);
                        flag = false;
                        break;
                    }
                    year = year - 1;
                    int best = 0;
                    for (int i = 1; i < yearcount; i++) {
                        if (scores[year][best] < scores[year][i]) {
                            best = i;
                        }
                    }
                    System.out.println("第" + (year + 1) + "年中成绩最好科目为:" + names[best] +
                            ",成绩为：" + scores[year][best]);
                    break;
                case 2:
                    //输入年份获得当年平均成绩
                    System.out.println("请输入指定年份，获得当年平均成绩");
                    year = IN.nextInt();
                    if (year <= 0 || year > yearcount) {
                        System.out.println("非法年份：" + year);
                        flag = false;
                        break;
                    }
                    year = year - 1;
                    double totalavg = 0;
                    for (int i = 0; i < scorecount; i++) {
                        totalavg += scores[year][i];
                    }
                    double avg = totalavg / scorecount;
                    System.out.println("第" + (year + 1) + "年的平均成绩为：" + avg);
                    break;
                case 3:
                    //求所有年份获得最好成绩
                    int bestyear = 0;
                    int bestscore = 0;
                    for (int i = 0; i < yearcount; i++) {
                        for (int j = 0; j < scorecount; j++) {
                            if (scores[bestyear][bestscore] < scores[i][j]) {
                                bestyear = i;
                                bestscore = j;
                            }
                        }
                    }
                    System.out.println("所有年份最好成绩为第" + (bestyear + 1) + "年的" + names[bestscore] + ",成绩为：" +
                            scores[bestyear][bestscore]);
                    break;
                case 4:
                    //求某门课历年最好成绩
                    System.out.println("请输入科目编号");
                    int subid = IN.nextInt();
                    if (subid < 0 || subid >= scorecount) {
                        System.out.println("非法的科目编号:" + subid);//注意subid是从0开始的
                        flag = false;
                        break;
                    }
                    year = 0;
                    for (int i = 1; i < yearcount; i++) {
                        if (scores[year][subid] < scores[i][subid]) {
                            year = i;
                        }
                    }
                    System.out.println("第" + (year + 1) + "年的" + names[subid] + "成绩最好,为" +
                            scores[year][subid]);
                    break;
                default:
                    flag = false;
                    System.out.println("不支持:" + operation + ",程序结束");
            }
        }
    }
}
