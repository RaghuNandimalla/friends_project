package com.information.friends.basic_information.feign_clients;

import com.information.friends.professional_info.responses.ProfessionalResponse;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROFESSIONAL-INFO", path = "/api/professional_info")
public interface ProfessionalClient {
    @GetMapping("/professions/{id}")
    public ResponseEntity<ProfessionalResponse> getProfessionalResponse(@PathVariable int id);
}
