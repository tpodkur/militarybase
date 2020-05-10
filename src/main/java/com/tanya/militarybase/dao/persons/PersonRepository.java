package com.tanya.militarybase.dao.persons;

import com.tanya.militarybase.dao.mapper.PersonMapper;
import com.tanya.militarybase.model.persons.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void postPerson(String firstName, String lastName, String thirdName) {
        String sql = "INSERT INTO PEOPLE(first_name, last_name, third_name) " +
                "VALUES (:first_name, :last_name, :third_name)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("first_name", firstName)
                .addValue("last_name", lastName)
                .addValue("third_name", thirdName);
        jdbcTemplate.update(sql, params);
    }

    public List<Person> getAll() {
        String sql = "SELECT * FROM PEOPLE";
        List<Person> persons = jdbcTemplate.query(sql, new PersonMapper());
        return persons;
    }

    public void deletePerson(int id) {
         String sql = "DELETE FROM PEOPLE "
    }
}
