package com.xiongxh.cryptocoin.utilities;

import android.content.Context;
import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

import timber.log.Timber;

public class NetworkUtils {

    private static final String BASE_URL = "https://min-api.cryptocompare.com/data/";
    private static final String PARAM_FROM_SYMBOL = "fsym";
    private static final String PARAM_TO_SYMBOL = "tsym";
    private static final String PARAM_FROM_SYMBOLS = "fsyms";
    private static final String PARAM_TO_SYMBOLS = "tsyms";
    private static final String PARAM_LIMIT = "limit";
    private static final String pref_price_unit = "USD";
    private static final String pref_interval = "histominute";

    public static URL getPriceUrl(String symbols){
        Uri priceUri = Uri.parse(BASE_URL).buildUpon()
                .appendEncodedPath("pricemultifull")
                .appendQueryParameter(PARAM_FROM_SYMBOLS, symbols)
                .appendQueryParameter(PARAM_TO_SYMBOLS, pref_price_unit)
                .build();
        try {
            URL priceUrl = new URL(priceUri.toString());
            Timber.d("Calling url: " + priceUrl);
            return priceUrl;

        }catch (MalformedURLException e){
            Timber.d(e.getMessage());
            return null;
        }
    }

    public static URL getHisto(String fromSymbol){
        String limit = "60";
        if (pref_interval.equals("histominute")){
            limit = "900";
        }

        Uri histUri = Uri.parse(BASE_URL).buildUpon()
                .appendEncodedPath(pref_interval)
                .appendQueryParameter(PARAM_FROM_SYMBOL, fromSymbol)
                .appendQueryParameter(PARAM_TO_SYMBOL, pref_price_unit)
                .appendQueryParameter(PARAM_LIMIT, limit)
                .build();
        try {
            URL histUrl = new URL(histUri.toString());
            Timber.d("Calling url: " + histUrl);
            return histUrl;

        }catch (MalformedURLException e){
            Timber.d(e.getMessage());
            return null;
        }
    }

    public static URL getUrl(Context context){
        //String sortStr = MoviePreferences.getPreferredSortType(context);
        //mSortType = sortStr;

        //return buildUrlWithQuery(sortStr);
        return null;
    }

    private static URL buildUrlWithQuery(String sortType){
        /**
         final String SORT_BY_PARAM = "sort_by";
         final String RELEASE_DATE_PARAM = "primary_release_date.gte";
         final String release_after = "2015-01-01";
         final String VOTE_COUNT_PARAM = "vote_count.gte";
         final String vote_count_threshold = "100";
         Uri buildUri = Uri.parse(BASE_URL).buildUpon()
         .appendQueryParameter(SORT_BY_PARAM, sortType)
         .appendQueryParameter(RELEASE_DATE_PARAM, release_after)
         .appendQueryParameter(VOTE_COUNT_PARAM, vote_count_threshold)
         .appendQueryParameter(API_KEY_PARAM, BuildConfig.MOVIE_DB_API_KEY)
         .build();
         */
//        if (sortType.equals("top_rated")){
//            BASE_URL = BASE_URL_TOP_RATED;
//        } else {
//            BASE_URL = BASE_URL_POPULAR;
//        }
//
//        Uri buildUri = Uri.parse(BASE_URL).buildUpon()
//                .appendQueryParameter(API_KEY_PARAM, BuildConfig.MOVIE_DB_API_KEY)
//                .build();
//
//        try {
//            URL url = new URL(buildUri.toString());
//            Timber.d( "Calling url: " + url);
//            return url;
//        }catch (MalformedURLException e){
//            Timber.d(e.getMessage());
//            return null;
//        }
        return null;
    }

}