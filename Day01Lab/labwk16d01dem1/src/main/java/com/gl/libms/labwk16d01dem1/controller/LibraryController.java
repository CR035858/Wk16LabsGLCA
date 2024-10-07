package com.gl.libms.labwk16d01dem1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gl.libms.labwk16d01dem1.model.Library;
import com.gl.libms.labwk16d01dem1.service.LibraryService;

@Controller
@RequestMapping("/libraries")
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/list")
	public String getBooks(Model model) {
		List<Library> libraries = libraryService.getAllLibraries();
		model.addAttribute("libraries", libraries);  //"books"->attribute name in the html file
		return "library-list"; //page to access
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		Library library = new Library();
		model.addAttribute("library", library);
		return "library-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("library") Library library) {
		libraryService.saveLibrary(library);
		return "redirect:/libraries/list";
	}
	
	
	
}
