package com.sinisa.slovarica;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

/**
 * Created by SINISA on 8.3.2016..
 */
public class Utilities {

    private static HashMap<Integer, Integer> mapOfIds = new HashMap<>();

    public HashMap<Integer, Integer> getMapOfIds() {
        return mapOfIds;
    }
    public static HashMap getIds(){
        mapOfIds.put(0, R.drawable.a_ucim);
        mapOfIds.put(1, R.drawable.b_ucim);
        mapOfIds.put(2, R.drawable.c_ucim);
        mapOfIds.put(3, R.drawable.cs_ucim);
        mapOfIds.put(4, R.drawable.cj_ucim);
        mapOfIds.put(5, R.drawable.d_ucim);
        mapOfIds.put(6, R.drawable.dz_ucim);
        mapOfIds.put(7, R.drawable.dj_ucim);
        mapOfIds.put(8, R.drawable.e_ucim);
        mapOfIds.put(9, R.drawable.f_ucim);
        mapOfIds.put(10, R.drawable.g_ucim);
        mapOfIds.put(11, R.drawable.h_ucim);
        mapOfIds.put(12, R.drawable.i_ucim);
        mapOfIds.put(13, R.drawable.j_ucim);
        mapOfIds.put(14, R.drawable.k_ucim);
        mapOfIds.put(15, R.drawable.l_ucim);
        mapOfIds.put(16, R.drawable.lj_ucim);
        mapOfIds.put(17, R.drawable.m_ucim);
        mapOfIds.put(18, R.drawable.n_ucim);
        mapOfIds.put(19, R.drawable.nj_ucim);
        mapOfIds.put(20, R.drawable.o_ucim);
        mapOfIds.put(21, R.drawable.p_ucim);
        mapOfIds.put(22, R.drawable.r_ucim);
        mapOfIds.put(23, R.drawable.s_ucim);
        mapOfIds.put(24, R.drawable.sj_ucim);
        mapOfIds.put(25, R.drawable.t_ucim);
        mapOfIds.put(26, R.drawable.u_ucim);
        mapOfIds.put(27, R.drawable.v_ucim);
        mapOfIds.put(28, R.drawable.z_ucim);
        mapOfIds.put(29, R.drawable.zs_ucim);

        return mapOfIds;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        //options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
