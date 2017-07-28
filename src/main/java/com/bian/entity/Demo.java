package com.bian.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Mr.Bi on 2017/2/24.
 */
@Entity
@Table(name = "DEMO")
public class Demo {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 10)
    private String name;
    @Column(columnDefinition = "double(10,4) default '0.0000'")
    private Double money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
