package com.example.matsayya.ihorizonsdemo.mvp.view;


import com.example.matsayya.ihorizonsdemo.mvp.model.Item;


import java.util.List;

public interface MainView extends BaseView {
    void onListLoaded(List<Item> list);

    void onShowDilaog(String message);

    void onHideDilaog();

    void onShowToast(String message);

    void clearItems();

}
