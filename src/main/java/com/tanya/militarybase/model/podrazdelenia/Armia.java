package com.tanya.militarybase.model.podrazdelenia;

import com.tanya.militarybase.model.OficerSostav;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Armia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private OficerSostav kapitan;
}
