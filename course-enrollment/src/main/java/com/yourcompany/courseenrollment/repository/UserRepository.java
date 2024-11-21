package main.java.com.yourcompany.courseenrollment.repository;

import com.yourcompany.courseenrollment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
