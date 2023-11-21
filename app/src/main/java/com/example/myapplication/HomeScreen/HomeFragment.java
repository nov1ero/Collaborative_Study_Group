package com.example.myapplication.HomeScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Set up RecyclerView with a LinearLayoutManager and your custom adapter
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewStudyGroups);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new StudyGroupAdapter(getStudyGroups()));

        return rootView;
    }

    // Dummy data for demonstration
    private List<StudyGroup> getStudyGroups() {
        List<StudyGroup> studyGroups = new ArrayList<>();
        studyGroups.add(new StudyGroup("Lets Study", "Calculus"));
        studyGroups.add(new StudyGroup("Hello", "Physics"));
        studyGroups.add(new StudyGroup("World", "Computer Science"));
        // Add more study groups as needed
        return studyGroups;
    }
}
