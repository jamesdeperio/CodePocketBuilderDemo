package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "image")
data class Image(
        @field:[PropertyElement(name = "width")]
        var width: Int = 0,
        @field:[PropertyElement(name = "height")]
        var height: Int = 0,
        @field:[PropertyElement(name = "title")]
        var title: String? = null,
        @field:[PropertyElement(name = "link")]
        var link: String? = null,
        @field:[PropertyElement(name = "url")]
        var url: String? = null

)