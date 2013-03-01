package com.example.helloworld.db;

import com.example.helloworld.core.Person;
import com.google.common.collect.ImmutableList;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface PeopleDAO {

    @RegisterMapperFactory(BeanMapperFactory.class)
    @SqlQuery("select id, fullName, jobTitle from people where id = :id")
    Person findById(@Bind("id") Long id);

    @SqlUpdate("insert into people (fullName, jobTitle) values (:fullName, :jobTitle)")
    @GetGeneratedKeys
    long create(@BindBean Person person);

    @RegisterMapperFactory(BeanMapperFactory.class)
    @SqlQuery("select id, fullName, jobTitle from people")
    ImmutableList<Person> findAll();

    @SqlUpdate("delete from people where id = :id")
    void deleteById(@Bind("id") Long id);
}
