package com.gl.libms.labwk16d01dem1.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.gl.libms.labwk16d01dem1.model.Library;

@Service
public interface LibraryService {
	
	public List <Library> getAllLibraries();
	public Library getLibraryById(Long id);
	public void saveLibrary(Library library);
	
	
}
