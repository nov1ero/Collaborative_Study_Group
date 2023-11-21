package com.example.myapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Random;

public class StudyGroupAdapter extends RecyclerView.Adapter<StudyGroupAdapter.StudyGroupViewHolder> {

    private List<StudyGroup> studyGroups;
    private int[] colors; // Array of different colors

    public StudyGroupAdapter(List<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
        this.colors = generateRandomColors(studyGroups.size()); // Generate random colors
    }

    private int[] generateRandomColors(int count) {
        int[] randomColors = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            randomColors[i] = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }

        return randomColors;
    }

    @NonNull
    @Override
    public StudyGroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_study_group, parent, false);
        return new StudyGroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudyGroupViewHolder holder, int position) {
        StudyGroup studyGroup = studyGroups.get(position);

        holder.textViewTitle.setText(studyGroup.getTitle());
        holder.textViewStudyTopic.setText(studyGroup.getStudyTopic());

        // Set a different background color for each study group item
        holder.itemView.setBackgroundColor(colors[position]);
    }

    @Override
    public int getItemCount() {
        return studyGroups.size();
    }

    static class StudyGroupViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewStudyTopic;

        StudyGroupViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewStudyTopic = itemView.findViewById(R.id.textViewStudyTopic);
        }
    }
}
