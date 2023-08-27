package io.github.dcassianodias.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @GetMapping("/hello/{nome}")
    @ResponseBody
    public String helloClientes(@PathVariable("nome") String nomeCliente){
        return String.format("Hello %s ", nomeCliente);
    }

}
