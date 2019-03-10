package com.example.recyclerviewlab;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<RecyclerViewData> userList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView =  findViewById(R.id.recycler_view);
        //createMockList();
        apicall();
        setUpRecyclerView();
    }
    /*private void createMockList(){
        RecyclerViewData data;
        data = new RecyclerViewData("https://www.bit.ly/2NT7svr","Nisheeth Agrawal","7");
        mockDataList.add(data);
        data = new RecyclerViewData("https://www.bit.ly/2NT7svr","Ayush Patel","8");
        mockDataList.add(data);
        data = new RecyclerViewData("https://www.bit.ly/2NT7svr","Shireen Kunal Sona","9");
        mockDataList.add(data);
        data = new RecyclerViewData("https://www.bit.ly/2NT7svr","Bhushan Thakre","5");
        mockDataList.add(data);
    }*/
    private void setUpRecyclerView()
    {
        recyclerViewAdapter=new RecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setRecyclerViewDataList(userList);
        recyclerViewAdapter.notifyDataSetChanged();
    }
    private void apicall() {
        ApiServices apiServices=AppClient.getInstance().createService(ApiServices.class);
        Call<UserWrapper> call = apiServices.getUserList() ;
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        userList.addAll(response.body().getRecyclerViewDataList());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {

            }
        });
    }
}
