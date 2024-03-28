package com.proxyapp.controller;

import com.proxyapp.model.ProxyAppModel;
import com.proxyapp.service.ProxyAppService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProxyAppController {

    private final ProxyAppService proxyAppService;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProxyAppController(ProxyAppService proxyAppService, RabbitTemplate rabbitTemplate) {
        this.proxyAppService = proxyAppService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/data")
    public ResponseEntity<String> processData(@RequestBody ProxyAppModel proxyAppModel) {
        // Retrieve additional data from Oracle database using the service
        String additionalData = proxyAppService.getAdditionalData(proxyAppModel.getId());

        // Put the incoming request data to the specific queue of RabbitMQ
        rabbitTemplate.convertAndSend("myQueue", proxyAppModel);

        return new ResponseEntity<>(additionalData, HttpStatus.OK);
    }
}