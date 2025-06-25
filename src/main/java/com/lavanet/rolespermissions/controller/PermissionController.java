package main.java.com.lavanet.rolespermissions.controller;

import main.java.com.lavanet.rolespermissions.dto.PermissionDTO;
import main.java.com.lavanet.rolespermissions.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public PermissionDTO createPermission(@RequestBody PermissionDTO permissionDTO) {
        return permissionService.createPermission(permissionDTO);
    }

    @GetMapping
    public List<PermissionDTO> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/{id}")
    public PermissionDTO getPermissionById(@PathVariable Long id) {
        return permissionService.getPermissionById(id);
    }

    @PutMapping("/{id}")
    public PermissionDTO updatePermission(@PathVariable Long id, @RequestBody PermissionDTO permissionDTO) {
        return permissionService.updatePermission(id, permissionDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
    }
}
