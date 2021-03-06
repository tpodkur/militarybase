package com.tanya.militarybase.model.podrazdelenia;

import com.tanya.militarybase.model.persons.Person;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Otdelenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Person kapitan;

    @ManyToOne
    private Vzvod vzvod;
}
