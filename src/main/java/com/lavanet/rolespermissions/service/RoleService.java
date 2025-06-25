package main.java.com.lavanet.rolespermissions.service;

import main.java.com.lavanet.rolespermissions.dto.RoleDTO;
import main.java.com.lavanet.rolespermissions.entity.Role;
import main.java.com.lavanet.rolespermissions.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setName(roleDTO.getName());
        role.setDescription(roleDTO.getDescription());
        role = roleRepository.save(role);
        return new RoleDTO(role.getId(), role.getName(), role.getDescription());
    }

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> new RoleDTO(role.getId(), role.getName(), role.getDescription()))
                .collect(Collectors.toList());
    }

    public RoleDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return new RoleDTO(role.getId(), role.getName(), role.getDescription());
    }

    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        role.setName(roleDTO.getName());
        role.setDescription(roleDTO.getDescription());
        role = roleRepository.save(role);
        return new RoleDTO(role.getId
