package main.java.com.lavanet.rolespermissions.repository;

import main.java.com.lavanet.rolespermissions.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
