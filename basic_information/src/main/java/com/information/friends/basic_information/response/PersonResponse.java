package com.information.friends.basic_information.response;

import com.information.friends.professional_info.responses.ProfessionalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bouncycastle.asn1.isismtt.x509.ProfessionInfo;

import javax.persistence.Column;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String dob;
    private String contactNo;
    private ProfessionalResponse professionalResponse;

}
