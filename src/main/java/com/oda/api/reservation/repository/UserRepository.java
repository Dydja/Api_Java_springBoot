package com.oda.api.reservation.repository;

import com.oda.api.reservation.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Iterator;

@Repository //signifie que la classe est un bean
public interface UserRepository extends CrudRepository<User, BigInteger> {

}
