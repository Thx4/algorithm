package designpartten.singleton;

/**
 * 饿汉式单例
 */
public class SingletonHunger {

    //创建 SingletonHunger 的一个对象
    private static SingletonHunger instance = new SingletonHunger();

    //让构造函数为 private，这样该类就不会被实例化
    private SingletonHunger(){}

    //获取唯一可用的对象
    public static SingletonHunger getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }


    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingletonHunger object = SingletonHunger.getInstance();

        //显示消息
        object.showMessage();
    }
}
