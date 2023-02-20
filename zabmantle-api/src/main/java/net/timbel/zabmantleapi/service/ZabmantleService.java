package net.timbel.zabmantleapi.service;

import lombok.extern.slf4j.Slf4j;
import net.timbel.zabmantleapi.dto.ZabmantleResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ZabmantleService {

    private final WebClient client = WebClient
        .create("https://semantle-ko.newsjel.ly/guess/")
        .mutate().build();

    public Mono<ZabmantleResponseDTO> guess(String word) {
        return client
            .get()
            .uri("{puzzle}/{word}", 325, word)
            .exchangeToMono(response ->
                response.bodyToMono(ZabmantleResponseDTO.class)
            )
            .log()
            ;

    }
}
