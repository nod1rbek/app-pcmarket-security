package uz.pcmarket.app_pcmarket_security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Monoblock extends AbsEntity {
    private Integer ram;

    private Double screenSize;

    private Integer hdd;
}
