package com.gl.ccms.labwk16d04dem1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.ccms.labwk16d04dem1.model.CCRepDetails;

@Service
public interface CCRepDetailService {
	
	public List<CCRepDetails> getAllCCRepDetails();
	public void saveCCRepDetail(CCRepDetails ccRepDetail);
	public void deleteCCRepById(int id);
	public CCRepDetails getCCRepById(int id);

}
