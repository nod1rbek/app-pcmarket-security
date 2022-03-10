package uz.pcmarket.app_pcmarket_security.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Monitor extends AbsEntity {

    private Double screenSize;
}
