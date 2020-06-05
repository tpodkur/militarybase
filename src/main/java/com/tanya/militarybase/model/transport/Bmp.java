package com.tanya.militarybase.model.transport;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bmp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer transportId;
    private String vid;

    private boolean characteristic1 = false;
    private String characteristic2 = "";
    private Integer characteristic3 = 0;
}
