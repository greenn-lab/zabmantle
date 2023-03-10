package net.timbel.zabmantleapi.api;

import lombok.RequiredArgsConstructor;
import net.timbel.zabmantleapi.service.ZabmantleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zabmantle")
@RequiredArgsConstructor
public class ZabmantleController {

    private final ZabmantleService service;


    @CrossOrigin
    @GetMapping("{word}")
    public Object wordMatching(@PathVariable String word) {
        return service.guess(word);
    }

}
