package com.tifa.framework.web.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class Rating {
    private String _id;

    private int userId;

    private int productId;

    private double score;

    private long timestamp;

    public Rating(int userId, int productId, double score) {
        this.userId = userId;
        this.productId = productId;
        this.score = score;
        this.timestamp = System.currentTimeMillis();
    }
}
