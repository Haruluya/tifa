package com.tifa.framework.web.service.rec;

public class HotRecommendationRequest {

    private int sum;

    public HotRecommendationRequest(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
