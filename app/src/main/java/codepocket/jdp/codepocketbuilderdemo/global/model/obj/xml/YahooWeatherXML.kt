package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "query" , writeNamespaces = [
    "yahoo=http://www.yahooapis.com/v1/base.rng"
])
data class YahooWeatherXML(
        @field:[Attribute(name = "yahoo:count")]
        var count: Int = 0,
        @field:[Attribute(name = "yahoo:created")]
        var created: String? = null,
        @field:[Attribute(name = "yahoo:lang")]
        var lang: String? = null,
        @field:[Element(name = "results")]
        var results: Results? = null
)