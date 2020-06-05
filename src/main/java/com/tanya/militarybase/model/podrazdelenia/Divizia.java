package com.tanya.militarybase.model.podrazdelenia;

import com.tanya.militarybase.model.persons.Oficer;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Divizia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Oficer kapitan;

    @ManyToOne
    private Korpus korpus;
}
