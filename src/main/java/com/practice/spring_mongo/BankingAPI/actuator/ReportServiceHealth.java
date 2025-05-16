package com.practice.spring_mongo.BankingAPI.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ReportServiceHealth implements HealthIndicator {
    @Override
    public Health health() {
        if(getReportService()){
            return Health.up().withDetail("Reporting Service", "Report Service is up").build();
        }
        else
            return Health.down().withDetail("Report Service", "Report Service is down").build();
    }

    public boolean getReportService(){
        return true;
    }
}
