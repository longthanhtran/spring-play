package com.acme.persistent;

import org.springframework.data.repository.CrudRepository;

import com.acme.persistent.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
