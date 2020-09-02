package com.example.demo.pattern.composite;

/**
 * @author lidongliang
 * create at: 2020/9/2  10:13 上午
 * <p>
 * 公司接口
 */
public interface Company {

    void add(Company company);

    void remove(Company company);

    /**
     * 展示树形结构
     *
     * @param depth
     */
    void display(int depth);

    /**
     * 不用部门所具有的各职责
     */
    void duty();
}
