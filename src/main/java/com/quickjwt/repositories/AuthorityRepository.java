package com.quickjwt.repositories;

import com.quickjwt.entities.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

    Authority findOneByAuthority(String authority);
}
