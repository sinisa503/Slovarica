package com.sinisa.slovarica;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

/**
 * Created by SINISA on 8.3.2016..
 */
public class Utilities {

    private static HashMap<Integer, Integer> mapOfIdsLearning = new HashMap<>();
    private static HashMap<Integer, Integer> mapOfIdsPlaying = new HashMap<>();

    public HashMap<Integer, Integer> getMapOfIds() {
        return mapOfIdsLearning;
    }
    public static HashMap getIdsLearning(){
        mapOfIdsLearning.put(0, R.drawable.a_ucim);
        mapOfIdsLearning.put(1, R.drawable.b_ucim);
        mapOfIdsLearning.put(2, R.drawable.c_ucim);
        mapOfIdsLearning.put(3, R.drawable.cs_ucim);
        mapOfIdsLearning.put(4, R.drawable.cj_ucim);
        mapOfIdsLearning.put(5, R.drawable.d_ucim);
        mapOfIdsLearning.put(6, R.drawable.dz_ucim);
        mapOfIdsLearning.put(7, R.drawable.dj_ucim);
        mapOfIdsLearning.put(8, R.drawable.e_ucim);
        mapOfIdsLearning.put(9, R.drawable.f_ucim);
        mapOfIdsLearning.put(10, R.drawable.g_ucim);
        mapOfIdsLearning.put(11, R.drawable.h_ucim);
        mapOfIdsLearning.put(12, R.drawable.i_ucim);
        mapOfIdsLearning.put(13, R.drawable.j_ucim);
        mapOfIdsLearning.put(14, R.drawable.k_ucim);
        mapOfIdsLearning.put(15, R.drawable.l_ucim);
        mapOfIdsLearning.put(16, R.drawable.lj_ucim);
        mapOfIdsLearning.put(17, R.drawable.m_ucim);
        mapOfIdsLearning.put(18, R.drawable.n_ucim);
        mapOfIdsLearning.put(19, R.drawable.nj_ucim);
        mapOfIdsLearning.put(20, R.drawable.o_ucim);
        mapOfIdsLearning.put(21, R.drawable.p_ucim);
        mapOfIdsLearning.put(22, R.drawable.r_ucim);
        mapOfIdsLearning.put(23, R.drawable.s_ucim);
        mapOfIdsLearning.put(24, R.drawable.sj_ucim);
        mapOfIdsLearning.put(25, R.drawable.t_ucim);
        mapOfIdsLearning.put(26, R.drawable.u_ucim);
        mapOfIdsLearning.put(27, R.drawable.v_ucim);
        mapOfIdsLearning.put(28, R.drawable.z_ucim);
        mapOfIdsLearning.put(29, R.drawable.zs_ucim);

        return mapOfIdsLearning;
    }
    public static HashMap getIdsPlaying(){
        mapOfIdsPlaying.put(0, R.drawable.a);
        mapOfIdsPlaying.put(1, R.drawable.b);
        mapOfIdsPlaying.put(2, R.drawable.c);
        mapOfIdsPlaying.put(3, R.drawable.cs);
        mapOfIdsPlaying.put(4, R.drawable.cj);
        mapOfIdsPlaying.put(5, R.drawable.d);
        mapOfIdsPlaying.put(6, R.drawable.dz);
        mapOfIdsPlaying.put(7, R.drawable.dj);
        mapOfIdsPlaying.put(8, R.drawable.e);
        mapOfIdsPlaying.put(9, R.drawable.f);
        mapOfIdsPlaying.put(10, R.drawable.g);
        mapOfIdsPlaying.put(11, R.drawable.h);
        mapOfIdsPlaying.put(12, R.drawable.i);
        mapOfIdsPlaying.put(13, R.drawable.j);
        mapOfIdsPlaying.put(14, R.drawable.k);
        mapOfIdsPlaying.put(15, R.drawable.l);
        mapOfIdsPlaying.put(16, R.drawable.lj);
        mapOfIdsPlaying.put(17, R.drawable.m);
        mapOfIdsPlaying.put(18, R.drawable.n);
        mapOfIdsPlaying.put(19, R.drawable.nj);
        mapOfIdsPlaying.put(20, R.drawable.o);
        mapOfIdsPlaying.put(21, R.drawable.p);
        mapOfIdsPlaying.put(22, R.drawable.r);
        mapOfIdsPlaying.put(23, R.drawable.s);
        mapOfIdsPlaying.put(24, R.drawable.sj);
        mapOfIdsPlaying.put(25, R.drawable.t);
        mapOfIdsPlaying.put(26, R.drawable.u);
        mapOfIdsPlaying.put(27, R.drawable.v);
        mapOfIdsPlaying.put(28, R.drawable.z);
        mapOfIdsPlaying.put(29, R.drawable.zs);

        return mapOfIdsPlaying;
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
