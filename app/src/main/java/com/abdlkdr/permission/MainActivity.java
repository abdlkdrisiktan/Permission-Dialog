package com.abdlkdr.permission;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  private Button permissionButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    permissionButton = findViewById(R.id.permission_button);
    permissionButton.setOnClickListener(buttonClickListener);
    permissionButton.setTextColor(Color.WHITE);
  }

  private final OnClickListener buttonClickListener = view -> Permissions.with(MainActivity.this)
      .request(Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA)
      .ifNecessary()
      .withRationaleDialog(
          getString(R.string.needs_the_microphone_and_camera_permissions_in_order_to_call_s),
          R.drawable.ic_mic_24,
          R.drawable.ic_camera_24)
      .withPermanentDenialDialog(
          getString(R.string.needs_the_microphone_and_camera_permissions_in_order_to_call_s))
      .onAllGranted(() -> {

      })
      .onAnyDenied(() -> {

      })
      .execute();
}