package net.timbel.zabmantleapi.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zabmantle")
public class ZabmantleController {

    @GetMapping("{word}")
    public Object wordMatching(@PathVariable String word) {
        return word;
    }

}
