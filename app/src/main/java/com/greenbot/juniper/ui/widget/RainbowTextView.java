package com.greenbot.juniper.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;


import com.greenbot.juniper.R;

/**
 * Created by gaurav on 6/8/17.
 */

public class RainbowTextView extends android.support.v7.widget.AppCompatTextView {
    public RainbowTextView(Context context) {
        super(context);
    }

    public RainbowTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RainbowTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Shader shader = getBitmapShader();//getRainbowShader(w);
        getPaint().setShader(shader);

       // applyEmbossFilter(new float[]{0f, 1f, 0.5f}, 0.8f, 3f, 3f);

        applyBlurrFilter(BlurMaskFilter.Blur.SOLID);

    }


    @NonNull
    private Shader getRainbowShader(int w) {
        int[] rainbow = getRainbowColors();

        Shader shader = new LinearGradient(0, 0, 0, w, rainbow,
                null, Shader.TileMode.MIRROR);
        Matrix matrix = new Matrix();
        matrix.setRotate(90);
        shader.setLocalMatrix(matrix);

        return shader;
    }

    private Shader getBitmapShader() {
        Bitmap bitmap = BitmapFactory.decodeResource(
                getResources(), R.drawable.cheetah_tiles);
        Shader shader = new BitmapShader(bitmap,
                Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        return shader;
    }

    private void applyEmbossFilter(
            float[] direction, float ambient,
            float specular, float blurRadius) {

        setText("EMBOSS");
        EmbossMaskFilter filter = new EmbossMaskFilter(
                direction, ambient, specular, blurRadius);
        getPaint().setMaskFilter(filter);
    }

    private void applyBlurrFilter(BlurMaskFilter.Blur style) {
        setText(style.name());
        float radius = getTextSize() / 10;
        BlurMaskFilter filter = new BlurMaskFilter(radius, style);
        getPaint().setMaskFilter(filter);
    }

    private int[] getRainbowColors() {
        return new int[]{
                getResources().getColor(R.color.rainbow_red),
                getResources().getColor(R.color.rainbow_yellow),
                getResources().getColor(R.color.rainbow_green),
                getResources().getColor(R.color.rainbow_blue),
                getResources().getColor(R.color.rainbow_purple)
        };
    }
}
