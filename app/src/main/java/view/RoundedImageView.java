package view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by SINISA on 19.3.2016..
 */

public class RoundedImageView extends ImageView
{
    public RoundedImageView(Context paramContext)
    {
        super(paramContext);
    }

    public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public static Bitmap getCroppedBitmap(Bitmap paramBitmap, int paramInt)
    {
        if ((paramBitmap.getWidth() != paramInt) || (paramBitmap.getHeight() != paramInt)) {
            paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
        }
        for (;;)
        {
            Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
            Paint localPaint = new Paint();
            localPaint.setAntiAlias(true);
            localPaint.setFilterBitmap(true);
            localPaint.setDither(true);
            localPaint.setColor(Color.parseColor("#BAB399"));
            Canvas localCanvas = new Canvas(localBitmap);
            localCanvas.drawARGB(0, 0, 0, 0);
            localCanvas.drawCircle(paramBitmap.getWidth() / 2 + 0.7F, paramBitmap.getHeight() / 2 + 0.7F, paramBitmap.getWidth() / 2 + 0.1F, localPaint);
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
            return localBitmap;
        }
    }

    @Override
    protected void onDraw(Canvas paramCanvas) {
        Drawable localDrawable = getDrawable();
        if (localDrawable == null) {
        }
        while ((getWidth() == 0) || (getHeight() == 0)) {
            return;
        }
        paramCanvas.drawBitmap(getCroppedBitmap(((BitmapDrawable) localDrawable).getBitmap()
                .copy(Bitmap.Config.ARGB_8888, true), getWidth()), 0.0F, 0.0F, null);
    }
}