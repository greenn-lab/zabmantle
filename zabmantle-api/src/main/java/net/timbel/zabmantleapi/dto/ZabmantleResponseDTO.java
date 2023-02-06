package net.timbel.zabmantleapi.dto;

import lombok.Data;

@Data
public class ZabmantleResponseDTO {
    private String guess;
    private String rank;
    private double sim;
}
