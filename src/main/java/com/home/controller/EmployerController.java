package com.home.controller;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.ListView;
import javax.validation.Valid;

import com.home.entity.Employer;
import com.home.exception.NotFoundException;
import com.home.model.EmployerDto;
import com.home.service.EmployerService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class EmployerController {
	
	@Autowired
	EmployerService employerService;
	
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAllEmployer(){
		List<Employer> list = employerService.findAll();
		List<EmployerDto> ls = list.stream().map( a -> {
			EmployerDto dto = new EmployerDto();
			BeanUtils.copyProperties(a, dto);
			return dto;
		}).toList();
		return ResponseEntity.ok().body(ls);
	}
	
	@GetMapping("by/{id}")
	public ResponseEntity<?> getEmployerById(@PathVariable Long id){
		Optional<Employer> opt = employerService.findById(id);
		
		if (opt.isPresent()) {
			
			return ResponseEntity.ok(opt.get());
		}else {
			throw new NotFoundException("không tìm thấy employer với id" + id);
		}
	}
	
	@PostMapping("create")
	public ResponseEntity<?> createEmployer( @RequestBody Employer employer){
		
			List<Employer> list = employerService.findByEmail(employer.getEmail().trim());
			if (list.size() > 0) {
				throw new NotFoundException("không thể thêm mới employer do email đã tồn tại");
			}else {
				return ResponseEntity.ok(employerService.save(employer));
			
		}
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateEmployer(@PathVariable Long id,
											@RequestBody Employer employer){
		Optional<Employer> opt = employerService.findById(id);
		
		if (opt.isPresent()) {
			
				employer.setId(id);
				return ResponseEntity.ok().body(employerService.save(employer)) ;
			
		}else {
			return ResponseEntity.ok(employerService.save(employer));
		}
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteEmployer(@PathVariable Long id){
		Optional<Employer> opt = employerService.findById(id);
		if (opt.isPresent()) {
			employerService.deleteById(id);
			return ResponseEntity.ok().body("Xóa thành công");
		}else {
			throw new NotFoundException("không tìm thấy employer với id cần xóa");
		}
	}
	
	@GetMapping("search")
	public ResponseEntity<?> searchByName(@RequestParam(defaultValue = "") String keyword){
		List<Employer> list = employerService.findByNameContaining(keyword); 
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("page")
	public ResponseEntity<?> pageEmployer(@RequestParam(defaultValue = "0") Integer pageNo){
		
		Pageable pageable = PageRequest.of(pageNo, 3);
		Page<Employer> pages = employerService.findAll(pageable);
		return ResponseEntity.ok(pages);
	}
	@GetMapping("date")
	public String getTime() {
		java.util.Date date = new java.util.Date();
		return String.valueOf(date);
	}
}
