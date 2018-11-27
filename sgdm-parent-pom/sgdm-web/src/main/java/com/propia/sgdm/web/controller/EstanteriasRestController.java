package com.propia.sgdm.web.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.propia.sgdm.service.bean.EstanteriaBean;

public interface EstanteriasRestController {
	
	@GetMapping(path="/", produces = "application/json")
	List<EstanteriaBean> getAll();

	@GetMapping(path="/{id}", produces = "application/json")
	EstanteriaBean getByIdent(@PathVariable("id") String id);

	
	@PutMapping(path="/{id}", consumes = "application/json", produces ="application/json")
	EstanteriaBean update(@RequestBody EstanteriaBean est, @PathVariable("id") String id);
	
	@PostMapping(path="/", consumes = "application/json", produces ="application/json")
	EstanteriaBean add(@RequestBody EstanteriaBean est);
	
	@DeleteMapping(path="/{id}")
	void delete(@PathVariable("id") String id);
	

}




