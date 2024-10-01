package ru.pickme.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pickme.backend.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
