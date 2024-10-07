package com.gl.ccms.labwk16d04dem1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.ccms.labwk16d04dem1.model.CCRepDetails;
import com.gl.ccms.labwk16d04dem1.repository.CCRepDetailRepository;

@Service
public class CCRepDetailServiceImpl implements CCRepDetailService{

	
	@Autowired
	CCRepDetailRepository ccRepRepository;

	@Override
	public List<CCRepDetails> getAllCCRepDetails() {
		// TODO Auto-generated method stub
		return ccRepRepository.findAll();
	}

	@Override
	public void saveCCRepDetail(CCRepDetails ccRepDetail) {
		// TODO Auto-generated method stub
		ccRepRepository.save(ccRepDetail);
	}

	@Override
	public void deleteCCRepById(int id) {
		// TODO Auto-generated method stub
		ccRepRepository.deleteById(id);
	}

	@Override
	public CCRepDetails getCCRepById(int id) {
		// TODO Auto-generated method stub
		Optional<CCRepDetails> result = ccRepRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
			throw new RuntimeException("CCRepresentative does not exists for Id : "+id);
		}
	}
	
}
