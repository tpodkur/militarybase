package com.tanya.militarybase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public enum Role implements GrantedAuthority {
    USER("hr"),
    OFICER("oficer"),
    RYADOVOY("ryadovoy");

    private String position;

    @Override
    public String getAuthority() {
        return name();
    }
}
