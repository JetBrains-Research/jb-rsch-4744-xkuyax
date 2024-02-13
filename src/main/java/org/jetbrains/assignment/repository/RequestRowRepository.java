package org.jetbrains.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRowRepository extends CrudRepository<RequestRow, Integer> {
}
