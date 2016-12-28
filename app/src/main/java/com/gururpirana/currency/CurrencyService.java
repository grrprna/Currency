package com.gururpirana.currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mobiltrakya on 22/12/16.
 */

public interface CurrencyService {
    @GET("currencies/{location}/latest")
    public Call<List<Currency>> getCurrencyList (
            @Path("location") String location);
}
