package br.com.zup.library_manager.Repositories;


import br.com.zup.library_manager.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
