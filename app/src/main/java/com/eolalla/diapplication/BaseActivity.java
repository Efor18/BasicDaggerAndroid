package com.eolalla.diapplication;

import android.app.Activity;
import android.os.Bundle;

import com.eolalla.diapplication.module.ActivityModule;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Ernesto Olalla on 29/11/14.
 */
public abstract class BaseActivity extends Activity {

    private ObjectGraph objectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DIApplication app = (DIApplication)getApplication();
        List<Object> modules = getModules();
        modules.add(new ActivityModule(this));
        objectGraph = app.plus(modules);
        objectGraph.inject(this);
    }

    protected abstract List<Object> getModules();
}
