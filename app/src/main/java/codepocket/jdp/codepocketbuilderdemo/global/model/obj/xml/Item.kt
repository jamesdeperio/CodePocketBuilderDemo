package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import java.util.*
@Xml(name = "item")
data class Item (
        @field:[Element(name = "yweather:forecast")]
        var forecast: List<Forecast> = ArrayList(),
        @field:[PropertyElement(name = "geo:lat")]
        var latitude: Double = 0.toDouble(),
        @field:[PropertyElement(name = "geo:long")]
        var longitude: Double = 0.toDouble(),
        @field:[PropertyElement(name = "title")]
        var title: String? = null,
        @field:[PropertyElement(name = "link")]
        var link: String? = null,
        @field:[PropertyElement(name = "pubDate")]
        var pubDate: String? = null,
        @field:[PropertyElement(name = "description")]
        var description: String? = null,
        @field:[Element(name = "yweather:condition")]
        var condition: Condition? = null,
        @field:[Element(name = "guid")]
        var guid: Guid? = null
)