package com.app.rxjava_flatmap_example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.rxjava_flatmap_example.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts = new ArrayList<>();

    @Override
    public PostViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  PostAdapter.PostViewHolder holder, int position) {
        holder.tvTitle.setText(posts.get(position).getTitle());
        if (posts.get(position).getComments()!=null){
            holder.tvNumOfComments.setText(String.valueOf(posts.get(position).getComments().size()));
            holder.tvNumOfComments.setVisibility(View.VISIBLE);
            holder.progress_circular.setVisibility(View.GONE);
        }
        else {
            holder.tvNumOfComments.setVisibility(View.GONE);
            holder.progress_circular.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return posts == null ? 0 : posts.size();
    }

    public void setPosts(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    public void updatePost(Post updatedPost){
        int postIndex = posts.indexOf(updatedPost);
        posts.set(postIndex,updatedPost);
        notifyItemChanged(postIndex);
    }



    public class PostViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle;
        private ProgressBar progress_circular;
        private TextView tvNumOfComments;

        public PostViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            progress_circular = itemView.findViewById(R.id.progress_circular);
            tvNumOfComments = itemView.findViewById(R.id.tvNumOfComments);
        }
    }
    
}
