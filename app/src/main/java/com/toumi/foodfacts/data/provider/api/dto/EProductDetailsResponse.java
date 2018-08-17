package com.toumi.foodfacts.data.provider.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class EProductDetailsResponse {

    @SerializedName("status_verbose")
    private String statusVerbose;

    private int status;
    private String code;
    private EProduct product;

    public String getStatusVerbose() {
        return statusVerbose;
    }

    public void setStatusVerbose(String statusVerbose) {
        this.statusVerbose = statusVerbose;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EProduct getProduct() {
        return product;
    }

    public void setProduct(EProduct product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "EProductDetailsResponse{" +
                "statusVerbose='" + statusVerbose + '\'' +
                ", status=" + status +
                ", code='" + code + '\'' +
                ", product=" + product +
                '}';
    }
}
