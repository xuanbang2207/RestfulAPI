package com.home.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.home.entity.Employer;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
@Service
public interface EmployerService {

	<S extends Employer> List<S> findAll(Example<S> example, Sort sort);

	<S extends Employer> List<S> findAll(Example<S> example);

	Employer getReferenceById(Long id);

	Employer getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Employer> entities);

	Employer getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Employer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Employer entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Employer> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Employer> entities);

	<S extends Employer> long count(Example<S> example);

	void deleteInBatch(Iterable<Employer> entities);

	<S extends Employer> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Employer> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Employer> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Employer> List<S> saveAll(Iterable<S> entities);

	Optional<Employer> findById(Long id);

	List<Employer> findAllById(Iterable<Long> ids);

	List<Employer> findAll(Sort sort);

	Page<Employer> findAll(Pageable pageable);

	List<Employer> findAll();

	<S extends Employer> Optional<S> findOne(Example<S> example);

	<S extends Employer> S save(S entity);

	List<Employer> findByEmail(String email);

	List<Employer> findByNameContaining(String name);

}
