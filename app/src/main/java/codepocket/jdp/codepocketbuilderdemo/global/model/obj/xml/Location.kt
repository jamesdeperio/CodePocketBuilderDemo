package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "yweather:location", writeNamespaces = [
    "yweather=http://xml.weather.yahoo.com/ns/rss/1.0"
])
data class Location (
        @field:[Attribute(name = "country")]
        var country: String? = null,
        @field:[Attribute(name = "city")]
        var city: String? = null,
        @field:[Attribute(name = "region")]
        var region: String? = null
)