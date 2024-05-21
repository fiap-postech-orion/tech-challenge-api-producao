package br.com.postech.software.architecture.techchallenge.produto.controller;

import br.com.postech.software.architecture.techchallenge.produto.model.PedidoProducao;
import br.com.postech.software.architecture.techchallenge.produto.service.ProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/v1/producao")
public class ProducaoController {

    @Autowired
    private ProducaoService producaoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<PedidoProducao>> listarTodosPedidosAtivos(@RequestParam String status) throws Exception {
        return new ResponseEntity<>(producaoService.findAllByStatusPedido(status), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<HttpStatus> salvaPedido(@RequestBody PedidoProducao pedidoProducao) throws Exception {
        producaoService.salvaPedido(pedidoProducao);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}