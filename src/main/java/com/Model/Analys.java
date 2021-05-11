package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Analys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // @Enumerated(EnumType.STRING)
    private String name;
    private  int more = 0;
    private int less = 0;
    private int normal = 0;

    public void setName(Age name) {
        this.name = name.toString() ;
    }

    public String getName() {
        return name;
    }

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public int getLess() {
        return less;
    }

    public void setLess(int less) {
        this.less = less;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public void More()
    {
        this.more++;
    }
    public void Less()
    {
        this.less++;
    }
    public void Normal()
    {
        this.normal++;
    }
}

