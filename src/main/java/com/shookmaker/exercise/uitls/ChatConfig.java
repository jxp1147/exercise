package com.shookmaker.exercise.uitls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatConfig {
    private Boolean disable_search;
    private Boolean enable_citation;
    private List<ChatMessageModel> messages;
}
