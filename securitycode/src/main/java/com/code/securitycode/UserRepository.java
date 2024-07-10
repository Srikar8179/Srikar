package com.code.securitycode;

	import com.example.jwt.model.User;
	import org.springframework.data.jpa.repository.JpaRepository;

	public interface UserRepository extends JpaRepository<User, Long> {
	    User findByUsername(String username);
	}

}
