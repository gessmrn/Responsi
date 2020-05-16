package com.example.newsresponsi.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsresponsi.NewsDiscoverAdapter;
import com.example.newsresponsi.R;
import com.example.newsresponsi.model.news.ArticlesItem;
import com.example.newsresponsi.view.viewmodel.NewsViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private NewsDiscoverAdapter newsDiscoverAdapter;
    private RecyclerView rvNewsDiscover;
    private NewsViewModel newsViewModel;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsDiscoverAdapter = new NewsDiscoverAdapter(getContext());
        newsDiscoverAdapter.notifyDataSetChanged();

        rvNewsDiscover = view.findViewById(R.id.fragmentnews_rv);
        rvNewsDiscover.setLayoutManager(new GridLayoutManager(getContext(), 2));

        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        newsViewModel.setNews();
        newsViewModel.getNews().observe(this,getNewss);

        rvNewsDiscover.setAdapter(newsDiscoverAdapter);
    }

    private Observer<ArrayList<ArticlesItem>> getNewss = new Observer<ArrayList<ArticlesItem>>() {
        @Override
        public void onChanged(ArrayList<ArticlesItem> articlesItems) {
            if (articlesItems != null){
                newsDiscoverAdapter.setData(articlesItems);
            }
        }
    };
}
