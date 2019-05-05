package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface NoteDao extends JpaRepository<Note,Long>,JpaSpecificationExecutor {
    long countNoteByIsnewEquals(Byte isnew);
    List<Note> findByContentIsLike(String content);
}
