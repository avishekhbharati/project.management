package sef.project.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sef.project.management.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select u from User u")
	public List<User> getUsers();

}