package com.example.m1;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FlowLayout extends FrameLayout {

    private final static int H_DISTANCE=20;
    private final static int V_DISTANCE=20;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout( Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout( Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void addTextView(String keys){

        //加载xml布局的方式
        TextView textView = (TextView) View.inflate(getContext(),R.layout.flow_item,null);
        textView.setText(keys);

        //布局宽高适应
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        //控制设置上布局参数
        textView.setLayoutParams(params);

        addView(textView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //获取本控件的宽度，用于计算行
        int width = getWidth();
        //行数
        int row = 0;

        //子控件左边的坐标
        int diswidth = H_DISTANCE;
        for (int i=0;i<getChildCount();i++){

            //查找子控件
            View view = getChildAt(i);
            int viewWidth = view.getWidth();
            int viewHeight = view.getHeight();


            Log.e("dt","textHeight:"+viewHeight);
            if (diswidth+viewWidth>width){
                //行数增加
                row++;
                diswidth=H_DISTANCE;
            }
            int viewTop = row*viewHeight+row*V_DISTANCE;

            //子控件布局
            view.layout(diswidth,viewTop,diswidth+viewWidth,viewTop+viewHeight);

            //记录下一次子控件左边的坐标
            diswidth+=(viewWidth+H_DISTANCE);

        }
    }
}
