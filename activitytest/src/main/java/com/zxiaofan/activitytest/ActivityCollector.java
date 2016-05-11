package com.zxiaofan.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动管理器，其他活动继承此活动即可
 * Created by yunhai on 2016/5/11.
 */
public class ActivityCollector extends Activity {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /*
    *  销毁所有活动
    */
    public static void finishAll() {
        for (Activity activity : activities
                ) {
            if (!activity.isFinishing()) {
                activity.finish();
            }

        }
    }
}
