package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "yweather:atmosphere", writeNamespaces = [
    "yweather=http://xml.weather.yahoo.com/ns/rss/1.0"
])
data class Atmosphere (
    @field:[Attribute(name="rising")]
    var rising: Int = 0,
    @field:[Attribute(name="humidity")]
    var humidity: Int = 0,
    @field:[Attribute(name="visibility")]
    var visibility: Double = 0.toDouble(),
    @field:[Attribute(name="pressure")]
    var pressure: Double = 0.toDouble()
)