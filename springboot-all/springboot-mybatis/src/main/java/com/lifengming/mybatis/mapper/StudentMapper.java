package com.lifengming.mybatis.mapper;

import com.lifengming.mybatis.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lifengming
 * @since 2019.12.17
 */
public interface StudentMapper {

    /**
     * 获取Student通过ID
     *
     * @param id id
     * @return Student
     */
    Student getStudentById(int id);

    int addStudent(Student student);

    int updateStudentName(@Param("name") String name, @Param("id") int id);

    Student getStudentByIdWithClassInfo(int id);
}
