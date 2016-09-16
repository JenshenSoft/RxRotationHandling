package com.jenshensoft.rxrotationhanding;


import rx.Observable;
import rx.subjects.BehaviorSubject;

public class HonConfigManager<Type> {

    private final DataProvider<Type> dataProvider;
    private BehaviorSubject<Type> subject;

    public HonConfigManager(DataProvider<Type> dataProvider) {
        this.dataProvider = dataProvider;
        this.subject = createSubject();
    }

    public Observable<Type> getData() {
       return null;
    }

    private BehaviorSubject<Type> createSubject() {
        return new BehaviorSubject.create();
    }


    public interface DataProvider<Type> {
        Observable<Type> provide();
    }
}
