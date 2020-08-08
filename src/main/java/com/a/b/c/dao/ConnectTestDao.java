package com.a.b.c.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public class ConnectTestDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    public List<String> getCity(){
        String sql="select name from city limit 10";
        List<String> result=jdbcTemplate.queryForList(sql, new HashMap(),String.class);
        return result;
    }
}
