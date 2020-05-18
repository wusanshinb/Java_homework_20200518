/**
 * @author: 肖瑶
 * @className: Cars
 * @packageName: cn.rentcar
 * @description: Cars类包含了各个车辆的信息。
 * @data: 2020年5月18日12:15:41
 **/
package rentcar;

public class Cars {
    public int order;
    public String carName;
    public int money;
    public double maxLoad;
    public double maxLoad2;

    public Cars(int order, String name, int money, double maxLoad) {
        this.order = order;
        this.carName = name;
        this.money = money;
        this.maxLoad = maxLoad;
    }

    public Cars(int order, String name, int money, double maxLoad, double maxLoad2) {
        this.order = order;
        this.carName = name;
        this.money = money;
        this.maxLoad = maxLoad;
        this.maxLoad2 = maxLoad2;
    }

    public static Cars[] loadCars() {
        Cars a = new Cars(1, "小轿车", 40, 4.0);
        Cars b = new Cars(2, "面包车", 65, 7.0);
        Cars c = new Cars(3, "大巴车", 180, 20.0);
        Cars d = new Cars(4, "低栏车", 30, 1.5);
        Cars e = new Cars(5, "高栏车", 47, 2.5);
        Cars f = new Cars(6, "厢式车", 80, 4.5);
        Cars g = new Cars(7, "日式皮卡车", 60, 5, 1);
        Cars h = new Cars(8, "美式皮卡车", 60, 2, 3);
        return new Cars[]{a, b, c, d, e, f, g, h};
    }
}
