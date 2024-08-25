package com.example.proj1.rest;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.proj1.entities.Cliente;
import com.example.proj1.repositorio.Clientes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/api/cliente")
public class ClienteController {

    private Clientes c;

    public ClienteController(Clientes c) {
        this.c = c;
    }

    @GetMapping("/{id}")//o valor vindo dessa url vai pra variavel ali embaixo
    @ResponseBody      
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id){
        Optional<Cliente> cc = c.findById(id);
        if(cc.isPresent()){
            return ResponseEntity.ok(cc.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    //request eh o que ta entrando, response saindo
    @PostMapping("/clientes")
    @ResponseBody
    public ResponseEntity save( @RequestBody Cliente cliente ){
        Cliente clienteSalvo = c.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }


    @SuppressWarnings("rawtypes")
    @DeleteMapping("/clientes/{id}")
    @ResponseBody
    public ResponseEntity deletarCliente(@PathVariable Integer id){
        Optional<Cliente> cc = c.findById(id);

        if(cc.isPresent()){
            c.delete(cc.get());
            return ResponseEntity.noContent().build();}
        else 
            return ResponseEntity.notFound().build();

    }
}
