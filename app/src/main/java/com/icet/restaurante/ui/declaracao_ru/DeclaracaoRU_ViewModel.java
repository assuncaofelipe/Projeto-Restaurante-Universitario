package com.icet.restaurante.ui.declaracao_ru;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DeclaracaoRU_ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DeclaracaoRU_ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tela declaracao RU fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}