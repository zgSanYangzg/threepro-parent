package cn.three.module.account.demo;

/**
 * Created by Administrator on 2018/2/10.
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    private Singleton() {
    }
    public static Singleton getSingleton(){
        return singleton;
    }
    public static void dosomething(){

    }
    public static void main(String[] args){
        StringBuilder a = new StringBuilder("");
        System.out.println(a.indexOf("a"));
        a.append("a,b,c");
        System.out.println(a.indexOf("a"));
        System.out.println(a.indexOf("b"));
    }
}

