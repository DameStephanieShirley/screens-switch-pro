package com.example.liyang.landanypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import layout.NextFragment;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener {


    private GridView grid_id;
    private FrameLayout frame;
    private Bundle bundle;

    /**
     * ① run produce
     * ② instance is server
     * ③ use heart
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid_id = (GridView) findViewById(R.id.grid_id);

        List<Map<String,Object>> datas = new ArrayList<>();
        Map<String,Object> map = null;
        for(int i = 0;i<50;i++){
            map = new HashMap<>();
            map.put("text",String.format("第%d个值",i));
            map.put("img",R.mipmap.ic_launcher);
            datas.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, datas, android.R.layout.activity_list_item,
                new String[]{"text", "img"},
                new int[]{android.R.id.text1, android.R.id.icon});
        grid_id.setAdapter(simpleAdapter);

        grid_id.setOnItemClickListener(this);
        frame = (FrameLayout) findViewById(R.id.frame);

        // check frame and bundle
        if (frame!=null&&savedInstanceState!=null) {
            Toast.makeText(this, "sssss", Toast.LENGTH_SHORT).show();
            NextFragment fragment = new NextFragment();
            fragment.setArguments(savedInstanceState);
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.frame,fragment).commit();

        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        // there is need call father method
        super.onSaveInstanceState(outState);

        // nullpoint Exeception
        if (bundle!=null) {
        outState.putString("text",bundle.getString("text"));
        }

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // listener for gridView  the resource is map
        Map map = (Map) parent.getAdapter().getItem(position);
        String text = ((String) map.get("text"));
        bundle = new Bundle();
        bundle.putString("text",text);

        // layout__land
        if (frame==null){
            Intent intent = new Intent(this, ShowActivity.class);
            intent.putExtra("bun",bundle);
            startActivity(intent);
        }else{
            //protial
            NextFragment fragment = new NextFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.frame,fragment).commit();

        }

    }
}
