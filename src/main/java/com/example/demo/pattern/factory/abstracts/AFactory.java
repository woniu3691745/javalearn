package com.example.demo.pattern.factory.abstracts;

/**
 * @author lidongliang
 * create at: 2020/8/20  12:07 下午
 * A餐工厂（提供可乐和米饭）
 * <p>
 * 工厂可以定制生产什么产品
 */
public class AFactory extends Factory {

    /**
     * 提供可乐
     *
     * @return Cola
     */
    @Override
    public IDrink createDrinkProduct() {
        return new Cola();
    }

    /**
     * 提供米饭
     *
     * @return Rice
     */
    @Override
    public IFood createFoodProduct() {
        return new Rice();
    }
}
