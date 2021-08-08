package com.cairone.poc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.StringPayload;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

    public void run(String... args) throws Exception {
        
        Logging logging = LoggingOptions.getDefaultInstance().getService();
        
        List<LogEntry> entries = new ArrayList<>();
        entries.add(LogEntry.of(StringPayload.of("Entry payload")));
        
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("i-am", "Diego");
        
        entries.add(LogEntry.of(JsonPayload.of(jsonMap)));
        
        logging.write(
            entries,
            WriteOption.logName("testing-from-remote-PC"),
            WriteOption.resource(MonitoredResource.newBuilder("global").build()));
    }

}
