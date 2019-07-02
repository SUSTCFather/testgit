package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FriendAdapter adapter;
    private List<CommunityContent> friendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com);
        initFriends();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FriendAdapter(this,friendList);
        recyclerView.setAdapter(adapter);
    }

    private void initFriends() {
        friendList = new ArrayList<>();
        CommunityContent content1 = new CommunityContent();
        content1.setHeadUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562065214044&di=d7d1103b40d16c0661fa09e96ec96c1b&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201510%2F08%2F20151008192345_uPC5U.jpeg");
        content1.setContentPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562065268617&di=23c1961c03e886fbaa068837fa73d9f4&imgtype=0&src=http%3A%2F%2Fdingyue.nosdn.127.net%2FgPrSpRQQiK7BeSxPwutHAq0YlE8GnfzezW5qfnTMrPYRU1529806876177.jpg");

        CommunityContent content2 = new CommunityContent();
        content2.setHeadUrl("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1471800268,3373504429&fm=26&gp=0.jpg");
        content2.setContentPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562065283708&di=4e80de295732ab64da8c4a4524dc466d&imgtype=0&src=http%3A%2F%2Fdingyue.ws.126.net%2F2019%2F03%2F06%2F1ebbcc7e374b4234ae3e78a76271ba8c.jpeg");

        CommunityContent content3 = new CommunityContent();
        content3.setHeadUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562065240135&di=1ef8330f842bc81ce363f56b3140033b&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201408%2F05%2F20140805182358_CckFB.thumb.700_0.png");
        content3.setContentPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562072573661&di=2a4d6abb4af28e5fa7d7b6c7d8cae106&imgtype=0&src=http%3A%2F%2Fwx1.sinaimg.cn%2Forj360%2F007hTftsgy1fxncn5rouij30cs1watj2.jpg");

        friendList.add(content1);
        friendList.add(content2);
        friendList.add(content3);
    }



}
