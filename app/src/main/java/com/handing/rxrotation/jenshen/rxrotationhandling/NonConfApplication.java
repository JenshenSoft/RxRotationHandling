package com.handing.rxrotation.jenshen.rxrotationhandling;

import android.app.Application;
import android.content.Context;

import com.github.partition.nonconfscope.dagger.AppModule;
import com.github.partition.nonconfscope.dagger.ApplicationComponent;
import com.github.partition.nonconfscope.dagger.DaggerApplicationComponent;

public class NonConfApplication extends Application {

  private static ApplicationComponent applicationComponent;

  public static ApplicationComponent applicationComponent() {
    return applicationComponent;
  }

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    applicationComponent = DaggerApplicationComponent
        .builder()
        .appModule(new AppModule())
        .build();
  }
}
