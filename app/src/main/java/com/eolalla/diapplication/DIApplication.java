package com.eolalla.diapplication;

import android.app.Application;

import com.eolalla.diapplication.module.RootModule;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Ernesto Olalla on 29/11/14.
 */
public class DIApplication extends Application {

    private ObjectGraph objectGraph;
    private Object modules;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules());
        objectGraph.inject(this);
        objectGraph.injectStatics();
    }

    public Object[] getModules() {
        return new Object[]{
                new RootModule(this)
        };
    }

    public ObjectGraph plus(List<Object> modules){
        return objectGraph.plus(modules.toArray());
    }
}
