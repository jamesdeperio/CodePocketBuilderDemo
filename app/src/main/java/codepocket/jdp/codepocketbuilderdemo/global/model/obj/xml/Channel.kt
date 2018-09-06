package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "channel")
data class Channel(
        @field:[PropertyElement(name = "ttl")]
        var ttl: Int = 0,
        @field:[PropertyElement(name = "title")]
        var title: String? = null,
        @field:[PropertyElement(name = "link")]
        var link: String? = null,
        @field:[PropertyElement(name = "description")]
        var description: String? = null,
        @field:[PropertyElement(name = "language")]
        var language: String? = null,
        @field:[PropertyElement(name = "lastBuildDate")]
        var lastBuildDate: String? = null,
        @field:[Element(name = "image")]
        var image: Image? = null,
        @field:[Element(name = "item")]
        var item: Item? = null,
        @field:[Element(name = "yweather:astronomy")]
        var astronomy: Astronomy? = null,
        @field:[Element(name = "yweather:atmosphere")]
        var atmosphere: Atmosphere? = null,
        @field:[Element(name = "yweather:wind")]
        var wind: Wind? = null,
        @field:[Element(name = "yweather:location")]
        var location: Location? = null,
        @field:[Element(name = "yweather:units" )]
        var units: Units? = null
)