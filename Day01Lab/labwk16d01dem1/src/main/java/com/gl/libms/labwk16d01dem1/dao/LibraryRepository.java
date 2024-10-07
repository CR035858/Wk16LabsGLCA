package com.gl.libms.labwk16d01dem1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.libms.labwk16d01dem1.model.Library;



@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
