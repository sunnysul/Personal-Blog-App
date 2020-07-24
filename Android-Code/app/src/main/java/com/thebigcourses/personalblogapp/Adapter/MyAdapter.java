package com.thebigcourses.personalblogapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thebigcourses.personalblogapp.Model.PostList;
import com.thebigcourses.personalblogapp.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<PostList> blogList;

    public MyAdapter(Context context, List<PostList> blogList) {
        this.context = context;
        this.blogList = blogList;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        PostList postList = blogList.get(position);
        holder.postTitle.setText(postList.getPostTitle());

    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView postTitle;
        public ViewHolder(View view, Context ctx) {
            super(view);
            context = ctx;
            postTitle = view.findViewById(R.id.postTitleTextViewID);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Todo Next
                }
            });
        }
    }
}
