package com.gururpirana.currency;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobiltrakya on 22/12/16.
 */

public class CurrencyAdapter {

    public static Currency mCurrency;

    public static class CurrencyRecyclerAdapter extends RecyclerView.Adapter<CurrencyHolder> {


        List<Currency> mCurrencies = new ArrayList<>();

        public CurrencyRecyclerAdapter(List<Currency> currencies) {
            mCurrencies = currencies;
        }

        @Override
        public CurrencyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_currency, null);
            CurrencyHolder mCurrencyHolder = new CurrencyHolder(v);

            return mCurrencyHolder;
        }

        @Override
        public void onBindViewHolder(CurrencyHolder holder, int position) {
            mCurrency = mCurrencies.get(position);
            holder.fill(mCurrency);

        }

        @Override
        public int getItemCount() {
            return mCurrencies.size();
        }
    }

    public static class CurrencyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mName, mBuyingPrice, mSellingPrice, mChangeRate;
        private String mCode1;

        public CurrencyHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);

            mName = (TextView) itemView.findViewById(R.id.name);
            mBuyingPrice = (TextView) itemView.findViewById(R.id.buying_price);
            mSellingPrice = (TextView) itemView.findViewById(R.id.selling_price);
            mChangeRate = (TextView) itemView.findViewById(R.id.change_rate);



        }

        public void fill(Currency mCurrency) {

            if (mCurrency.getChange_rate() < 0) {
                mChangeRate.setTextColor(itemView.getContext().getResources().getColor(android.R.color.holo_red_dark));


            } else {
                int color = Color.parseColor("#FF0456D2");
                mChangeRate.setTextColor(color);

            }

            mName.setText(mCurrency.getFull_name());
            mBuyingPrice.setText(String.format("%.4f", mCurrency.getBuying()));
            mSellingPrice.setText(String.format("%.4f", mCurrency.getSelling()));
            mChangeRate.setText("% " + String.format("%.2f", mCurrency.getChange_rate()));
            mCode1 = mCurrency.getCode();


        }

        @Override
        public void onClick(View view) {




            Dialog mDialog = new Dialog(view.getContext());
            mDialog.setContentView(R.layout.dialog_detail);
            mDialog.setTitle("Details");

            TextView mName2 = (TextView) mDialog.findViewById(R.id.full_name_detail);
            TextView mSelling = (TextView) mDialog.findViewById(R.id.selling_price_detail);
            TextView mBuying = (TextView) mDialog.findViewById(R.id.buying_price_detail);
            TextView mCode = (TextView) mDialog.findViewById(R.id.code_detail);
            TextView mChangeRate = (TextView) mDialog.findViewById(R.id.change_rate_detail);

            mName2.setText(mName.getText());
            mSelling.setText(mSellingPrice.getText());
            mBuying.setText(mBuyingPrice.getText());
            mCode.setText(mCode1);
            mChangeRate.setText(mChangeRate.getText());
            mDialog.show();


        }
    }
}
