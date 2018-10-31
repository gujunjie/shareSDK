package com.example.abc.myapplication38;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class MainActivity extends AppCompatActivity {

    private String imageUrl="http://h.hiphotos.baidu.com/zhidao/pic/item/0823dd54564e9258ce27366f9c82d158ccbf4e1b.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_share=(Button)findViewById(R.id.btn_share);
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    showShare(MainActivity.this,imageUrl);
            }
        });
    }

    public void showShare(Context context,String imageUrl) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle("我分享的精美图片");

        oks.setImageUrl(imageUrl);
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl(imageUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("快来看看吧");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath(Environment.getExternalStorageDirectory().getPath()+"/mydownload"+"/4.jpg");
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl(imageUrl);
        // comment是我对这条分享的评论，仅在人人网使用
        //oks.setComment("我是测试评论文本");
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // 启动分享GUI
        oks.show(context);
    }

}
