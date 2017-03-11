package com.saiu.language.labmdas.exersByMe.dataForExers;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Artem Karnov @date 11.03.17.
 *         artem.karnov@t-systems.com
 */


public interface CitizenRepository extends CrudRepository<Citizen, Long> {

    List<Citizen> findByLastName(String lastName);
}