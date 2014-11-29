package com.eolalla.diapplication.module;

import android.content.Context;

import com.eolalla.diapplication.DIApplication;
import com.eolalla.diapplication.trash.B;
import com.eolalla.diapplication.trash.C;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ernesto Olalla on 29/11/14.
 */

@Module(injects = DIApplication.class, library = true)
public class RootModule {

    private Context context;


    public RootModule(Context context){
        this.context = context;
    }

    @Named("ApplicationContext")
    @Provides Context provideApplicationContext(){
        return context;
    }

    @Provides
    @Singleton
    B providesB(C c){
        return c;
    }
}
