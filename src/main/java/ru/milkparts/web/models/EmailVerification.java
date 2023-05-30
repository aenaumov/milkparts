package ru.milkparts.web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Setter
@Getter
@Table(name = "EMAIL_VERIFICATIONS")
public class EmailVerification {
    @Id
    @GeneratedValue(generator = "UUID_GENERATOR")
    @GenericGenerator(name = "UUID_GENERATOR", strategy = "org.hibernate.id.UUIDGenerator")
    private String verificationId;
    private String username;

    public EmailVerification(String username) {
        this.username=username;
    }

    public EmailVerification() {

    }
}
