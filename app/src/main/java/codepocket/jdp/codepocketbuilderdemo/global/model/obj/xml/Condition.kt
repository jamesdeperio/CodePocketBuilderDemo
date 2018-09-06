package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "yweather:condition", writeNamespaces = [
    "yweather=http://xml.weather.yahoo.com/ns/rss/1.0"
])
data class Condition (
    @field:[Attribute(name="temp")]
    var temp: Int = 0,
    @field:[Attribute(name="code")]
    var code: Int = 0,
    @field:[Attribute(name="date")]
    var date: String? = null,
    @field:[Attribute(name="text")]
    var text: String? = null
)