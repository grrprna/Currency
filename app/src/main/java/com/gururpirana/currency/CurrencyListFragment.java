package com.gururpirana.currency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mobiltrakya on 22/12/16.
 */

public class CurrencyListFragment extends Fragment {

    private RecyclerView mCurrencyListRecycler;

    CurrencyService mCurrencyService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_currency_list, container, false);


        mCurrencyListRecycler = (RecyclerView) v.findViewById(R.id.currency_recycler_view);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        mCurrencyListRecycler.setLayoutManager(lm);

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("http://www.doviz.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mCurrencyService = mRetrofit.create(CurrencyService.class);


        update();

        return v;
    }

    public void update() {

        Call<List<Currency>> mCall = mCurrencyService.getCurrencyList("all");

        mCall.enqueue(new Callback<List<Currency>>() {
            @Override
            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {

                mCurrencyListRecycler.setAdapter(new CurrencyAdapter.CurrencyRecyclerAdapter(response.body()));
                Log.d("isim bastım:","geldi");


            }

            @Override
            public void onFailure(Call<List<Currency>> call, Throwable t) {
                Toast.makeText(getActivity(), R.string.error_message, Toast.LENGTH_LONG).show();

            }
        });


    }
}
