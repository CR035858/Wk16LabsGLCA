package com.gl.libms.labwk16d01dem1.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.gl.libms.labwk16d01dem1.model.Library;

@Service
public interface LibraryService {
	
	public List <Library> getAllLibraries();
	public Library getLibraryById(Long id);
	public void deleteLibraryById(Long id);
	public void saveLibrary(Library library);
	
	public List<Library> getAllLibrariesWithNoBooks();
	public List<Library> getLibrariesCustomSorted(String order,String column);
	
	List <Library> getLibrariesPaged(int fromRecord,int noOfRecords);
	List <Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage);
}
