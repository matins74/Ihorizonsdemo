package com.example.matsayya.ihorizonsdemo.mvp.presenter;





import com.example.matsayya.ihorizonsdemo.api.CommonApiService;
import com.example.matsayya.ihorizonsdemo.base.BasePresnter;
import com.example.matsayya.ihorizonsdemo.mapper.MainMapper;
import com.example.matsayya.ihorizonsdemo.mvp.model.Item;
import com.example.matsayya.ihorizonsdemo.mvp.model.RepoMainResponse;
import com.example.matsayya.ihorizonsdemo.mvp.view.MainView;


import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

public class MainPresenter extends BasePresnter<MainView> implements Observer<RepoMainResponse>
{

    @Inject
    protected CommonApiService commonApiService;
    @Inject
    protected MainMapper mobileListMapper;

    @Inject
    MainPresenter()
    {

    }

    public void getMobiles()
    {
        getView().onShowDilaog("Loading.....");
        Observable<RepoMainResponse> repoResponseResponseObservable = commonApiService.getMobiles();
        subscribe(repoResponseResponseObservable,this);
    }

    @Override
    public void onCompleted() {
        getView().onHideDilaog();
        getView().onShowToast("Loading complete.....");
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDilaog();
        getView().onShowToast("Error loading....." + e.getMessage());

    }

    @Override
    public void onNext(RepoMainResponse repoMainResponse) {

        List<Item> list = MainMapper.mapRepository(repoMainResponse);
        getView().clearItems();
        getView().onListLoaded(list);
    }
}
