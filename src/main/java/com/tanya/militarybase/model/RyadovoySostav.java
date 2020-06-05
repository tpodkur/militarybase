package com.tanya.militarybase.model;

import com.tanya.militarybase.model.persons.Person;
import com.tanya.militarybase.model.podrazdelenia.Otdelenie;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RyadovoySostav {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    private Integer personId;
//    private Integer otdelenieId;

    @OneToOne
    private Person person;

    @ManyToOne
    private Otdelenie otdelenie;
}
