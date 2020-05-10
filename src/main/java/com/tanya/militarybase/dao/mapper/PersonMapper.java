package com.tanya.militarybase.dao.mapper;

import com.tanya.militarybase.model.persons.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person man = new Person();
        man.setFirstName(rs.getString("first_name"));
        man.setLastName(rs.getString("last_name"));
        man.setThirdName(rs.getString("third_name"));
        return man;
    }
}
