package com.tom.mvc.global.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Embeddable
public class RecordTrace {

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public static RecordTrace create() {
        RecordTrace res = new RecordTrace();
        LocalDateTime nowTime = LocalDateTime.now();
        res.createdAt = nowTime;
        res.updatedAt = nowTime;
        return res;
    }

    public void update() {
        this.updatedAt = LocalDateTime.now();
    }
}
