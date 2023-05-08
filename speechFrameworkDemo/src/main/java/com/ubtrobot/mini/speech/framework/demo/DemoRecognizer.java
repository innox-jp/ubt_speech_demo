package com.ubtrobot.mini.speech.framework.demo;

import android.util.Log;

import com.ubtechinc.mini.weinalib.TencentVadRecorder;
import com.ubtrobot.speech.AbstractRecognizer;
import com.ubtrobot.speech.AudioRecordListener;
import com.ubtrobot.speech.RecognitionOption;

public class DemoRecognizer extends AbstractRecognizer {
  private final TencentVadRecorder recorder;
  private static final String TAG = DemoRecognizer.class.getName();

  public DemoRecognizer(TencentVadRecorder recorder) {
    this.recorder = recorder;
    recorder.registerRecordListener(new AudioRecordListener() {
      @Override public void onRecord(byte[] asrData, int length) {
        //asrData: pcm, 16000 sampleRate, 8bit
        //Receive the recording data of microphone output in line here
        Log.d(TAG, "onRecord: " + asrData.toString());
      }
    }, null, null);
  }

  @Override protected void startRecognizing(RecognitionOption recognitionOption) {
    recorder.start();
  }

  @Override protected void stopRecognizing() {
    recorder.stop();
  }
}
