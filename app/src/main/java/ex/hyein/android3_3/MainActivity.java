package ex.hyein.android3_3;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer [] mMplayer=new MediaPlayer[3];
    private Button bt_start;
    private Button bt_stop;
    private ListView lv_music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create MediaPlayer object
        mMplayer[0]= new MediaPlayer();
        mMplayer[1] = new MediaPlayer();
        mMplayer[2] = new MediaPlayer();
        // create Button object and added Event lisener.
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_stop = (Button) findViewById(R.id.bt_stop);
        lv_music = (ListView) findViewById(R.id.lv_music);


        // Prepare mp3 file for MediaPlayer
        try {
//if(AssetFileDescriptor afd)
            AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.boysandgirls);
           // AssetFileDescriptor afd1 = getResources().openRawResourceFd(R.raw.lifeiscool);
            //AssetFileDescriptor afd2= getResources().openRawResourceFd(R.raw.sugar);
            //for(int i=0;i<3;i++) {
            mMplayer[0].setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            //mMplayer[1].setDataSource(afd1.getFileDescriptor(), afd1.getStartOffset(), afd1.getLength());
            //mMplayer[2].setDataSource(afd2.getFileDescriptor(), afd2.getStartOffset(), afd2.getLength());
        //}
        } catch(Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        try {

         //   AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.boysandgirls);
            AssetFileDescriptor afd1 = getResources().openRawResourceFd(R.raw.lifeiscool);
            //AssetFileDescriptor afd2= getResources().openRawResourceFd(R.raw.sugar);
            //for(int i=0;i<3;i++) {
           // mMplayer[0].setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mMplayer[1].setDataSource(afd1.getFileDescriptor(), afd1.getStartOffset(), afd1.getLength());
            //mMplayer[2].setDataSource(afd2.getFileDescriptor(), afd2.getStartOffset(), afd2.getLength());
            //}
        } catch(Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        try {

        //    AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.boysandgirls);
            // AssetFileDescriptor afd1 = getResources().openRawResourceFd(R.raw.lifeiscool);
           AssetFileDescriptor afd2= getResources().openRawResourceFd(R.raw.sugar);
            //for(int i=0;i<3;i++) {
           // mMplayer[0].setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            //mMplayer[1].setDataSource(afd1.getFileDescriptor(), afd1.getStartOffset(), afd1.getLength());
            mMplayer[2].setDataSource(afd2.getFileDescriptor(), afd2.getStartOffset(), afd2.getLength());
            //}
        } catch(Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        // Music Start
        /*
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++) {
                    try {
                        mMplayer[i].prepare();
                        mMplayer[i].start();


                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        */

        // Music Stop
        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++)
                    mMplayer[i].stop();
            }
        });


        // Create listview
        final String[] musicList = {"Boys and Girls", "life is cool", "Sugar"};
        ArrayAdapter<String> musicAdapter;
        musicAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, musicList);
        lv_music.setAdapter(musicAdapter);
        lv_music.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    mMplayer[position].prepare();
                    mMplayer[position].start();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(getApplicationContext(), "click : "+ musicList[position], Toast.LENGTH_LONG).show();
            }
        });

    }
}