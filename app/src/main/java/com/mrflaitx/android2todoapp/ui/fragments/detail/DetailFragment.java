package com.mrflaitx.android2todoapp.ui.fragments.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrflaitx.android2todoapp.R;
import com.mrflaitx.android2todoapp.databinding.FragmentDetailBinding;


public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
    }

    private void initListeners() {
        binding.saveBtn.setOnClickListener(v -> {
            String resultText = binding.enterEt.getText().toString().trim();
            Bundle bundle = new Bundle();
            bundle.putString("key",resultText);
            getParentFragmentManager().setFragmentResult("result",bundle);
            closeFragment();
        });
    }

    private void closeFragment() {
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }
}