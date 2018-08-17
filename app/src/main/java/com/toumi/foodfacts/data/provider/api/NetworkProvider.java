package com.toumi.foodfacts.data.provider.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.GsonBuilder;
import com.toumi.foodfacts.BuildConfig;
import com.toumi.foodfacts.data.model.Product;
import com.toumi.foodfacts.data.provider.api.mapper.ProductMapper;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
@Singleton
public class NetworkProvider {
    private final ApiService apiService;

    @Inject
    public NetworkProvider() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createOkHttpClient())
                .build();

        this.apiService = retrofit.create(ApiService.class);
    }

    private OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.addNetworkInterceptor(provideNetworkInterceptor());
        okHttpBuilder.cache(null);
        okHttpBuilder.readTimeout(1, TimeUnit.MINUTES);
        okHttpBuilder.connectTimeout(1, TimeUnit.MINUTES);
        return okHttpBuilder.build();
    }

    private Interceptor provideNetworkInterceptor() {

        // Stetho logging interceptor
        return new StethoInterceptor();
    }

    public Observable<Product> getProduct(String barcodeNumber) {
        return apiService.getProductDetails(barcodeNumber).map(ProductMapper::map);
    }
}
