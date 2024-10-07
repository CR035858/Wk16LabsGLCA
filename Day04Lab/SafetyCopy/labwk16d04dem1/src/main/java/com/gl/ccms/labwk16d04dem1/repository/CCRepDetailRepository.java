package com.gl.ccms.labwk16d04dem1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gl.ccms.labwk16d04dem1.model.CCRepDetails;

@Repository
public interface CCRepDetailRepository extends JpaRepository<CCRepDetails, Integer>{

}
