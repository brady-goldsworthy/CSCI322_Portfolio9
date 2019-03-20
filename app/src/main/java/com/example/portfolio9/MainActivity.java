package com.example.portfolio9;

/*
    Brady Goldsworthy z1816747

    Justin Dupre z1835941

    Portfolio 9

 */


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {

    private ViewGroup paintingContainer;

    private Transition transition;

    private Scene activeScene, passiveScene1, passiveScene2, passiveScene3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintingContainer = findViewById(R.id.paintingLayout);

        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        activeScene = Scene.getSceneForLayout(paintingContainer, R.layout.scene1, this);
        passiveScene1 = Scene.getSceneForLayout(paintingContainer, R.layout.scene2, this);
        passiveScene2 = Scene.getSceneForLayout(paintingContainer, R.layout.scene3, this);
        passiveScene3 = Scene.getSceneForLayout(paintingContainer, R.layout.scene4, this);

        //Make the active scene visible
        activeScene.enter();
    }

    public void changeScene(View view){
        Scene temp;

        temp = activeScene;

        activeScene = passiveScene1;
        passiveScene1 = passiveScene2;
        passiveScene2 = passiveScene3;
        passiveScene3 = temp;

        TransitionManager.go(activeScene, transition);
    }
}
