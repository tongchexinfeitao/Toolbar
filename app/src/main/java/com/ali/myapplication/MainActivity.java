package com.ali.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    //为了兼容5.0一下系统，需要使用v7包中的Toolbar
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        //必须先设置支持toolbar
        setSupportActionBar(toolbar);
        //获取actionBar，用于设置navigationIcon
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //设置navigationIcon 为系统默认的返回按钮
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //设置navigationIcon的点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置标题
        toolbar.setTitle(R.string.app_name);
        //设置标题margin
        toolbar.setTitleMarginTop(3);
        //设置子标题
        toolbar.setSubtitle(R.string.app_name);
        //设置菜单点击监听
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        Toast.makeText(MainActivity.this, "action_edit", Toast.LENGTH_SHORT).show();
                        Log.e("tag", "action_edit");
                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                        Log.e("tag", "action_share");
                        break;
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                        Log.e("tag", "action_settings");
                        break;
                }
                return false;
            }
        });
    }

    //添加菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单文件
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
