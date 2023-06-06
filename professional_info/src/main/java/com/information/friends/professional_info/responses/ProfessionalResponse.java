package com.information.friends.professional_info.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfessionalResponse {
    private int id;
    private String companyName;
    private String profession;
    private String role;
    private String sector;

}
