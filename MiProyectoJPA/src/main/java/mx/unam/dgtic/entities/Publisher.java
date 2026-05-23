package mx.unam.dgtic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PUBLISHER")
public class Publisher {
    @Id
    private String code;

    @Column(name = "PUBLISHER_NAME")
    private String name;

    public Publisher() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
