package cn.three.module.account.demo;

/**
 * Created by Administrator on 2018/2/26.
 */
public class ConcreteCreator {
    public static void main(String[] args){
        AnimalFactory factory = new CatFactory();
        Animal cat = factory.createAnimal();
        cat.eat();
        factory = new DogFactory();
        Animal dog = factory.createAnimal();
        dog.eat();
    }
}
