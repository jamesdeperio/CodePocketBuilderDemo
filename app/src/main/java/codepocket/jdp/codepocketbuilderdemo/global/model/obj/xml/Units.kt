package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "yweather:units", writeNamespaces = [
    "yweather=http://xml.weather.yahoo.com/ns/rss/1.0"
])
data class Units (
    @field:[Attribute(name = "distance")]
    var distance: String? = null,
    @field:[Attribute(name = "temperature")]
    var temperature: String? = null,
    @field:[Attribute(name = "pressure")]
    var pressure: String? = null,
    @field:[Attribute(name = "speed")]
    var speed: String? = null
)