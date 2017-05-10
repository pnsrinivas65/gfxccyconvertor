package com.anz.gfx.ccycon.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anz.gfx.ccycon.api.service.AuditApiService;
import com.anz.gfx.ccycon.exception.NotFoundException;
import com.anz.gfx.ccycon.model.Audit;
import com.anz.gfx.ccycon.model.repository.AuditRepository;

@Service
@Transactional
public class AuditApiServiceImpl implements AuditApiService {

	@Autowired

	private AuditRepository auditRepository;

	@Override
	public List<Audit> findAllAudit() throws NotFoundException {
		return auditRepository.findAll();
	}

	@Override
	public Audit updateAudit(Audit audit) throws NotFoundException {
		return auditRepository.save(audit);
	}

	@Override
	public Audit addAudit(Audit audit) throws NotFoundException {
		return auditRepository.save(audit);

	}

	@Override
	public Audit findByIdAudit(Integer id) throws NotFoundException {
		return auditRepository.findOne(id);

	}

	@Override
	public void deleteAudit(Integer id) throws NotFoundException {
	}

}
