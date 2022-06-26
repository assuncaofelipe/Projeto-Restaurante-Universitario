package com.icet.restaurante.ui.declaracao_ru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.icet.restaurante.databinding.FragmentDeclaraoRuBinding;

public class DeclaracaoRU_Fragment extends Fragment {

    private FragmentDeclaraoRuBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DeclaracaoRU_ViewModel declaracaoRUViewModel =
                new ViewModelProvider(this).get(DeclaracaoRU_ViewModel.class);

        binding = FragmentDeclaraoRuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDeclaraoRu;
        declaracaoRUViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}