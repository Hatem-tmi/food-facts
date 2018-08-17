package com.toumi.foodfacts.data.provider.api;

import com.toumi.foodfacts.data.provider.api.dto.EProductDetailsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("product/{barcodeNumber}.json")
    Observable<EProductDetailsResponse> getProductDetails(@Path("barcodeNumber") String barcodeNumber);
}
