package com.turkey.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.turkey.business.Turkey;
import com.turkey.db.TurkeyRepo;


@CrossOrigin
@RestController
@RequestMapping("/turkeys")
public class TurkeyController {
	
/*
 *  A controller will implement 5 CRUD methods
 *  1.) get all
 *  2.) get by id
 *  3.) post - insert
 *  4.) put - Update
 *  5.) DELETE - Delete
 */
	@Autowired
	private TurkeyRepo turkeyRepo;
	
	// get all Turkeys
	@GetMapping("/")
	public List<Turkey> getAll() {
		return turkeyRepo.findAll();
	}
	// Get a turkey by id
	@GetMapping("/{id}")
	public Optional<Turkey> getById(@PathVariable int id) {
		return turkeyRepo.findById(id);
	
	
	
	}
	// Add a turkey
	@PostMapping("/")
	public Turkey addTurkey(@RequestBody Turkey m) {
	m =	turkeyRepo.save(m);
	return m;
	}
	
	// update turkey
	@PutMapping("/")
	public Turkey updateTurkey(@RequestBody Turkey m) {
		m = turkeyRepo.save(m);
		return m;
	}
	// update turkey
	@DeleteMapping("/{id}")
	public Turkey deleteTurkey(@PathVariable int id) {
		Optional<Turkey> m = turkeyRepo.findById(id);
		if (m.isPresent()) {

		turkeyRepo.deleteById(id);
		}
		else {
			System.out.println("Error turkey not found for id" + id);
		}
		return m.get();
	}
	
	
	
}
