package com.example.aplikasi_baru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class StepFragment extends Fragment {

    private static final String ARG_STEP_NUMBER = "step_number";
    private static final String ARG_STEP_DESCRIPTION = "step_description";
    private static final String ARG_STEP_IMAGE = "step_image";

    private int stepNumber;
    private String stepDescription;
    private int stepImage;

    public StepFragment() {
        // Required empty public constructor
    }

    public static StepFragment newInstance(int stepNumber, String stepDescription, int stepImage) {
        StepFragment fragment = new StepFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STEP_NUMBER, stepNumber);
        args.putString(ARG_STEP_DESCRIPTION, stepDescription);
        args.putInt(ARG_STEP_IMAGE, stepImage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stepNumber = getArguments().getInt(ARG_STEP_NUMBER);
            stepDescription = getArguments().getString(ARG_STEP_DESCRIPTION);
            stepImage = getArguments().getInt(ARG_STEP_IMAGE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step, container, false);

        ImageView imageViewStep = view.findViewById(R.id.imageViewStep);
        TextView textViewStep = view.findViewById(R.id.textViewStep);
        Button buttonNext = view.findViewById(R.id.buttonNext);

        imageViewStep.setImageResource(stepImage);
        textViewStep.setText(stepDescription);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager2 viewPager = requireActivity().findViewById(R.id.viewPager);
                viewPager.setCurrentItem(stepNumber);
            }
        });

        return view;
    }
}
