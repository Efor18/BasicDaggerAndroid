package com.eolalla.diapplication.module;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ernesto Olalla on 29/11/14.
 */

@Module(library = true, complete = false)
public class ActivityModule {

    private Context context;

    public ActivityModule(Context context){
        this.context = context;
    }

    @Provides
    @Named("ActivityContext")
    Context provideApplicationContext(){
        return context;
    }

}
