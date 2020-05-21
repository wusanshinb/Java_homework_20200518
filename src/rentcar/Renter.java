/**
 * @author: 肖瑶
 * @className: Renter
 * @packageName: cn.rentcar
 * @description: Renter类包含了各种租车的详细功能，包括确认租车数量、时间和最后的计算费用等。
 * @data: 2020年5月18日12:14:17
 **/
package rentcar;

import java.util.Scanner;

public class Renter {

    /**
     * *@description: 用于打印所有汽车信息
     * *@param: null
     **/
    public static void printCars() {
        Cars[] allCars = Cars.loadCars();  // 从Cars类里面加载所有车的信息
        System.out.println("租车信息如下：");
        System.out.println("载客车");
        System.out.println("序号  车辆名称  租车费用（元/（车·天））  最大载人（人）");

        // 三类车分别打印
        for (int i = 0; i < 3; i++) {
            System.out.println(allCars[i].order + "     " + allCars[i].carName + "     " + allCars[i].money + "                  " + allCars[i].maxLoad);
        }
        System.out.println("载货车");
        System.out.println("序号  车辆名称  租车费用（元/（车·天））  最大载货（吨）");
        for (int i = 3; i < 6; i++) {
            System.out.println(allCars[i].order + "     " + allCars[i].carName + "     " + allCars[i].money + "                   " + allCars[i].maxLoad);
        }
        System.out.println("载货车");
        System.out.println("序号  车辆名称  租车费用（元/（车·天））  最大载人（人）   最大载货（吨）");
        for (int i = 6; i < 8; i++) {
            System.out.println(allCars[i].order + "     " + allCars[i].carName + "     " + allCars[i].money + "                 " + allCars[i].maxLoad + "               " + allCars[i].maxLoad2);
        }

    }

    /**
     * *@description: 用于输入租用车辆的数量，并进行输入的合理性检验
     * *@param: null
     * *@return：int[] rentDay
     **/
    public static int[] inputRentNum() {
        Cars[] allCars = Cars.loadCars();  // 加载所有车辆的信息
        int[] carNum = new int[8];    // 用于记录租用汽车数量的数组
        for (int i = 0; i < 8; i++) {
            System.out.println("请输入序号" + (i + 1) + "(" + allCars[i].carName + ")" + "的租用数量：");  // 打印提示输入信息
            while (true) {
                try {      // 捕捉输入为小数的异常并提醒重新输入
                    carNum[i] = new Scanner(System.in).nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("租车数量不能是小数！" + "请重新输入序号" + (i + 1) + "(" + allCars[i].carName + ")" + "的租用数量：");
                    continue;
                }
                if (carNum[i] < 0) {    // 捕捉输入为负数的异常并提醒重新输入
                    System.out.println("租车数量不能是负数！" + "请重新输入序号" + (i + 1) + "(" + allCars[i].carName + ")" + "的租用数量：");
                } else {
                    break;
                }
            }
        }
        return carNum;
    }

    /**
     * *@description: 用于输入租用车辆的天数，并进行输入的合理性检验
     * *@param: int[] rentNum
     * *@return: int[] rentDay
     **/
    public static int[] inputRentDay(int[] rentNum) {
        int[] rentDay = new int[8];       // 用于记录租车的天数的数组，同样有合理性检验
        Cars[] allCars = Cars.loadCars();
        for (int i = 0; i < 8; i++) {
            if (rentNum[i] != 0) {
                while (true) {
                    System.out.println("请输入序号" + (i + 1) + "(" + allCars[i].carName + ")" + "的租用天数：");
                    rentDay[i] = new Scanner(System.in).nextInt();
                    if (rentDay[i] < 0) {
                        System.out.println("租车天数不能是负数！" + "请重新输入序号" + (i + 1) + "(" + allCars[i].carName + ")" + "的租用天数：");
                    } else {
                        break;
                    }
                }
            }
        }
        return rentDay;
    }

    /**
     * *@description: 用于最后计算总体租车的最大载人（货）量，总体租车费用，租车天数，租用车辆总数，各个车辆的租用数目（分行列出，数目为0不列出）
     * *@param: int[] rentNum， int[] rentDay
     * *@return: null
     **/
    public static void calculate(int[] rentNum, int[] rentDay) {
        Cars[] allCars = Cars.loadCars();
        int totalLoad1 = 0;
        double totalLoad2 = 0.0;
        double totalDay = 0.0;
        double money = 0.0;
        int num = 0;
        for (int i = 0; i < 8; i++) {
            totalLoad1 += allCars[i].maxLoad * rentNum[i];
            totalLoad2 += allCars[i].maxLoad2 * rentNum[i];
            totalDay += rentDay[i];
            money += allCars[i].money * rentNum[i] * rentDay[i];
            num += rentNum[i];
        }
        System.out.println("总体租车的最大载人量为" + totalLoad1);
        System.out.println("总体租车的最大载货量为" + totalLoad2);
        System.out.println("总体租车费用为" + money);
        System.out.println("总体租车天数为" + totalDay);
        System.out.println("租用车辆总数为" + num);
        for (int i = 0; i < 8; i++) {
            if (rentDay[i] != 0) {
                System.out.println("序号" + (i + 1) + "(" + allCars[i].carName + ")" + "的租用数目为：" + rentDay[i]);
            }
        }
        String str1 = "\0";
        do {
            str1 = new Scanner(System.in).nextLine();
        } while (!str1.equals(""));
    }

    /**
     * *@description: 用于启动各个租车的方法
     * *@param: null
     * *@return: null
     **/
    public static void letsFuckingRentIt() {
        printCars();
        int[] rentNum = inputRentNum();
        int[] rentDay = inputRentDay(rentNum);
        calculate(rentNum, rentDay);
    }
}
