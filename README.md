# CheckBoxTexView  图片+文字复选框
  
  

## 一.首先在项目的gradle中引用：
<pre><code>
    allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' } //此处插入
          }
      }
</code></pre>


## 二.其次在dependencies中添加：
<pre><code>
dependencies {
      compile 'com.github.alijiahua:CheckBoxText:1.3'
}
</code></pre>

## 三.效果预览：
![](https://github.com/alijiahua/CheckBoxText/blob/master/img/img.gif)

## 四.xml中使用：
    <com.yideng168.checkboxtextlibrary.CheckBoxTexView
               android:id="@+id/id_checkbox_textview"
               android:layout_width="200dp"
               android:layout_height="200dp"
               app:textColorChecked="@color/colorPrimary"
               app:textColorUnChecked="@color/colorAccent"
               app:checkedDrawable="@drawable/all_on"
               app:uncheckedDrawable="@drawable/all_off"
               app:text="@string/app_name"
               android:layout_centerInParent="true"
               />

## 五.java中监听：
    CheckBoxTexView checkBoxTexView= (CheckBoxTexView) findViewById(R.id.id_checkbox_textview);
        checkBoxTexView.setOnCheckedChangeListener(new CheckBoxTexView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean isChecked) {

                Log.d("MainActivity", "isChecked:" + isChecked);

            }
        });

## 六.CSDN博客地址：http://blog.csdn.net/alijiahua


