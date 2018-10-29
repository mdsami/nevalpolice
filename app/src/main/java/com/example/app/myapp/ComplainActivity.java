package com.example.app.myapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.LongDef;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.myapp.model.Complain;
import com.example.app.myapp.module.SpinnerValue;
import com.example.app.myapp.service.RestApi;
import com.example.app.myapp.service.RetrofitClient;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.kbeanie.multipicker.utils.FileUtils;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import net.alhazmy13.mediapicker.Image.ImagePicker;
import net.alhazmy13.mediapicker.Video.VideoPicker;
import com.example.app.myapp.IdInitialClass;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cafe.adriel.androidaudiorecorder.AndroidAudioRecorder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Multipart;
import retrofit2.http.Path;

import com.example.app.myapp.model.Nearby;
public class ComplainActivity extends AppCompatActivity  {


    SpinnerValue[] spArr1 = new SpinnerValue[]{
            new SpinnerValue("Select Type of crime  ", "0"),
            new SpinnerValue("লঞ্চে অতিরিক্ত যাত্রী বোঝাই  ", "1"),
            new SpinnerValue("নৌ পথে  ছিনতাই  ", "2"),
            new SpinnerValue(" জাটকা নিধন ","3"),
            new SpinnerValue(" অন্যান্য  ","4"),
    };
    SpinnerValue[] spArr2 = new SpinnerValue[]{

            new SpinnerValue("Select Thana  ", "0"),
            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
            new SpinnerValue("নারায়ণগঞ্জ সদর নৌ থানা", "59"),
            new SpinnerValue("কলাগছিয়া নৌ থানা", "60"),
            new SpinnerValue("পাটুরিয়া নৌ থানা", "87"),
            new SpinnerValue("ডবাহাদুরবাদ নৌ থানা", "93"),
            new SpinnerValue("বরিশাল সদর নৌ থানা", "103"),
            new SpinnerValue("পূর্ব ইলিশা নৌ থানা ", "104"),
            new SpinnerValue("হকেএমপি নৌ থানা খুলনা", "116"),
            new SpinnerValue("নলিয়ান নৌ থানা", "117"),
            new SpinnerValue("চাঁদপাই নৌ থানা", "118"),
            new SpinnerValue("বুড়ি গোয়ালিনী নৌ থানা", "119"),
            new SpinnerValue("চাঁঁদপুর সদর নৌ থানা", "135"),
    };

    SpinnerValue[] spArr3 = new SpinnerValue[]{
            new SpinnerValue("Select Fari  ", "0"),
            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়ি ", "53"),
            new SpinnerValue("কুতুবপুর নৌ ফাঁড়ি", "54"),
            new SpinnerValue("বরিসুর নৌ ফাঁড়ি", "55"),

            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "56"),
            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "57"),
            new SpinnerValue("টঙ্গি নৌ ফাঁড়ি", "58"),


    };


    IdInitialClass idInitialClass;

    EditText etmgs,etphone;
    private Context mContext;
    private ImageView cameraView,videoView ,AudioView ;
    public static final int ACTIVITY_RECORD_SOUND = 0;

    List<String> mPaths;

    private Uri cameraImageUri = null;
    private Uri videoUri = null;
    private Uri audioUri = null;

    Button btnSubmit;

    private ProgressDialog progressDialog;

    String audioPath;
    private MultipartBody.Part img;
    private MultipartBody.Part video;
    private MultipartBody.Part audio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);


        mContext = this;

        cameraView = findViewById(R.id.cameraView);
        videoView = findViewById(R.id.videoView);
        AudioView = findViewById(R.id.recordView);

        etmgs = (EditText) findViewById(R.id.etmgs);
        etphone = (EditText) findViewById(R.id.etphone);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);




        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Wait...");
        progressDialog.setCanceledOnTouchOutside(false);



        btnSubmit = (Button) findViewById(R.id.btnSubmit);


        //setup data
        idInitialClass = new IdInitialClass();

        //initialize Spinner
        for (int i = 1; i <= 3; i++) {
            if ( i == 1 ) {
                idInitialClass.getSpinner(this, "sp" + i, spArr1);
            }else if(i == 2){

                idInitialClass.getSpinner(this, "sp" + i, spArr2);

            }else if(i == 3 ){
                idInitialClass.getSpinner(this, "sp" + i, spArr3);
            }



        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("id");
            //The key argument here must match that used in the other activity
            //Toast.makeText(mContext, "id", Toast.LENGTH_SHORT).show();
            idInitialClass.getSpinnerSelected(this, "sp2", spArr2, Integer.parseInt(value));
            idInitialClass.getSpinnerSelected(this, "sp3", spArr3, Integer.parseInt(value));
            Log.d("DATA_ID", value);
        }

        // open camera for image
        cameraView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(ComplainActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                            ContextCompat.checkSelfPermission(ComplainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        requestForNeededPermission();
                    }else{
                        BringImagePicker();
                    }
                }else{
                    BringImagePicker();
                }
            }
        });

        //open camera for video recording
        videoView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(ComplainActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                            ContextCompat.checkSelfPermission(ComplainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        requestForNeededPermission();
                    }else{
                        openCameraForRecordVideo();
                    }
                }else{
                    openCameraForRecordVideo();
                }



            }
        });

        //Audio recoder
        AudioView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(ComplainActivity.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                        requestForNeededPermission();
                    }else{
                        openRecoderForRecordAudio();
                    }
                }else{
                    openRecoderForRecordAudio();
                }



            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();

                List<SpinnerValue> etval = idInitialClass.getSpinnerArrVlaue(mContext, "sp", 2, 2);
                List<SpinnerValue> etva2 = idInitialClass.getSpinnerArrVlaue(mContext, "sp", 3, 3);


                String phone = etphone.getText().toString().trim();
                String message = etmgs.getText().toString().trim();
                String thana_id = idInitialClass.getSingleSpinnerVlaue(etval);
                String fari_id = idInitialClass.getSingleSpinnerVlaue(etva2);


                //img
                if(cameraImageUri != null){
                    File imgFile = new File(cameraImageUri.getPath());
                    img = MultipartBody.Part.createFormData("img",imgFile.getName(), RequestBody.create(MediaType.parse("image/*"),imgFile));
                }else{

                    Bitmap bm = BitmapFactory.decodeResource( getResources(), R.drawable.bnp_logo);
                    String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
                    File file = new File(extStorageDirectory, "bnp_logo.png");
                    FileOutputStream outStream = null;
                    try {
                        outStream = new FileOutputStream(file);
                        bm.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                        outStream.flush();
                        outStream.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Uri imguri=Uri.fromFile(file);
                    File imgFile = new File(imguri.getPath());
                    img = MultipartBody.Part.createFormData("img",imgFile.getName(), RequestBody.create(MediaType.parse("image/*"),imgFile));
            }



                //video
                if(videoUri != null){
                    File videoFile = new File(videoUri.getPath());
                    video = MultipartBody.Part.createFormData("video",videoFile.getName(), RequestBody.create(MediaType.parse("video/*"),videoFile));
                }else{
                    video = null;
                }


                //audio
                if(audioUri != null){
                    File audioFile = new File(audioUri.getPath());
                    audio = MultipartBody.Part.createFormData("audio",audioFile.getName(), RequestBody.create(MediaType.parse("audio/*"),audioFile));
                }else{
                    audio = null;
                }



                RetrofitClient.getRestApiInterface().complainPost(phone,message,thana_id,fari_id,img,video,audio).enqueue(new Callback<Complain>() {
                    @Override
                    public void onResponse(Call<Complain> call, retrofit2.Response<Complain> response) {
                        Toast.makeText(mContext, "Succuss", Toast.LENGTH_SHORT).show();
                        Log.d("DATA", response.message());
                        progressDialog.dismiss();
                        Log.w("Sami => ",new Gson().toJson(response));
                    }

                    @Override
                    public void onFailure(Call<Complain> call, Throwable t) {
                        Toast.makeText(mContext, "Fail : " + t.getMessage(), Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                });


            }
        });

        requestForNeededPermission();
    }

    // getting Storage read and write permission
    private void requestForNeededPermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getApplicationContext(), "All permissions are granted!", Toast.LENGTH_SHORT).show();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Error occurred! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ComplainActivity.this);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    private void openCameraForRecordVideo() {
        new VideoPicker.Builder(ComplainActivity.this)
                .mode(VideoPicker.Mode.CAMERA_AND_GALLERY)
                .directory(VideoPicker.Directory.DEFAULT)
                .extension(VideoPicker.Extension.MP4)
                .enableDebuggingMode(true)
                .build();
    }


    private void openRecoderForRecordAudio() {
        audioPath = Environment.getExternalStorageDirectory() + "/recorded_audio.wav";
        int color = getResources().getColor(R.color.colorPrimaryDark);
        int requestCode = 0;
        AndroidAudioRecorder.with(this)
                .setFilePath(audioPath)
                .setColor(color)
                .setRequestCode(requestCode)
                .record();

    }



    // Image Croper
    public void BringImagePicker(){
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1,1)
                .start(ComplainActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        // getting imageUri
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                cameraImageUri = result.getUri();
                cameraView.setImageURI(cameraImageUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }

        // getiing videoUri
        if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
             mPaths =  data.getStringArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH);
             List<String> myList = new ArrayList<>();
             myList.add(mPaths.get(0));

             String path = String.valueOf(myList.get(0));

             videoUri = Uri.parse(path);
             Log.d("videoUri" , String.valueOf(videoUri));

        }

        // getting audioUri
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                // Great! User has recorded and saved the audio file
                audioUri = Uri.parse(audioPath);
                Log.d("Record_Path" , "Saved Path::" + audioUri);
            } else if (resultCode == RESULT_CANCELED) {
                // Oops! User has canceled the recording
            }
        }

    }

    public void backButton(View view) {
        Intent backIntent = new Intent(ComplainActivity.this, MainActivity.class);
        startActivity(backIntent);
        backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }
}
