/**
 * 
 */
package com.olivier.topcollegues.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Table;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olivier.topcollegues.entite.Collegue;
import com.olivier.topcollegues.repository.CollegueRepository;

@RestController
@RequestMapping("/top-collegues")
@CrossOrigin(origins = "*")
public class CollegueController {
	
	@Autowired private CollegueRepository collegueRepo;
	
	@GetMapping
	public List<Collegue> listercollegues(){
		return this.collegueRepo.findAll();
	}
	
	@PostMapping
	public void postCollegue(@RequestBody Collegue col){
		Optional <Collegue> opt = collegueRepo.findAll().stream().filter(collegue -> collegue.getNom().equals(col.getNom())).findFirst();
		if(!opt.isPresent()){
			collegueRepo.save(col);
		}
	}
	
	@PutMapping("{pseudo}/score")
	public Collegue putCollegue(@RequestBody Map<String, String> map, @PathVariable String pseudo){
		Optional<Collegue> opt = collegueRepo.findAll().stream().filter(collegue -> collegue.getNom().equals(pseudo)).findFirst();
		Collegue col = new Collegue();
		if(opt.isPresent()){
			if(map.get("avis").equals("jaime")){
				col = opt.get();
				col.setScore(col.getScore()+10);
				collegueRepo.save(col);	
			}
			if(map.get("avis").equals("jedeteste")){
				col = opt.get();
				col.setScore(col.getScore()-5);
				collegueRepo.save(col);	
			}
			
		}
		return col;
	
	}
}
