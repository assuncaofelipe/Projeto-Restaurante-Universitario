package com.icet.restaurante.ui.cardapio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.icet.restaurante.databinding.FragmentCardapioBinding;

public class CardapioFragment extends Fragment {

    private FragmentCardapioBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CardapioViewModel galleryViewModel =
                new ViewModelProvider(this).get(CardapioViewModel.class);

        binding = FragmentCardapioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCardapio;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}