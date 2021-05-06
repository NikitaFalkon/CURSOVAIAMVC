package com.model;

import javax.persistence.*;

/*@Entity
@Table(name = "age")
public class Age {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String aging;
    @OneToOne(mappedBy = "age")
    private Patient patient;
    @OneToOne(mappedBy = "age")
    private Norma norma;

    public String getAging() {
        return aging;
    }

    public void setAging(String aging) {
        this.aging = aging;
    }
}*/
public enum Age {
    Child, Teenager, Adult;
}
