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
	public void saveLibrary(Library library) {
		// TODO Auto-generated method stub
		libRepository.save(library);
	}

	
}
