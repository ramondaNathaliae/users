package com.protectedobjects.users.repository;

import com.protectedobjects.users.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    Optional<Country> findById(Long id);

    List<Country> findAll();

    List<Country> findAllByOrderByNameAsc();

    Country findTopByOrderByCountryIdDesc();

}
