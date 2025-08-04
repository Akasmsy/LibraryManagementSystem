package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entities.IssuesRecords;

@Repository
public interface IssuedBookRepo extends JpaRepository<IssuesRecords, Long> {

}
