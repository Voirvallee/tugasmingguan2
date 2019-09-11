package com.rosie.navigationdrawer.server;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rosie.navigationdrawer.model.Model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainData2 extends ViewModel {
    private final ArrayList<Model> listItem = new ArrayList<>();

    private MutableLiveData<ArrayList<Model>> listDataItem =  new MutableLiveData<>();

    public void getDataList2(final String data){
        Interface getDataEndPoint = ApiService.getClient().create(Interface.class);
        Call<ResponseBody> call = getDataEndPoint.getData2(data, ApiService.API_KEY, "en-US");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String result = response.body().string();
                    JSONObject responseJson = new JSONObject(result);
                    JSONArray list = responseJson.getJSONArray("results");

                    for (int a = 0;a <  list.length();a++){
                        JSONObject movies = list.getJSONObject(a);
                        Model model = new Model(movies);
                        listItem.add(model);
                    }
                    listDataItem.postValue(listItem);
                    Log.d("sd", "onResponse"+list.toString());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("sd", "onFailure"+t.getMessage());

            }
        });
    }
    public LiveData<ArrayList<Model>> getDatas2(){
        return listDataItem;
    }

}
