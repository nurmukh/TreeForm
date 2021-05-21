package com.example.murojatnoma.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.murojatnoma.entity.CsvFile;
import com.example.murojatnoma.service.CsvFileService;

@Controller
public class CsvFileController {

	@Autowired
	private CsvFileService csvFileService;

	@GetMapping("/homePage")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/showAll")
	public String showCsvFiles(Model model) {

		List<CsvFile> allEntities = csvFileService.getAllCsvFileEntities();
		model.addAttribute("csvFiles", allEntities);
		return "show-all";
	}

	@GetMapping("/showAllByAscOrder")
	public String showAllByDescOrder(Model model) {

		List<CsvFile> allEntitiesByAscOrder = csvFileService.getAllByIdAsc();
		model.addAttribute("csvFiles", allEntitiesByAscOrder);
		return "show-all-byAsc-order";
	}

	@GetMapping("/showAllByCurrentId")
	public String showAllByCurrecntId(@RequestParam("id") String id, Model model) {

		List<CsvFile> allEntitiesByCurrentId = csvFileService.getAllByCurrentId(id);
		model.addAttribute("csvFiles", allEntitiesByCurrentId);
		return "show-all-byCurrent-id";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/uploadCsvFile", consumes = { "multipart/form-data" })
	public String uploadCsvFile(@RequestParam("file") MultipartFile file, Model model) {

		try {
			List<CsvFile> parsedObjects = csvFileService.parseCsvToObject(file.getInputStream());
			csvFileService.saveCsvFilesAsObject(parsedObjects);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:showAll";
	}

}
