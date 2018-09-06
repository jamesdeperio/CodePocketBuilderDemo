package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "yweather:wind", writeNamespaces = [
    "yweather=http://xml.weather.yahoo.com/ns/rss/1.0"
])
data class Wind (
    @field:[Attribute(name = "chill")]
    var chill: Int = 0,
    @field:[Attribute(name = "speed")]
    var speed: Int = 0,
    @field:[Attribute(name = "direction")]
    var direction: Int = 0
)