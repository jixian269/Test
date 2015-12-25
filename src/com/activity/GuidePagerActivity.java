package com.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.jiaotong.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class GuidePagerActivity extends Activity {

	private List<View> list = new ArrayList<View>();
	private Button loginbtn;
	private ImageView point1,point2,point3;
	private ViewPager viewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//�ж��Ƿ���ʾ����ҳ
//		if(!MyApplication.share.getShow()) {
//			finish();
//			startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//		}
		
		setContentView(R.layout.activity_guidepager);
		
		point1 = (ImageView) findViewById(R.id.guidepager1);
		point2 = (ImageView) findViewById(R.id.guidepager2);
		point3= (ImageView) findViewById(R.id.guidepager3);
		
		View view1 = new View(GuidePagerActivity.this);
		view1.setBackgroundResource(R.color.gray);
		View view2 = new View(GuidePagerActivity.this);
		view2.setBackgroundResource(R.color.blue1);
		
		LayoutInflater inflater = LayoutInflater.from(GuidePagerActivity.this);
		View view3 = inflater.inflate(R.layout.activity_guidelogin, null);
		loginbtn = (Button) view3.findViewById(R.id.guide_login);
		
		list.add(view1);
		list.add(view2);
		list.add(view3);
		
		viewPager = (ViewPager) findViewById(R.id.guide_pager);
		viewPager.setAdapter(new MyViewPagerAdapter());
		viewPager.setOnPageChangeListener(new MyOnPagerChangerListner());
		
		loginbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), LoginActivity.class));
				finish();
			}
		});
	}
	
	class MyViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager) container).removeView(list.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			((ViewPager) container).addView(list.get(position));
			
			return list.get(position);
		}
	}
	
	class MyOnPagerChangerListner implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			if (arg0 == 0) {
				point1.setImageResource(R.drawable.page_now);
				point2.setImageResource(R.drawable.page);
				point3.setImageResource(R.drawable.page);

			} else if (arg0 == 1) {
				point1.setImageResource(R.drawable.page);
				point2.setImageResource(R.drawable.page_now);
				point3.setImageResource(R.drawable.page);

			} else if (arg0 == 2) {
				point1.setImageResource(R.drawable.page);
				point2.setImageResource(R.drawable.page);
				point3.setImageResource(R.drawable.page_now);

			}
		}
	}
}