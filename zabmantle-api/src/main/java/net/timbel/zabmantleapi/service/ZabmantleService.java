package net.timbel.zabmantleapi.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;
import lombok.extern.slf4j.Slf4j;
import net.timbel.zabmantleapi.dto.ZabmantleResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ZabmantleService {

    private static final LocalDate INITIAL_DATE = LocalDate.of(2022, 4, 1);

    private final WebClient client = WebClient
        .create("https://semantle-ko.newsjel.ly/guess/")
        .mutate().build();

    public Mono<ZabmantleResponseDTO> guess(String word) {
        return client
            .get()
            .uri("{puzzle}/{word}", getPuzzleNumber(), word)
            .exchangeToMono(response ->
                response.bodyToMono(ZabmantleResponseDTO.class)
            )
            .log()
            ;
    }

    private long getPuzzleNumber() {
        final LocalDate now = LocalDate.now();
        return DAYS.between(INITIAL_DATE, now);
    }
}

