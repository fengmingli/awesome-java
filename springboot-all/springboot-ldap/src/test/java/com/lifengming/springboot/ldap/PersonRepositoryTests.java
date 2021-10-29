package com.lifengming.springboot.ldap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.Name;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests {

    @Autowired
    private LdapTemplate ldapTemplate;

    private PersonRepoImpl personRepo;

    @Before
    public void init() {
        personRepo = new PersonRepoImpl();
        personRepo.setLdapTemplate(ldapTemplate);
    }

    @Test
    public void authenticate() {
    }

    @Test
    public void add() {
    }

    @Test
    public void delete() {

    }

    @Test
    public void update() {

    }

    @Test
    public void query() {
        personRepo.getAllPersonNamesWithTraditionalWay();
    }
}
