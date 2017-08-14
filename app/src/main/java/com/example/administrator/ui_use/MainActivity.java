package com.example.administrator.ui_use;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
//不管怎样，第二天的太阳还是会升起来，而且是新的---------《夏至未至》
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ImageView image_1;
    private ProgressBar proB_1;
    private ProgressBar proB_2;
    private EditText edit_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        Button button_1 = (Button) findViewById(R.id.btn_1);
        Button button_2 = (Button) findViewById(R.id.btn_2);
        Button button_3 = (Button) findViewById(R.id.btn_3);
        Button proB_button_1 = (Button) findViewById(R.id.proB_btn_1);
        Button proB_button_2 = (Button) findViewById(R.id.proB_btn_2);
        Button proB_button_3 = (Button) findViewById(R.id.proB_btn_3);
        Button proD_button_1 = (Button) findViewById(R.id.proD_btn_1);
        image_1 = (ImageView) findViewById(R.id.img_1);
        edit_1 = (EditText) findViewById(R.id.edit_1);
        proB_1 = (ProgressBar) findViewById(R.id.proB_1);
        proB_2 = (ProgressBar)findViewById(R.id.proB_2);


//实现获取输入框的数据
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,edit_1.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
//        重写on

        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        proB_button_1.setOnClickListener(this);
        proB_button_2.setOnClickListener(this);
        proB_button_3.setOnClickListener(this);
        proD_button_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            改变图片
            case R.id.btn_2:
                image_1.setImageResource(R.drawable.img_2);
                break;
            case  R.id.btn_3:
                image_1.setImageResource(R.drawable.img_1);
                break;
//            进度条调整
            case R.id.proB_btn_1:
                int progress_1 = proB_1.getProgress();
                progress_1 = progress_1 - 5;
                proB_1.setProgress(progress_1);
                break;
            case  R.id.proB_btn_2:
                int progress_2 = proB_1.getProgress();
                progress_2 = progress_2 + 5;
                proB_1.setProgress(progress_2);
//                隐藏进度条却会增加进度条进度，这里实现隐藏刷新图标
            case R.id.proB_btn_3:
//                点击如果visibility的属性为隐藏，则显示，否则就隐藏
                if(proB_2.getVisibility() == View.GONE){
                    proB_2.setVisibility(View.VISIBLE);
                }else{
                    proB_2.setProgress(View.VISIBLE);
                }
                break;
            case  R.id.proD_btn_1:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("加载中。。。");
                progressDialog.setMessage("Loading...");
//                该处为false时按"back"键时不能退出该ProgressDialog
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }

//    为软件设置按下“back”时的事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("提示");
            dialog.setMessage("你即将离开我");
            dialog.setCancelable(false);
            dialog.setPositiveButton("离开", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            }).setNegativeButton("留下", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).show();
            return true;
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        System.exit(0);
//    }

}
