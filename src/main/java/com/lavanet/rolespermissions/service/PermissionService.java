package main.java.com.lavanet.rolespermissions.service;

import main.java.com.lavanet.rolespermissions.dto.PermissionDTO;
import main.java.com.lavanet.rolespermissions.entity.Permission;
import main.java.com.lavanet.rolespermissions.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public PermissionDTO createPermission(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setName(permissionDTO.getName());
        permission.setDescription(permissionDTO.getDescription());
        permission = permissionRepository.save(permission);
        return new PermissionDTO(permission.getId(), permission.getName(), permission.getDescription());
    }

    public List<PermissionDTO> getAllPermissions() {
        return permissionRepository.findAll().stream()
                .map(permission -> new PermissionDTO(permission.getId(), permission.getName(), permission.getDescription()))
                .collect(Collectors.toList());
    }

    public PermissionDTO getPermissionById(Long id) {
        Permission permission = permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found"));
        return new PermissionDTO(permission.getId(), permission.getName(), permission.getDescription());
    }

    public PermissionDTO updatePermission(Long id, PermissionDTO permissionDTO) {
        Permission permission = permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found"));
        permission.setName(permissionDTO.getName());
        permission.setDescription(permissionDTO.getDescription());
        permission = permissionRepository.save(permission);
        return new PermissionDTO(permission.getId(), permission.getName(), permission.getDescription());
    }

    public void deletePermission(Long id) {
        Permission permission = permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found"));
        permissionRepository.delete(permission);
    }
}
