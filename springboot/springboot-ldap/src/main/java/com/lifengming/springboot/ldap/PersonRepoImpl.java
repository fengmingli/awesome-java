package com.lifengming.springboot.ldap;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;

import javax.naming.Context;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

public class PersonRepoImpl implements IPersonRepo {

    private LdapTemplate ldapTemplate;

    @Override
    public void setLdapTemplate(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    /**
     * 查询部分字段集合
     * @return
     */
    @Override
    public List<String> getAllPersonNames() {
        return ldapTemplate.search(
                query().where("objectclass").is("person"), (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }

    /**
     * 传统LDAP查询方式
     * @return
     */
    @Override
    public List<String> getAllPersonNamesWithTraditionalWay() {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "");
        env.put(Context.PROVIDER_URL, "");
        env.put(Context.SECURITY_PRINCIPAL, "");
        env.put(Context.SECURITY_CREDENTIALS, "");
        DirContext ctx;
        try {
            ctx = new InitialDirContext(env);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        List<String> list = new LinkedList<String>();
        NamingEnumeration results = null;
        try {
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            results = ctx.search("", "(objectclass=user)", controls);
            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                Attribute attr = attributes.get("cn");
                String cn = attr.get().toString();
                list.add(cn);
            }
        } catch (NameNotFoundException e) {
            // The base context was not found.
            // Just clean up and exit.
        } catch (NamingException e) {
            //throw new RuntimeException(e);
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception e) {
                    // Never mind this.
                }
            }
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                    // Never mind this.
                }
            }
        }
        return list;
    }

    /**
     * 查询对象映射集合
     * @return
     */
    @Override
    public List<Person> getAllPersons() {
        return ldapTemplate.search(query()
                .where("objectclass").is("user"), new PersonAttributesMapper());
    }

    /**
     * 根据DN查询指定人员信息
     * @param dn
     * @return
     */
    @Override
    public Person findPersonWithDn(String dn) {
        return ldapTemplate.lookup(dn, new PersonAttributesMapper());
    }

    /**
     * 组装查询语句
     * @param orgId
     * @return
     */
    @Override
    public  List<String> getPersonNamesByOrgId(String orgId) {
        LdapQuery query = query()
                .base("ou=person,dc=coreservice")
                .attributes("cn", "sn")
                .where("objectclass").is("person")
                .and("orgId").is(orgId);
        return ldapTemplate.search(query,(AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }

}
