package ru.solandme.holidays;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import ru.solandme.holidays.adapters.MyFragmentPagerAdapter;
import ru.solandme.holidays.utils.Utils;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        sharedPreferences = getApplicationContext().getSharedPreferences("settings", Context.MODE_PRIVATE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.main_view_pager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_show_splash)
                .setChecked(sharedPreferences.getBoolean("isDontShowSplash", false));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_theme_light:
                Utils.changeToTheme(Utils.THEME_MATERIAL_LIGHT, this);
                return true;
            case R.id.action_theme_dark:
                Utils.changeToTheme(Utils.THEME_MATERIAL_DARK, this);
                return true;
            case R.id.action_show_splash:
                if(item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                sharedPreferences.edit().putBoolean("isDontShowSplash", item.isChecked()).apply();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
