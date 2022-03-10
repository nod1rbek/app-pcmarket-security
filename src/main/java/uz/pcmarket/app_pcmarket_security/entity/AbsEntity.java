package uz.pcmarket.app_pcmarket_security.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public abstract class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String model;

    private Double price;
}
