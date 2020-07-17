package com.learntodroid.mvvmrestapi.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.learntodroid.mvvmrestapi.R;
import com.learntodroid.mvvmrestapi.adapters.BookSearchResultsAdapter;
import com.learntodroid.mvvmrestapi.databinding.FragmentBooksearchBinding;
import com.learntodroid.mvvmrestapi.viewmodels.BookSearchViewModel;

public class BookSearchFragment extends Fragment {
    private BookSearchViewModel viewModel;
    private BookSearchResultsAdapter adapter;
    private FragmentBooksearchBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new BookSearchResultsAdapter();

        viewModel = new ViewModelProvider(this).get(BookSearchViewModel.class);
        viewModel.init();
        viewModel.getVolumesResponseLiveData().observe(this, volumesResponse -> {
            if (volumesResponse != null) {
                adapter.setResults(volumesResponse.getItems());
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_booksearch, container, false);
        View view = binding.getRoot();

        binding.fragmentBooksearchSearchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.fragmentBooksearchSearchResultsRecyclerView.setAdapter(adapter);

        binding.fragmentBooksearchSearch.setOnClickListener(v -> performSearch());

        return view;
    }

    public void performSearch() {
        String keyword = binding.fragmentBooksearchKeyword.getEditableText().toString();
        String author = binding.fragmentBooksearchAuthor.getEditableText().toString();

        viewModel.searchVolumes(keyword, author);
    }
}
