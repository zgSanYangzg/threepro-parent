package cn.three.module.account.demo;

/**
 * Created by Administrator on 2018/2/27.
 */
public class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
