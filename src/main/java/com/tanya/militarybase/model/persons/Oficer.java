package com.tanya.militarybase.model.persons;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class Oficer extends Person {
    @Override
    public String getPosition() {
        return "Офицер";
    }
}