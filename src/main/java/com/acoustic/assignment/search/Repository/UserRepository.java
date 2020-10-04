package com.acoustic.assignment.search.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acoustic.assignment.search.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	@Query("SELECT s FROM User s WHERE lower(s.firstName) LIKE lower(CONCAT('%',?1, '%')) or lower(s.lastName) LIKE lower(CONCAT('%',?1, '%')) order by s.firstName")
	Page<User> getLastUserByKeyWord(String key,Pageable pageable);

}
