package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "yweather:forecast", writeNamespaces = [
"yweather=http://xml.weather.yahoo.com/ns/rss/1.0"
])
data class Forecast (
        @field:[Attribute(name = "high")]
        var high: Int = 0,
        @field:[Attribute(name = "code")]
        var code: Int = 0,
        @field:[Attribute(name = "low")]
        var low: Int = 0,
        @field:[Attribute(name = "date")]
        var date: String? = null,
        @field:[Attribute(name = "text")]
        var text: String? = null,
        @field:[Attribute(name = "day")]
        var day: String? = null
)