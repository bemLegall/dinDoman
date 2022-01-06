package JT.com.br.JT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import JT.com.br.JT.User.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(String username);
}
