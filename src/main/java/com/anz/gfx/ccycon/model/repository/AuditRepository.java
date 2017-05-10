package com.anz.gfx.ccycon.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.gfx.ccycon.model.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {

}
