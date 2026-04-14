package com.jenny.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jenny.backend.entity.NoteEntity;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

}
