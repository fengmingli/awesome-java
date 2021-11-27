package com.lifengming.springboot.swagger2.application;

import com.lifengming.springboot.swagger2.domain.Company;
import com.lifengming.springboot.swagger2.infrastructure.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lifengming
 * @date 2020.02.28
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> findAll() {
        return companyMapper.selectList(null);
    }

    @Override
    public Company findOne(String id) {
        return companyMapper.selectById(id);
    }

    @Override
    public void update(Company company) {
        companyMapper.updateById(company);
    }

    @Override
    public void add(Company company) {
        companyMapper.insert(company);
    }

    @Override
    public void delete(String id) {
        companyMapper.deleteById(id);
    }
}
