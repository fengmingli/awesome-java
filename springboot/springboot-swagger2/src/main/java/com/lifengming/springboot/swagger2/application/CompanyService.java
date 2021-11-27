package com.lifengming.springboot.swagger2.application;

import com.lifengming.springboot.swagger2.domain.Company;

import java.util.List;

/**
 * @author lifengming
 * @date 2020.02.28
 */
@SuppressWarnings("all")
public interface CompanyService {

    List<Company> findAll();

    Company findOne(String id);

    void update(Company company);

    void add(Company company);

    void delete(String id);
}
