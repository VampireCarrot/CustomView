#CustomView
自定义View由菜鸟到大神
# 了解自定义View
  一：Android 怎么获取安卓中的各类资源以及去使用它

    1.1：drawable 作用:存放各种图片类型,不能纯数字定义文件名,另可以新建.xml文件类型  通常自定义控件样式时会在此文件夹中新建个.xml格式文件作为背景图
                    使用方法:getDrawable(R.drawable.xxx)

    1.2：valuse
        1.2.1：strings.xml
                        定义格式:<string name="xxx">字符串值</string>
                        支持占用符  例子:  
                        <string name="xxx">今天%1$s,温度%2$d</string>
                        %1 %2---代表参数所在位置
                        $s,$d代表参数,s,d为参数类型
                        getString(R.string.xxx,"星期一",20) = 今天星期一,温度20
                        使用方法:资源文件中   @string/xxx
                        代码中   getString(R.string.xxx)
        1.2.2：arrays.xml
              			作用:定义数组,可以是int,string,char
              			定义格式:<type-array name="xxx">
              			<item>数组元素值</item>
              			</type-array>
              			使用方法:资源文件中   不支持引用
              			代码中   type s[] = getResource.getTypeArray(R.array.xxx)
        1.2.3:colors.xml
              			作用:定义颜色
              			定义格式:<color name="xxx">#color值</color>
              			使用方法:资源文件中 @color/xxx
              			代码中getResource.getColor(R.color.xxx) 或者
              			getresource.getDrawable(R.color.xxx)
        1.2.4:dimens.xml
                        作用:定义尺寸大小
        			    定义格式:<dimen name="xxx">值</dimen>
        			    使用方法:资源文件中 @dimen/xxx
        			    代码中  getResource.getDimension(R.dimen.xxx)

		1.2.5:styles.xml
			            作用:定义试图样式
			            定义格式:<style name="xxx"  parent="yyy">
			            <item name="xxx2">元素值</item>
    1.3：anim
                作用:存放各种自定义动画格式
                使用方法:getResources().getAnimation(R.anim.xxx)
    1.4：layout
                作用:存放各种布局文件
                使用方法:setcontentView(R.layout.xxx) ,View view = LayoutInflater.from(context).inflate(R.layout.xxx,null)
    1.5：xml
                作用:存放各种xml文件,例如使用PreferenceFragment时需要在此xml文件夹中建立个preferenceFragment使用的.xml文件
                使用方法:XmlResoutceParser xml = getResources().getXml(R.xml.xxx)
    1.6：raw
                作用:直接存放拖入文件
                使用方法:InputStream read = getResources().openRawResource(R.raw.xxx)
                OutputStream write = getResources().openRawResource(R.raw.xxx)
    1.7：assets
                作用:存放拖入文件
                使用方法:InputStream read =getAssets().open(R.assets.xxx)
                OutputStream write = getAssets().open(R.assets.xxx)
    1.8：mipmap
                作用：仅存放图片资源，但是更倾向于小图 比如 ICON
                使用方法：R.mipmap.XXX.png




自定义控件三部曲之动画篇（一）——alpha、scale、translate、rotate、set的xml属性及用法

    一：概述 Android中Animation有四种组成（alpha ,scale ,translate,rotate）

        1、XML配置文件中
        alpha
        渐变透明度动画效果
        scale
        渐变尺寸伸缩动画效果
        translate
        画面转换位置移动动画效果
        rotate
        画面转移旋转动画效果
        2、动作文件存放位置
        动作定义文件应该存放在res/anim文件夹下
        3、Animation类的方法解释
         reset() 重置Animation的初始化
         cancel() 取消Animation动画
         start() 开始Animation动画
         setAnimationListener(AnimationListener listener) 给当前Animation设置动画监听
         hasStarted() 判断当前Animation是否开始
         hasEnded() 判断当前Animation是否结束

         既然补间动画只能给View使用，那就来看看View中和动画相关的几个常用方法吧，如下：
         View类的常用动画操作方法
         解释
         startAnimation(Animation animation) 对当前View开始设置的Animation动画
         clearAnimation()  取消当View在执行的Animation动画
         到此整个Android的补间动画常用详细属性及方法全部介绍完毕，如有特殊的属性需求可以访问Android Developer查阅即可。如下我们就来个综合大演练。

    二、scale标签——调节尺寸
        1、自有属性
        scale标签是缩放动画，可以实现动态调控件尺寸的效果，有下面几个属性：

        android:fromXScale    起始的X方向上相对自身的缩放比例，浮点值，比如1.0代表自身无变化，0.5代表起始时缩小一倍，2.0代表放大一倍；
        android:toXScale        结尾的X方向上相对自身的缩放比例，浮点值；
        android:fromYScale    起始的Y方向上相对自身的缩放比例，浮点值，
        android:toYScale        结尾的Y方向上相对自身的缩放比例，浮点值；
        android:pivotX            缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，当为数值时，表示在当前View的左上角，即原点处加上50px，做为起始缩放点；如果是50%，表示在当前控件的左上角加上自己宽度的50%做为起始点；如果是50%p，那么就是表示在当前的左上角加上父控件宽度的50%做为起始点x轴坐标。（具体意义，后面会举例演示）
        android:pivotY           缩放起点Y轴坐标，取值及意义跟android:pivotX一样。
        2、从Animation类继承的属性
        Animation类是所有动画（scale、alpha、translate、rotate）的基类，这里以scale标签为例，讲解一下，Animation类所具有的属性及意义。关于Animation类的官方文档位置为：《Animation》
        android:duration        动画持续时间，以毫秒为单位 
        android:fillAfter       如果设置为true，控件动画结束时，将保持动画最后时的状态
        android:fillBefore      如果设置为true,控件动画结束时，还原到开始动画前的状态
        android:fillEnabled     与android:fillBefore 效果相同，都是在动画结束时，将控件还原到初始化状态
        android:repeatCount     重复次数
        android:repeatMode      重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用才能看到效果。因为这里的意义是重复的类型，即回放时的动作。
        android:interpolator    设定插值器，其实就是指定的动作效果，比如弹跳效果等，不在这小节中讲解，后面会单独列出一单讲解。
    三、alpha标签——调节透明度
        1、自身属性
        android:fromAlpha   动画开始的透明度，从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明
        android:toAlpha       动画结束时的透明度，也是从0.0 --1.0 ，0.0表示全透明，1.0表示完全不透明
    四、rotate标签——旋转
        1、自身属性
        android:fromDegrees     开始旋转的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数
        android:toDegrees         结束时旋转到的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数
        android:pivotX               缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，具体意义已在scale标签中讲述，这里就不再重讲
        android:pivotY               缩放起点Y轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p
    五、translate标签 —— 平移
        1、自身属性
        android:fromXDelta     起始点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，具体意义已在scale标签中讲述，这里就不再重讲
        android:fromYDelta    起始点Y轴从标，可以是数值、百分数、百分数p 三种样式；
        android:toXDelta         结束点X轴坐标
        android:toYDelta        结束点Y轴坐标
    六、set标签——定义动作合集
        1、set标签自已是没有属性的，他的属性都是从Animation继承而来，但当它们用于Set标签时，就会对Set标签下的所有子控件都产生作用。

自定义控件三部曲之动画篇（二）——Interpolator插值器
    一、概述
    Interpolator属性是Animation类的一个XML属性，所以alpha、scale、rotate、translate、set都会继承得到这个属性。
    Interpolator被译为插值器，其实我不大能从字面上理解为什么会这样译，其实他是一个指定动画如何变化的东东，跟PS里的动作有点类似：随便拿来一张图片，应用一个动作，图片就会指定变化。
    Interpolator的系统值有下面几个：
        AccelerateDecelerateInterpolator   在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
        AccelerateInterpolator             在动画开始的地方速率改变比较慢，然后开始加速
        AnticipateInterpolator             开始的时候向后然后向前甩
        AnticipateOvershootInterpolator    开始的时候向后然后向前甩一定值后返回最后的值
        BounceInterpolator                 动画结束的时候弹起
        CycleInterpolator                  动画循环播放特定的次数，速率改变沿着正弦曲线
        DecelerateInterpolator             在动画开始的地方快然后慢
        LinearInterpolator                 以常量速率改变
        OvershootInterpolator              向前甩一定值后再回到原来位置
















































































































































































































































