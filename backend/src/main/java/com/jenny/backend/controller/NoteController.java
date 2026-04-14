package com.jenny.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jenny.backend.dto.NoteDto;
import com.jenny.backend.service.NoteService;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*") // 允許來自任何來源的跨域請求
public class NoteController {
    
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<NoteDto> getAll() {
        return noteService.getAllNotes();
    }

    // 收到前端的 JSON，@RequestBody 會自動把 JSON 轉成 Java 的 NoteDto 物件
    @PostMapping
    public NoteDto create(@RequestBody NoteDto noteDto) {
        return noteService.createNote(noteDto);
    }
}
