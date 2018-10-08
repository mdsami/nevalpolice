package com.example.app.myapp.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.al.tobangla.utils.ProcessType;
import com.al.tobangla.views.BNTextView;
import com.example.app.myapp.ComplainActivity;
import com.example.app.myapp.R;
import com.example.app.myapp.model.Information;

import java.util.List;

public class ThanaFariRecyclerAdapter extends RecyclerView.Adapter<ThanaFariRecyclerAdapter.ViewHolder> {
    private List<Information> informationList;
    private Context mContext;

    public ThanaFariRecyclerAdapter(List<Information> informationList) {
        this.informationList = informationList;
    }

    @Override
    public ThanaFariRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_thanafari_listview,viewGroup,false);
        mContext = viewGroup.getContext();
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(ThanaFariRecyclerAdapter.ViewHolder viewHolder, int i) {
        final String id = informationList.get(i).getId();
        String oc = informationList.get(i).getOc();
       final String phone = informationList.get(i).getPhone();
        String thana = informationList.get(i).getName();

        viewHolder.setThanaFariInfo(oc,phone,thana);

        viewHolder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    }else{
                        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ phone ));
                        mContext.startActivity(callIntent);
                    }
                }else{
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phone));
                    mContext.startActivity(callIntent);
                }
            }
        });

        viewHolder.btnMgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.SEND_SMS}, 1);
                    }else{
                        Intent callIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+phone));
                        mContext.startActivity(callIntent);
                    }
                }else{
                    Intent callIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+phone));
                    mContext.startActivity(callIntent);
                }
            }
        });

        viewHolder.btnComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conplainIntent = new Intent(mContext,ComplainActivity.class);
                mContext.startActivity(conplainIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return informationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        BNTextView tvOc;
        BNTextView tvPost;
        BNTextView tvPhn;
        BNTextView tvThana;

        Button btnComplain;

        ImageView btnCall,btnMgs;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            btnCall = view.findViewById(R.id.btnCall);
            btnMgs = view.findViewById(R.id.btnMgs);
            btnComplain = view.findViewById(R.id.btnComplain);

        }

        public void setThanaFariInfo(String oc,String phone,String thana){
            tvOc = view.findViewById(R.id.tvOc);
            tvPhn = view.findViewById(R.id.tvPhn);
            tvPost = view.findViewById(R.id.tvPost);
            tvThana = view.findViewById(R.id.tvThana);


            tvOc = new BNTextView(mContext);
            tvPost = new BNTextView(mContext);
            tvPhn = new BNTextView(mContext);
            tvPhn.setProcessType(ProcessType.NUMBER);
            tvThana = new BNTextView(mContext);



            tvOc.setText(oc);
            tvPhn.setText(phone);
            tvThana.setText(thana);

        }
    }
}
