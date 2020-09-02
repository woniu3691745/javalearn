package com.example.demo.pattern.composite;

/**
 * @author lidongliang
 * create at: 2020/9/2  10:20 上午
 * <p>
 * 部门类1 叶子结点
 */
public class Department1 implements Company {

    private String name;

    public Department1(String name) {
        this.name = name;
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        StringBuffer stringBuffer = new StringBuffer("-");
        for (int i = 0; i < depth; i++) {
            stringBuffer.append("-");
        }

        System.out.println(stringBuffer.append(name));
    }

    @Override
    public void duty() {
        System.out.println(name + "负责研发产品");
    }
}
