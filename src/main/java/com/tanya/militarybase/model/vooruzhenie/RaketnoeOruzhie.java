package com.tanya.militarybase.model.vooruzhenie;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RaketnoeOruzhie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer vooruzhenieId;
    private String vid;

    private boolean characteristic1 = false;
    private String characteristic2 = "";
    private Integer characteristic3 = 0;
}
