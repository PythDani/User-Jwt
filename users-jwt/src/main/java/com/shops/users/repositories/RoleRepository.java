package com.shops.users.repositories;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shops.commons.users.models.entity.Role;

@RepositoryRestResource(path="role")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
