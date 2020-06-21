package com.example.naviassignment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.naviassignment.R;
import com.example.naviassignment.adapter.ClosedPRAdapter;
import com.example.naviassignment.model.ClosedPRModel;
import com.example.naviassignment.viewmodel.ClosedPRViewmodel;

import java.util.List;

public class ClosedPRActivity extends AppCompatActivity {

    ProgressDialog progressBar;
    ClosedPRViewmodel closedPRViewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_pull_request);
        showProgress();
        closedPRViewmodel = new ViewModelProvider(this).get(ClosedPRViewmodel.class);
        initializeViewModel(closedPRViewmodel);
    }

    private void initializeViewModel(ClosedPRViewmodel closedPullRequestViewModel) {
        closedPullRequestViewModel.init(this);
        closedPullRequestViewModel.getClosedPRResponse();
        closedPullRequestViewModel.getClosedPRLiveData().observe(this, new Observer<List<ClosedPRModel>>() {
            @Override
            public void onChanged(List<ClosedPRModel> closedPRModel) {
                updateAdapter(closedPRModel);
                progressBar.dismiss();
            }
        });
    }

    private void updateAdapter(List<ClosedPRModel> closedPRModelList) {
        RecyclerView recyclerView = findViewById(R.id.closed_pr_list);
        ClosedPRAdapter adapter = new ClosedPRAdapter(closedPRModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void showProgress(){
        progressBar = ProgressDialog.show(this, "Breathe in Breathe out", "We are fetching your data...", true);
    }
}
