package com.lifengming.springboot.ldap;

import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class PersonAttributesMapper implements AttributesMapper<Person> {
    /**
     * Map Attributes to an object. The supplied attributes are the attributes
     * from a single SearchResult.
     *
     * @param attrs attributes from a SearchResult.
     * @return an object built from the attributes.
     * @throws NamingException if any error occurs mapping the attributes
     */
    @Override
    public Person mapFromAttributes(Attributes attrs) throws NamingException {
        Person person = new Person();
        person.setSuerName((String)attrs.get("cn").get());
        person.setMail((String)attrs.get("mail").get());
        return person;
    }
}
