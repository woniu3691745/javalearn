package com.example.demo.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lidongliang
 * create at: 2020/9/2  10:15 上午
 * <p>
 * 具体公司类 树枝节点
 */
public class ConcreteCompany implements Company {

    /**
     * 树形结构 add
     */
    private List<Company> companyList = new ArrayList<>();

    private String name;

    public ConcreteCompany(String name) {
        this.name = name;
    }

    @Override
    public void add(Company company) {
        companyList.add(company);
    }

    @Override
    public void remove(Company company) {
        companyList.remove(company);
    }

    @Override
    public void display(int depth) {
        StringBuilder stringBuilder = new StringBuilder("-");
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.append(name));

        for (Company company : companyList) {
            company.display(depth+2);
        }

    }

    @Override
    public void duty() {
        for (Company company : companyList) {
            company.duty();
        }
    }
}
