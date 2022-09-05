package com.home.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.home.entity.Employer;
import com.home.repository.EmployerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;

@Component
public class EmployerServiceImpl implements EmployerService{

	@Autowired
	EmployerRepository employerRepository;

	public EmployerServiceImpl(EmployerRepository employerRepository) {
		
		this.employerRepository = employerRepository;
	}

	@Override
	public <S extends Employer> S save(S entity) {
		return employerRepository.save(entity);
	}

	@Override
	public <S extends Employer> Optional<S> findOne(Example<S> example) {
		return employerRepository.findOne(example);
	}

	@Override
	public List<Employer> findAll() {
		return employerRepository.findAll();
	}

	@Override
	public List<Employer> findByEmail(String email) {
		return employerRepository.findByEmail(email);
	}

	@Override
	public Page<Employer> findAll(Pageable pageable) {
		return employerRepository.findAll(pageable);
	}

	@Override
	public List<Employer> findAll(Sort sort) {
		return employerRepository.findAll(sort);
	}

	@Override
	public List<Employer> findAllById(Iterable<Long> ids) {
		return employerRepository.findAllById(ids);
	}

	@Override
	public Optional<Employer> findById(Long id) {
		return employerRepository.findById(id);
	}

	@Override
	public <S extends Employer> List<S> saveAll(Iterable<S> entities) {
		return employerRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		employerRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return employerRepository.existsById(id);
	}

	@Override
	public <S extends Employer> S saveAndFlush(S entity) {
		return employerRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Employer> List<S> saveAllAndFlush(Iterable<S> entities) {
		return employerRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Employer> Page<S> findAll(Example<S> example, Pageable pageable) {
		return employerRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Employer> entities) {
		employerRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Employer> long count(Example<S> example) {
		return employerRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Employer> entities) {
		employerRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return employerRepository.count();
	}

	@Override
	public <S extends Employer> boolean exists(Example<S> example) {
		return employerRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		employerRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		employerRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Employer entity) {
		employerRepository.delete(entity);
	}

	@Override
	public <S extends Employer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return employerRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		employerRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		employerRepository.deleteAllInBatch();
	}

	@Override
	public Employer getOne(Long id) {
		return employerRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Employer> entities) {
		employerRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		employerRepository.deleteAll();
	}

	@Override
	public Employer getById(Long id) {
		return employerRepository.getById(id);
	}

	@Override
	public Employer getReferenceById(Long id) {
		return employerRepository.getReferenceById(id);
	}

	@Override
	public <S extends Employer> List<S> findAll(Example<S> example) {
		return employerRepository.findAll(example);
	}

	@Override
	public <S extends Employer> List<S> findAll(Example<S> example, Sort sort) {
		return employerRepository.findAll(example, sort);
	}

	@Override
	public List<Employer> findByNameContaining(String name) {
		return employerRepository.findByNameContaining(name);
	}
	
	
}
