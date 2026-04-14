package com.jenny.backend.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NoteDto {
    private Long id;
    private String title;
    private String weather;
    private String photoUrl;
    private LocalDateTime createTime;
}
