package com.pzf.liaotian.album;

import java.util.HashMap;

import android.content.Context;
import android.graphics.Bitmap;

import com.pzf.liaotian.bean.album.ImageTool;

/**
 * @desc:用于预览相关图片缓存
 *BK:http://blog.sina.com.cn/cuil11
 * @date: 2015年7月3日 下午4:40:54
 * QQ2050542273
 * @email:15162925211@163.com
 */
public class DisplayBitmapCache {
    private static DisplayBitmapCache instance = null;
    private HashMap<String, Bitmap> map = new HashMap<String, Bitmap>();
    private Context context = null;

    public static synchronized DisplayBitmapCache getInstance(Context c) {
        if (null == instance) {
            instance = new DisplayBitmapCache(c);
        }
        return instance;
    }

    private DisplayBitmapCache(Context c) {
        context = c;
    }

    public void set(String path, Bitmap bmp) {
        map.put(path, bmp);
    }

    public Bitmap get(String path) {
        if (map.containsKey(path)) {
            return map.get(path);
        } else {
            Bitmap bmp = ImageTool.getBigBitmapForDisplay(path, context);
            if (null != bmp) {
                map.put(path, bmp);
            }
            return bmp;
        }
    }
}
