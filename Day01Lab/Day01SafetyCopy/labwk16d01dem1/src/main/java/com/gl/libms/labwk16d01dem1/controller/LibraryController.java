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
		
		String[] columns = {"id","library","subject","books","publisher"};
		String[] order = {"Ascending","Descending"};
		model.addAttribute("columns", columns);
		model.addAttribute("order", order);
		
		return "library-list"; //page to access
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		Library library = new Library();
		model.addAttribute("library", library);
		return "library-form";
	}
	
	@PostMapping("/showFormForUpdate")
	public String showUpdateForm(Model model,@RequestParam("libraryId") Long libraryId) {
		Library library = libraryService.getLibraryById(libraryId);
		System.out.println("Library Object "+library);
		model.addAttribute("library", library);
		return "library-form";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("libraryId") Long libraryId) {
		libraryService.deleteLibraryById(libraryId);
		return "redirect:/libraries/list";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("library") Library library) {
		libraryService.saveLibrary(library);
		return "redirect:/libraries/list";
	}
	
	@PostMapping("/showFilteredList")
	public String showFilteredList(@ModelAttribute("library") String library,
									@RequestParam("filters") String filters,
									@RequestParam("columns") String column,
									@RequestParam("order") String order,
									@RequestParam("fromRecord") int fromRecord,
									@RequestParam("noOfRecords") int noOfRecords,
									@RequestParam("pageNo") int pageNo,
									@RequestParam("recPerPage") int recPerPage,
									Model model) {
		List<Library> libraries ;
		System.out.println("Filter "+filters);
		
		
		
		if (filters.equals("nobooks"))
		{
			libraries = libraryService.getAllLibrariesWithNoBooks();
			model.addAttribute("libraries", libraries);
			//return "filtered-list";
		}
		else if (filters.equals("sort"))
		{
			System.out.println("Order :"+order+" Subject "+column);
			libraries = libraryService.getLibrariesCustomSorted(order, column);
			model.addAttribute("libraries", libraries);
			//return "filtered-list";
		} //topX
		else if (filters.equals("topX"))
		{
			
			libraries = (List<Library>) libraryService. getLibrariesPaged(fromRecord,noOfRecords);
			model.addAttribute("libraries", libraries);
			//return "filtered-list";
		}
		else if (filters.equals("paging"))
		{
			
			libraries = (List<Library>) libraryService. getLibrariesCustomPaged(pageNo,recPerPage);
			model.addAttribute("libraries", libraries);
			//return "filtered-list";
		}
		else if (filters == "")
		{
			return "error-page";
		}
		return "filtered-list";
	}
	
}
