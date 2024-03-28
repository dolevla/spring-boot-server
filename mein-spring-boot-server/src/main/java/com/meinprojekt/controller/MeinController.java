package com.meinprojekt.controller;

import com.meinprojekt.model.MeinModel;
import com.meinprojekt.service.MeinService;
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
public class MeinController {

    private final MeinService meinService;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MeinController(MeinService meinService, RabbitTemplate rabbitTemplate) {
        this.meinService = meinService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/data")
    public ResponseEntity<String> processData(@RequestBody MeinModel meinModel) {
        // Retrieve additional data from Oracle database using the service
        String additionalData = meinService.getAdditionalData(meinModel.getId());

        // Put the incoming request data to the specific queue of RabbitMQ
        rabbitTemplate.convertAndSend("myQueue", meinModel);

        return new ResponseEntity<>(additionalData, HttpStatus.OK);
    }
}