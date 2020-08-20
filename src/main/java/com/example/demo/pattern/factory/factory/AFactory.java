package com.example.demo.pattern.factory.factory;

import com.example.demo.pattern.factory.IProduct;
import com.example.demo.pattern.factory.ProductA;

/**
 * @author lidongliang
 * create at: 2020/8/20  11:52 上午
 * <p>
 * A工厂
 */
public class AFactory extends Factory {

    /**
     * 提供A产品
     *
     * @return ProductA
     */
    @Override
    public IProduct createProduct() {
        return new ProductA();
    }

}