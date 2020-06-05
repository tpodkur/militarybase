package com.tanya.militarybase.model.oficer_persons;

import com.tanya.militarybase.model.OficerSostav;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Leytenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private OficerSostav oficerSostav;

    private boolean characteristic1 = false;
    private String characteristic2 = "";
    private Integer characteristic3 = 0;
}
