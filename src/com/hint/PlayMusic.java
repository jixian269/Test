package com.hint;


import com.example.jiaotong.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class PlayMusic {
	SoundPool soundPool;
	int id;

	public PlayMusic(Context context) {
		soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		id = soundPool.load(context, R.raw.music, 0);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

	public void play() {
		soundPool.play(id, 1, 1, 0, 0, 1);//速率最低0.5最高为2，1代表正常速度 
	}

}
