package cn.bluemobi.dylan.welcomevideopager;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yuandl on 2016-11-10.
 */

public class GuildFragment extends Fragment {

    private CustomVideoView customVideoView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customVideoView = new CustomVideoView(getContext());
        int index=getArguments().getInt("index");
        Uri uri;
        if(index==1){
            uri=Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.guide_1);
        }else if(index==2){
            uri=Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.guide_2);
        }else{
            uri=Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.guide_3);
        }
        customVideoView.playVideo(uri);
        return customVideoView;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(customVideoView!=null){
            customVideoView.stopPlayback();
        }
    }
}
