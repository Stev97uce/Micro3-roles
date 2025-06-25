package main.java.com.lavanet.rolespermissions.repository;

import main.java.com.lavanet.rolespermissions.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
