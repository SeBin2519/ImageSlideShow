package kr.hs.emirim.sebin2519.imageslideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewFlipper flip;
    EditText edTime;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flip = (ViewFlipper) findViewById(R.id.view_flip);
        edTime = (EditText) findViewById(R.id.editText);

        Button butStart = (Button) findViewById(R.id.but_start);
        butStart.setOnClickListener(this);

        Button butStop = (Button) findViewById(R.id.but_stop);
        butStop.setOnClickListener(this); //현재 킇래스 객체

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_start:
                time=(int)(Double.parseDouble(edTime.getText().toString())*1000);//반환받기 위한 메서드 => getText()
                flip.setFlipInterval(time);//viewFlipper에 넘겨지는 간격 설정 => 1000: 1초
                flip.startFlipping();
                break;
            case R.id.but_stop:
                flip.stopFlipping();
        }
    }
}
