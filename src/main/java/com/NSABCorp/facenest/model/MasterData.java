package com.NSABCorp.facenest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_master")
@Data
@NoArgsConstructor
public class MasterData {

    @Id
    private Long id;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "id")
    private User authUser;


    @Column(nullable = false)
    private String email;


    @Column
    private String fullName;

    @Column
    private String username;

    private String phone;
    private String location;

    private String role;

    @Column(nullable = false)
    private boolean profileCreated=false;

}
