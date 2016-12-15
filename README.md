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
    1.8：mipmap 作用：仅存放图片资源，但是更倾向于小图 比如 ICON
                使用方法：R.mipmap.XXX.png

























































































































































































































































