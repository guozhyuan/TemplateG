package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hedgehog.ratingbar.RatingBar;
import com.psychological.cxks.R;

import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.bean.ExpertDetailBean;
import com.psychological.cxks.bean.param.EvaluateParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.OnSalePackgeAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import co.lujun.androidtagview.TagContainerLayout;
import io.reactivex.disposables.Disposable;

public class ExpertDetailActivity extends BaseActivity implements View.OnClickListener {

    private TextView peer_name;//对方的名字
    private ImageView back;
    private TextView message;
    private TextView talk;
    private TextView order;
    private TextView needMore;
    private ImageView head;
    private TextView nick;
    private TextView jobTitle;
    private TextView jobTime;
    private TextView rank;
    private TextView diploma; //资质证书
    private TagContainerLayout tagLayout;
    private ImageView imgBig;
    private ImageView play;
    private ProgressBar bar;
    private TextView introduction;

    private TextView educationBackground;
    private TextView trainingExperience;
    private TextView workExprience;


    private RecyclerView recyclerPackge;
    private ImageView consumerHead;
    private TextView consumerNick;
    private TextView consumerEvaluate;
    private RatingBar ratingbar;


    private ExpertBean.ResultBean transData; //传递的咨询师信息
    private MediaPlayer mediaPlayer;
    private ExpertDetailBean detailBean;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transData = (ExpertBean.ResultBean) getIntent().getSerializableExtra("expert");

        peer_name.setText(Objects.requireNonNull(transData).getName());
        nick.setText(Objects.requireNonNull(transData).getName());
        Glide.with(this).load(Objects.requireNonNull(transData).getImg()).apply(RequestOptions.circleCropTransform()).into(head);

        OnSalePackgeAdapter onSalePackgeAdapter = new OnSalePackgeAdapter(this);
        recyclerPackge.setLayoutManager(new LinearLayoutManager(this));
        recyclerPackge.setAdapter(onSalePackgeAdapter);

        getDetail(transData.getUserId());
        getEvaluate(transData.getUserId());

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_expert;
    }

    @Override
    public void findView() {
        peer_name = findViewById(R.id.peer_name);
        back = findViewById(R.id.back);
        message = findViewById(R.id.message);
        talk = findViewById(R.id.talk);
        order = findViewById(R.id.order);
        needMore = findViewById(R.id.need_more);

        head = findViewById(R.id.head);
        nick = findViewById(R.id.nick);
        jobTitle = findViewById(R.id.jobTitle);
        jobTime = findViewById(R.id.jobTime);
        rank = findViewById(R.id.rank);
        diploma = findViewById(R.id.diploma);
        tagLayout = findViewById(R.id.tagLayout);
        imgBig = findViewById(R.id.img_big);
        play = findViewById(R.id.play);
        bar = findViewById(R.id.progressbar);
        introduction = findViewById(R.id.introduction);
        educationBackground = findViewById(R.id.educationBackground);
        trainingExperience = findViewById(R.id.trainingExperience);
        workExprience = findViewById(R.id.workExprience);

        recyclerPackge = findViewById(R.id.recycler_packge);

        consumerHead = findViewById(R.id.consumer_head);
        consumerNick = findViewById(R.id.consumer_nick);
        consumerEvaluate = findViewById(R.id.consumer_evaluate);
        ratingbar = findViewById(R.id.ratingbar);
        ratingbar.setmClickable(false);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        message.setOnClickListener(this);
        talk.setOnClickListener(this);
        order.setOnClickListener(this);
        needMore.setOnClickListener(this);
        play.setOnClickListener(this);
    }

    private void getDetail(String userId) {
        Disposable subscribe = ApiWrapper.getInstance().expertDetail(userId).subscribe(ret -> {
            detailBean = ret;
            peer_name.setText(ret.getName());
            nick.setText(ret.getName());
            Glide.with(ExpertDetailActivity.this).load(ret.getImg()).apply(RequestOptions.circleCropTransform()).into(head);
            jobTitle.setText(ret.getRank());
            jobTime.setText(String.format("从业%s年", ret.getWorkTime()));
            rank.setText(ret.getDiploma());
            diploma.setText(ret.getDiploma());
            Glide.with(ExpertDetailActivity.this).load(ret.getImg()).into(imgBig);
            introduction.setText(ret.getDetail());
            ArrayList<String> tagList = new ArrayList<>(Arrays.asList(ret.getLabels().split(",")));
            tagLayout.setTags(tagList);
            recordUrl = ret.getPath();
        });
        compositeDisposable.add(subscribe);
    }

    private void getEvaluate(String userId) {
        EvaluateParam param = new EvaluateParam();
        param.consultId = userId;
        Disposable subscribe = ApiWrapper.getInstance().evaluateList(param).subscribe(ret -> {
            Glide.with(ExpertDetailActivity.this).load(ret.get(0).getImg()).into(consumerHead);
            consumerNick.setText(ret.get(0).getConsultName());
            consumerEvaluate.setText(ret.get(0).getContent());
            ratingbar.setStar(ret.get(0).getLevel());
        });
        compositeDisposable.add(subscribe);
    }


    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            bar.setProgress(mediaPlayer.getCurrentPosition());
        }
    };
    private String recordUrl;

    private void playVoice(String url) {
        mediaPlayer = new MediaPlayer();

        mediaPlayer.setOnCompletionListener(player -> {
            mediaPlayer.stop();
            mediaPlayer.release();
            timer.cancel();
        });

        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                return false;
            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // 准备完成
                int micLen = mediaPlayer.getDuration();
                bar.setMax(micLen);
                timer.schedule(timerTask, 0, 1000);
            }
        });

        try {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        Bundle bundle = null;
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.message:

                break;
            case R.id.talk:

                break;

            case R.id.order:
                intent = new Intent(ExpertDetailActivity.this, ReservationActivity.class);
                bundle = new Bundle();
                bundle.putSerializable("expert", detailBean);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.need_more:
                intent = new Intent(ExpertDetailActivity.this, ConsumerEvaluateActivity.class);
                intent.putExtra("userId", transData.getUserId());
                startActivity(intent);
                break;
            case R.id.play:
                if (recordUrl != null) {
                    playVoice(recordUrl);
                } else {
                    Toast.makeText(this, "正在准备音频", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            timer.cancel();
        }
    }

}
