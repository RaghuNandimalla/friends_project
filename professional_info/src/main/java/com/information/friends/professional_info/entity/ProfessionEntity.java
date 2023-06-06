package com.information.friends.professional_info.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "professional_info")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ProfessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NonNull
    @Column(name = "profession")
    private String profession;
    @NonNull
    @Column(name = "role")
    private String role;
    @NonNull
    @Column(name = "sector")
    private String sector;
    @NonNull
    @Column(name = "company_name")
    private String companyName;
}
