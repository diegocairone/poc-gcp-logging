package com.cairone.poc.ui.ctrl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairone.poc.ui.dto.LogMsg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/logmsg")
public class LoggingCtrl {

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public LogMsg logMessage(
            String msg, 
            @RequestParam(defaultValue = "INFO", required = false) String level) {
        
        if (level.equalsIgnoreCase("DEBUG")) {
            log.debug("Message to log: {}", msg);
        } else if (level.equalsIgnoreCase("WARNING")) {
            log.warn("Message to log: {}", msg);            
        } else if (level.equalsIgnoreCase("ERROR")) {
            log.error("Message to log: {}", msg);            
        } else  {
            log.info("Message to log: {}", msg);
        }
        
        return new LogMsg(msg);
    }
}
