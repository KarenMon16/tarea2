package org.example.repositories.data.interfaces;

import org.example.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRolRepository extends JpaRepository<User, Integer> {
}
