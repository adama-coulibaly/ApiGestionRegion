package com.projetODC.Projet.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReponseMessage {

    private String message;
    private Boolean status;
}
