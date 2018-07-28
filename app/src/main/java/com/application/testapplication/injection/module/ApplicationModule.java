package com.application.testapplication.injection.module;

import com.application.testapplication.injection.scope.ApplicationScope;
import com.application.testapplication.ui.base.rxbus.RxBus;
import com.application.testapplication.ui.base.rxbus.RxBusImpl;
import com.application.testapplication.utils.IKeyBoardUtil;
import com.application.testapplication.utils.KeyBoardUtil;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {

   @Binds
   @ApplicationScope
   abstract RxBus bindRxBus(RxBusImpl rxBus);

   @Binds
   @ApplicationScope
   abstract IKeyBoardUtil bindKeyBoardUtil(KeyBoardUtil keyBoardUtil);

}
