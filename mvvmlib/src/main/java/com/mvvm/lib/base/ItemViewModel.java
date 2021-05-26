package com.mvvm.lib.base;


import androidx.annotation.NonNull;


public class ItemViewModel<VM extends BaseViewModel> {
    protected VM viewModel;

    public ItemViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }
}
