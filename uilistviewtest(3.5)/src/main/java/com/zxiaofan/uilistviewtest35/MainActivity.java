package com.zxiaofan.uilistviewtest35;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemClickListener;

import java.util.List;

public class MainActivity extends Activity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango", "A", "A", "A", "A", "C", "A", "A", "B", "A"};

    //数组中的数据是无法直接传递给ListView 的，我们还需要借助适配器来完成。
//Android 中提供了很多适配器的实现类，其中我认为最好用的就是ArrayAdapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();// 初始化水果数据
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.l_fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        // ListView的点击事件
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
        fruitList.add(apple);
        fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
        fruitList.add(new Fruit("Orange", R.drawable.orange_pic));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
        fruitList.add(new Fruit("Pear", R.drawable.pear_pic));
        fruitList.add(new Fruit("Strawberry", R.drawable.strawberry_pic));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
        fruitList.add(new Fruit("Mango", R.drawable.mango_pic));
    }
}
