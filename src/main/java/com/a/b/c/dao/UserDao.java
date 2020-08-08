package com.a.b.c.dao;

import com.a.b.c.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int inert(User user) {
        if(isDuplicate(user.getName(),user.getPassword()).longValue()>0){
            return 0;
        }
        String sql = "insert into db_t_user (name,password,email) values (:name,:password,:email)";
        Map<String, Object> param = new HashMap<>();
        param.put("name", user.getName());
        param.put("password", user.getPassword());
        param.put("email", user.getEmail());
        return jdbcTemplate.update(sql, param);
    }

    public Long isDuplicate(String name, String password){
        String sql="select count(1) from db_T_user where name=:name and password=:password";
        Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        param.put("password",password);
        return jdbcTemplate.queryForObject(sql,param,Long.class);
    }

    public User queryUser(String username,String password){
        String sql="select name,password,role from db_T_user where name=:username and password=:password";
        Map<String,Object> param=new HashMap<>();
        param.put("username",username);
        param.put("password",password);
        User user= jdbcTemplate.queryForObject(sql,param, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u=new User();
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("password"));
                u.setRole(resultSet.getString("role"));
                return u;
            }
        });
        return user;
    }

}
