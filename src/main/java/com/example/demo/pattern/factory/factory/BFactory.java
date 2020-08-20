package com.example.demo.pattern.factory.factory;

import com.example.demo.pattern.factory.IProduct;
import com.example.demo.pattern.factory.ProductB;

/**
 * @author lidongliang
 * create at: 2020/8/20  11:53 上午
 * <p>
 * B工厂
 */
public class BFactory extends Factory {

    /**
     * 提供B产品
     *
     * @return ProductB
     */
    @Override
    public IProduct createProduct() {
        return new ProductB();
    }

}
