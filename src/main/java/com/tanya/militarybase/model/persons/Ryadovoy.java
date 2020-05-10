package com.tanya.militarybase.model.persons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class Ryadovoy extends Person {
    @Override
    public String getPosition() { return "Рядовой"; }
}
