package com.thebigcourses.personalblogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.thebigcourses.personalblogapp.Adapter.MyAdapter;
import com.thebigcourses.personalblogapp.Model.PostList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public List<PostList> blogList;
    public RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        blogList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, ConstantsValue.post_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0; i<response.length(); i++){

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        PostList fetchPostList = new PostList();
                        //Log.d("Name", jsonObject.getString("postID"));
                        fetchPostList.setPostID(jsonObject.getString("postID").trim());
                        fetchPostList.setPostTitle(jsonObject.getString("postTitle").trim());
                        fetchPostList.setPostImageUrl(jsonObject.getString("postImageUrl").trim());
                        fetchPostList.setPostDescription(jsonObject.getString("postDescription").trim());
                        blogList.add(fetchPostList);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    adapter = new MyAdapter(getApplicationContext(), blogList);
                    recyclerView.setAdapter(adapter);


                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);


    }
}
