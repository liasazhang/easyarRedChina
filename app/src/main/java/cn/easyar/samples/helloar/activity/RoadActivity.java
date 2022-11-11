package cn.easyar.samples.helloar.activity;

import android.app.Activity;
import android.content.Intent;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import androidx.annotation.Nullable;
import cn.easyar.samples.helloar.R;
import cn.easyar.samples.helloar.game.GameActivity;
import cn.easyar.samples.helloar.obj.Gl2Utils;
import cn.easyar.samples.helloar.obj.Obj3D;
import cn.easyar.samples.helloar.obj.ObjFilter2;
import cn.easyar.samples.helloar.obj.ObjReader;

//import部分


public class RoadActivity extends Activity
{
    private Intent intent;
    private GLSurfaceView mGLView1,mGLView2,mGLView3,mGLView4;
    private List<ObjFilter2> filters,filters2,filters3,filters4;
    private TextView textView;
//    时间拖延
    private static final long DELAY = 8000;
    private TimerTask task;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road);

//显示模型
        mGLView1= (GLSurfaceView) findViewById(R.id.mGLView1);
        mGLView2= (GLSurfaceView) findViewById(R.id.mGLView2);
        mGLView3= (GLSurfaceView) findViewById(R.id.mGLView3);
        mGLView4= (GLSurfaceView) findViewById(R.id.mGLView4);
        mGLView1.setEGLContextClientVersion(2);
        mGLView1.setVisibility(View.GONE);
        mGLView2.setEGLContextClientVersion(2);
        mGLView2.setVisibility(View.GONE);
        mGLView3.setEGLContextClientVersion(2);
        mGLView3.setVisibility(View.GONE);
        mGLView4.setEGLContextClientVersion(2);
        mGLView4.setVisibility(View.GONE);
        List<Obj3D> model= ObjReader.readMultiObj(this,"assets/爬雪山.obj");
        List<Obj3D> model2= ObjReader.readMultiObj(this,"assets/红军.obj");
        List<Obj3D> model3= ObjReader.readMultiObj(this,"assets/井冈山.obj");
        List<Obj3D> model4= ObjReader.readMultiObj(this,"assets/红旗.obj");
//        List<Obj3D> model= ObjReader.readMultiObj(this,"assets/季节号.obj");
        filters=new ArrayList<>();
        filters2=new ArrayList<>();
        filters3=new ArrayList<>();
        filters4=new ArrayList<>();

        for (int i=0;i<model.size();i++){
            ObjFilter2 f=new ObjFilter2(getResources());
            f.setObj3D(model.get(i));
            filters.add(f);
        }
        for (int i=0;i<model2.size();i++){
            ObjFilter2 f=new ObjFilter2(getResources());
            f.setObj3D(model2.get(i));
            filters2.add(f);
        }
        for (int i=0;i<model3.size();i++){
            ObjFilter2 f=new ObjFilter2(getResources());
            f.setObj3D(model3.get(i));
            filters3.add(f);
        }
        for (int i=0;i<model4.size();i++){
            ObjFilter2 f=new ObjFilter2(getResources());
            f.setObj3D(model4.get(i));
            filters4.add(f);
        }
        mGLView1.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                for (ObjFilter2 f:filters){
                    f.create();
                }
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                for (ObjFilter2 f:filters){
                    f.onSizeChanged(width, height);
                    float[] matrix= Gl2Utils.getOriginalMatrix();
                    Matrix.translateM(matrix,0,0,-0.3f,0);
                    Matrix.scaleM(matrix,0,1f,1f*width/height,1f);
                    f.setMatrix(matrix);
                }
            }
//            转速
            @Override
            public void onDrawFrame(GL10 gl) {
                GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
                for (ObjFilter2 f:filters){
                    Matrix.rotateM(f.getMatrix(),0,0.2f,0,0.8f,0);
                    f.draw();
                }
            }
        });

        mGLView2.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                for (ObjFilter2 f:filters2){
                    f.create();
                }
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                for (ObjFilter2 f:filters2){
                    f.onSizeChanged(width, height);
                    float[] matrix= Gl2Utils.getOriginalMatrix();
                    Matrix.translateM(matrix,0,0,-0.3f,0);
                    Matrix.scaleM(matrix,0,1f,1f*width/height,1f);
                    f.setMatrix(matrix);
                }
            }


            @Override
            public void onDrawFrame(GL10 gl) {
                GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
                for (ObjFilter2 f:filters){
                    Matrix.rotateM(f.getMatrix(),0,0.2f,0,0.8f,0);
                    f.draw();
                }
            }
        });
        mGLView3.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                for (ObjFilter2 f:filters3){
                    f.create();
                }
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                for (ObjFilter2 f:filters3){
                    f.onSizeChanged(width, height);
                    float[] matrix= Gl2Utils.getOriginalMatrix();
                    Matrix.translateM(matrix,0,0,-0.3f,0);
                    Matrix.scaleM(matrix,0,1f,1f*width/height,1f);
                    f.setMatrix(matrix);
                }
            }

            @Override
            public void onDrawFrame(GL10 gl) {
                GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
                for (ObjFilter2 f:filters){
                    Matrix.rotateM(f.getMatrix(),0,0.2f,0,0.8f,0);
                    f.draw();
                }
            }
        });
        mGLView4.setRenderer(new GLSurfaceView.Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                for (ObjFilter2 f:filters4){
                    f.create();
                }
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                for (ObjFilter2 f:filters4){
                    f.onSizeChanged(width, height);
                    float[] matrix= Gl2Utils.getOriginalMatrix();
                    Matrix.translateM(matrix,0,0,-0.3f,0);
                    Matrix.scaleM(matrix,0,1f,1f*width/height,1f);
                    f.setMatrix(matrix);
                }
            }

            @Override
            public void onDrawFrame(GL10 gl) {
                GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
                for (ObjFilter2 f:filters){
                    Matrix.rotateM(f.getMatrix(),0,0.2f,0,0.8f,0);
                    f.draw();
                }
            }
        });
        mGLView1.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        mGLView2.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        mGLView3.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        mGLView4.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        //RadioButton的点击事件实现联动
        ImageView button1 = (ImageView)findViewById(R.id.obj1);
        ImageView button2 = (ImageView)findViewById(R.id.obj2);
        ImageView button3 = (ImageView)findViewById(R.id.obj3);
        ImageView button4 = (ImageView)findViewById(R.id.obj4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent=new Intent(RoadActivity.this, ObjLoadActivity2.class);
//                startActivity(intent);
                mGLView1.setVisibility(View.VISIBLE);
                final Intent localIntent=new Intent(RoadActivity.this, GameActivity.class);//你要转向的Activity
                Timer timer=new Timer();
                TimerTask tast=new TimerTask() {
                    @Override
                    public void run(){
                        startActivity(localIntent);//执行
                    }
                };
                timer.schedule(tast,DELAY);//10秒后



            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent=new Intent(RoadActivity.this, ObjLoadActivity2.class);
//                startActivity(intent);
                mGLView2.setVisibility(View.VISIBLE);
                final Intent localIntent=new Intent(RoadActivity.this,GameActivity.class);//你要转向的Activity
                Timer timer=new Timer();
                TimerTask tast=new TimerTask() {
                    @Override
                    public void run(){
                        startActivity(localIntent);//执行
                    }
                };
                timer.schedule(tast,DELAY);//10秒后



            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent=new Intent(RoadActivity.this, ObjLoadActivity2.class);
//                startActivity(intent);
                mGLView3.setVisibility(View.VISIBLE);
                final Intent localIntent=new Intent(RoadActivity.this,GameActivity.class);//你要转向的Activity
                Timer timer=new Timer();
                TimerTask tast=new TimerTask() {
                    @Override
                    public void run(){
                        startActivity(localIntent);//执行
                    }
                };
                timer.schedule(tast,DELAY);//10秒后



            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent=new Intent(RoadActivity.this, ObjLoadActivity2.class);
//                startActivity(intent);
                mGLView4.setVisibility(View.VISIBLE);
                final Intent localIntent=new Intent(RoadActivity.this,GameActivity.class);//你要转向的Activity
                Timer timer=new Timer();
                TimerTask tast=new TimerTask() {
                    @Override
                    public void run(){
                        startActivity(localIntent);//执行
                    }
                };
                timer.schedule(tast,DELAY);//10秒后



            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        mGLView1.onResume();
        mGLView1.setVisibility(View.GONE);
        mGLView2.onResume();
        mGLView2.setVisibility(View.GONE);
        mGLView3.onResume();
        mGLView3.setVisibility(View.GONE);
        mGLView4.onResume();
        mGLView4.setVisibility(View.GONE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLView1.onPause();
        mGLView2.onPause();
        mGLView3.onPause();
        mGLView4.onPause();
    }


}
