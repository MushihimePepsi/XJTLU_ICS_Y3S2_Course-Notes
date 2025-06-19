public class MyPoint {
    // 实例变量
    double x;
    double y;

    // 空构造函数，创建一个坐标为 (0.0, 0.0) 的点
    public MyPoint() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // 根据指定的坐标创建一个点
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 获取器方法
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // 实例方法，返回此点与另一个 MyPoint 类型点之间的距离
    public double distance(MyPoint other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    // 静态方法，返回两个 MyPoint 对象之间的距离
    public static double distance(MyPoint p1, MyPoint p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // 测试程序
    public static void main(String[] args) {
        // 创建三个点
        MyPoint p1 = new MyPoint(0.0, 0.0);
        MyPoint p2 = new MyPoint(10.25, 20.8);
        MyPoint p3 = new MyPoint(13.25, 24.8);

        // 使用实例方法计算距离
        double distance1 = p1.distance(p2);
        System.out.println("Distance between p1 and p2 (instance method): " + distance1);

        // 使用静态方法计算距离
        double distance2 = MyPoint.distance(p1, p2);
        System.out.println("Distance between p1 and p2 (static method): " + distance2);
    }
}