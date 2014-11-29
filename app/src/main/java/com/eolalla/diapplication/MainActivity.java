package com.eolalla.diapplication;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.eolalla.diapplication.module.MainActivityModule;
import com.eolalla.diapplication.trash.A;
import com.eolalla.diapplication.trash.B;
import com.eolalla.diapplication.trash.C;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import dagger.Lazy;
import dagger.Provides;


public class MainActivity extends BaseActivity {

    @Inject
    A a;
    @Inject
    B b;
    @Inject
    C c;
    @Inject
    @Named("ApplicationContext")
    Context appContext;

    @Inject
    Lazy<A> lazyA;

    @Inject
    Provider<C> providerC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a.toString();
        b.toString();
        c.toString();
        lazyA.get();
        providerC.get();

    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = new LinkedList<Object>();
        modules.add(new MainActivityModule());
        return modules;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
