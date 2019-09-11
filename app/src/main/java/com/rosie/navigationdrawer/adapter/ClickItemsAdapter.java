package com.rosie.navigationdrawer.adapter;

import android.view.View;

public class ClickItemsAdapter  implements View.OnClickListener{
    private onCallback onCallback;

    public ClickItemsAdapter(onCallback onCallback){
        this.onCallback = onCallback;
    }

    @Override
    public void onClick(View v) { onCallback.onItemClicked(v);}

    public interface onCallback{
        void onItemClicked(View view);

    }






}
