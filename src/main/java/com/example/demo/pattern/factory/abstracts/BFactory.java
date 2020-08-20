package com.example.demo.pattern.factory.abstracts;

/**
 * @author lidongliang
 * create at: 2020/8/20  12:07 下午
 * <p>
 * B餐工厂（提供面条和雪碧）
 */
public class BFactory extends Factory {


    /**
     * 提供面条
     *
     * @return Noddle
     */
    @Override
    public IFood createFoodProduct() {
        return new Noddle();
    }

    /**
     * 提供雪碧
     *
     * @return Sprite
     */
    @Override
    public IDrink createDrinkProduct() {
        return new Sprite();
    }
}
