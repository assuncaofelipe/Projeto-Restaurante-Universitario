package com.icet.restaurante.ui.cardapio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CardapioViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CardapioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tela cardapio fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}