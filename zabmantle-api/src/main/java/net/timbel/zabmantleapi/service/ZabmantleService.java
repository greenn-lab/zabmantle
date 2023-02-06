package net.timbel.zabmantleapi.service;

import net.timbel.zabmantleapi.dto.ZabmantleResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ZabmantleService {

    private final WebClient client = WebClient
        .create("https://semantle-ko.newsjel.ly/guess/")
        .mutate().build();

    public ZabmantleResponseDTO guess(String word) {
        return client
            .get()
            .uri("{puzzle}/{word}", 307, word)
            .retrieve()
            .bodyToMono(ZabmantleResponseDTO.class)
            .block();
    }
}
