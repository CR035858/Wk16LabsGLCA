package com.gl.libms.labwk16d01dem1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.libms.labwk16d01dem1.dao.LibraryRepository;
import com.gl.libms.labwk16d01dem1.model.Library;


@Service
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
	LibraryRepository libRepository;

	@Override
	public List<Library> getAllLibraries() {
		// TODO Auto-generated method stub
		return libRepository.findAll();
	}

	@Override
	public Library getLibraryById(Long id) {
		// TODO Auto-generated method stub
		Optional<Library> result = libRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
			throw new RuntimeException("Library does not exists for Id : "+id);
		}
	}

	@Override
	public void deleteLibraryById(Long id) {
		// TODO Auto-generated method stub
		libRepository.deleteById(id);
	}

	@Override
	public void saveLibrary(Library library) {
		// TODO Auto-generated method stub
		libRepository.save(library);
	}

	public List<Library> getAllLibrariesWithNoBooks() {

		Library libraryWithNoBooks = new Library();
		
		libraryWithNoBooks.setCommaSeperatedBooknames("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		
		return libRepository.findAll(example);
	}
	

	public List<Library> getLibrariesCustomSorted(String order,String column) {
		String selectedColumn = column;
		List <Library> libraries;
		if(order.equals("Ascending"))
		{
			switch(selectedColumn)
			{
				case "library":
				{
					libraries =  libRepository.findAll(Sort.by(Direction.ASC, "name"));
					break;
				}
				case "books":
				{
					libraries =  libRepository.findAll(Sort.by(Direction.ASC, "commaSeperatedBooknames"));
					break;
				}				
				default:
				{
					libraries =  libRepository.findAll(Sort.by(Direction.ASC, column));
					break;
				}
			}
		}
		else
		{
			switch(selectedColumn)
			{
				case "library":
				{
					libraries =  libRepository.findAll(Sort.by(Direction.DESC, "name"));
					break;
				}
				case "books":
				{
					libraries =  libRepository.findAll(Sort.by(Direction.DESC, "commaSeperatedBooknames"));
					break;
				}				
				default:
				{
					libraries =  libRepository.findAll(Sort.by(Direction.DESC, column));
					break;
				}
			}
		}
		return libraries;
	}
	
	public List <Library> getLibrariesPaged(int fromRecord,int noOfRecords) {
		Pageable first3records = PageRequest.of(fromRecord, noOfRecords);
		return libRepository.findAll(first3records).get().collect(Collectors.toList());
	}

	public List <Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		Pageable first3records = PageRequest.of(pageNumber, numberOfRecordsOnAPage);
		return libRepository.findAll(first3records).get().collect(Collectors.toList());
	}
}
