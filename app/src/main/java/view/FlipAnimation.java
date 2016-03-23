package view;

/**
 * Created by SINISA on 19.3.2016..
 */

import android.graphics.Camera;
import android.view.View;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class FlipAnimation extends Animation {
    private boolean backAnimation = false;
    private Camera camera;
    private float centerX, centerY;
    private boolean forward = true;
    private View fromView, toView;

    public FlipAnimation(View paramView1, View paramView2, boolean paramBoolean, long paramLong) {
        this.fromView = paramView1;
        this.toView = paramView2;
        this.backAnimation = paramBoolean;
        setDuration(paramLong);
        setFillAfter(false);
        setInterpolator(new LinearInterpolator());
    }

    protected void applyTransformation(float paramFloat, Transformation paramTransformation) {
        double d = 3.141592653589793D * paramFloat;
        float f2 = (float) (180.0D * d / 3.141592653589793D);
        float f1 = f2;
        if (this.backAnimation) {
            f1 = -f2;
        }
        f2 = f1;
        if (paramFloat >= 0.5F) {
            f2 = f1 - 180.0F;
            this.fromView.setVisibility(8);
            this.toView.setVisibility(0);
        }
        paramFloat = f2;
        if (this.forward) {
            paramFloat = -f2;
        }
        Matrix matrix = paramTransformation.getMatrix();
        this.camera.save();
        this.camera.translate(0.0F, 0.0F, (float) (150.0D * Math.sin(d)));
        this.camera.rotateY(paramFloat);
        this.camera.getMatrix(matrix);
        this.camera.restore();
        //paramTransformation.preTranslate(-this.centerX, -this.centerY);
        //paramTransformation.postTranslate(this.centerX, this.centerY);
    }

    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
        this.centerX = (paramInt1 / 2);
        this.centerY = (paramInt2 / 2);
        this.camera = new Camera();
    }

    public void reverse() {
        this.forward = false;
        View localView = this.toView;
        this.toView = this.fromView;
        this.fromView = localView;
    }
}
