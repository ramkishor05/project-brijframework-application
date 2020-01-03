package com.brijframework.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.application.model.EOLKUnit;

@Repository
@Transactional
public interface LKUnitRepository extends JpaRepository<EOLKUnit, Long>{

}
