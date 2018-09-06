package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "yweather:astronomy", writeNamespaces = [
    "yweather=http://xml.weather.yahoo.com/ns/rss/1.0"
])
data class Astronomy (
    @field:[Attribute(name="sunrise")]
    var sunrise: String? = null,
    @field:[Attribute(name="sunset")]
    var sunset: String? = null
)