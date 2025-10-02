package org.example.models;

import javax.xml.crypto.Data;
import java.util.Date;

public class BaseModel { // Also called Auditable
    private Long id;
    private Date createdAt;
    private Data updatedAt;

    // We need getters and setters here, because only then child classes can use these methods and can have access
    // to Base model PRIVATE attributes

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Data getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Data updatedAt) {
        this.updatedAt = updatedAt;
    }
}
