package com.tanya.militarybase.model.ryadovoy_persons;

import com.tanya.militarybase.model.RyadovoySostav;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RyadovoyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private RyadovoySostav ryadovoySostav;

    private boolean characteristic1 = false;
    private String characteristic2 = "";
    private Integer characteristic3 = 0;
}
