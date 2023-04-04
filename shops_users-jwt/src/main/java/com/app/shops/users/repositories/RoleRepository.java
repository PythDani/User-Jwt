package com.app.shops.users.repositories;



import org.springframework.data.repository.CrudRepository;

import com.app.shops.users.models.entity.Role;




public interface RoleRepository extends CrudRepository<Role, Long> {
}
