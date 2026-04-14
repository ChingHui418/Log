package com.jenny.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenny.backend.dto.NoteDto;
import com.jenny.backend.entity.NoteEntity;
import com.jenny.backend.repository.NoteRepository;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public NoteDto getNoteDto(NoteEntity noteEntity) {
        NoteDto noteDto = new NoteDto();

        noteDto.setId(noteEntity.getId());
        noteDto.setTitle(noteEntity.getTitle());
        noteDto.setWeather(noteEntity.getWeather());
        noteDto.setPhotoUrl(noteEntity.getPhotoUrl());
        noteDto.setCreateTime(noteEntity.getCreateTime());

        return noteDto;
    }

    // Entity 轉換成 Dto
    public List<NoteDto> getAllNotes() {
        List<NoteEntity> noteEntities = noteRepository.findAll();

        return noteEntities.stream()
                           .map(this::getNoteDto)
                           .collect(Collectors.toList());    
    }

    // 前端傳回的 Dto 轉換成 Entity
    public NoteDto createNote(NoteDto noteDto) {
        NoteEntity noteEntity = new NoteEntity();

        noteEntity.setTitle(noteDto.getTitle());
        noteEntity.setWeather(noteDto.getWeather());
        noteEntity.setPhotoUrl(noteDto.getPhotoUrl());

        NoteEntity savedNoteEntity = noteRepository.save(noteEntity);

        return getNoteDto(savedNoteEntity);
    }
}
