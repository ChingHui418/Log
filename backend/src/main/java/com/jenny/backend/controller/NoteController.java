package com.jenny.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jenny.backend.dto.NoteDto;
import com.jenny.backend.service.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<NoteDto> getAll() {
        return noteService.getAllNotes();
    }
}
