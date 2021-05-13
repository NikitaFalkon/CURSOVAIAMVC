package com.model;

import org.decimal4j.util.DoubleRounder;

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
    private  double more = 0;
    private double less = 0;
    private double normal = 0;
    private double sick = 0;
    private double healthy = 0;

    public void setName(Age name) {
        this.name = name.toString() ;
    }

    public String getName() {
        return name;
    }

    public double getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }

    public double getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public double getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public double getLess() {
        return less;
    }

    public void setLess(int less) {
        this.less = less;
    }

    public double getNormal() {
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
    public void Sick() {this.sick++;}
    public void Healthy() {this.healthy++;}
    public static double roundAvoid(double value) {
       /* MathContext context = new MathContext(5, RoundingMode.HALF_UP);
        BigDecimal result = new BigDecimal(value, context);*/
        double result = DoubleRounder.round(value, 3);
        System.out.println(result);
        return  result;
    }
    public void ForGraph()
    {
        double count = this.more+this.less+this.normal;
        double people = this.healthy+this.sick;
        this.more = roundAvoid(this.more/count);
        this.less = roundAvoid(this.less/count);
        this.normal = roundAvoid(this.normal/count);
        this.healthy = roundAvoid(this.healthy/people);
        this.sick = roundAvoid(this.sick/people);
    }
}



