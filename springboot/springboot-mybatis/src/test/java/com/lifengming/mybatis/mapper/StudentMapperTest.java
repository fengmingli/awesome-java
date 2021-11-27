package com.lifengming.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


/**
 * @author lifengming
 * @since 2019.12.17
 */
public class StudentMapperTest {
    private SqlSessionFactory factory;
    @Before
    public void setUp() throws Exception {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));

    }

    @Test
    public void getStudentById() {
        System.out.println("本地缓存范围: " + factory.getConfiguration().getLocalCacheScope());
        System.out.println("二级缓存是否被启用: " + factory.getConfiguration().isCacheEnabled());
    }

    @Test
    public void addStudent() {
        //自动开启提交事务
        SqlSession sqlSession = factory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        System.out.println(mapper.getStudentById(1).toString());
        sqlSession.close();
    }

    @Test
    public void updateStudentName() {
    }

    @Test
    public void getStudentByIdWithClassInfo() {
    }
}