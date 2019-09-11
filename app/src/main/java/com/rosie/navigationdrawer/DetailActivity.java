package com.rosie.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rosie.navigationdrawer.model.Model;

public class DetailActivity extends AppCompatActivity {
    public final static String Extra = "extra";

    Model mModel;
    ImageView imgDetail;
    TextView tvName, tvDate, tvOverview, tvRatingBar;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail =  findViewById(R.id.img_detail);
        tvName =  findViewById(R.id.tv_title);
        tvDate =  findViewById(R.id.tv_title_date);
        tvOverview =  findViewById(R.id.tv_overview);
        ratingBar = findViewById(R.id.rating_bar);
        tvRatingBar = findViewById(R.id.rating_label);

        mModel = getIntent().getParcelableExtra(Extra);
        if (mModel != null){
            if(getSupportActionBar()!= null){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle(mModel.getName());
            }
            Glide.with(this).
                    load(mModel.getPoster_path())
                    .apply(new RequestOptions().override(350,350))
                    .placeholder(R.drawable.default_pict)
                    .error(R.drawable.default_pict).into(imgDetail);
            tvName.setText(mModel.getName());
            tvDate.setText(mModel.getFirst_air_date());
            tvOverview.setText(mModel.getOverview());

            float rat = mModel.getVote_average().floatValue()/2;
            String labelRating = Float.toString(rat);

//            tvRatingBar.setText(getResources().getString(R.string.label_rating, labelRating));
            ratingBar.setRating(rat);
        }
    }
}
