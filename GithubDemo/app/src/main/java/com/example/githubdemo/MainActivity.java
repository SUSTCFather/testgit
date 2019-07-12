package com.example.githubdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubdemo.model.CommunityContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private FriendAdapter adapter;
    private List<CommunityContent> friendList;
    private String[] mUrls = new String[]{
            "http://img4.imgtn.bdimg.com/it/u=1816685083,3049248793&fm=26&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=1958512261,2690107717&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2611048718,2883446503&fm=26&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2710955231,433835707&fm=26&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3485487130,4276370278&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1444023808,3753293381&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=882039601,2636712663&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=375794163,1310101500&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=602170967,4011104212&fm=26&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3958252548,1176782870&fm=26&gp=0.jpg",
            "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg",
            "http://img1.imgtn.bdimg.com/it/u=2574446418,376089193&fm=11&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2487055384,1545018402&fm=11&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1194350710,3369075951&fm=11&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=2537314757,610604066&fm=11&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2883285466,3701136881&fm=11&gp=0.jpg"
    };
    private String[] headUrls = new String[]{
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562065214044&di=d7d1103b40d16c0661fa09e96ec96c1b&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201510%2F08%2F20151008192345_uPC5U.jpeg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1471800268,3373504429&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562065240135&di=1ef8330f842bc81ce363f56b3140033b&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201408%2F05%2F20140805182358_CckFB.thumb.700_0.png",
            "http://img3.imgtn.bdimg.com/it/u=3677209778,3519789803&fm=26&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=829044612,3699393036&fm=26&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3276179142,1686381254&fm=26&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2402471065,951299553&fm=26&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=158036347,4141243511&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1671299626,1672203385&fm=26&gp=0.jpg"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        friendList = new ArrayList<>();
        adapter = new FriendAdapter(this,friendList);

        recyclerView.setAdapter(adapter);
        initFriends();
    }

    private void initFriends() {
        List<CommunityContent> newList = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<100;i++){
            newList.add(contentFatory(random.nextInt(9)+1));
        }
        friendList.clear();
        friendList.addAll(newList);

    }

    private CommunityContent contentFatory(int picNum){
        Random random = new Random();
        CommunityContent content = new CommunityContent(random.nextInt(2));
        for(int i=0;i<picNum;i++){
            content.addContentPicUrls(mUrls[random.nextInt(mUrls.length)]);
        }
        content.setHeadUrl(headUrls[random.nextInt(headUrls.length)]);
        return content;
    }


}
