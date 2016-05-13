package com.zxiaofan.uilistviewtest35;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yunhai on 2016/5/13.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        // 提升ListView 的运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView == null) { // convertView 参数，这个参数用于将之前加载好的a布局进行缓存，以便之后可以进行重用
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();// 重新获取ViewHolder
        }
//        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitName.setText(fruit.getName());
        // 优化
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    /*个内部类ViewHolder，用于对控件的实例进行缓存*/
    //当convertView 为空的时候，创建一个ViewHolder 对象，并将控件的实例都存放在ViewHolder 里，
    //然后调用View的setTag()方法，将ViewHolder 对象存储在View 中。当convertView 不为空的时候则调用View 的getTag()方法，把ViewHolder 重新取出。
    //这样所有控件的实例都缓存在了ViewHolder里，就没有必要每次都通过findViewById()方法来获取控件实例了。
    private class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
