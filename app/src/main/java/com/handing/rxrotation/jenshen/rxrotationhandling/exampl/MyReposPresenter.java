package com.handing.rxrotation.jenshen.rxrotationhandling.exampl;

import android.support.annotation.Nullable;
import android.util.Log;

import com.github.partition.nonconfscope.dagger.NonConfigurationScope;
import com.github.partition.nonconfscope.repos.Repo;
import com.github.partition.nonconfscope.rx.ObserverAdapter;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

@NonConfigurationScope
public class MyReposPresenter {

    private final GithubInteractor githubInteractor;
    private Subscription viewSubscription = Subscriptions.empty();

    @Inject
    MyReposPresenter(GithubInteractor githubInteractor) {
        this.githubInteractor = githubInteractor;
    }

    void setView(@Nullable final MyReposView view) {
        viewSubscription.unsubscribe();
        if (view != null) {
            subscribeView(view);
        }
    }

    private void subscribeView(final MyReposView view) {
        viewSubscription = githubInteractor.getRepo().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverAdapter<List<Repo>>() {
                    @Override
                    public void onError(Throwable e) {
                        Log.e("ReposPresenter", "Error", e);
                        view.displayError();
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        view.setRepos(repos);
                    }
                });
    }
}