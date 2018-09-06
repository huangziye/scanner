package com.hzy.zxing.util;

import android.content.Context;

/**
 * 根据资源的名字获取其ID值
 * Created by ziye_huang on 2017/7/17.
 */

public class MResource {

    /**
     * 根据资源的名字获取其ID值
     *
     * @param context
     * @param className R.java 中类的名字
     * @param idName    id 的名字
     * @return
     */
    public static int getIdByName(Context context, String className, String idName) {
        String packageName = context.getPackageName();
        int id = 0;
        try {
            Class r = Class.forName(packageName + ".R");
            Class[] classes = r.getClasses();
            Class desireClass = null;

            for (int i = 0; i < classes.length; ++i) {
                if (classes[i].getName().split("\\$")[1].equals(className)) {
                    desireClass = classes[i];
                    break;
                }
            }

            if (null != desireClass) {
                id = desireClass.getField(idName).getInt(desireClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}
