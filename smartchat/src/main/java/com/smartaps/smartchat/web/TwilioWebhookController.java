package com.smartaps.smartchat.web;

import com.smartaps.smartchat.service.MessageProcessingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/twilio")
public class TwilioWebhookController {

    private final MessageProcessingService processingService;

    public TwilioWebhookController(MessageProcessingService ps) {
        this.processingService = ps;
    }

    @PostMapping("/webhook")
    public void handleIncomingMessage(@RequestParam("From") String from,
            @RequestParam("Body") String body) {
        // On délègue immédiatement au Tier 2
        processingService.processIncomingMessage(from, body);
    }
}