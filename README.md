
## LoopViewPager

>### 添加引用



```
//项目根目录 gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

//app目录  gradle
dependencies {
	 implementation 'com.github.jack921:LoopViewPagers:1.2'
}
```



---

>### 属性

属性 | 解释
---|---
loop_now_indicator_img | 指示器当前点的图片
loop_indicator_img | 指示器未选点的图片
loop_gravity | 指示器的位置(center:中间,left:左边,right:右边)


---


> ### API说明

api | 解释
---|---
startBanner() | 开始轮播
startBanner(long delayTime) | 开始轮播同时设置滚动的时间间隔
setAnimation() | 切换过度动画
getViewPager | 得到原生的ViewPage
setData(Context context, List<T> mData, CreateView mCreatView) | 为LoopViewPager的View轮播设值, CreateView为View创建，刷新，删除的接口
setData(final Context context, List<T> mData,final UpdateImage updateImage) | 为LoopViewPager的简单图片轮播设值，UpdateImage返回ImageView和对应数据以便你用图片加载框架加载
setOnPageChangeListener() | 设置viewpager滑动监听
setOnPageClickListener() | 点击每个banner的监听
setIndicatorType() | 设置指示器的类型，有IndicatorView()和IndicatiorCanvasView
setDelayTime() | 设置滚动的时间间隔
showIndicator(boolean show) | 是否显示指示器
setIndicatorGravity() | 设置指示器的位置(IndicatorGravity.CENTER,IndicatorGravity.LEFT,IndicatorGravity.RIGHT)
setIndicatorAnimator() | 当是IndicatorView指示器时，返回选择点的View,以便你那这个View进行各种动画操作

---

注：setData()方法最好放在最后面执行

---


>#### View无限轮播demo

```
List<String> data=new ArrayList<>();
    final LayoutInflater layoutInflater=LayoutInflater.from(this);
    data.add("View1");data.add("View2");
    data.add("View3"); data.add("View4");
    data.add("View5"); data.add("View6");
    viewPager.setData(this, data, new CreateView() {
        @Override
        public View createView(int position) {
            return layoutInflater.inflate(R.layout.layout_view,null);
        }
        @Override
        public void updateView(View view,int position, Object item) {
            ((TextView)view.findViewById(R.id.view_name)).setText((String)item);
        }
        @Override
        public void deleteView(int position){
             //View销毁后的逻辑处理
        }
});
```

###### 效果图：

![view.gif](https://upload-images.jianshu.io/upload_images/925576-c7c907916a7e5167.gif?imageMogr2/auto-orient/strip)


---


>#### 懒人加载数据demo


```
List<Integer> data=new ArrayList<>();
    data.add(R.mipmap.ic_banner1);
    data.add(R.mipmap.ic_banner2);
    data.add(R.mipmap.ic_banner3);
    viewPager.setData(this, data, new UpdateImage<Integer>() {
        @Override
        public void loadImage(ImageView view, int position, Integer item) {
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            //加载图片，如gide
            Glide.with(MainActivity.this).load(item).into(view);
        }
});
```


###### 效果图：

![image.gif](https://upload-images.jianshu.io/upload_images/925576-e1718da15129fc22.gif?imageMogr2/auto-orient/strip)





