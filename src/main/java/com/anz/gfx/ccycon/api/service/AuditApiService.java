package com.anz.gfx.ccycon.api.service;

import java.util.List;

import com.anz.gfx.ccycon.exception.NotFoundException;
import com.anz.gfx.ccycon.model.Audit;

public interface AuditApiService {

	List<Audit> findAllAudit() throws NotFoundException;
	Audit updateAudit(Audit audit) throws NotFoundException;
	Audit addAudit(Audit audit) throws NotFoundException;
	Audit findByIdAudit(Integer id) throws NotFoundException;
	void deleteAudit(Integer id) throws NotFoundException;

}
