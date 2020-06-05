package com.tanya.militarybase.model.join_entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OficerSostavPerson {
    private String firstName = "";
    private String lastName = "";
    private String thirdName = "";
    private Integer oficerId;
}
