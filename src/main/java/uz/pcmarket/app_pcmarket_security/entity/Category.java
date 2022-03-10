package uz.pcmarket.app_pcmarket_security.entity;

import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Enabled
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Category parentCategory;

    @OneToMany
    private Pc pc;

    @OneToMany
    private Monitor monitor;

    @OneToMany
    private Noutbook noutbook;

    @OneToMany
    private Printer printer;

    @OneToMany
    private Monoblock monoblock;
}
